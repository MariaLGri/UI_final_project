
<p align="center">
  <a href="https://offer-now.ru/" target="_blank" title="Официальный сайт компании" style="text-decoration: none;">
    <img src="media/pictures/company_logo.png" alt="HAR Logo" width="400" height="70" style="border: 0;">
    <br>
    <span style="color: #0066cc; font-size: 1.25rem; font-weight: 600; margin-top: 8px; display: inline-block;">
         </span>
  </a>
</p>

<div align="center">
  <h2> ПРОЕКТ АВТОМАТИЗАЦИИ | <img src="media/offer_now_logo.png" width="20" alt=""> OFFER NOW</h2>
</div>

---
<table>
  <tr>
    <td style="background-color: #f5f9ff; padding: 20px; border: 1px solid #e0e8f5;">

## :scroll: Содержание:

- [Используемый стек](#используемый-стек)
- [Запуск автотестов](#запуск-автотестов)
- [Сборка в Jenkins](#сборка-в-jenkins)
- [Пример Allure-отчета](#пример-allure-отчета)
- [Интеграция](#Интеграция)
- [Уведомления в Telegram](#уведомления-в-telegram)
- [Видео примера запуска тестов](#видео-примера-запуска-тестов)

---

<a id="используемый-стек"></a>

# :computer: Используемый стек

<br>

<p align="center">
  <a href="https://www.jetbrains.com/idea/" target="_blank"><img width="50px" title="IntelliJ IDEA" src="media/icons/Intelij_IDEA.png" alt="IntelliJ IDEA"></a>
  <a href="https://www.java.com/" target="_blank"><img width="50px" title="Java" src="media/icons/Java.png" alt="Java"></a>
  <a href="https://selenide.org/" target="_blank"><img width="50px" title="Selenide" src="media/icons/Selenide.svg" alt="Selenide"></a>
  <a href="https://aerokube.com/selenoid/" target="_blank"><img width="50px" title="Selenoid" src="media/icons/Selenoid.png" alt="Selenoid"></a>
  <a href="https://docs.qameta.io/allure/" target="_blank"><img width="50px" title="Allure Report" src="media/icons/Allure_Report.png" alt="Allure Report"></a>
  <a href="https://gradle.org/" target="_blank"><img width="50px" title="Gradle" src="media/icons/Gradle.png" alt="Gradle"></a>
  <a href="https://junit.org/junit5/" target="_blank"><img width="50px" title="JUnit5" src="media/icons/JUnit5.png" alt="JUnit5"></a>
  <a href="https://github.com/" target="_blank"><img width="50px" title="GitHub" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/github/github-original.svg" alt="GitHub"></a>
  <a href="https://www.jenkins.io/" target="_blank"><img width="50px" title="Jenkins" src="media/icons/Jenkins.png" alt="Jenkins"></a>
  <a href="https://docs.qameta.io/allure-testops/" target="_blank"><img width="50px" title="AllureTestOps" src="media/icons/AllureTestOps.svg" alt="Allure TestOps"></a>
  <a href="https://telegram.org/" target="_blank"><img width="50px" title="Telegram" src="media/icons/Telegram.png" alt="Telegram"></a>
</p>

<br>

Тесты в данном проекте написаны на языке <code>Java</code> с использованием фреймворка для тестирования <code>
Selenide</code>, сборщик - <code>Gradle</code>. <code>JUnit 5</code> задействован в качестве фреймворка модульного
тестирования.

При прогоне тестов для запуска браузеров используется <code>Selenoid</code>.
Для удаленного запуска реализована джоба в <code>Jenkins</code> с формированием Allure-отчета и отправкой результатов
в <code>Telegram</code> при помощи бота. Так же реализована интеграция с <code>Allure TestOps</code> и <code>
Jira</code>.

<br>

### ✅ Проверки

- ✔️ **Проверка открытия страницы вакансии Auto QA (Java)**
- ✔️ **Проверка невозможности добавить вакансию в избраннное без регистрации**
- ✔️ **Проверка перехода на официальный сайт компании со страницы описания компании**
- ✔️ **Проверка видимости общей оценки компании**
- ✔️ **Проверка перехода на страницу краткого описания компании для вакансии**

<br>

### ✨ | 📑 Содержание Allure-отчета | ✨

* Шаги теста;
* Скриншот страницы на последнем шаге;
* Page Source;
* Логи браузерной консоли;
* Видео выполнения автотеста.

<br>

<a id="запуск-автотестов"></a>

### ✨ | 🖥️ Запуск автотестов из терминала | ✨

```
gradle clean test
-Dbrowser=chrome 
-DbrowserVersion=127.0 
-DbrowserSize=1920x1200 
-DselenoidUrl=selenoid.autotests.cloud 
```

При выполнении данной команды в терминале IDE тесты запустятся удаленно в <code>Selenoid</code>.

<br>

---

<a id="сборка-в-jenkins"></a>
<p align="center"> 

# <a href="https://jenkins.autotests.cloud/job/035_vacancy_test_home/" target="_blank"><img width="40px" style="vertical-align:middle" src="media/pictures/Jenkins_logo.png" alt="Jenkins Logo"> Сборка в Jenkins

</p>




Для запуска сборки необходимо перейти в раздел <code> Build with Parameters:</code> и нажать кнопку <code>Build</code>.
<p align="center">

<img title="Jenkins Build" src="media/pictures/build.PNG">
</p>

После выполнения сборки, в блоке <code>История сборок</code> напротив номера сборки появятся значки <code>Allure
Report</code>, при клике на которую откроется страница с сформированным отчетом.

<br>

---

<a id="пример-allure-отчета"></a>
<p align="center">

# <img width="38" style="vertical-align:middle" alt="Allure Report" src="media/icons/Allure_Report.png"> Пример Allure-отчета

### 🔍 Обзор

<p align="center">
  <a href="https://jenkins.autotests.cloud/job/035_vacancy_test_home/29/allure/" target="_blank" rel="noopener noreferrer">
    <img src="media/pictures/A_report.png" alt="Allure Overview Dashboard" style="border: 1px solid #ddd; border-radius: 4px; padding: 5px;">
  </a>
</p>

### 📂 Группы тестов
<p align="center">
  <a href="https://jenkins.autotests.cloud/job/035_vacancy_test_home/29/allure/#suites/a657a03f5cf0e7f2aa2f3b2cec09b6fd/b0c9276acbc5217e/" target="_blank" rel="noopener noreferrer">
    <img src="media/pictures/testgrup.png" alt="Allure Test Suites" style="border: 1px solid #ddd; border-radius: 4px; padding: 5px; margin-top: 20px;">
  </a>
</p>

### 📈 Анализ тестов

<p align="center">
  <a href="https://jenkins.autotests.cloud/job/035_vacancy_test_home/29/allure/#graph" target="_blank" rel="noopener noreferrer">
    <img src="media/pictures/graphs.png" alt="Allure Analytics Graph" style="border: 1px solid #ddd; border-radius: 4px; padding: 5px; margin-top: 20px;">
  </a>
</p>

<br>

---

<a id="Интеграция"></a>

# <a href="https://allure.autotests.cloud/project/4774/dashboards" target="_blank"><img width="38" src="media/icons/AllureTestOps.svg" alt="Allure TestOps"> Интеграция с Allure TestOps</a>

<p align="center">
   <br>
<img src="media/pictures/A_testOps.png">
</p>

<br>

---

<a id="уведомления-в-telegram"></a>

# <img width="38" style="vertical-align:middle" title="Selenoid" src="media/icons/Telegram.png"> Результат выполнения автотестов в Телеграм

После завершения сборки специальный бот, созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет
сообщение с отчетом о прогоне тестов.

<p align="center">
<img width="400" title="Telegram Notifications" src="media/pictures/telegram.PNG">
</p>

<br>

---

<a id="видео-примера-запуска-тестов"></a>

# <img width="38" style="vertical-align:middle" title="Selenoid" src="media/icons/Selenoid.png"> Видео примера запуска тестов в Selenoid

В отчетах Allure для каждого теста прикреплен не только скриншот, но и видео прохождения теста

<br>

<p align="center">
  <img src="media/Video/video.gif" alt="Demo" width="700">
</p>

   </td>
  </tr>
</table>