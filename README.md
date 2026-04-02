# WhatsApp Chatbot Backend (Spring Boot)

This is a small backend project that simulates a WhatsApp chatbot webhook using Spring Boot.
It accepts a JSON request, reads the `message` field, and returns a simple reply.

## Features

- REST endpoint: POST /webhook
- Simple chatbot rules:
  - Hi -> Hello
  - Bye -> Goodbye
  - anything else -> I didn't understand that
- Logs every incoming message using SLF4J (so you can see requests in the console)

## Tech Stack used

- Java 17
- Spring Boot (Maven)
- Spring Web (REST API)
- SLF4J + Logback (logging)

## Project Structure

I kept the project structure clean and simple:

- controller package: handles the REST endpoint (`WebhookController`)
- service package: chatbot logic (`ChatbotService`)
- model package: request/response classes (`WebhookRequest`, `WebhookResponse`)
- src/main/resources/application.properties: server configuration


## API Details

### Endpoint

- `POST /webhook`

### Sample Request JSON

```json
{
  "message": "Hi"
}
```

### Sample Responses

1. When input is `Hi`

Request:
```json
{ "message": "Hi" }
```

Response:
```json
{
  "reply": "Hello"
}
```

2. When input is `Bye`

Request:
```json
{ "message": "Bye" }
```

Response:
```json
{
  "reply": "Goodbye"
}
```

3. When input is unknown (example)

Request:
```json
{ "message": "What is this?" }
```

Response:
```json
{
  "reply": "I didn't understand that"
}
```

## Logging Explanation

Every incoming request message is logged using a normal logger (SLF4J).
You’ll see lines in the console like:

- `Incoming message: ...`

## Challenges Faced (and how I solved them)

1. **Getting Maven + Spring Boot working correctly**
   - I fixed the pom.xml to use the proper Spring Boot parent and added the spring-boot-starter-web dependency.

2. **Making sure the controller returns the exact JSON format**
   - I used a response model (`WebhookResponse`) so the output always matches:
     `{"reply":"..."}`.

3. **Making it easy to deploy later**
   - I set the server port in `application.properties` using `PORT` with a fallback, so hosting platforms won’t break the app.

## Future Improvements

- Add a `GET /health` endpoint for checking server status
- Add more chatbot rules (more commands, keyword matching)
- Add basic tests for the chatbot service and controller

## Deployment

This project is deployed on Render using Docker.

Live API:
https://whatsapp-chatbot-2-ncue.onrender.com/webhook


