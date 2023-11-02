# Software Document
RSS/Atom feeds update tracker Rest API service project for Spring Boot

## Software Environment

- Java 21
- H2 database
- Spring Boot 3.1.5
- Maven 3.9.5
- The Room Java Library 2.1.0

## Software Structure
- feature_name(feed) 
  - controller
  - dto
  - entity
  - job
  - mapper
  - repository
  - service


## Software Behaviour
System designed as a Spring Boot Web Application. Provides Rest API with following endpoints:

1. Get list of stored resources faceted by given categories and date range (with query params) 
```
GET http://localhost:8080/tracker/api/v1/feeds/search?category=CORS&dateFrom=2010-04-27T04:30:45.123Z&dateTo=2023-10-30T22:30:45.123Z

RESPONSE BODY:
[
    {
        "title": "[VSM-VUX] Advanced Car Search Encuesta cerrada",
        "link": "https://hypothes.is/a/C2ocXndYEe6urZPTuzKYRA",
        "description": "<blockquote>¿Qué productos de crédito has usado?</blockquote>Falta el texto de aclaración que señale \"Selecciona todas las que apliquen\"",
        "getPublicationDate": "2023-10-30T23:10:52+04:00",
        "author": "camiamado",
        "thumbnails": "",
        "categories": [],
        "relatedIdentifiers": "tag:hypothes.is,2015-09:C2ocXndYEe6urZPTuzKYRA"
    },
    {
        "title": "Club de cerveza artesanal | Cervecería Nómada",
        "link": "https://hypothes.is/a/40sYDndXEe6N0E8uiNJqmA",
        "description": "<blockquote>¡Personaliza tu suscripción!</blockquote>Cada mes puedes cambiar tu elección",
        "getPublicationDate": "2023-10-30T23:09:45+04:00",
        "author": "LuisaRP",
        "thumbnails": "",
        "categories": [],
        "relatedIdentifiers": "tag:hypothes.is,2015-09:40sYDndXEe6N0E8uiNJqmA"
    },
    ........
]
```

2. Get list of stored resources faceted by given categories and date range (with the search body)
``` 
POST http://localhost:8080/tracker/api/v1/feeds/search

REQUEST BODY:
{
    "categories" : ["Java"],
    "dateFrom" : "2010-04-27T04:30:45.123Z",
    "dateTo" : "2023-10-30T22:30:45.123Z"
}
    
RESPONSE BODY:
[
    {
        "title": "The man rescuing Britain's 'magical' glow worms",
        "link": "https://www.bbc.co.uk/news/science-environment-67240450?at_medium=RSS&at_campaign=KARANGA",
        "description": "Glow worms are a rare sight in the UK but one young conservationist is trying to bring them back.",
        "getPublicationDate": "2023-10-28T03:52:02+04:00",
        "author": "",
        "thumbnails": "",
        "categories": [],
        "relatedIdentifiers": "https://www.bbc.co.uk/news/science-environment-67240450"
    },
    {
        "title": "Reintroducing wildlife species 'not a priority'",
        "link": "https://www.bbc.co.uk/news/science-environment-67230751?at_medium=RSS&at_campaign=KARANGA",
        "description": "Bringing previously extinct native species like beavers back to England is not on the Environment Secretary's priority list.",
        "getPublicationDate": "2023-10-27T06:59:02+04:00",
        "author": "",
        "thumbnails": "",
        "categories": [],
        "relatedIdentifiers": "https://www.bbc.co.uk/news/science-environment-67230751"
    }, 
    ........
]
```

## Software Run
- Run application with bach command from project root ./scripts/run.sh
- Run the application from the IDEA itself

## Software Design and Diagram
Please check the [Rss Tracker Service Design](design/rss-tracker-service-draft-design-flow.drawio)
