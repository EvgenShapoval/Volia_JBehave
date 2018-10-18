Narrative:
Checking the JBehave

Scenario: Проверка количества вакансий на ITPage
Given Открыть HomePage volia.com
When В блоке menu выбрать Світ Волі
When На CompanyPage в блоке menu main кликнуть по Вакансіі
When На VacanciesPage в сайдбаре выбрать IT
Then Проверить, что на ITPage отображается '2' вакансии

Scenario: Проверяем с заявленной на сайте стоимостью аренды сервера 
Given Открыть HomePage volia.com
When В блоке Menu кликаем по вкладке «Дата-центр ВОЛЯ»
Then Сравниваем Вартість сервера Від '199' грн/міс с заявленной на сайте