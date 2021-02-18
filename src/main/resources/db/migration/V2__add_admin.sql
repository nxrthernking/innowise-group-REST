insert into roles (name) values ('ROLE_USER'), ('ROLE_ADMIN');

insert into users (username, password) values
('admin', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i');
--password: 100
insert into user_roles (user_id, role_id) values (1, 1), (1, 2);