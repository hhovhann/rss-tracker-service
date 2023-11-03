CREATE TABLE IF NOT EXISTS feed_configuration (
                                    id bigserial not null,
                                    domain varchar(255),
                                    ingestion_enable boolean,
                                    primary key (id)
);

CREATE TABLE IF NOT EXISTS feed_entity (
                             id bigserial not null,
                             author varchar(255),
                             description varchar(512),
                             link varchar(255),
                             publication_date timestamp(6) with time zone,
                             related_identifiers varchar(255),
                             thumbnails varchar(255),
                             title varchar(255),
                             primary key (id)
);

CREATE TABLE IF NOT EXISTS feed_entity_categories (
                                    feed_entity_id bigint not null,
                                    categories varchar(255)
);

ALTER TABLE IF EXISTS feed_entity_categories
    add constraint fk_feed_entity_id
    foreign key (feed_entity_id)
    references feed_entity
