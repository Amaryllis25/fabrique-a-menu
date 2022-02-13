## Client part of the server menu

<br>

#### Add a menu in menu serveur
```bash
curl -H "Content-Type: application/json" --data-raw '{"name": "Menu spécial scout", "dishes": [{"name": "Salade composée assaisonné aux herbes de prairies"},{"name": "Poisson acheté faute de prise"}, {"name": "Bananes au chocolat, ouf !"}]}' https://fabrique-menu.herokuapp.com/menus
```

<br>

#### Lunch of the project // sera a virer car on livre un jar

```bash
cd fabrique-client
mvn clean package
jar --create --manifest=MANIFEST.mf --file menucli.jar target/classes/Menucli.class
java -jar menucli.jar
java -cp "menucli.jar;libs\json-20211205.jar;libs\picocli-4.6.2.jar" Menucli
```

<br>

#### Here an overview of the commands :

<br>

##### - help : list all available commands
```bash
java -cp "menucli.jar;libs\json-20211205.jar;libs\picocli-4.6.2.jar" Menucli help
```

##### - list-menus : list all menus
```bash
java -cp "menucli.jar;libs\json-20211205.jar;libs\picocli-4.6.2.jar" Menucli list-menus
```

##### - delete-menus : delete a menu
```bash
java -cp "menucli.jar;libs\json-20211205.jar;libs\picocli-4.6.2.jar" Menucli delete-menus/{id}
```