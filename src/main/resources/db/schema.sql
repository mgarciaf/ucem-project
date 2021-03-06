CREATE TABLE categoria_cuarto (
  id IDENTITY PRIMARY KEY,
  nombre varchar(100) NOT NULL,
  descripcion varchar(1000) NOT NULL,
  precio DECIMAL NOT NULL
);

CREATE TABLE cuarto (
  id IDENTITY PRIMARY KEY,
  numero SMALLINT NOT NULL,
  descripcion VARCHAR(1000) NOT NULL,
  categoria INT NOT NULL
);

CREATE TABLE huesped(
  id IDENTITY PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL,
  email VARCHAR(50) NOT NULL UNIQUE,
  telefono VARCHAR(20) NOT NULL,
);

CREATE TABLE reservacion(
  id IDENTITY PRIMARY KEY,
  desde DATETIME NOT NULL,
  hasta DATETIME NOT NULL,
  cuarto INT NOT NULL,
  huesped INT NOT NULL
);

CREATE TABLE recibo(
  id IDENTITY PRIMARY KEY,
  total DECIMAL NOT NULL,
  reservacion INT NOT NULL
);

CREATE TABLE cupo(
  id IDENTITY PRIMARY KEY,
  fecha_ingreso TIMESTAMP NOT NULL,
  fecha_salida TIMESTAMP NOT NULL,
  categoria INT NOT NULL
);

ALTER TABLE cuarto ADD FOREIGN KEY ( categoria ) REFERENCES categoria_cuarto( id );
ALTER TABLE reservacion ADD FOREIGN KEY ( cuarto ) REFERENCES cuarto( id );
ALTER TABLE reservacion ADD FOREIGN KEY ( huesped ) REFERENCES huesped( id );
ALTER TABLE recibo ADD FOREIGN KEY ( reservacion ) REFERENCES reservacion ( id );
ALTER TABLE cupo ADD FOREIGN KEY ( categoria ) REFERENCES categoria_cuarto( id );