#language:ru
@tk6.3 @UI @regress
Функция: Проверка поведения системы при невалидном вводе в поле поиска. Страница "Сотрудники" по ролью HR

  Предыстория: Иницилизация и авторизация под ролью hr

    Дано открыть сайт
    Тогда инициализация страницы 'DjangoAuthorization'

  Структура сценария: Открытие стартовой страницы, авторизация под аккаунтом "hr",
  после нажатия на кнопку "Сотрудники",  проверка поведения системы при нажатии на кнопку "Выполнить" без выбора сотрудников и незаполненном поле "Действие"

    Если авторизоваться логином '<login>'
    Тогда инициализация страницы 'DjangoAdministration'
    Если кнопка '<button_emp>' отображается
    Тогда нажать на '<button_emp>'
    Тогда инициализация страницы 'DjangoEmployee'
    Если кнопка '<button>' отображается
    Тогда нажать на '<button>'
    И поле '<field>' инфоблок с текстом '<text>' присутствует

    Примеры:
      |login |button_emp |button   |field                      |text                                                                                     |
      |hr    |Сотрудники |Выполнить|Предупреждение в заголовке |Чтобы произвести действия над объектами, необходимо их выбрать. Объекты не были изменены.|
