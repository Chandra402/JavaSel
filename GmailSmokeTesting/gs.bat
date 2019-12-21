@echo on
SET PROJECT_PATH=./GmailSmokeTesting/

cd %PROJECT_PATH%

call mvn clean
call mvn test

pause