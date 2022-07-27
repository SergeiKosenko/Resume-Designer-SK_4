create table users
(
    id            bigserial primary key,
    photo         varchar(200),
    firstname     varchar(36) not null,
    lastname      varchar(36) not null,
    password      varchar(86) not null,
    gender        char,
    date_of_birth date,
    email         varchar(50) unique,
    created_at    timestamp default current_timestamp,
    updated_at    timestamp default current_timestamp
);

create table roles
(
    id         bigserial primary key,
    name       varchar(36) not null,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);

create table users_roles
(
    user_id    bigint not null references users (id),
    role_id    bigint not null references users (id),
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp,
    primary key (user_id, role_id)
);

create table works
(
    id           bigserial primary key,
    user_id      bigint references users (id), --not null
    organization varchar(90) not null,
    post         varchar(40) not null,
    start_work   date        not null,
    end_work     date,
    progress     text        not null,
    created_at   timestamp default current_timestamp,
    updated_at   timestamp default current_timestamp
);

create table educations
(
    id           bigserial primary key,
    user_id      bigint references users (id), --not null
    organization varchar(150) not null,
    speciality   varchar(100) not null,
    year_start   date         not null,
    year_end     date         not null,
    created_at   timestamp default current_timestamp,
    updated_at   timestamp default current_timestamp
);

create table resumes
(
    id           bigserial primary key,
    user_id      bigint references users (id), --not null
    post         varchar(150) not null,
    salary       bigint       not null,
    schedule     varchar(100) not null,
    about_myself text,
    created_at   timestamp default current_timestamp,
    updated_at   timestamp default current_timestamp
);

insert into users (firstname, lastname, password, gender, date_of_birth, email)
values ('Иван', 'Иванов', '$2г$10$w1ytad53C7t3mlJwjcKo9OBlcX/bq/UE8T8TLv6/zzsC8kxB0JP0W', 'M', '1980-01-01', 'user@email.ru'),
       ('Василий', 'Васильев', '$2г$10$/MQlCibLN9qvjDZGgoc4D.E7CHUujQvbqN7cBg6zvpqpJU6sK2FBG', 'M', '1980-01-01', 'admin@email.ru'),
       ('Федор', 'Федоров', '$2y$10$mdKE8cGOczVlKhKYSsuQiurkwyJlzHVcya173eN.VEGsD2AM2eiJO', 'M', '1980-01-01', 'superadmin@email.ru');

insert into roles (name)
values ('ROLE_USER'),
       ('ROLE_ADMIN'),
       ('ROLE_SUPER_ADMIN');

insert into users_roles (user_id, role_id)
values (1, 1),
       (2, 2),
       (3, 3);

insert into works (user_id, organization, post, start_work, end_work, progress)
values (1, 'R&k', 'Системный администратор', '2000-01-01', '2010-01-01', 'Много работал'),
       (1, '1C', 'Программист', '2011-01-01', '2015-01-01',
        'Обновлял и редактировал конфигурацию 1С, делал формы отчетов');


insert into educations (user_id, organization, speciality, year_start, year_end)
values (1, 'МГУ', 'информационные технологии', '2002-07-01', '2005-08-011');


insert into educations (user_id, organization, speciality, year_start, year_end)
values (1, 'НГУ', 'системная инженерия', '2012-08-01', '2017-12-01');