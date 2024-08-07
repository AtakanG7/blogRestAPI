# Java Spring Boot API for Bloggers

A RESTful backend for modern blogging platforms. You can use this as a starting point and create your own API.

## Project Metadata

| Attribute | Value |
|-----------|-------|
| Version | 1.0.0 |
| Java Compatibility | 11+ |
| Spring Boot Version | 2.5.x |
| Database | PostgreSQL 13+ |
| API Specification | OpenAPI 3.0 |

## Technology Stack

| Layer | Technologies |
|-------|--------------|
| Application | Java 11, Spring Boot 2.5.x |
| Web | Spring MVC, Spring Security |
| Data Access | Spring Data JPA, Hibernate |
| Security | JWT, BCrypt |
| Database | PostgreSQL 13+ |
| Build | Maven 3.6+ |
| Testing | JUnit 5, Mockito |

## Core Features

| Feature | Description |
|---------|-------------|
| Authentication | JWT-based stateless authentication |
| Authorization | Role-based access control (RBAC) |
| User Management | User registration, profile updates |
| Blog Management | CRUD operations for blog posts |
| Data Validation | Input validation using Bean Validation |
| Exception Handling | Global exception handling with custom responses |

## API Endpoints

### Authentication

| Method | Endpoint | Description | Access |
|--------|----------|-------------|--------|
| POST | `/api/auth/signup` | Register new user | Public |
| POST | `/api/auth/login` | Authenticate user | Public |

### Blog Operations

| Method | Endpoint | Description | Access |
|--------|----------|-------------|--------|
| GET | `/api/blog` | Retrieve all blogs | Public |
| GET | `/api/blog/{id}` | Retrieve specific blog | Public |
| POST | `/api/blog` | Create new blog | Authenticated |
| PUT | `/api/blog/{id}` | Update blog | Authenticated |
| DELETE | `/api/blog/{id}` | Delete blog | Authenticated |

### User Management

| Method | Endpoint | Description | Access |
|--------|----------|-------------|--------|
| GET | `/api/users/{id}` | Retrieve user details | Authenticated |
| PUT | `/api/users/{id}` | Update user details | Authenticated |

## Security Measures

| Aspect | Implementation |
|--------|----------------|
| Authentication | JWT with configurable expiration |
| Password Storage | BCrypt hashing |
| Authorization | Spring Security with custom UserDetailsService |
| HTTPS | Enforced in production environments |
| CORS | Configurable Cross-Origin Resource Sharing |

## Getting Started for Developers

1. Clone the repository
2. Configure database settings in `application.properties`
3. Run `mvn spring-boot:run`
4. Access the API at `http://localhost:8080`

## Contribution Guidelines

Contributions are welcome. Please adhere to the following process:
1. Fork the repository
2. Create a feature branch
3. Commit changes and write appropriate tests
4. Submit a pull request with a comprehensive description of changes

## License

This project is licensed under the MIT License.

### Credit
Created by Atakan G. (AtakanG7)
