# Blog REST API

A simple Java Spring Boot REST API for bloggers.

## Project Overview

This project is a RESTful API built with Java and Spring Boot, designed to serve as a backend for a blogging platform. It provides endpoints for user authentication, blog post management, and user profile management.

## Features

- User authentication (signup and login)
- Blog post creation, retrieval, updating, and deletion
- User profile management
- Role-based access control

## Technologies Used

- Java
- Spring Boot
- Spring Security
- JPA / Hibernate
- JWT for authentication

## API Endpoints

### Authentication

- `POST /api/auth/signup`: Register a new user
- `POST /api/auth/login`: Authenticate a user and receive a JWT

### Blog Posts

- `GET /api/blog`: Retrieve all blog posts
- `GET /api/blog/{id}`: Retrieve a specific blog post
- `POST /api/blog`: Create a new blog post (requires authentication)
- `PUT /api/blog/{id}`: Update an existing blog post (requires authentication)
- `DELETE /api/blog/{id}`: Delete a blog post (requires authentication)

### User Management

- `GET /api/users/{id}`: Retrieve user information (requires authentication)
- `PUT /api/users/{id}`: Update user information (requires authentication and authorization)

## Setup and Installation

1. Clone the repository
2. Ensure you have Java and Maven installed
3. Configure your database settings in `src/main/resources/application.properties`
4. Run the application using `mvn spring-boot:run`

## Configuration

Make sure to set up your database configuration in `src/main/resources/application.properties`. You may also need to configure JWT secret and expiration time in this file.