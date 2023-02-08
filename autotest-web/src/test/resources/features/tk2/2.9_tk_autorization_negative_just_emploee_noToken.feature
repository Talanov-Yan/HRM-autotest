#language:ru
@Test

Функционал: Негативная авторизация под ролью "just_employee"

  Сценарий: Проверка авторизации под ролью "just_employee" с активированным
  чек-боксом "Я желаю войти с админскими правами"
    Дано открыть url "http://178.154.246.238:58082/"
    Когда инициализация страницы "DjangoAuthorization"
    Тогда нажать на чекбокс "Я желаю войти с админскими правами"
    И чекбокс "Я здесь впервые" отображается и не выбран
    Если поле ввода "токен" отображается
    И ввести в поле "логин" значение "just_employee"
    И ввести в поле "пароль" значение "hrmhrm123"
    Тогда кликнуть на элемент "войти"
    Если проверить что "токен" есть  атрибут "validationMessage" с значением "Заполните это поле." подождав 0 сек.