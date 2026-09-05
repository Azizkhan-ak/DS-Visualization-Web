# DS-Visualization-Web

An interactive data structures visualizer built with **Spring Boot** (backend) and **HTML5/CSS/JS** (frontend).

## Purpose

This project exists for deliberate DSA practice with visual feedback. The split is intentional:

| Part | Owner |
|---|---|
| Data structure logic (algorithms, pointers, edge cases) | **Aziz** — written from scratch, no copy-paste |
| REST API wiring, DTOs, Spring boilerplate | **Aziz** |
| UI visualization (HTML/CSS/JS, animations, layout) | **Claude** |

The goal is to deeply re-learn every data structure by implementing it by hand, then immediately see it working in a browser.

## Stack

- **Backend:** Java 17, Spring Boot 3, Maven
- **Frontend:** Vanilla HTML/CSS/JS (single-file, no build step)
- **State:** `@SessionScope` — one data structure instance per browser session (multi-user safe)

## Running

```bash
mvn spring-boot:run
```

Open `http://localhost:8080`

## Data Structures

| Structure | Status | Endpoint prefix |
|---|---|---|
| Linked List (Singly) | ✅ Complete | `/api/linkedlist` |
| Stack | 🔜 Next | `/api/stack` |
| Queue | 🔜 | `/api/queue` |
| Binary Search Tree | 🔜 | `/api/bst` |
| Graph | 🔜 | `/api/graph` |

## Linked List API

| Method | Endpoint | Body |
|---|---|---|
| GET | `/api/linkedlist/state` | — |
| POST | `/api/linkedlist/insert/end` | `{ "value": 10 }` |
| POST | `/api/linkedlist/insert/beginning` | `{ "value": 10 }` |
| POST | `/api/linkedlist/insert/position` | `{ "value": 10, "position": 2 }` |
| DELETE | `/api/linkedlist/delete/end` | — |
| DELETE | `/api/linkedlist/delete/beginning` | — |
| DELETE | `/api/linkedlist/delete/value` | `{ "value": 10 }` |
| DELETE | `/api/linkedlist/delete/position` | `{ "position": 2 }` |
| POST | `/api/linkedlist/reverse` | — |
| DELETE | `/api/linkedlist/clear` | — |
| GET | `/api/linkedlist/contains/{value}` | — |

Positions are **1-based** (position 1 = head).

Response shape:
```json
{
  "values": [10, 20, 30],
  "size": 3,
  "message": "Element added!"
}
```

## Project Structure

```
src/main/java/.../
├── controllers/         REST controllers
├── services/            Interfaces
├── servicesimpls/       Implementations (Aziz writes the logic here)
├── dtos/
│   ├── general/Node.java
│   ├── request/
│   └── response/
src/main/resources/
└── static/index.html    UI (Claude builds this)
```
