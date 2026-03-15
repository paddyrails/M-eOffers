# M-eOffers

## Introduction

M-eOffers is the **CS Sales Offers Service** for Apple CS Sales. It exposes an API to qualify and retrieve offers based on team and channel, so clients can get the set of offers that apply for a given sales team and channel (e.g. Adviser, Employee App). Each qualifying offer is returned with offer code, product code, base price, calculated price, and discount applied. The service is part of the CS Sales ecosystem and is consumed by downstream applications that need to present or use offer eligibility and pricing.

---

## Business Architecture

- **Purpose:** Determine which offers qualify for a given team and channel, and return those offers with consistent pricing and discount information (base price, calculated price, discount applied).
- **Capabilities:** Clients supply a team code and a channel; the service returns the list of qualifying offers with offer code, product code, base price, calculated price, and discount applied. Qualification is driven by business rules (e.g. year ranges, customer type) associated with offer qualifications.
- **Scope:** Offer catalog and qualification rules are managed within the service; pricing and discount values are exposed in the API response. The service is read-oriented from the API perspective.
- **Key concepts:** Teams (e.g. identified by team codes), channels (e.g. All, Adviser, Employee App), and offer qualifications that link offers to rules (e.g. year rule, customer type) and validity windows (e.g. year ranges).

---

## Data Architecture

- **Core entities:** Offers and Offer Qualifications. An offer has an identifier, offer code, product code, and channel. A qualification links an offer to a validity window (e.g. year1–year2) and to rules stored as structured data (e.g. year rule, customer type). Rules are persisted in a flexible format (e.g. JSON) to support evolving qualification logic.
- **Data store:** Relational store (PostgreSQL). Offers and offer qualifications are stored in separate tables with a relationship between them; qualification rules use a JSON column for variable structure.
- **Data flow:** Read path: API request specifies team code and channel → service evaluates qualifications (e.g. by team/channel and rules) → offers that qualify are resolved and enriched with base price, calculated price, and discount applied → list of qualifying offers is returned. Base and calculated pricing and discounts may be derived from persisted data or from integration with catalog/pricing services.
- **Caching:** Offer-related responses are cached in memory (e.g. Caffeine) to reduce database load and improve latency for repeated team/channel combinations.

---

## Application Architecture

- **API layer:** REST over HTTP. Single offers endpoint: qualify offers by team code and channel (both supplied as query parameters). Contract is defined in OpenAPI 3 (YAML in the repo) and used for server stub generation and documentation (e.g. Swagger UI).
- **Service layer:** Orchestrates offer qualification: accepts team code and channel, uses data access to load offers and their qualifications, applies business rules to determine which offers qualify, and maps results to the response shape (offer code, product code, base price, calculated price, discount applied). Caching is applied at or above this layer.
- **Data access layer:** Persistence of offers and offer qualifications (JPA) with repository/DAO abstractions so the service remains decoupled from storage. Qualification rules are read and interpreted by the service layer.
- **Deployment unit:** Single deployable service (e.g. Spring Boot executable). Configuration is externalized (e.g. database URL, credentials, cache settings) via configuration files or environment variables. API documentation (Swagger UI) is served from the same process.

---

## Technology Architecture

- **Runtime:** Java 17.
- **Framework:** Spring Boot 3.2 (web, data JPA, cache, dev tools).
- **API:** REST; OpenAPI 3.0 for contract and documentation; SpringDoc used to serve Swagger UI from the same application.
- **Persistence:** JPA/Hibernate with PostgreSQL; connection pooling (e.g. HikariCP) and optional leak detection; schema managed by Hibernate (e.g. update strategy in non-production); PostgreSQL dialect and JSON column support for qualification rules.
- **Caching:** Spring Cache abstraction with Caffeine as the provider; cache configuration (size, TTL) and cache names defined in application configuration.
- **Build:** Maven; multi-module layout with a parent POM and a service module that produces the runnable artifact.
- **Operations:** Service runs as a single process; database and cache are the main external dependencies. Database can be run via Docker for local development using the credentials and database name referenced in the application configuration.
