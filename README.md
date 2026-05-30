# 🚀 OrderTracker — E-Commerce Order Management Backend with Webhook Integration

OrderTracker is a **microservice-based backend system** designed for managing e-commerce orders with real-time webhook processing, JWT security, and distributed architecture using Spring Boot and Spring Cloud.

The system handles **order creation, status tracking, payment/shipment webhook events, logging, and notifications** in a scalable and modular way.

---

# 🏗️ Architecture

The system is built using microservices:

- API Gateway
- Auth Service (JWT Authentication)
- Order Service (Order Management)
- Webhook Service (External event processing)
- Logging Service (Audit & Webhook logs)
- Notification Service (Email notifications)
- Eureka Discovery Server
- PostgreSQL Databases (per service)

---

# ⚙️ Tech Stack

- Java 17+
- Spring Boot
- Spring Cloud (Eureka, OpenFeign)
- Spring Security (JWT)
- Spring Data JPA
- PostgreSQL
- Docker & Docker Compose
- Swagger / OpenAPI 3
- SLF4J Logging

---

# 🎯 Features

## 🔐 Authentication & Authorization
- JWT-based stateless authentication
- Role-based access control (USER / ADMIN)

---

## 📦 Order Management
- Create, update, delete orders
- Track order status
- Role-based access for order operations

---

## 🔗 Webhook Integration
- `POST /api/webhooks/payment`
- `POST /api/webhooks/shipment`

Automatically updates order status based on external events (payment/shipping providers).

---

## 📧 Email Notifications
- Async email notifications using `@Async`
- Triggered after webhook updates

---

## 📊 Logging & Audit
- Stores all webhook events in database
- Timestamped audit trail for debugging and monitoring

---

## 📄 API Documentation
- Swagger UI available for all services
- OpenAPI 3 specification enabled

---

# 🐳 Run with Docker

```bash
docker compose up --build
