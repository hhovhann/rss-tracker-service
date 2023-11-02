INSERT INTO FEED_ENTITY (id,
     title,
     link,
     description,
     author,
     publication_date,
     thumbnails,
     relatedIdentifiers
    ) VALUES (5L,
              'spring-mvc-cors-configuration',
              'https://howtodoinjava.com/spring5/webmvc/spring-mvc-cors-configuration/',
              'CORS helps in serving web content from multiple domains into browsers who usually have the same-origin security policy. In this example, we will learn to enable CORS support in Spring MVC application at method and global level.The post <a rel="nofollow" href="https://howtodoinjava.com/spring5/webmvc/spring-mvc-cors-configuration/">Spring CORS Configuration Examples</a> appeared first on <a rel="nofollow" href="https://howtodoinjava.com">HowToDoInJava</a>.',
              'Lokesh Gupta',
              '2023-11-02 15:58:27+04',
              '',
              'https://howtodoinjava.com/spring5/webmvc/spring-mvc-cors-configuration/');

INSERT INTO FEED_CATEGORIES (feed_entity_id, categories) VALUES (5L, 'JAVA');
INSERT INTO FEED_CATEGORIES (feed_entity_id, categories) VALUES (5L, 'CORS');
INSERT INTO FEED_CONFIGURATION (id, domain, ingestion_enable) VALUES (5L, 'https://hypothes.is/stream.rss', true);
