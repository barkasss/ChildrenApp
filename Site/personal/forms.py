from .models import Task
from django.forms import ModelForm, TextInput, Textarea, Select


class TaskForm(ModelForm):
    class Meta:
        model = Task
        fields = ['title', 'tag', 'location', 'price', 'task']
        widgets = {
            'title': TextInput(attrs={
                'class': 'form-control',
                'placeholder': 'Введите назавние'
            }),
            'tag': Select(attrs={
                'class': 'form-control',
                'placeholder': 'Введите тег'
            }),
            'location': TextInput(attrs={
                'class': 'form-control',
                'placeholder': 'Введите местоположение'
            }),
            'price': TextInput(attrs={
                'class': 'form-control',
                'placeholder': 'Введите цену'
            }),
            'task': Textarea(attrs={
                'class': 'form-control',
                'placeholder': 'Введите описание'
            }),
        }