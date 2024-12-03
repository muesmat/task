# Tasks APIs

This is a springboot v(3.4.0) project to manage tasks with securtiy enabled.

postgres sql script & Postman collection available the repo

paging is applied over get all tasks and search

## Run

Please run the following command:

```bash
mvn spring-boot:run
```

## Usage

### User signup : POST /api/v1/users (required only ADMIN)
Request

```json
{
    "firstName" : "Muhammad", // required
    "lastName" : "Ahmed", // required
    "email" : "mud23@gmail.com", // required
    "password" : "qwertyuiop[]", // required;min=10;max=100
    "role" : "USER" // required;^(ADMIN|USER)$
}
```
Response

```json
{
    "firstName": "Muhammad",
    "lastName": "Ahmed",
    "email": "mud32@gmail.com",
    "role": "USER"
}
```
### User signin : POST /api/v1/users/login
Request
```json
{
    "email" : "mud32@gmail.com",
    "password" : "qwertyuiop[]"
}
```
Response

```json
{
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtdWQzMkBnbWFpbC5jb20iLCJpYXQiOjE3MzMyMzQ5NzIsImV4cCI6MTczMzgzOTc3Mn0"
}
```
### Create Task : POST /api/v1/tasks (require ADMIN role)
Request
```json
{
    "title": "task #1", // required
    "description": "task #1 description",
    "priority": "HIGH", // required;^(HIGH|MEDIUM|LOW)$
    "dueDate": "2024-12-02T22:18:21.683+00:00" // required
}
```
Response

```json
{
    "id": 19,
    "title": "task #1",
    "description": "task #1 description",
    "status": "TODO",
    "priority": "HIGH",
    "dueDate": "2024-12-02T22:18:21.683+00:00"
}
```
### Update Task : PUT /api/v1/tasks/{id} (require ADMIN or USER roles)
Request
```json
{
    "title": "task #1",
    "description": "task #1 description",
    "priority": "HIGH",
    "status" : "TODO", // optional or (HIGH|MEDIUM|LOW)$
    "dueDate": "2024-12-02T22:18:21.683+00:00" 
}
```
Response

```json
{
    "id": 14,
    "title": "task #1",
    "description": "task #1 description",
    "status": "TODO",
    "priority": "HIGH",
    "dueDate": "2024-12-02T22:18:21.683+00:00"
}
```

### Get all Tasks: GET /api/v1/tasks?offset=1&pageSize=4 (require ADMIN role)

Response

```json
[
    {
        "id": 3,
        "title": "task #1",
        "description": "task #1 description",
        "status": "todo",
        "priority": "1",
        "dueDate": "2024-12-02T22:18:21.683+00:00"
    },    
    {
        "id": 8,
        "title": "task #1",
        "description": "task #1 description",
        "status": "todo",
        "priority": "1",
        "dueDate": "2024-12-02T22:18:21.683+00:00"
    }
 
    {
        "id": 15,
        "title": "task #1",
        "description": "task #1 description",
        "status": "TODO",
        "priority": "HIGH",
        "dueDate": "2024-12-02T22:18:21.683+00:00"
    },
    {
        "id": 5,
        "title": "task #1",
        "description": "task #1 description",
        "status": "todo",
        "priority": "LOWE",
        "dueDate": "2024-12-02T22:18:21.683+00:00"
    }
 
]
```

### Get Task by Id : GET /api/v1/tasks/1 (require ADMIN or USER roles)

Response

```json
{
    "id": 3,
    "title": "task #1",
    "description": "task #1 description",
    "status": "todo",
    "priority": "1",
    "dueDate": "2024-12-02T22:18:21.683+00:00"
}
```
### Search Tasks : GET /api/v1/tasks/search?priority=HIGH&title=task&description=description&status=SCHEDULED&offset=2&pageSize=3

Paramaters:
priority: optional or HIGH|MEDUIM|LOW
status: optinal or TODO|SCHEDULED|DONE
title: min 3 charaters
description: min 5 charaters

Response

```json
[
    {
        "id": 17,
        "title": "task #1",
        "description": "task #1 description",
        "status": "SCHEDULED",
        "priority": "HIGH",
        "dueDate": "2024-12-02T22:18:21.683+00:00"
    }
]
```


### Delete Task by Id : Delete /api/v1/tasks/1 (require ADMIN  role)
