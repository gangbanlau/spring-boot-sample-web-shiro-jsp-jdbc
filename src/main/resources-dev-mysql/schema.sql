CREATE TABLE IF NOT EXISTS products (
  id  BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name varchar(64) NOT NULL,
  price decimal(15,2) NOT NULL,
  description varchar(255),
  UNIQUE KEY(name)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS users (
  id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  userid varchar(64) NOT NULL,
  email varchar(64),
  passphrase varchar(100) NOT NULL,
  salt varchar(100) NOT NULL,
  date_created datetime NOT NULL,
  description varchar(255),
  UNIQUE KEY(userid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS roles (
  id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  description varchar(255),
  name varchar(50) NOT NULL,
  UNIQUE KEY(name)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS role_permissions (
  role_id BIGINT NOT NULL,
  permission varchar(50) NOT NULL,
  PRIMARY KEY (role_id, permission),
  CONSTRAINT fk_role_id FOREIGN KEY (role_id) REFERENCES roles (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS user_roles (
  user_id BIGINT NOT NULL,
  role_id BIGINT NOT NULL,
  PRIMARY KEY (user_id,role_id),
  CONSTRAINT fk_user_role_role_id FOREIGN KEY (role_id) REFERENCES roles (id),
  CONSTRAINT fk_user_role_user_id FOREIGN KEY (user_id) REFERENCES users (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
