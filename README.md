## Client part of the server menu

<br>

#### Dependances of the project

- Spring boot and ... :
  - spring-boot-starter-data-jpa
  - spring-boot-starter-web
  - spring-boot-starter-test
- Lombok
- H2 Database
- Picocli
- Json
- maven-failsafe-plugin

<br>

#### Plugins maven

- spring-boot-maven-plugin
- maven-surefire-plugin

<br>

#### Add a menu in menu serveur
```bash
curl -H "Content-Type: application/json" --data-raw '{"name": "Menu spécial scout", "dishes": [{"name": "Salade composée assaisonné aux herbes de prairies"},{"name": "Poisson acheté faute de prise"}, {"name": "Bananes au chocolat, ouf !"}]}' https://fabrique-menu.herokuapp.com/menus
```

<br>

#### Here an overview of the commands :

<br>

##### - help : list all available commands
```bash
java -cp "menucli.jar;libs\json-20211205.jar;libs\picocli-4.6.2.jar" com.cicdlectures.menucli.Menucli help
```

##### - list-menus : list all menus
```bash
java -cp "menucli.jar;libs\json-20211205.jar;libs\picocli-4.6.2.jar" com.cicdlectures.menucli.Menucli list-menus
```

##### - delete-menus : delete a menu
```bash
java -cp "menucli.jar;libs\json-20211205.jar;libs\picocli-4.6.2.jar" com.cicdlectures.menucli.Menucli delete-menus id
```

##### --server-url option : change server
```bash
java -cp "menucli.jar;libs\json-20211205.jar;libs\picocli-4.6.2.jar" com.cicdlectures.menucli.Menucli list-menus --server-url=
https://menuserverapp.herokuapp.com 
```

```bash
java -cp "menucli.jar;libs\json-20211205.jar;libs\picocli-4.6.2.jar" com.cicdlectures.menucli.Menucli delete-menus --server-url=
https://menuserverapp.herokuapp.com id
```


<br>

#### Creation of new version of the project

```bash
cd fabrique-client
mvn clean package
jar --create --manifest=MANIFEST.mf --file menucli.jar target/classes/com/cicdlectures/menucli/Menucli.class
```

<br>

#### Play tests
```bash
mvn test
```