# TinyEcommerce

Backend for the TinyEcommerce project.

## Development environment.

Requires **Java and Maven** installed since this is an spring boot project.

Requires a database using **PostgreSQL** version 13.

This project implements the Data Access Object (DAO) pattern  to isolate the business layer from the persistence layer using an abstract API.

**Steps:**
 - Clone the repo
 - Import as a Maven project to your Java IDE.
 - Run: `mvn clean install` or use the IDE tools to perform it easily.
 - Open the `application.yml` file and edit the `url, username and password` lines to match your database configuration

## Usage

The backend provides a file to populate the database with demo data. This file is named `data.sql`.

Further configuration will not be required.