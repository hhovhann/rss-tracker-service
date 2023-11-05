# Software Document
RSS/Atom feeds update tracker Rest API service project for Spring Boot

## Software Environment

- Java 17 (soon will move to 21, not supporting by maven yet)
- Postgres database
- Flyway migration
- Spring Boot 3.1.5
- Maven 3.9.5
- Jmeter
- The Room Java Library 2.1.0

## Software Structure
- feature_name(feed) 
  - controller
  - dto
  - entity
  - exception
  - mapper
  - repository
  - service

## Software Behaviour
System designed as a Spring Boot Web Application. Provides Rest API with following endpoints:

1. Get list of stored resources faceted by given categories and date range
``` 
POST http://localhost:8080/tracker/api/v1/feeds/search

REQUEST BODY:
{
    "categories" : ["best practices"],
    "dateFrom" : "2010-04-27T04:30:45.123Z",
    "dateTo" : "2023-11-30T22:30:45.123Z"
}
    
RESPONSE BODY:
[
    {
        "title": "Dangers of Not Emailing Your Blog Posts in 2023",
        "link": "https://www.feedotter.com/blog/dangers-of-not-emailing-blog-posts-in-2023/?utm_source=rss&utm_medium=rss&utm_campaign=dangers-of-not-emailing-blog-posts-in-2023",
        "description": "In today&#8217;s digital landscape, where content is abundant and attention spans are fleeting, promoting your blog posts effectively is more critical than ever. Neglecting email marketing as a means of distributing your blog content can have severe consequences. In this article, we&#8217;ll explore the dangers of overlooking email promotion in 2023, backed by data and [&#8230;]",
        "getPublicationDate": "2023-08-01T08:08:45Z",
        "author": "Andy Theimer",
        "thumbnails": "entry.getSource().getIcon().getUrl()",
        "categories": [
            "best practices",
            "marketing automation"
        ],
        "relatedIdentifiers": "https://www.feedotter.com/?p=27751"
    },
    {
        "title": "Easy steps for using recipient time zones in Marketo emails",
        "link": "https://www.feedotter.com/blog/recipient-time-zones-marketo-emails/?utm_source=rss&utm_medium=rss&utm_campaign=recipient-time-zones-marketo-emails",
        "description": "Ever wondered what the Recipient Time Zone option below your Marketo scheduler was for? Anytime you&#8217;re sending marketing emails to your recipients, a big question can be the best time to send this email you&#8217;ve carefully curated. You can always find blog posts and research on the optimal time to send your emails for the [&#8230;]",
        "getPublicationDate": "2023-02-23T19:40:56Z",
        "author": "Andy Theimer",
        "thumbnails": "entry.getSource().getIcon().getUrl()",
        "categories": [
            "best practices",
            "email marketing",
            "Marketo"
        ],
        "relatedIdentifiers": "https://www.feedotter.com/?p=27586"
    },
    {
        "title": "Emailing Blog Posts in 2023 – What Do Marketers Think?",
        "link": "https://www.feedotter.com/blog/emailing-blog-posts-in-2023/?utm_source=rss&utm_medium=rss&utm_campaign=emailing-blog-posts-in-2023",
        "description": "It&#8217;s 2023, should businesses send regular blog emails to their subscribers?  I wanted to know how marketers truly viewed the topic of emailing blog posts in the modern marketing era so I spent the past month interviewing more than 20 marketing experts to find out how they perceive emailing blog posts in the year 2023. [&#8230;]",
        "getPublicationDate": "2023-02-10T03:00:43Z",
        "author": "Andy Theimer",
        "thumbnails": "entry.getSource().getIcon().getUrl()",
        "categories": [
            "B2B Resources",
            "best practices",
            "company blog",
            "content marketing",
            "Featured"
        ],
        "relatedIdentifiers": "https://www.feedotter.com/?p=20719"
    },
    {
        "title": "New UI Walkthrough: Updates for a Better, Easy to Use Interface",
        "link": "https://www.feedotter.com/blog/new-ui-updates-walkthrough/?utm_source=rss&utm_medium=rss&utm_campaign=new-ui-updates-walkthrough",
        "description": "FeedOtter has some exciting new UI changes to the Automated campaigns area. While sending is the same and your existing campaigns will continue to run according to their normal schedules, the Edit Campaign screen has been updated and rearranged for easier access to certain features and to optimize user flow. Let&#8217;s walk through what&#8217;s changing: 1. Templates [&#8230;]",
        "getPublicationDate": "2022-09-07T13:39:25Z",
        "author": "Andy Theimer",
        "thumbnails": "entry.getSource().getIcon().getUrl()",
        "categories": [
            "company blog",
            "best practices",
            "Product Features"
        ],
        "relatedIdentifiers": "https://www.feedotter.com/?p=26851"
    },
    {
        "title": "3 Useful Ways You Can Create Email Content By Integrating an RSS Feed Into Pardot",
        "link": "https://www.feedotter.com/blog/rss-feed-into-pardot/?utm_source=rss&utm_medium=rss&utm_campaign=rss-feed-into-pardot",
        "description": "Here at FeedOtter, something that&#8217;s usually on our minds is how to streamline the process of creating routine, content emails and newsletters that you can easily push to your email sending platform. And what better way to automate content emails than adding an RSS feed into Pardot? Let&#8217;s look at the need for an RSS [&#8230;]",
        "getPublicationDate": "2022-05-06T17:43:49Z",
        "author": "Andy Theimer",
        "thumbnails": "entry.getSource().getIcon().getUrl()",
        "categories": [
            "pardot",
            "B2B Resources",
            "best practices",
            "company blog",
            "how to",
            "Blog",
            "digest",
            "newletter",
            "podcasts",
            "RSS",
            "RSS feed"
        ],
        "relatedIdentifiers": "https://www.feedotter.com/?p=25502"
    },
    {
        "title": "3 Easy Tips for Reducing Unsubscribes on Content Emails",
        "link": "https://www.feedotter.com/blog/reducing-unsubscribes-on-content-emails/?utm_source=rss&utm_medium=rss&utm_campaign=reducing-unsubscribes-on-content-emails",
        "description": "Working with email automation and customers sending website content to their subscribers, we see lots of questions about high unsubscribe rates and what our best tips for reducing unsubscribes on routine content emails are. Gaining lead subscribers is one thing, keeping them can be just as difficult for marketers.  Reducing Unsubscribes The first step to [&#8230;]",
        "getPublicationDate": "2022-02-07T17:34:51Z",
        "author": "Andy Theimer",
        "thumbnails": "entry.getSource().getIcon().getUrl()",
        "categories": [
            "email marketing",
            "B2B Resources",
            "best practices"
        ],
        "relatedIdentifiers": "https://www.feedotter.com/?p=25458"
    }
]
```

## Software Setup and Run:  Docker containers
- Create  .env file from the root project with the varibles
  ```
    POSTGRES_DB=rss-tracker-dev-db
    POSTGRES_USER=api-user
    POSTGRES_PASSWORD=api-password
    POSTGRES_LOCAL_PORT=15432
    POSTGRES_DOCKER_PORT=5432
    SPRING_APP_LOCAL_PORT=8888
    SPRING_APP_DOCKER_PORT=8080
  ```
- From root directory start containers with `docker-compose up`
- To stop the containers run `docker compose down`

## Software Setup and Run: Local Application
- Download and install [Docker Desktop](https://www.docker.com/products/docker-desktop/) if you not have it installed in your machine
- Run local postgres ```docker run -p 5432:5432 -e POSTGRES_USER=api-user  -e POSTGRES_PASSWORD=api-password -e POSTGRES_DB=rss-tracker-dev-db -d postgres:14.5```
- Run application with bach command from project root ./scripts/run.sh
- Run the application from the IDEA itself

## Software testing with custom data initialization
- Run `seed/feed_configuration_data.sql` to fill feed configuration table to see scheduler job process
- NOTE: If you want to feed all database Run `seed/all_data.sql`

## Software Design and Diagram
Please check the [Rss Tracker Service Design](design/rss-tracker-service-draft-design-flow.drawio)
