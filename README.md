# Product details

This application was built with Spring Boot and an in-memory database (H2).


SOLID principles and clean code practices were applied to the project.

The following patterns were used:
- builder
- Adapter
- Singleton

## Execute the application

You can use the zip file to get the project or you can clone the repository.
https://github.com/diegoviana89/meli

Go to [run.md](run.md) file to know  the prerequisites and how to run the application.


## AI productivity
Windsurf AI plugin was used to generate some code, configurations and documentation.
Go to [prompts.md](prompts.md) to know the used prompts.

## Endpoints

After running the application hit the following endpoints to get the documentation and details

- Swagger UI: `http://localhost:8085/swagger-ui.html`
- OpenAPI Documentation: `http://localhost:8085/v3/api-docs`

## Project structure

This project was built using hexagonal architecture to decouple the layers from each other and make it more
scalable as needed.


```
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── challenge/
│   │   │           └── meli/
│   │   │               ├── MeliApplication.java
│   │   │               ├── domain/
│   │   │               ├── exceptions/
│   │   │               ├── infraestructure/
│   │   │               └── repository/
│   │   └── resources/
│   └── test/
│       └── java/
├── .gitattributes
├── .gitignore
├── build.gradle
├── gradlew
├── gradlew.bat
├── HELP.md
├── prompt.md
├── README.md
├── run.md
└── settings.gradle        
```

# get the API documentation
- http://localhost:8085/swagger-ui.html
- http://localhost:8085/v3/api-docs