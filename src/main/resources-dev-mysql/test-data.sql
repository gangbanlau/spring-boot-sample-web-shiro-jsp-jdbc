INSERT INTO products (id, name, price) values(1, 'Lamp', 5.78);
INSERT INTO products (id, name, price) values(2, 'Table', 75.29);
INSERT INTO products (id, name, price) values(3, 'Chair', 22.81);

INSERT INTO users VALUES (1,'admin','','M1IFzumVt5cZznXtuE7uBS5xFE62vpcQY939F12ZTGQuJS9/vrnGKOiTu+cJGDEZO1XfJQYATVLO7qQTDuiCfA==','Cv2YXgmaudkMcw0/10T0jw==','2013-03-21 00:00:00', 'password is TestUserPassword');
INSERT INTO users VALUES (2,'manager','','M1IFzumVt5cZznXtuE7uBS5xFE62vpcQY939F12ZTGQuJS9/vrnGKOiTu+cJGDEZO1XfJQYATVLO7qQTDuiCfA==','Cv2YXgmaudkMcw0/10T0jw==','2013-03-21 00:00:00', '');
INSERT INTO users VALUES (3,'viewer','','M1IFzumVt5cZznXtuE7uBS5xFE62vpcQY939F12ZTGQuJS9/vrnGKOiTu+cJGDEZO1XfJQYATVLO7qQTDuiCfA==','Cv2YXgmaudkMcw0/10T0jw==','2013-03-21 00:00:00', '');
INSERT INTO roles VALUES (1,'Administrator Role','Administrator');
INSERT INTO roles VALUES (2,'Inventory Manager Role','Manager');
INSERT INTO roles VALUES (3,'Inventory Viewer Role','Viewer');
INSERT INTO role_permissions VALUES (1, '*');
INSERT INTO role_permissions VALUES (2, 'product:*');
INSERT INTO role_permissions VALUES (3, 'product:query');
INSERT INTO user_roles (user_id, role_id) VALUES (1 ,1);
INSERT INTO user_roles (user_id, role_id) VALUES (2 ,2);
INSERT INTO user_roles (user_id, role_id) VALUES (3 ,3);

