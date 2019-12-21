@echo on
SET PROJECT_PATH=C:\Users\AjayKumar\Selenium Scripts\SeleniumDemo5\GmailSmokeTesting

cd %PROJECT_PATH%

call mvn clean
call mvn test

pause