from django.urls import path
from . import views

urlpatterns = [
    path('', views.to_login, name='redirect_to_login'),
    path('accounts/register/', views.register, name='register'),
    path('accounts/login/', views.login, name='login')
]
