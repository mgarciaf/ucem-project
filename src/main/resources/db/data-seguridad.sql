/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Arlette Roger
 * Created: 02-20-2017
 */

INSERT INTO usuarios(username,password,enabled)
VALUES ('ucem','$2a$06$7Ezb0s.y8vck52mzt2lkQuhi0KW3LfP6J.RBhwC0JYhSRAekMYf5q', true);

/*password:1234*/
INSERT INTO usuarios(username,password,enabled)
VALUES ('jperez','$2a$06$7Ezb0s.y8vck52mzt2lkQuhi0KW3LfP6J.RBhwC0JYhSRAekMYf5q', true);

INSERT INTO usuarios_roles (username, role)
VALUES ('ucem', 'ROLE_ADMIN');

INSERT INTO usuarios_roles (username, role)
VALUES ('jperez', 'ROLE_USER');
