#language:ru
@tk5.11 @UI @regress
Функция: Страница "Сотрудники". Роли HR, Public (позитивные)

  Предыстория: Иницилизация и авторизация под ролью hr

    Дано открыть сайт
    Тогда инициализация страницы 'DjangoAuthorization'

  Структура сценария: Открытие стартовой страницы, авторизация под аккаунтом "hr",
  после нажатия на кнопку "Сотрудники", проверка работотоспособности фильтров

    Если авторизоваться логином '<login>'
    Тогда инициализация страницы 'DjangoAdministration'
    Если кнопка '<button>' отображается
    Тогда нажать на '<button>'
    Тогда инициализация страницы 'DjangoEmployee'
    И нажать на элемент 'Категории фильтров' с текстом 'Офис'
    Затем в блоке 'Фильтр' нажать на ссылку с текстом '<text>'
    Если в блоке 'Таблица' в столбце '<column>' все записи = '<text>'

    Примеры:
      |login |button     |column       |text |
      |hr    |Сотрудники |Текущий город|Пенза|
