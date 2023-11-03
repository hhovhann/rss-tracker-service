# Software Document
RSS/Atom feeds update tracker Rest API service project for Spring Boot

## Software Environment

- Java 20 (soon will move to 21, not supporting by maven yet)
- Postgres database
- Flyway migration
- Spring Boot 3.1.5
- Maven 3.9.5
- The Room Java Library 2.1.0

## Software Structure
- feature_name(feed) 
  - controller
  - dto
  - entity
  - mapper
  - repository
  - service

## Software Behaviour
System designed as a Spring Boot Web Application. Provides Rest API with following endpoints:

1. Get list of stored resources faceted by given categories and date range (with query params) 
```
GET http://localhost:8080/tracker/api/v1/feeds/search?categories=CORS,JAVA&dateFrom=2010-04-27T04:30:45.123Z&dateTo=2023-10-30T22:30:45.123Z

RESPONSE BODY:
[
    {
        "title": "spring-mvc-cors-configuration",
        "link": "https://howtodoinjava.com/spring5/webmvc/spring-mvc-cors-configuration/",
        "description": "CORS helps in serving web content from multiple domains into browsers who usually have the same-origin security policy. In this example, we will learn to enable CORS support in Spring MVC application at method and global level.The post <a rel=\"nofollow\" href=\"https://howtodoinjava.com/spring5/webmvc/spring-mvc-cors-configuration/\">Spring CORS Configuration Examples</a> appeared first on <a rel=\"nofollow\" href=\"https://howtodoinjava.com\">HowToDoInJava</a>.",
        "getPublicationDate": "2023-11-02T23:59:46+04:00",
        "author": "Lokesh Gupta",
        "thumbnails": "thumbnails icon link here",
        "categories": [
            "CORS"
        ],
        "relatedIdentifiers": "https://howtodoinjava.com/spring5/webmvc/spring-mvc-cors-configuration/"
    },
    {
        "title": "Spring CORS Configuration Examples",
        "link": "https://howtodoinjava.com/spring5/webmvc/spring-mvc-cors-configuration/",
        "description": "CORS helps in serving web content from multiple domains into browsers who usually have the same-origin security policy. In this example, we will learn to enable CORS support in Spring MVC application at method and global level.\nThe post <a rel=\"nofollow\" href=\"https://howtodoinjava.com/spring5/webmvc/spring-mvc-cors-configuration/\">Spring CORS Configuration Examples</a> appeared first on <a rel=\"nofollow\" href=\"https://howtodoinjava.com\">HowToDoInJava</a>.",
        "getPublicationDate": "2023-11-02T23:59:48+04:00",
        "author": "Lokesh Gupta",
        "thumbnails": "thumbnails icon link here",
        "categories": [
            "CORS"
        ],
        "relatedIdentifiers": "https://howtodoinjava.com/spring5/webmvc/spring-mvc-cors-configuration/"
    }
]
```

2. Get list of stored resources faceted by given categories and date range (with the search body)
``` 
POST http://localhost:8080/tracker/api/v1/feeds/search

REQUEST BODY:
{
    "categories" : ["CORS", "JAVA"],
    "dateFrom" : "2010-04-27T04:30:45.123Z",
    "dateTo" : "2023-11-30T22:30:45.123Z"
}
    
RESPONSE BODY:
[
    {
        "title": "spring-mvc-cors-configuration",
        "link": "https://howtodoinjava.com/spring5/webmvc/spring-mvc-cors-configuration/",
        "description": "CORS helps in serving web content from multiple domains into browsers who usually have the same-origin security policy. In this example, we will learn to enable CORS support in Spring MVC application at method and global level.The post <a rel=\"nofollow\" href=\"https://howtodoinjava.com/spring5/webmvc/spring-mvc-cors-configuration/\">Spring CORS Configuration Examples</a> appeared first on <a rel=\"nofollow\" href=\"https://howtodoinjava.com\">HowToDoInJava</a>.",
        "getPublicationDate": "2023-11-02T23:59:46+04:00",
        "author": "Lokesh Gupta",
        "thumbnails": "thumbnails icon link here",
        "categories": [
            "CORS"
        ],
        "relatedIdentifiers": "https://howtodoinjava.com/spring5/webmvc/spring-mvc-cors-configuration/"
    },
    {
        "title": "Spring CORS Configuration Examples",
        "link": "https://howtodoinjava.com/spring5/webmvc/spring-mvc-cors-configuration/",
        "description": "CORS helps in serving web content from multiple domains into browsers who usually have the same-origin security policy. In this example, we will learn to enable CORS support in Spring MVC application at method and global level.\nThe post <a rel=\"nofollow\" href=\"https://howtodoinjava.com/spring5/webmvc/spring-mvc-cors-configuration/\">Spring CORS Configuration Examples</a> appeared first on <a rel=\"nofollow\" href=\"https://howtodoinjava.com\">HowToDoInJava</a>.",
        "getPublicationDate": "2023-11-02T23:59:48+04:00",
        "author": "Lokesh Gupta",
        "thumbnails": "thumbnails icon link here",
        "categories": [
            "CORS"
        ],
        "relatedIdentifiers": "https://howtodoinjava.com/spring5/webmvc/spring-mvc-cors-configuration/"
    }
]
```

## Software Setup and Run
- Download and install [Docker Desktop](https://www.docker.com/products/docker-desktop/) if you not have it installed in your machine
- Run local postgres ```docker run -p 5432:5432 -e POSTGRES_USER=api-user  -e POSTGRES_PASSWORD=api-password -e POSTGRES_DB=rss-trackerdev-db -d postgres:14.5```
- Run application with bach command from project root ./scripts/run.sh
- Run the application from the IDEA itself
- Run `create_feed_configuration_data.sql` to fill feed configuration table 

## Software Design and Diagram
Please check the [Rss Tracker Service Design](design/rss-tracker-service-draft-design-flow.drawio)

## Nice to have next releases
- Unit, Integration tests cleanup, finalize IN PROGRESS
- Support: Run as a container
- Support: Flyway migration                 DONE
- Performance test (Jmeter scenarios)
