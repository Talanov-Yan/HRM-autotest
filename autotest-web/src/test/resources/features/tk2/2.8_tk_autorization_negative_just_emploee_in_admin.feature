#language:ru
@Test
Функционал: Негативная авторизация под ролью "just_employee"

    Сценарий: Проверка авторизации под ролью "just_employee" с активированными чек-боксами
             "Я желаю войти с админскими правами" и "Я здесь впервые"
    Дано открыть url "http://178.154.246.238:58082/"
    Когда инициализация страницы "DjangoAuthorization"
    И кликнуть на элемент "Я желаю войти с админскими правами"
    И кликнуть на элемент "Я здесь впервые"
    Тогда ввести в поле "логин" значение "just_employee"
    И ввести в поле "пароль" значение "hrmhrm123"
    Тогда кликнуть на элемент "выслать инструкцию на почту"
    И кликнуть на элемент "войти"
    Если на странице присутствует текст "У этого пользователя нет админских прав."

