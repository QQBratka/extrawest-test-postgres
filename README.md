# extrawest-test-postgres
### About:
Simple API that shows advertising messages in JSON format with pagination and sorting. 

### Technologies used:
1. Spring Boot
2. Spring Security
3. Hibernate
4. Postgres SQL

### Endpoints
* http://localhost:8080/login for login
* http://localhost:8080/register POST for register new user with permission read (User role) permit for all (use only 
unique emails, in api implemented simple validations with regular expression)
* http://localhost:8080/advertising GET for authenticated users with both read or write permissions with pagination by 
default page = 0, size = 5 and sort by price, but you can use whatever you want, for example ?page=2&size=3&sortBy=type
* http://localhost:8080/users POST only for permission write (Admin) create new user (with repeat password)
* http://localhost:8080/users/{id} PUT only for permission write (Admin) update user by id
* http://localhost:8080/users/{id} DELETE only for permission write (Admin) delete user by id

### Useful info:
In api already exists 14 adv. and 1 user with role ADMIN, just log in with credentials admin@gmail.com 
and password admin and use postman for checking endpoints :) 
