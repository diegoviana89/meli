# Meli Challenge - Local Development Setup

This guide will help you set up and run the Meli Challenge project locally.

## Prerequisites

- Java 21 JDK (OpenJDK or Oracle JDK)
- Gradle 8.0 or later (included with project)
- Your favorite IDE (IntelliJ IDEA, VS Code, or Eclipse recommended)

## Getting Started

1. **Clone the repository or unzip the project file and navigate to the project directory**
   ```bash
   git clone <repository-url>
   cd meli
   ```

2. **Build the project**
   ```bash
   # On Windows
   .\gradlew build
   
   # On macOS/Linux
   ./gradlew build
   ```

3. **Run the application**
   ```bash
   # On Windows
   .\gradlew bootRun
   
   # On macOS/Linux
   ./gradlew bootRun
   ```

   The application will start on `http://localhost:8085`

## curl
- get all products
```bash
curl --request GET \
--url http://localhost:8085/product
```
- get product by id
```bash
curl --request GET \
  --url 'http://localhost:8085/product/compare?productId=11111111-1111-1111-1111-111111111111%2C22222222-2222-2222-2222-222222222222'
```

-swagger contract
```bash
curl --request GET \
  --url http://localhost:8085/api-docs
```

## Development

### Using an IDE
1. Open the project in your preferred IDE
2. Import as a Gradle project if prompted
3. Run the main application class: `com.challenge.meli.MeliChallengeApplication`

### Database
- The application uses an embedded H2 database for development
- H2 Console is enabled at: `http://localhost:8080/h2-console`
  - JDBC URL: `jdbc:h2:mem:testdb`
  - Username: `sa`
  - Password: (leave empty)

### API Documentation
- Swagger UI: `http://localhost:8085/swagger-ui.html`
- OpenAPI Documentation: `http://localhost:8085/v3/api-docs`

## Testing

Run the test suite with:
```bash
./gradlew test
```

## Troubleshooting

- If you encounter Java version issues, ensure you have Java 21 installed and set as default
- If you see port conflicts, check if port 8080 is already in use
- For database issues, check the application logs for connection errors
