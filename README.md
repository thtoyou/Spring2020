

Voici le lien Postman afin de tester l'application : https://www.getpostman.com/collections/42538b3f0d724ac332b3 
Les test "user/update" et prof/update ne fonctionnent pas sur Postman mais sont opérationnels à partir de swagger (http://localhost:8080/swagger-ui/index.html#/user-controller/updateUserUsingPUT)

La base de donnée a été lancée dans un docker :3306 et phpmyadmin sur :8090.
le fichier testspringdata.sql est la pour initialiser la BDD. 

Un AOP est configuré dans src/main/java/sample/aop/monitor/ServiceMonitor.java. 