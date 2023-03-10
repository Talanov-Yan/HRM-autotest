#language:ru
@tk6.6 @UI @regress
Функция: Проверка поведения системы при невалидном вводе в поле поиска. Страница "Сотрудники" по ролью HR

  Предыстория: Иницилизация и авторизация под ролью hr

    Дано открыть сайт
    Тогда инициализация страницы 'DjangoAuthorization'

  Структура сценария: Открытие стартовой страницы, авторизация под аккаунтом "hr",
  после нажатия на кнопку "Сотрудники", проверка поведения системы при экспорте списка сотрудников через опцию выпадающего списка при не выбранном формате экспортируемого файла

    Если авторизоваться логином '<login>'
    Тогда инициализация страницы 'DjangoAdministration'
    Если кнопка '<button_emp>' отображается
    Тогда нажать на '<button_emp>'
    Тогда инициализация страницы 'DjangoEmployee'
    И на текущей странице в блоке '<element>' нажать на любую ссылку
    Тогда выбрать элемент '<dropdown>' с текстом '<textdropdown>'
    Если кнопка '<button>' отображается
    Тогда нажать на '<button>'
    И поле '<field>' инфоблок с текстом '<text>' присутствует

    Примеры:
      |login |button_emp |element         |dropdown     |button   |textdropdown                       |field                      |text                              |
      |hr    |Сотрудники |Таблица чек-бокс|Действие меню|Выполнить|Экспортировать выбранные Сотрудники|Предупреждение в заголовке |Необходимо выбрать формат экспорта|

