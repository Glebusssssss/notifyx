# NotifyX — Asynchronous Notification Service Engine

[![Live Demo](https://img.shields.io/badge/Vercel-Live%20Production-black?logo=vercel)](https://notifyx-wheat.vercel.app)
[![Java 17](https://img.shields.io/badge/Java-17-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Build Status](https://img.shields.io/badge/Tests-JUnit%205%20%7C%20Mockito-blue.svg)]()

NotifyX is a robust, lightweight asynchronous backend notification service built with **Java 17** and **Spring Boot**. Designed to mirror enterprise microservice architectures, it processes multi-channel notification dispatches (EMAIL, SMS, PUSH), handles state persistence via JPA, and provides structured audit logging.

---

## 🚀 Live Endpoints

- **Live Service Base URL:** [https://notifyx-wheat.vercel.app](https://notifyx-wheat.vercel.app)
- **Health Check Endpoint:** `GET /`
- **Notification API:** `POST /api/v1/notifications`

---

## ✨ Features

- **Multi-Channel Dispatch:** Support for `EMAIL`, `SMS`, and `PUSH` notification channels.
- **State Management & Auditing:** Persistent lifecycle status tracking (`SENT`, `PENDING`, `FAILED`) with automatically updated timestamps.
- **RESTful API Interface:** Structured JSON request validation and response handling.
- **Containerised Deployment:** Dockerized build environment running live on Vercel container infrastructure.
- **Automated Health Monitoring:** Root path status mapping returning runtime operational metrics.

---

## 🛠 Tech Stack

- **Language:** Java 17
- **Framework:** Spring Boot, Spring Data JPA, Spring Web
- **Database:** H2 Database (In-Memory / Persistent SQL)
- **Testing:** JUnit 5, Mockito
- **DevOps & Infrastructure:** Docker, Vercel Containers, Git

---

## 🧪 Testing

The service includes a complete unit test suite validating controller mappings, service logic, and mock dependency behaviours.

To run the full test suite locally:

```bash
./mvnw test