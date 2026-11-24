Implementación parcial de Api REST con java 17.

Incluye el endopoint POST /cards para emitir tarjetas a partir de un producto existente y los datos del titular. Genera un número de 16 dígitos, con el indicador del producto como prefijo, estado inicial ISSUED, vencimiento a tres años, saldo inicial 0.00 y moneda USD.

Para ejecutar, configurar DB_USERNAME, DB_PASSWORD y la URL de PostgresSQL en aplication.properties; Despues ejecurtar:

./mvnw spring-boot:run

Este es el curl de postman:
curl -i -X POST http://localhost:8080/cards \
  -H "Content-Type: application/json" \
  -d '{
    "productId": "123456",
    "holderName": "Ricardo Perez"
  }'
