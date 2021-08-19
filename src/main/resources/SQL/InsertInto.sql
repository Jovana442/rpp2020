INSERT INTO "proizvodjac"("id", "naziv", "adresa", "kontakt")
VALUES(nextval('proizvodjac_seq'), 'Bambi', 'Đure Đakovića bb, Požarevac', '+381 11 30 67 505');
INSERT INTO "proizvodjac"("id", "naziv", "adresa", "kontakt")
VALUES(nextval('proizvodjac_seq'), 'Soko Štark d.o.o.', 'Bulevar Peka Dapčevića 29, Beograd', 
	   '+381 11 42 67 545');
INSERT INTO "proizvodjac"("id", "naziv", "adresa", "kontakt")
VALUES(nextval('proizvodjac_seq'), 'Swisslion-Takovo', 'Vaska Pope 4, Beograd', 
	   '+381 11 20 69 300');
INSERT INTO "proizvodjac"("id", "naziv", "adresa", "kontakt")
VALUES(nextval('proizvodjac_seq'), 'Pionir d.o.o', 'Požeška 65b, Beograd', 
	   '+381 11 30 50 764');
	   
INSERT INTO "racun"("id", "datum", "nacin_placanja")
VALUES(nextval('racun_seq'), to_date('01.03.2017.', 'dd.mm.yyyy.'), 'Gotovina');
INSERT INTO "racun"("id", "datum", "nacin_placanja")
VALUES(nextval('racun_seq'), to_date('01.04.2017.', 'dd.mm.yyyy.'), 'Gotovina');
INSERT INTO "racun"("id", "datum", "nacin_placanja")
VALUES(nextval('racun_seq'), to_date('20.05.2017.', 'dd.mm.yyyy.'), 'Kartica');

INSERT INTO "racun"("id", "datum", "nacin_placanja")
VALUES(nextval('racun_seq'), to_date('17.05.2017.', 'dd.mm.yyyy.'), 'Gotovina');
INSERT INTO "racun"("id", "datum", "nacin_placanja")
VALUES(nextval('racun_seq'), to_date('23.06.2017.', 'dd.mm.yyyy.'), 'Gotovina');
INSERT INTO "racun"("id", "datum", "nacin_placanja")
VALUES(nextval('racun_seq'), to_date('20.08.2017.', 'dd.mm.yyyy.'), 'Kartica');

INSERT INTO "racun"("id", "datum", "nacin_placanja")
VALUES(nextval('racun_seq'), to_date('06.09.2017.', 'dd.mm.yyyy.'), 'Gotovina');
INSERT INTO "racun"("id", "datum", "nacin_placanja")
VALUES(nextval('racun_seq'), to_date('26.09.2017.', 'dd.mm.yyyy.'), 'Gotovina');
INSERT INTO "racun"("id", "datum", "nacin_placanja")
VALUES(nextval('racun_seq'), to_date('02.10.2017.', 'dd.mm.yyyy.'), 'Kartica');

INSERT INTO "racun"("id", "datum", "nacin_placanja")
VALUES(nextval('racun_seq'), to_date('06.11.2017.', 'dd.mm.yyyy.'), 'Gotovina');
INSERT INTO "racun"("id", "datum", "nacin_placanja")
VALUES(nextval('racun_seq'), to_date('26.11.2017.', 'dd.mm.yyyy.'), 'Gotovina');
INSERT INTO "racun"("id", "datum", "nacin_placanja")
VALUES(nextval('racun_seq'), to_date('02.12.2017.', 'dd.mm.yyyy.'), 'Kartica');
	   
INSERT INTO "proizvod"("id", "naziv", "proizvodjac")
VALUES(nextval('proizvod_seq'), 'Bambi mlevena plazma 2kg', 1);
INSERT INTO "proizvod"("id", "naziv", "proizvodjac")
VALUES(nextval('proizvod_seq'), 'Bambi plazma 300g', 1);
INSERT INTO "proizvod"("id", "naziv", "proizvodjac")
VALUES(nextval('proizvod_seq'), 'Bambi Josh party mix 380g', 1);

INSERT INTO "proizvod"("id", "naziv", "proizvodjac")
VALUES(nextval('proizvod_seq'), 'Najlepše želje sa keksom 250g', 2);
INSERT INTO "proizvod"("id", "naziv", "proizvodjac")
VALUES(nextval('proizvod_seq'), 'Štark vafl fazon 22g', 2);
INSERT INTO "proizvod"("id", "naziv", "proizvodjac")
VALUES(nextval('proizvod_seq'), 'Štark smoki 150g', 2);

INSERT INTO "proizvod"("id", "naziv", "proizvodjac")
VALUES(nextval('proizvod_seq'), 'Swisslion Takovo Eurokrem 800g', 3);
INSERT INTO "proizvod"("id", "naziv", "proizvodjac")
VALUES(nextval('proizvod_seq'), 'Bevita keks classic porodično pakovanje 720g', 3);
INSERT INTO "proizvod"("id", "naziv", "proizvodjac")
VALUES(nextval('proizvod_seq'), 'Takovo domaća marmelada mešano voće 700g', 3);

INSERT INTO "proizvod"("id", "naziv", "proizvodjac")
VALUES(nextval('proizvod_seq'), 'Pionir karamela lešnik 100g', 4);
INSERT INTO "proizvod"("id", "naziv", "proizvodjac")
VALUES(nextval('proizvod_seq'), 'Pionir Medeno srce jagoda 150g', 4);
INSERT INTO "proizvod"("id", "naziv", "proizvodjac")
VALUES(nextval('proizvod_seq'), 'Galeb mlečna čokolada 80g', 4);


INSERT INTO "stavka_racuna"("id", "redni_broj", "kolicina", "jedinica_mere", "cena", "racun", "proizvod")
VALUES (nextval('stavka_racuna_seq'), 1, 10, 'komad', 1250, 1, 1);
INSERT INTO "stavka_racuna"("id", "redni_broj", "kolicina", "jedinica_mere", "cena", "racun", "proizvod")
VALUES (nextval('stavka_racuna_seq'), 2, 20, 'komad', 190, 1, 2);
INSERT INTO "stavka_racuna"("id", "redni_broj", "kolicina", "jedinica_mere", "cena", "racun", "proizvod")
VALUES (nextval('stavka_racuna_seq'), 3, 30, 'komad', 100, 1, 3);

INSERT INTO "stavka_racuna"("id", "redni_broj", "kolicina", "jedinica_mere", "cena", "racun", "proizvod")
VALUES (nextval('stavka_racuna_seq'), 1, 10, 'komad', 250, 2, 4);
INSERT INTO "stavka_racuna"("id", "redni_broj", "kolicina", "jedinica_mere", "cena", "racun", "proizvod")
VALUES (nextval('stavka_racuna_seq'), 2, 20, 'komad', 25, 2, 5);
INSERT INTO "stavka_racuna"("id", "redni_broj", "kolicina", "jedinica_mere", "cena", "racun", "proizvod")
VALUES (nextval('stavka_racuna_seq'), 3, 30, 'komad', 80, 2, 6);

INSERT INTO "stavka_racuna"("id", "redni_broj", "kolicina", "jedinica_mere", "cena", "racun", "proizvod")
VALUES (nextval('stavka_racuna_seq'), 1, 10, 'komad', 600, 3, 7);
INSERT INTO "stavka_racuna"("id", "redni_broj", "kolicina", "jedinica_mere", "cena", "racun", "proizvod")
VALUES (nextval('stavka_racuna_seq'), 2, 20, 'komad', 165, 3, 8);
INSERT INTO "stavka_racuna"("id", "redni_broj", "kolicina", "jedinica_mere", "cena", "racun", "proizvod")
VALUES (nextval('stavka_racuna_seq'), 3, 30, 'komad', 270, 3, 9);

INSERT INTO "stavka_racuna"("id", "redni_broj", "kolicina", "jedinica_mere", "cena", "racun", "proizvod")
VALUES (nextval('stavka_racuna_seq'), 1, 10, 'komad', 102, 4, 10);
INSERT INTO "stavka_racuna"("id", "redni_broj", "kolicina", "jedinica_mere", "cena", "racun", "proizvod")
VALUES (nextval('stavka_racuna_seq'), 2, 20, 'komad', 130, 4, 11);
INSERT INTO "stavka_racuna"("id", "redni_broj", "kolicina", "jedinica_mere", "cena", "racun", "proizvod")
VALUES (nextval('stavka_racuna_seq'), 3, 30, 'komad', 90, 4, 12);

INSERT INTO "stavka_racuna"("id", "redni_broj", "kolicina", "jedinica_mere", "cena", "racun", "proizvod")
VALUES (nextval('stavka_racuna_seq'), 1, 40, 'komad', 102, 5, 10);
INSERT INTO "stavka_racuna"("id", "redni_broj", "kolicina", "jedinica_mere", "cena", "racun", "proizvod")
VALUES (nextval('stavka_racuna_seq'), 2, 50, 'komad', 130, 5, 11);
INSERT INTO "stavka_racuna"("id", "redni_broj", "kolicina", "jedinica_mere", "cena", "racun", "proizvod")
VALUES (nextval('stavka_racuna_seq'), 3, 60, 'komad', 90, 5, 12);
