insert into templates (id, templatetext, createdat) values(1, 'Hello, %s', now());
insert into templates (id, templatetext, createdat) values(2, 'Greetings, %s', now());
insert into templates (id, templatetext, createdat) values(3, 'Dear %s, we are glad to see you again', now());
alter sequence templates_seq restart with 4;

