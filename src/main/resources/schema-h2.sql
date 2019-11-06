CREATE TABLE Country (
    id identity primary key,
    name varchar(100) not null
);
CREATE TABLE City (
    id identity primary key,
    name varchar(100) not null,
    idCountry int not null
)