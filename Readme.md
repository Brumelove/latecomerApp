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

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/f61abdae2c8a44c78bfdccff022753e9)](https://app.codacy.com/gh/Brumelove/latecomerApp?utm_source=github.com&utm_medium=referral&utm_content=Brumelove/latecomerApp&utm_campaign=Badge_Grade_Settings)

