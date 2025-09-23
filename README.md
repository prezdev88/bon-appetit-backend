# Postgre connection string
```bash
postgresql://admin:123123@bonappetit-backend-postgres:5432/bonappetit_db?options=-c%20TimeZone=America/Santiago
```

# Endpoints

## Create a waiter
```bash
curl -X POST http://localhost:8080/api/waiters \
    -H "Content-Type: application/json" \
    -d '{"name":"Juan Pérez", "userIdNumber":"11222333"}'
```

## Get list of waiters
```bash
curl -X GET http://localhost:8080/api/waiters
```

```bash
curl -X GET http://localhost:8080/api/waiters?page=0&size=10&sort=id,asc
```

## Waiter login
```bash
curl -i -X POST http://localhost:8080/api/waiters/login \
    -H "Content-Type: application/json" \
    -d '{"userIdNumber":"11222333"}'
```

## Search
```bash
curl -X GET "http://localhost:8080/api/waiters/search?name=jua&page=0&size=10&sort=name,asc" \
  -H "Accept: application/json"
```

## Disable waiter
```bash
curl -X DELETE http://localhost:8080/api/waiters/1
```
