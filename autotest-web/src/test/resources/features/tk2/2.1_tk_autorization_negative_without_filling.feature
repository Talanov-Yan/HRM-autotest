#language:ru
@Test

Функционал: Негативная авторизация

  Сценарий: Авторизация без заполнения полей

    Дано открыть url "http://178.154.246.238:58082/"
    Когда инициализация страницы "DjangoAuthorization"
    Тогда кликнуть на элемент "войти"
    И проверить что "логин" есть  атрибут "validationMessage" с значением "Заполните это поле." подождав 0 сек.