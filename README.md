# MedBill — Medical Billing System (Dark UI, Docker-ready)

This project is a small Medical Billing web app built with **Java Spring Boot** and an integrated **dark modern UI** served from the same application (no separate frontend server). It is Docker-ready using a multi-stage Dockerfile (build with Maven in the builder stage).

## Quick start (Docker required and running)

1. Build image:
   ```bash
   docker build -t medbill-app .
   ```

2. Run container:
   ```bash
   docker run -p 8080:8080 medbill-app
   ```

3. Open UI in browser:
   http://localhost:8080

### Features
- View seeded bills (3 sample records at startup)
- Add new bill via the form (inputs: patientName, treatment, amount)
- Attractive dark theme with responsive table

### Notes
- Data stored in memory (service list) — restarts clear data.
- Jenkinsfile included as CI/CD example.
- Docker multi-stage build handles Maven, so you don't need Maven locally.

