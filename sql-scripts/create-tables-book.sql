
-- create table if not exists publisher(
-- id BIGSERIAL PRIMARY KEY,
-- name VARCHAR(250) not null,
-- country varchar(250)
-- );
-- create table if not exists author(
-- id BIGSERIAL primary key,
-- name varchar(250) not null,
-- birth_year integer,
-- nationality varchar(50)
-- );

-- create table if not exists book(
-- id bigserial primary key,
-- title varchar(250) not null,
-- publication_year integer,
-- author_id bigint not null,
-- publisher_id bigint not null,
-- foreign key(author_id) references author(id),
-- foreign key(publisher_id) references publisher(id)
-- );



