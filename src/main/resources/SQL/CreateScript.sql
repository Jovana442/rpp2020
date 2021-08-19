DROP TABLE IF EXISTS racun CASCADE;
DROP TABLE IF EXISTS proizvodjac CASCADE;
DROP TABLE IF EXISTS proizvod CASCADE;
DROP TABLE IF EXISTS stavka_racuna CASCADE;

DROP SEQUENCE IF EXISTS racun_seq;
DROP SEQUENCE IF EXISTS proizvodjac_seq;
DROP SEQUENCE IF EXISTS proizvod_seq;
DROP SEQUENCE IF EXISTS stavka_racuna_seq;

CREATE TABLE racun(
	id integer NOT NULL,
    datum date NOT NULL,
    nacin_placanja VARCHAR(200)
);

CREATE TABLE proizvodjac(
	id integer NOT NULL,
    naziv VARCHAR(50) NOT NULL,
	adresa VARCHAR(200) not null,
	kontakt VARCHAR(100) not null
);

CREATE TABLE proizvod(
	id integer NOT NULL,
    naziv VARCHAR(50) NOT NULL,
    proizvodjac integer not null
);

CREATE TABLE stavka_racuna(
	id integer NOT NULL,
	redni_broj integer NOT NULL,
   	kolicina numeric NOT NULL,
    	jedinica_mere VARCHAR(50),
	cena numeric NOT NULL,
	racun integer NOT NULL,
	proizvod integer NOT NULL
	
);

ALTER TABLE proizvod ADD CONSTRAINT FK_Proizvod_Proizvodjac FOREIGN KEY (proizvodjac) REFERENCES proizvodjac (id);
ALTER TABLE stavka_racuna ADD CONSTRAINT FK_Stavka_Racuna_Racun FOREIGN KEY (racun) REFERENCES racun(id);
ALTER TABLE stavka_racuna ADD CONSTRAINT FK_Stavka_Racuna_Proizvod FOREIGN KEY (proizvod) REFERENCES proizvod(id);

ALTER TABLE racun ADD CONSTRAINT PK_Racun PRIMARY KEY(id);
ALTER TABLE proizvodjac ADD CONSTRAINT PK_Proizvodjac PRIMARY KEY(id);
ALTER TABLE proizvod ADD CONSTRAINT PK_Proizvod PRIMARY KEY(id);
ALTER TABLE stavka_racuna ADD CONSTRAINT PK_Stavka_racuna PRIMARY KEY(id);

CREATE INDEX IDXFK_Proizvod_Proizvodjac ON proizvod (proizvodjac);
CREATE INDEX IDXFK_Stavka_Racuna_Racun ON stavka_racuna (racun);
CREATE INDEX IDXFK_Stavka_Racuna_Proizvod ON stavka_racuna (proizvod);

CREATE SEQUENCE racun_seq INCREMENT 1;
CREATE SEQUENCE proizvodjac_seq INCREMENT 1;
CREATE SEQUENCE proizvod_seq INCREMENT 1;
CREATE SEQUENCE stavka_racuna_seq INCREMENT 1;


