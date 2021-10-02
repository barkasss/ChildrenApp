from django import forms
from django.contrib.auth.models import User
from django.contrib.auth.forms import UserCreationForm, AuthenticationForm


class LoginForm(AuthenticationForm):
    username = forms.CharField(label='Логин')

    class Meta:
        model = User
        fields = ['username', 'password']


class RegisterForm(UserCreationForm):
    email = forms.EmailField()
    username = forms.CharField(label='Логин')

    class Meta:
        model = User
        fields = ['first_name', 'last_name', 'username', 'email', 'password1', 'password2']