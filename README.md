# Matcher
Решение тестового задания для проекта IntelliJ plugin for Lego Mindstorms

Решение заключается в обертке над CharSequence, которая запоминает дедлайн, после которого операции с оберткой выкинут исключение

---

Не очень понятна строка "избежать выбрасывания исключений в процессе исполнения."
Кажется это можно решить просто падая в нашей функции, но на мой взгляд так делать не стоит, лучше мы выкинем исключение
