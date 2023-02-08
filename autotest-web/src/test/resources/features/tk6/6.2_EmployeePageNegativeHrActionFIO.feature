#language:ru
@tk6.2 @UI @regress
Функция: Проверка поведения системы при невалидном вводе в поле поиска. Страница "Сотрудники" по ролью HR

  Предыстория: Иницилизация и авторизация под ролью hr

    Дано открыть сайт
    Тогда инициализация страницы 'DjangoAuthorization'

  Структура сценария: Открытие стартовой страницы, авторизация под аккаунтом "hr",
  после нажатия на кнопку "Сотрудники", проверка поведения системы при нажатии на кнопку "Поиск" с незаполненным в полем поиска

    Если авторизоваться логином '<login>'
    Тогда инициализация страницы 'DjangoAdministration'
    Если кнопка '<button_emp>' отображается
    Тогда нажать на '<button_emp>'
    Тогда инициализация страницы 'DjangoEmployee'
    И в текущем блоке 'ФИО' взять <number> элемент
    Если при нажатии на кнопку '<button>' в блоке 'Таблица' в столбце 'ФИО', <number> элемент не изменился

    Примеры:
      |login |button_emp |button   |number|
      |hr    |Сотрудники |Выполнить|1     |
