CREATE TABLE IF NOT EXISTS FEED_ENTITY_CATEGORIES
(
    feed_entity_id bigserial constraint fk_feed_entity_id PRIMARY KEY,
    categories VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS FEED_ENTITY (
    id bigserial constraint pk_feed_entity_id PRIMARY KEY,
    title varchar(256) NOT NULL,
    link varchar(256) NOT NULL,
    description varchar(512) NOT NULL,
    author varchar(100) NOT NULL,
    publication_date TIMESTAMP NOT NULL,
    thumbnails varchar(256) NOT NULL,
    related_identifiers varchar(256) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS  FEED_CONFIGURATION (
    id bigserial constraint pk_feed_configuration_id  PRIMARY KEY,
    domain varchar(100) NOT NULL,
    ingestion_enable BOOLEAN NOT NULL
);

