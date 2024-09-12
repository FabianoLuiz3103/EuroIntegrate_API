ALTER TABLE users_roles
    ADD CONSTRAINT FK_users_roles_role
    FOREIGN KEY (role_id)
    REFERENCES roles(id);

ALTER TABLE users_roles
    ADD CONSTRAINT FK_users_roles_user
    FOREIGN KEY (user_id)
    REFERENCES usuarios(id);