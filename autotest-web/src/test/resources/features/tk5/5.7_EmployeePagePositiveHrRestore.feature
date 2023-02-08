#language:ru
@tk5.7 @UI @regress
Функция: Страница "Сотрудники". Роли HR, Public (позитивные)

  Предыстория: Иницилизация и авторизация под ролью hr

    Дано открыть сайт
    Тогда инициализация страницы 'DjangoAuthorization'

  Структура сценария: Открытие стартовой страницы, авторизация под аккаунтом "hr",
  после нажатия на кнопку "Сотрудники", проверка работотоспособности восстановления удаленных сотрудников

    Если авторизоваться логином '<login>'
    Тогда инициализация страницы 'DjangoAdministration'
    Если кнопка '<button_emp>' отображается
    Тогда нажать на '<button_emp>'
    Тогда инициализация страницы 'DjangoEmployee'
    Если кнопка '<button>' отображается
    Тогда нажать на '<button>'
    Тогда инициализация страницы 'DjangoRestoreEmployee'
    И на текущей странице в блоке '<block>' нажать на любую ссылку
    Тогда инициализация страницы 'DjangoReturnEmployee'
    Если на текущей странице 'Инфоблок' с текстом '<text>' присутствует
    Тогда нажать на кнопку 'Сохранить'
    Тогда инициализация страницы 'DjangoEmployee'
    Если в поле The Сотрудник “ и ” was changed successfully. присутствует элемент 'Name'

    Примеры:
      |login |button_emp |button                           |block       |text                                                                    |
      |hr    |Сотрудники |Восстановить удаленный сотрудники|Дата и время|Нажмите кнопку "Сохранить" далее, чтобы восстановить эту версию объекта.|