JOB QUEUE WITH RABBITMQ
=====================================

This project is an API REST to use rabbitmq for import user and your repositories to job queue.

Module Information
========================

* api-core
* api-custom
* api-job
* api-public

That project use
========================

* Java 1.8
* Maven 3.x
* RabbitMQ 3.x

Dependencies
========================

* JBoss RestEasy (Implementation JAX-RS: http://resteasy.jboss.org/)
* RabbitMQ (Job Queue Manager: http://rabbitmq.com/)

How to start project?
========================

1. repository clone;
2. check your Java and Maven versions;
3. go to the project root directory in terminal;
4. run: $ mvn clean install;
5. go to api-public directory;
6. run: $ mvn tomcat7:run;
7. run in other terminal session: $ curl http://localhost:8080/api/v1/import/github/leonardorifeli or access in your browser.

Ref: Steps in RabbitMQ
======================

* RabbitMQ: http://goo.gl/Nr9OYt

License
========================

[MIT License](http://leonardorifeli.mit-license.org/) © Leonardo Rifeli