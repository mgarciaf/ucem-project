INSERT INTO categoria_cuarto (nombre,descripcion,precio)
    VALUES ('Individual', 'Ideal para quienes viajan solos.',50.0);

INSERT INTO categoria_cuarto (nombre,descripcion,precio)
    VALUES ('Doble', 'Solo para parejas.',80.0);

INSERT INTO cuarto (numero, descripcion,categoria)
    VALUES(1,'Vista a la piscina',1);
INSERT INTO cuarto (numero, descripcion,categoria)
  VALUES(2,'Remodelado recientemente',1);

INSERT INTO cupo (fecha_ingreso, fecha_salida, categoria)
    VALUES('2017-02-12T23:28:56.782Z', '2017-02-13T23:28:56.782Z', 1);

INSERT INTO cupo (fecha_ingreso, fecha_salida, categoria)
    VALUES('2017-02-14T23:28:56.782Z', '2017-02-15T23:28:56.782Z', 2);

INSERT INTO huesped(nombre, email, telefono)
    VALUES('Marlon Garcia', 'marlongarcia@gmail.com', '888888888');

INSERT INTO reservacion(desde, hasta, cuarto, huesped)
    values('2017-02-14T23:28:56.782Z', '2017-02-15T23:28:56.782Z', 1, 1);
