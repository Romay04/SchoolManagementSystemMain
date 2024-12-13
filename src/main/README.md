

//Note that all field are required

{
"info": {
"_postman_id": "d034b028-c70b-4cab-9735-0042e4fac211",
"name": "Parent API",
"description": "Parent RESTful API where parent can Register and Login with thier credentials",
"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json",
"_exporter_id": "38028423"
},
"item": [
{
"name": "Sign Up request",
"request": {
"method": "POST",
"header": [],
"body": {
"mode": "raw",
"raw": "{\r\n    \"email\": \"example@example.com\",\r\n    \"password\": \"mypassword\",\r\n    \"role\": \"admin\",\r\n    \"specialization\": \"software_development\"\r\n}",
"options": {
"raw": {
"language": "json"
}
}
},
"url": {
"raw": "http://localhost:8080/api/register",
"protocol": "http",
"host": [
"localhost"
],
"port": "8080",
"path": [
"api",
"signup"
]
},
"description": "Request to Sign up"
},
"response": []
},
{
"name": "Login Request",
"request": {
"method": "POST",
"header": [],
"url": {
"raw": "http://localhost:8080/auth/v1/login",
"protocol": "http",
"host": [
"localhost"
],
"port": "8080",
"path": [
"auth",
"v1",
"login"
]
},
"description": "Parent Logs in with email and password"
},
"response": []
},
{
"name": "parent dashboard",
"request": {
"method": "GET",
"header": [],
"url": {
"raw": "http://localhost:8080/auth/v1/parent",
"protocol": "http",
"host": [
"localhost"
],
"port": "8080",
"path": [
"auth",
"v1",
"parent"
]
}
},
"response": []
}
]
}