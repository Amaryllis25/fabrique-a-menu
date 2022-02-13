## Client part of the server menu

<br>

#### 1. Dependances of the project

- spring-boot-starter-test
- picocli
- json

<br>

#### 2. Plugins maven

- spring-boot-maven-plugin
- maven-surefire-plugin

<br>

#### 3. Here an overview of the commands :

<br>

- help : list all available commands
```bash
java -cp "menucli.jar;libs\json-20211205.jar;libs\picocli-4.6.2.jar" com.cicdlectures.menucli.Menucli help
```

- list-menus : list all menus
```bash
java -cp "menucli.jar;libs\json-20211205.jar;libs\picocli-4.6.2.jar" com.cicdlectures.menucli.Menucli list-menus
```

- delete-menus : delete a menu
```bash
java -cp "menucli.jar;libs\json-20211205.jar;libs\picocli-4.6.2.jar" com.cicdlectures.menucli.Menucli delete-menus id
```
A noter qu'il semble y avoir un problème du côté du serveur : lorsqu'il y a un menu dans le repository, celui-ci se supprime très bien, cependant lorsque plusieurs sont présents il y a une erreur interne au serveur.

- --server-url option : change server
```bash
java -cp "menucli.jar;libs\json-20211205.jar;libs\picocli-4.6.2.jar" com.cicdlectures.menucli.Menucli list-menus --server-url=
https://menuserverapp.herokuapp.com 
```

```bash
java -cp "menucli.jar;libs\json-20211205.jar;libs\picocli-4.6.2.jar" com.cicdlectures.menucli.Menucli delete-menus --server-url=
https://menuserverapp.herokuapp.com id
```

- add-menu : bonus ! add a special scout menu
```bash
java -cp "menucli.jar;libs\json-20211205.jar;libs\picocli-4.6.2.jar" com.cicdlectures.menucli.Menucli list-menus add-menu
```

<br>

#### 4. Creation of new version of the project

```bash
cd fabrique-client
mvn clean package
jar --create --manifest=MANIFEST.mf --file menucli.jar target/classes/com/cicdlectures/menucli/Menucli.class
```

<br>

#### 5. Play tests

<br>

- Unit tests :
```bash
mvn test
```

<br>

- Integration tests :
```bash
mvn integration-test
```
