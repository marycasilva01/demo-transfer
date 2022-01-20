# transfer

## Inserção de agendamento de transferências financeiras

## Parametros Consulta

- Endpoint: http://localhost:8080/demo/transfers?page=0&size=20
- page = Pagina atual. Default = 0
- size = Tamanho da página a ser buscada no banco. Default = 20
```shell
curl -X GET "http://localhost:8080/demo/transfers?page=0&size=20" -H  "accept: application/json"

```
## Post (Salvar agendamento)

### Request
```shell
curl -X POST "http://localhost:8080/demo/transfers" 
-H  "accept: application/json" 
-H  "Content-Type: application/json" 
-d "{\"amount\":100000,\"transferAt\":\"2022-02-10\",\"accountOrigin\":\"1234\",\"accountDestination\":\"2345\"}"
```
### Response
```shell
{
  "id": 1,
  "amount": 100000,
  "feeAmount": 4000,
  "type": "C",
  "createdAt": "2022-01-10",
  "transferAt": "2022-02-10",
  "accountOrigin": "1234",
  "accountDestination": "2345"
}
```

## Swagger
- http://localhost:8080/demo/swagger-ui
