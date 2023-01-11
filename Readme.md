Service that checks for late cormers and add fines

mvn clean install
create your db and insert values from dump.sql to test

host = localhost:8092/latecomer
To Get all employee ==> {{host}}/employees
To Get employee by any parameter ==> {{host}}/employees?{parameter}=value
E.g {{host}}/employees?employees?employeeName=Brume

To Sort E.g {{host}}/employees?sort=employeeGbese,desc

To Post, UPDATE and Delete follows same rule 

Check Unit Test for verifying employee fine.

#Swagger latest version is uncompatible with spring Data Rest, although i can find a way to tweak it, It is time taking and   

[![Codacy Badge](https://app.codacy.com/project/badge/Grade/e45133aab2a6435b96c370734b8eca8d)](https://www.codacy.com/gh/Brumelove/latecomerApp/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=Brumelove/latecomerApp&amp;utm_campaign=Badge_Grade)
