#!/bin/bash
set -e

# create test db
psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
	CREATE DATABASE "java-qa";
	GRANT ALL PRIVILEGES ON DATABASE "java-qa" TO admin;
EOSQL

# verify that db was created
psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "java-qa" -c '\l' | grep "java-qa" > /dev/null
if [ $? -eq 0 ]; then
  echo "database java-qa created successfully"
else
  echo "failed to create database java-qa"
  exit 1
fi