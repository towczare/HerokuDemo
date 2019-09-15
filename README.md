# Spring Boot Heroku Flyway Demo App

Simple example showing how to connect [Spring Boot App](https://spring.io/projects/spring-boot) to [Heroku Database](https://name.heroku.com) with [Flyway library](https://flywaydb.org/) used as database versioning tool.

## Deploying app to Heroku
1. Create new application in Heroku console
![personal_new.png](personal_new.png)
![new_app.png](new_app.png)
![new_app_heroku.png](new_app_heroku.png)
2. Configure your github source, by searching project
![search_github.png](search_github.png)
![github_connect.png](github_connect.png)
3. Enable automatic deploys, so each time pull request is merged, new version will be deployed.
![automatic_deploys.png](automatic_deploys.png)
4. Switch to addon tab and search postgres addon.
![addons.png](addons.png)
![search_addon_postgres.png](search_addon_postgres.png)
![postgres2.png](postgres2.png)
![free_postgres.png](free_postgres.png)
5. Go back to deploy tab and deploy application.
![deploy_branch.png](deploy_branch.png)
6. Take a look on logs, if everything is fine.
![deploy_logs.png](deploy_logs.png)
7. Open your app, once it is successfully deployed.
![open_app.png](open_app.png)

## Configure elephantsql database

1. Create account and database instance on [https://www.elephantsql.com/](https://www.elephantsql.com/)
2. Prepare following env values:
```
JDBC_DATABASE_URL=jdbc:postgresql://rogue.db.elephantsql.com:5432/abcdefgh
JDBC_DATABASE_PASSWORD=1234qwerweeweweedwr_4321gdfgdfdgd
JDBC_DATABASE_USERNAME=abcdefgh
```
3. Paste them in env window in your IntelliJ IDE
![ide.png](ide.png)
4. Run your app.

## Creating Heroku Postgres Database

In case you want to create database for local purposes, follow below steps:

1. Create database using creator in [Heroku database](https://name.heroku.com)
2. Open credential page for newly created database.

![.images/credentials.png](.images/credentials.png)

3. Now setup connection to your database, using obtained credentials.

![.images/new_connection.png](.images/new_connection.png)

This is expected format for your IntelliJ connection
```
jdbc:postgresql://ec2-ho-stn-num-bers.eu-west-1.compute.amazonaws.com:5432/database_name?sslmode=require
```
4. If everything is setup correctly, green *Success* message should appear.

![.images/success.png](.images/success.png)

5. Go to your schema tab, and check your database schema.
![.images/schema_select.png](.images/schema_select.png)

6. Setup your configuration in environment variables as following:
![.images/envs_idea.png](.images/envs_idea.png)