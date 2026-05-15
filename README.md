# Belbin Team Role Evaluator

A Spring Boot web application that guides users through a Belbin-inspired team role self-assessment and presents their results on a visual, podium-style results page.

> ⚠️ **Disclaimer:** This is a Belbin-*inspired* side project for learning purposes. The questions are not the official Belbin Self-Perception Inventory, which is copyrighted by Belbin Associates. For the official assessment, visit [belbin.com](https://www.belbin.com).

---

## What is Belbin?

The Belbin model describes nine roles that people naturally play in teams, grouped into three categories:

| Category | Roles |
|---|---|
| 🤝 Social | Resource Investigator, Teamworker, Co-ordinator |
| 💡 Thinking | Plant, Monitor Evaluator, Specialist |
| ⚙️ Task | Shaper, Implementer, Completer Finisher |

---

## Tech Stack

| Technology | Version | Purpose |
|---|---|---|
| Java | 25 | Language |
| Spring Boot | 4.0.6 | Web framework |
| Spring Data JPA | — | Database abstraction |
| H2 Database | — | Embedded file-based DB |
| Thymeleaf | — | Server-side HTML templates |
| Lombok | — | Boilerplate reduction |
| Maven | — | Build tool |

---

## Getting Started

### Prerequisites

- Java 25
- Maven (or use the included `mvnw` wrapper)

### Run the app

```bash
./mvnw spring-boot:run
```

Then open your browser at:

```
http://localhost:8080
```

The database is seeded automatically on first startup — no setup required.

### Other useful commands

```bash
# Run tests
./mvnw test

# Build a JAR
./mvnw package

# Run the JAR
java -jar target/belbineval-0.0.1-SNAPSHOT.jar
```

---

## How It Works

1. **Landing page** — user enters their name and starts the test
2. **7 sections** — each section shows 8 statements; user distributes exactly 10 points across them
3. **Validation** — points must sum to exactly 10, and each value must be between 0 and 10
4. **Scoring** — after all 7 sections, points are summed per role across all answers
5. **Results** — roles are ranked by score, converted to percentages, and displayed

### Scoring logic

Each of the 56 statements is tagged to a Belbin role. When a user assigns points to a statement, those points accumulate toward that role's total. After all 7 sections:

```
Role score     = sum of all points given to statements tagged with that role
Role %         = (role score / total points given) × 100
```

The top 3 roles are displayed on the podium. All 9 roles appear in the full breakdown, grouped by category.

---

## Project Structure

```
com.rf2.belbineval
├── model/
│   ├── BelbinRole.java          # Enum — 9 roles with displayName, category, description, strengths, weaknesses
│   ├── RoleCategory.java        # Enum — SOCIAL, THINKING, TASK
│   ├── Question.java            # Entity — section, statementIndex, text, role
│   ├── Submission.java          # Entity — participantName, takenAt, answers
│   └── Answer.java              # Entity — submission, question, points
├── repository/
│   ├── QuestionRepository.java
│   ├── SubmissionRepository.java
│   └── AnswerRepository.java
├── service/
│   ├── ScoringService.java      # calculateScores, getRankedRoles, getTopRoles, calculatePercentages
│   └── SubmissionService.java   # createSubmission, saveAnswersForSection, isSectionValid
├── controller/
│   ├── HomeController.java      # GET /, POST /start
│   ├── TestController.java      # GET+POST /test/{id}/section/{n}
│   └── ResultsController.java   # GET /results/{id}
└── seeder/
    └── DataSeeder.java          # Seeds 56 questions on first startup

src/main/resources/
├── templates/
│   ├── index.html               # Landing page
│   ├── section.html             # Question form with live point counter
│   └── results.html             # Podium + role details + full breakdown
├── static/css/
│   └── style.css
└── application.properties
```

---

## Key URLs

| URL | Description |
|---|---|
| `http://localhost:8080` | Landing page |
| `http://localhost:8080/test/{id}/section/1` | First section of a test |
| `http://localhost:8080/results/{id}` | Results for a submission |
| `http://localhost:8080/h2-console` | H2 database console |

### H2 Console connection details

| Field | Value |
|---|---|
| JDBC URL | `jdbc:h2:file:./belbin-db` |
| User Name | `sa` |
| Password | *(leave empty)* |

---

## Results Page

The results page has three sections:

**🏆 Podium** — top 3 roles in olympic podium layout (1st centre, 2nd left, 3rd right) with role name, category badge and percentage score.

**📖 About Your Top Roles** — detail cards for each top role including description, strengths and allowable weaknesses.

**📊 Full Breakdown** — all 9 roles grouped by category (Social / Thinking / Task) with a bar chart column showing relative scores.

---

## Configuration

`src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:h2:file:./belbin-db
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

server.port=8080
```

Data persists between restarts because `jdbc:h2:file:` is used instead of `jdbc:h2:mem:`.

---

## Possible Future Features

- 📋 History page — list and revisit past submissions by name
- 🖨️ Print / export — PDF-friendly results view
- 🔒 Spring Security — user accounts so results are private
- 🐘 PostgreSQL — swap H2 for a production-grade database
- 👥 Team view — aggregate multiple submissions into a team balance overview
- 📊 Compare profiles — side-by-side comparison between two participants

---

## License

This project is for educational purposes. The Belbin Team Roles model is the intellectual property of Belbin Associates. This application is not affiliated with or endorsed by Belbin Associates.
