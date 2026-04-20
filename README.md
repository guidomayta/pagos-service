# Microservicio de Pagos

Este es el microservicio encargado de gestionar los pagos del sistema.

## Descripción

El servicio de Pagos proporciona APIs para:
- Registrar nuevos pagos
- Consultar pagos existentes
- Actualizar estados de pagos
- Eliminar pagos
- Consultar pagos por venta
- Filtrar pagos por estado

## Puertos

- **Desarrollo (Dev)**: 8093
- **Producción**: 8093

## Configuración

### Variables de entorno

- `SPRING_PROFILES_ACTIVE`: Perfil activo (dev o prod)
- `EUREKA_CLIENT_SERVICEURL_DEFAULTZONE`: URL del servidor Eureka
- `SPRING_CONFIG_IMPORT`: URL del servidor de configuración
- `SPRING_DATASOURCE_URL`: URL de la base de datos (solo prod)
- `SPRING_DATASOURCE_USERNAME`: Usuario de la base de datos (solo prod)
- `SPRING_DATASOURCE_PASSWORD`: Contraseña de la base de datos (solo prod)

## Ejecutar en Desarrollo

```bash
./mvnw spring-boot:run
```

## Docker

### Imagen de desarrollo
```bash
docker-compose -f docker-compose-dev.yml up
```

### Imagen de producción
```bash
docker-compose up
```

## Endpoints

### GET /api/pagos
Obtiene todos los pagos

### GET /api/pagos/{id}
Obtiene un pago por ID

### GET /api/pagos/numero/{numeroPago}
Obtiene un pago por número

### GET /api/pagos/venta/{ventaId}
Obtiene los pagos de una venta

### GET /api/pagos/estado/{estado}
Obtiene pagos por estado

### POST /api/pagos
Crea un nuevo pago

### PUT /api/pagos/{id}
Actualiza un pago

### DELETE /api/pagos/{id}
Elimina un pago

## Base de datos

La base de datos se migra automáticamente usando Flyway.
