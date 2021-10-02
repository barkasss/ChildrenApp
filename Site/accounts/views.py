from django.shortcuts import render, redirect
from .forms import RegisterForm, LoginForm
from .fire_config import db, auth

from Site.personal.transfer import enter


def login(request):
    if request.method == 'POST':
        form = LoginForm(request.POST)
        if form.is_valid():
            username = form.cleaned_data.get('username')
            password = form.cleaned_data.get('password')
            all_users = db.child('owner_users').get()
            for user in all_users:
                if user.val()['username'] == username:
                    if user.val()['password'] == password:
                        t
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

            print(token)
            data = {
                'first_name': form.cleaned_data.get('first_name'),
                'last_name': form.cleaned_data.get('last_name'),
                'username': form.cleaned_data.get('username'),
                'email': email,
                'password': password,
            }
            db.child('owner_users').child(token).set(data)
            return redirect('login')
    else:
        form = RegisterForm()
    return render(request, 'registration/register.html', {'form': form})


def to_login(request):
    return redirect('login')