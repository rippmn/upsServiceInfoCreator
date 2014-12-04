upsServiceInfoCreator
=====================

A ServiceInfoCreator extension to spring-cloud-cloudfoundry-connector that will accept a UPS without a URI but instead contains the following params to be used by the RelationalServiceInfoCreator:
* host - mysql host name
* name - name of the database on host
* port - port number of mysql instance
* user - database username
* password - passw0rd of the user with permissions to database

For this to work the service name parameter must include "mysql"

For example this cf command to create cups will work

```
>cf cups mysql-ups -p '{"host": "mysql01","name": "database-mysql",
"password": "passw0rd","port": "3306","user": "db_user"}'
```
