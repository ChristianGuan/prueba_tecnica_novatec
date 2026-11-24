Implementación parcial de Api REST con java 17.

Incluye el endopoint 

POST /cards: para emitir tarjetas a partir de un producto existente y los datos del titular. Genera un número de 16 dígitos, con el indicador del producto como prefijo, estado inicial ISSUED, vencimiento a tres años, saldo inicial 0.00 y moneda USD.
GET /cards/{cardId}: Consulta una tarjeta por su identificador
POST /cards/{cardId}/activate: Activar una tarjeta emitida, si ya está activa, devuelve 200 sin modificar su estado.

Quedaron pendiente el endpoint de bloqueo, completar los campos de consultas y las pruebas automatizadas.

Para ejecutar, configurar DB_USERNAME, DB_PASSWORD y la URL de PostgresSQL en aplication.properties; Despues ejecurtar:

./mvnw spring-boot:run

El producto 123456 debe existir previamente en la base de datos.

Ejemplo para emitir una tarjeta, ejecutable con curl o importable en Postman:

Este es el curl de postman:
curl -i -X POST http://localhost:8080/cards \
  -H "Content-Type: application/json" \
  -d '{
    "productId": "123456",
    "holderName": "Ricardo Perez"
  }'

  Para consultar y activar, reemplazar CARD_ID por el identificador devuelto en la emisión:
  curl -i http://localhost:8080/cards/CARD_ID
  curl -i -X POST http://localhost:8080/cards/CARD_ID/activate
