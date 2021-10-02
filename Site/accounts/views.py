import requests
from django.shortcuts import render, redirect
from .forms import RegisterForm, LoginForm
from .fire_config import db, auth
from django.contrib.auth.models import User

import sys
sys.path.insert(0, r'C:\Users\sergt\Desktop\kdhack\site\Site\personal')

import transfer

import logging

logger = logging.getLogger(__name__)


def login(request):
    if request.method == 'POST':
        form = LoginForm(request.POST)
        username = request.POST.get('username')
        password = request.POST.get('password')
        all_users = db.child('owner_users').get()

        for user in all_users.each():
            if user.val()['username'] == username:
                if user.val()['password'] == password:
                    return redirect('profile')
        return redirect('login')
    else:
        form = LoginForm()
    return render(request, 'registration/login.html', {'form': form})


def register(request):
    if request.method == 'POST':
        form = RegisterForm(request.POST)
        if form.is_valid():
            email = form.cleaned_data.get('email')
            password = form.cleaned_data.get('password1')
            user = auth.create_user_with_email_and_password(email, password)
            token = user['localId']
            username = form.cleaned_data.get('username')

            data = {
                'first_name': form.cleaned_data.get('first_name'),
                'last_name': form.cleaned_data.get('last_name'),
                'username': username,
                'email': email,
                'password': password,
            }
            db.child('owner_users').child(token).set(data)
            user = User.objects.create_user(username, email, password)
            user.save()
            return redirect('profile')
    else:
        form = RegisterForm()
    return render(request, 'registration/register.html', {'form': form})


def to_login():
    return redirect('login')