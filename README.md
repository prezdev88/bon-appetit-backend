# Postgre connection string
```bash
postgresql://admin:123123@bonappetit-backend-postgres:5432/bonappetit_db?options=-c%20TimeZone=America/Santiago
```

# Endpoints

```bash
curl -X POST http://localhost:8080/api/waiters \
           -H "Content-Type: application/json" \
           -d '{"name":"Juan Pérez"}'
```