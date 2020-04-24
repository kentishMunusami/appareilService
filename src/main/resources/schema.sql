drop table if exists appareil;
drop table if exists user;   
  
CREATE TABLE appareil (
  id_appareil INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  status VARCHAR(250) NOT NULL
);

CREATE TABLE user (
  id_user INT AUTO_INCREMENT  PRIMARY KEY,
  mail VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL
);