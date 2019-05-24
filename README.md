# Welcome to EmployeeWithholding Service

## Current version 1.0.0

## Microservice purpose:
This microservice provides the employee's tax withholdings.

## ROUTES
- http://localhost:8097/
- **EUREKA SERVICE NAME**: EMPWITHHOLDINGS
## Currently supported APIs:
- /empWithholdings/info
- /empWithholdings/getwithholdings

## Message formats and error handling
This microservice uses JSON for all input and output messages.
It uses POST methods.

## Sample input and output

- /empBenefits/getbenefits

Method: POST

**Input JSON:**
------------------------------------------------------------------
~~~
{
    "employeeId": "11111"
}
~~~
------------------------------------------------------------------

**Output JSON:**
------------------------------------------------------------------
~~~
{
    "employeeId": 11111,
    "empFedWhPct": 6,
    "empStateWhPct": 0,
    "empCityWhPct": 30,
    "totalWitholdings": 125
}
~~~
------------------------------------------------------------------

**Error JSON:**
------------------------------------------------------------------
~~~
{
    "employeeId": 11111,
    "errorMsg": "NOT_FOUND"
}
~~~
------------------------------------------------------------------

### Guides
The following guides illustrates how to use certain features correctly:

* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)
* [Accessing JPA Data with REST](https://spring.io/guides/gs/accessing-data-rest/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
