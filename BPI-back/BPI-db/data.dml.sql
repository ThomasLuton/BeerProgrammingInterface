DELETE FROM user_accounts;
DELETE FROM roles;

INSERT INTO roles (name) values
('User'),('Modo'),('Admin');

INSERT INTO user_accounts (pseudo, mail, password, role_id) values
('Simmarila', 'test@gmail.com', '$2a$12$iAAYxoVcGycvzOtKvXMIfOor.JFkEV6KifMsObYKsYDzrp.Av66t6', 1);