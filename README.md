# Studierendenverwaltung

Eine einfache Webanwendung zur Verwaltung von Studierenden, entwickelt mit Spring Boot und Thymeleaf.

## Funktionen

* Studierende hinzufügen
* Studierendendaten anzeigen
* Studierendendaten bearbeiten
* Studierende löschen
* Validierung der Eingaben

## Technologien

* Java
* Spring Boot
* Spring MVC
* Spring Data JPA / Hibernate
* Thymeleaf
* Bootstrap
* MySQL
* Maven

## Datenbank

Die Anwendung verwendet eine MySQL-Datenbank. Benutzername und Passwort werden über Umgebungsvariablen konfiguriert:

`DB_USERNAME`
`DB_PASSWORD`

## Projekt starten

1. MySQL starten und die benötigte Datenbank erstellen.
2. `DB_USERNAME` und `DB_PASSWORD` als Umgebungsvariablen setzen.
3. Das Projekt in IntelliJ IDEA öffnen.
4. `StudentManagementSystemApplication` starten.
5. Die Anwendung im Browser über `http://localhost:8080` öffnen.
