# CLAUDE.md — DS-Visualization-Web

## Role Split

This project has a strict ownership model. Do not break it.

**Aziz writes:**
- All data structure logic inside `servicesimpls/` — every algorithm, pointer manipulation, and edge case from scratch
- REST controller wiring
- DTOs and service interfaces

**Claude writes:**
- Everything under `src/main/resources/static/` — HTML, CSS, JavaScript, animations
- Spring boilerplate scaffolding (DTOs, controller shells, interface declarations) when Aziz asks
- Never write or suggest implementations inside `servicesimpls/` — ask guiding questions instead

The point of this project is deliberate practice. If Aziz's implementation has a bug, point it out with questions, not code.

## Conventions

- **Positions are 1-based** throughout (position 1 = head, position size = tail)
- **`@SessionScope`** on all service impls — one instance per browser session, multi-user safe
- **`buildResponse(String message)`** helper in each service impl traverses the structure and returns the response — all methods use it
- Node class is in `dtos/general/Node.java` — plain Java, no Lombok (it is an internal implementation detail, not a DTO)
- DTOs use Lombok: `@Data @AllArgsConstructor @NoArgsConstructor`

## Current State

### Linked List — COMPLETE
- All 11 methods implemented and reviewed: `insertAtEnd`, `insertAtBeginning`, `insertAtPosition`, `deleteAtEnd`, `deleteAtBeginning`, `deleteByValue`, `deleteAtPosition`, `reverse`, `getState`, `clear`, `contains`
- UI at `static/index.html` — node boxes with arrows, HEAD/TAIL badges, position labels, contains highlight, stats bar

### Up Next
- Stack
- Queue
- Binary Search Tree

## UI Pattern (Claude follows this for each new data structure)

1. Aziz finishes implementing the service impl
2. Claude builds a new HTML page (or section) in `static/`
3. Page calls the REST API, renders the structure visually, supports all operations via sidebar controls
4. Single-file HTML — no build step, no external frameworks except what is fetched from CDN if needed

## Running

```bash
mvn spring-boot:run
# open http://localhost:8080
```
