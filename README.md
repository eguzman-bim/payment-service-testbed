# Payment Service

API REST de pagos de demostración con Java 17, Spring Boot 3.5 y H2 en memoria.

## Requisitos

- JDK 17
- Maven 3.9 o superior

## Ejecutar

```bash
mvn test
mvn spring-boot:run
```

La base de datos H2 se crea al iniciar la aplicación y se descarta al detenerla.

## API

Crear un pago:

```bash
curl -i -X POST http://localhost:8080/api/payments \
  -H 'Content-Type: application/json' \
  -d '{"merchantId":"merchant-demo","amount":12.50,"currency":"USD"}'
```

Consultarlo con el `id` devuelto:

```bash
curl -i http://localhost:8080/api/payments/UUID_DEL_PAGO
```

Consultar el reporte por comercio:

```bash
curl -i 'http://localhost:8080/api/legacy/reports?merchant=merchant-demo'
```

## Estructura

```text
src/main/java/com/example/payment/
├── PaymentApplication.java
├── api/PaymentController.java
├── domain/Payment.java
├── domain/PaymentRepository.java
└── legacy/
    ├── LegacyReportController.java
    └── LegacyReportRepository.java
src/main/resources/
├── application.properties
└── schema.sql
src/test/java/com/example/payment/PaymentApplicationTests.java
pom.xml
```
