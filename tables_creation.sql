		
		-- TABLES--
BEGIN TRANSACTION;

create table pieces(idpiece varchar(100) primary key, nom varchar(1000) not null unique, quantite real not null, prixachat integer not null, pprixvente integer not null, dprixvente integer not null, check(quantite >= 0 and prixachat > 0 and pprixvente > prixachat and dprixvente > prixachat) );

create table personnes(idpersonne varchar(50) primary key, nom varchar(1000) not null, numero integer not null unique);

create table ventes(idvente serial primary key, idpiece varchar(100) references pieces, idpersonne varchar(50) references personnes, prixvente integer not null, quantite real not null, dates date not null, check(prixvente > 0 and quantite >= 1));
-- serial is a syntax specific to postgresql  and is used for auto incrementation--

create table achats(idachat serial primary key, idpiece varchar(100) references pieces, idpersonne varchar(50) references personnes, prixachat integer not null, quantite real not null, dates date not null, check(prixachat > 0 and quantite >= 1));

COMMIT;