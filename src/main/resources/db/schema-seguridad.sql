/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Arlette Roger
 * Created: 02-20-2017
 */
CREATE  TABLE usuarios (
  username VARCHAR(45) PRIMARY KEY,
  password VARCHAR(60) NOT NULL ,
  enabled TINYINT NOT NULL DEFAULT 1);
  
  
  CREATE TABLE usuarios_roles (
  id int(11) IDENTITY PRIMARY KEY,
  username VARCHAR(45) NOT NULL,
  role VARCHAR(45) NOT NULL,
  UNIQUE KEY usuarios_roles_uq (role,username));
  
  ALTER TABLE usuarios_roles ADD FOREIGN KEY ( username ) REFERENCES usuarios( username );
