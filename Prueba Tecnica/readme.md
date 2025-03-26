# Prueba Técnica Spring Boot

### Requerimientos

* Springboot
* Docker
* Postman
* Maven
* Packaging Jar


### Dependencias
* spring-boot-starter-data-jpa
* spring-boot-starter-web
* spring-boot-devtools
* h2
* junit-jupiter-api
* spring-aop
* slf4j-api
* spring-boot-starter-test
* spring-boot-starter-cache
* spring-boot-starter-security


### Comandos disponibles

Una vez instalado, se pueden utilizar los siguiente comandos:

```DOCKER
docker build - t proyecto .  #imagen
docker build run - p 8000:8080 proyecto:latest    #contenedor 
```

### Estructura de Archivos

* `aspect` Para un log en específico
* `service` Para la lógica.
* `cache` Para la cache.
* `controller` Para realizar el CRUD.
* `exceptions` Para poder lanzar excepciones.
* `model` Para definir la entidad JPA.
* `repository` La interfaz que nos permitira no realizar sql manual.
* `security` La seguridad del proyecto.
* `Service.test` Los tests Unitarios.
* `target.` Tendremos los .jar para dockerizar el proeyecto.
* 

### Accesos

PUT     Modificar    nave-> http://localhost:8000/api/naves
POST    Añadir       nave-> http://localhost:8000/api/naves
GET     Listar       naves-> http://localhost:8000/api/naves
GET     ListarID     nave-> http://localhost:8000/api/naves/{id}
DELETE  ListarID     nave-> http://localhost:8000/api/naves/{id}
GET     ListarParam  nave->http://localhost:8000/api/naves/buscar
Consola  Sin Seguridad http://localhost:8000/h2-console