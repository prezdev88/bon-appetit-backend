# Postgre connection string
```bash
postgresql://admin:123123@bonappetit-backend-postgres:5432/bonappetit_db?options=-c%20TimeZone=America/Santiago
```

# Endpoints

## Create a waiter
```bash
curl -X POST http://localhost:8080/api/waiters \
    -H "Content-Type: application/json" \
    -d '{"name":"Juan Pérez"}'
```

## Get list of waiters
```bash
curl -X GET http://localhost:8080/api/waiters
```

```bash
curl -X GET http://localhost:8080/api/waiters?page=0&size=10&sort=id,asc
```