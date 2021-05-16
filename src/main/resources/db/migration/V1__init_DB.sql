
create table real_estate(
    dtype varchar(50) not null ,
    id bigserial not null primary key ,
    city varchar (50) not null ,
    house_number varchar(50) not null ,
    price bigint not null ,
    street varchar(50) not null ,
    total_area double precision not null ,
    floor_number integer,
    number_of_rooms integer,
    house_type varchar(50),
    land_area float,
    user_id bigint not null
);

create table users(
    id bigserial primary key,
    username varchar(100) not null ,
    password varchar(255) not null

);

create table roles(
    id bigserial primary key ,
    name varchar(100) not null
);

create table user_role_relation(
    user_id bigint not null ,
    role_id bigint not null
);

alter table if exists user_role_relation add foreign key (role_id) references roles(id);

alter table if exists user_role_relation add foreign key (user_id) references users(id);