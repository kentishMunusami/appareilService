drop table if exists appareil;    
  
CREATE TABLE appareil (
  id_appareil INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  status VARCHAR(250) NOT NULL
);