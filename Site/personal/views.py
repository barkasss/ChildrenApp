from django.shortcuts import render, redirect
from .models import Task
from .forms import TaskForm
from fire_config import db, auth
from random import randint

# Create your views here.


def index(request):
    tasks = Task.objects.order_by('-id')
    return render(request, 'personal/index.html', {'title': 'Главная', 'tasks': tasks})


def about(request):
    return render(request, 'personal/about.html')


def create(request):
    error = ''
    if request.method == 'POST':
        form = TaskForm(request.POST)
        if form.is_valid():
            title = form.cleaned_data.get('title')
            location = form.cleaned_data.get('location')
            price = form.cleaned_data.get('price')
            task = form.cleaned_data.get('task')
            tag = form.cleaned_data.get('tag')
            token = randint(0, 99999999999999)
            data = {
                'cardName': title,
                'link': location,
                 'cost': price,
                 'Description': task,
                'tag': tag,
                'key': token
            }

            db.child('cards').child(str(token)).set(data)
            form.save()
            return redirect('profile')
        else:
            error = 'Форма неверная'
    form = TaskForm()
    context = {
        'form': form,
        error: error
    }
    return render(request, 'personal/create.html', context)