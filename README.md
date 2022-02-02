# springboot2-java11-incoming-request-log
Sample project for log incoming HTTP requests into a file and expose to Actuator

## Specifications
* Spring Boot 2.6.3
* Java 11

## Create a greeting
Make a `POST` request to `/api/greetings`, as shown in the following curl-based example:
```shell
curl --location --request POST 'http://localhost:8080/api/greetings' \
--header 'Content-Type: application/json' \
--data-raw '{
    "to_person": "Joseph",
    "from_place": "Perú"
}'
```
The generated request is similar to the following:
```http
POST /api/greetings HTTP/1.1
Content-Type: application/json
Host: localhost:8080

{
"to_person": "Joseph",
"from_place": "Perú"
}
```
The resulting response is similar to the following:
```
HTTP/1.1 200 OK
Content-Type: text/plain;charset=UTF-8
 
Hello, Joseph from Perú
```

## Retrieving the log file
Make a `GET` request to `/api/actuator/logfile`, as shown in the following curl-based example:
```shell
curl --location --request GET 'http://localhost:8080/api/actuator/logfile'
```
The generated request is similar to the following:
```http
GET /api/actuator/logfile HTTP/1.1
Host: localhost:8080
```
The resulting response is similar to the following:
```
HTTP/1.1 200 OK
Content-Type: text/plain;charset=UTF-8

2022-01-30 18:19:33.505 DEBUG 6204 --- [http-nio-8080-exec-8] o.s.w.f.CommonsRequestLoggingFilter      : Before request [POST /api/greetings, client=0:0:0:0:0:0:0:1, headers=[user-agent:"PostmanRuntime/7.29.0", accept:"*/*", postman-token:"20e2e4f9-cd24-49d0-a662-ae929dd89733", host:"localhost:8080", accept-encoding:"gzip, deflate, br", connection:"keep-alive", content-length:"59", Content-Type:"application/json;charset=UTF-8"]]
2022-01-30 18:19:33.510 DEBUG 6204 --- [http-nio-8080-exec-8] o.s.w.f.CommonsRequestLoggingFilter      : After request [POST /api/greetings, client=0:0:0:0:0:0:0:1, headers=[user-agent:"PostmanRuntime/7.29.0", accept:"*/*", postman-token:"20e2e4f9-cd24-49d0-a662-ae929dd89733", host:"localhost:8080", accept-encoding:"gzip, deflate, br", connection:"keep-alive", content-length:"59", Content-Type:"application/json;charset=UTF-8"], payload={
    "to_person": "Joseph",
    "from_place": "Perú"
}]
2022-01-30 18:19:36.832 DEBUG 6204 --- [http-nio-8080-exec-9] o.s.w.f.CommonsRequestLoggingFilter      : Before request [GET /api/actuator/logfile, client=0:0:0:0:0:0:0:1, headers=[user-agent:"PostmanRuntime/7.29.0", accept:"*/*", postman-token:"00cd241b-334e-42ec-9846-bb744414065e", host:"localhost:8080", accept-encoding:"gzip, deflate, br", connection:"keep-alive"]]
```
