# 🧠 CicloVital – Backend (Spring Boot)

Este proyecto corresponde al desarrollo de una API REST con **Spring Boot**, como parte del curso de **Programación II**. Su propósito es simular un sistema de acompañamiento emocional para usuarios, con capacidad de registrar emociones, mantener conversaciones (tipo chatbot) y guardar registros diarios personales.

La API está conectada a una base de datos **PostgreSQL** en la nube a través de **Neon** (https://neon.tech), lo que permite desplegar y trabajar desde cualquier lugar.

---

## 🎯 Funcionalidades principales

- Registro y autenticación de usuarios
- Creación de chats por usuario (máximo 100)
- Gestión de mensajes dentro de cada chat (ilimitados)
- Registro emocional diario (máximo 1 por día por usuario)

---

## 🧱 Tecnologías utilizadas

- Java 17
- Spring Boot 3.x
- Maven
- PostgreSQL (Neon)
- Validaciones con `@Validated`
- Arquitectura RESTful
- CORS habilitado para uso con frontend

---

## 🧩 Reglas de negocio implementadas

- ✅ Máximo de **100 chats por usuario**
- ✅ Mensajes **ilimitados por chat**
- ✅ Solo **1 registro emocional por día** por usuario
- ✅ Validaciones de correo único, duplicados, y errores de entrada
- ✅ Manejo de respuestas con `ResponseEntity` y códigos HTTP apropiados

---

## 🛠️ Endpoints REST disponibles

### 🔐 Usuarios – `/api/usuarios`

| Método | Ruta | Descripción |
|--------|------|-------------|
| `GET` | `/api/usuarios` | Lista todos los usuarios |
| `GET` | `/api/usuarios/{id}` | Busca usuario por ID |
| `POST` | `/api/usuarios` | Registra nuevo usuario |
| `PUT` | `/api/usuarios/actualizar/{id}` | Actualiza un usuario existente |
| `DELETE` | `/api/usuarios/eliminar/{id}` | Elimina un usuario por ID |
| `POST` | `/api/usuarios/login` | Login con correo y contraseña |

---

### 💬 Chats – `/api/chats`

| Método | Ruta | Descripción |
|--------|------|-------------|
| `GET` | `/api/chats` | Lista todos los chats |
| `GET` | `/api/chats/{id}` | Busca chat por ID |
| `POST` | `/api/chats` | Crea un nuevo chat (máx. 100 por usuario) |
| `PUT` | `/api/chats/actualizar/{id}` | Actualiza un chat |
| `DELETE` | `/api/chats/eliminar/{id}` | Elimina un chat |

---

### 📨 Mensajes – `/api/mensajes`

| Método | Ruta | Descripción |
|--------|------|-------------|
| `GET` | `/api/mensajes` | Lista todos los mensajes |
| `GET` | `/api/mensajes/{id}` | Busca mensaje por ID |
| `POST` | `/api/mensajes` | Crea un nuevo mensaje en un chat |
| `PUT` | `/api/mensajes/actualizar/{id}` | Actualiza un mensaje |
| `DELETE` | `/api/mensajes/eliminar/{id}` | Elimina un mensaje |

---

### 📘 Registros diarios – `/api/registros`

| Método | Ruta | Descripción |
|--------|------|-------------|
| `GET` | `/api/registros` | Lista todos los registros |
| `GET` | `/api/registros/{id}` | Busca registro por ID |
| `POST` | `/api/registros` | Crea nuevo registro (1 por día por usuario) |
| `PUT` | `/api/registros/actualizar/{id}` | Actualiza un registro diario |
| `DELETE` | `/api/registros/eliminar/{id}` | Elimina un registro diario |

---

## 🌐 Configuración para conexión con Neon

En `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://<tu-url-neon>/<tu-db>?sslmode=require
spring.datasource.username=<usuario>
spring.datasource.password=<contraseña>

spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
