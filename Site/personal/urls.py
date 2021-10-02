from django.urls import path
from . import views
from transfer import user
urlpatterns = [
    path('profile', views.index, name='profile'),
    path('about', views.about, name='about'),
    path('create', views.create, name='create')
]
