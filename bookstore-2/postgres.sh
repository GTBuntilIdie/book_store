#! /bin/sh
docker run --name postgres -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=bookstore -p 5432:5432 --rm postgres:14.4
