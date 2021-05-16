insert into users(username,password) values
('user','$2y$12$9g.BQpxqmqKC.51MqU2gLOryREFc/afomP/j.4Zzkk/03W5kz3ZL.'),
--password: user
('alex','$2a$04$8vRqN/GQzxnCmFbTZZZJauKXP24JFpL4JMbqFUALrVZygqbvCja6O');
insert into user_role_relation (user_id, role_id) values (2, 1);
insert into user_role_relation (user_id, role_id) values (3, 1);
