# Testing http://computer-database.gatling.io/computers
* Win10 64;
* IntelliJ IDEA;
* Google Chrome v90.0.4430.212 (64);
* ChromeDriver 90.0.4430.24;

# Terminal commands:
**mvn clean test** - removes files created during build in the project directory, then build.

**allure serve allure serve target/surefire-reports** - generates a log report.

# Task:
http://computer-database.gatling.io/computers
Написать автоматический тест для проверки того, что функциональность “Add a new computer” в “Computer database” работает (или не работает).

Желательно: заполнение всех данных в форме добавления нового компьютера. Introduced date: 10 лет назад до написания тестового
Discontinued: дата написания тестового задания

Приветствуется стек технологий: Java + TestNG + Gradle + Selenium + любой инструмент для формирования репорта
Добавьте документацию по работе с проектом и загрузите в паблик репозиторий на GitHub.
