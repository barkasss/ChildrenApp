# Generated by Django 3.2.7 on 2021-10-02 09:54

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('personal', '0002_auto_20211002_0613'),
    ]

    operations = [
        migrations.AddField(
            model_name='task',
            name='tag',
            field=models.CharField(choices=[('Хореография', 'Хореография'), ('Атлетика и гимнастика', 'Атлетика и гимнастика'), ('Единоборства', 'Единоборства'), ('Водный спорт', 'Водный спорт'), ('Зимний спорт', 'Зимний спорт'), ('Силовой спорт', 'Силовой спорт'), ('Игры с мячом', 'Игры с мячом'), ('Спорт с техникой', 'Спорт с техникой'), ('Техническаие конструкторы', 'Техническаие конструкторы'), ('Иностранные языки', 'Иностранные языки'), ('Естественные науки', 'Естественные науки'), ('Гуманитарные науки', 'Гуманитарные науки'), ('Настольные игры', 'Настольные игры'), ('Искусство и дизайн', 'Искусство и дизайн'), ('Музыка и хор', 'Музыка и хор'), ('Зрелищные искусства', 'Зрелищные искусства'), ('Мода и стиль', 'Мода и стиль'), ('Познавательные увлечения', 'Познавательные увлечения'), ('Туризм', 'Туризм'), ('ДПИ и Ремесла', 'ДПИ и Ремесла'), ('Журналистика', 'Журналистика')], default='', max_length=50, verbose_name='Теги'),
        ),
    ]
