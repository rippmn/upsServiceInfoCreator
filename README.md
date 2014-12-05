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

**Important Note**

As of 2014-12-05 the Java buildpack functionality that attempts to "inject" the buildpack configured MySQL JDBC driver for bound services with _"mysql"_ in their name will produce the following behavior:
- A warning message will be displayed during staging
```
[Services]WARN  A service with a name label or tag matching (?-mix:mysql) was found, but was missing one of the required credentials ["uri"]
```
- The jdbc driver will not be injected
To ensure that you application has access to a JDBC driver either through a fork of the build pack, or including it in the deployed artifact. 

Another, less recommended approach to work around this could be an update of this code to allow for the submission of a empty/false URI in the UPS.  This would then be ignored by overiding appropriate RelationalServiceInfoCreator code.  
Options:
- ignore an empty URI and replace with the URI generated from other params
- destroy URI (perhaps triggered by a specific value like "falseURI") and replace with value generated from other supplied params

