# Prueba Técnica Spring Boot

Este proyecto es una prueba técnica desarrollada con Spring Boot. Permite gestionar una entidad `Nave` con operaciones CRUD (Crear, Leer, Actualizar y Eliminar), utilizando JPA para la persistencia, Docker para la contenedorización y seguridad mediante Spring Security.

## Requerimientos

- **Spring Boot**
- **Docker**
- **Postman** (para pruebas)
- **Maven**
- **Packaging JAR**

## Dependencias

El proyecto utiliza las siguientes dependencias:

- `spring-boot-starter-data-jpa`: Para la integración con JPA y bases de datos.
- `spring-boot-starter-web`: Para la creación de una API REST.
- `spring-boot-devtools`: Herramientas de desarrollo para mejorar la productividad.
- `h2`: Base de datos en memoria para desarrollo.
- `junit-jupiter-api`: Framework de pruebas unitarias.
- `spring-aop`: Para la programación orientada a aspectos.
- `slf4j-api`: Librería para la gestión de logs.
- `spring-boot-starter-test`: Dependencias para realizar pruebas unitarias.
- `spring-boot-starter-cache`: Soporte para caché.
- `spring-boot-starter-security`: Para la configuración de seguridad en la API.

## Comandos disponibles

Una vez que el proyecto esté instalado, puedes usar los siguientes comandos para construir y ejecutar el contenedor Docker:

```bash
# Construir la imagen Docker
docker build -t proyecto .

# Ejecutar el contenedor
docker run -p 8000:8080 proyecto:latest


Estructura de Archivos
La estructura del proyecto está organizada de la siguiente manera:

aspect: Contiene los aspectos relacionados con el logging.

service: Contiene la lógica de negocio.

cache: Implementación de la lógica de caché.

controller: Implementación de los controladores para las operaciones CRUD.

exceptions: Manejo de excepciones personalizadas.

model: Definición de las entidades JPA.

repository: Interfaces para interactuar con la base de datos sin necesidad de escribir consultas SQL manualmente.

security: Configuración de la seguridad del proyecto.

Service.test: Contiene las pruebas unitarias.

target/: Carpeta donde se generarán los archivos .jar para Dockerizar el proyecto.

Rutas de Acceso
A continuación se listan las rutas disponibles para interactuar con la API:

PUT: Modificar una nave
URL: http://localhost:8000/api/naves

POST: Añadir una nueva nave
URL: http://localhost:8000/api/naves

GET: Listar todas las naves
URL: http://localhost:8000/api/naves

GET: Listar una nave por ID
URL: http://localhost:8000/api/naves/{id}

DELETE: Eliminar una nave por ID
URL: http://localhost:8000/api/naves/{id}

GET: Buscar naves con parámetros específicos
URL: http://localhost:8000/api/naves/buscar

Consola H2 (sin seguridad):
URL: http://localhost:8000/h2-console
