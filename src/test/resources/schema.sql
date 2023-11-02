-- Feed configuration table
CREATE TABLE IF NOT EXISTS  FEED_ENTITY_CATEGORIES (feed_entity_id long, categories varchar(500));
-- Feed entity table
CREATE TABLE IF NOT EXISTS FEED_ENTITY (
     id long AUTO_INCREMENT  PRIMARY KEY,
     title varchar(256) NOT NULL,
     link varchar(256) NOT NULL,
     description varchar(500) NOT NULL,
     author varchar(500) NOT NULL,
     publication_date TIMESTAMP NOT NULL,
     thumbnails varchar(10) NOT NULL,
     relatedIdentifiers varchar(50) DEFAULT NULL
    );
-- Feed categories table
CREATE TABLE IF NOT EXISTS  FEED_CONFIGURATION (id long AUTO_INCREMENT  PRIMARY KEY, domain varchar(100) NOT NULL, INGESTION_ENABLE BOOLEAN NOT NULL);