== Projet de gestion de menu pour la cantina de Mos-Estafette - Reprise

=== Lancer le projet

```bash
mvn clean package
jar --create --manifest=MANIFEST.mf --file menucli.jar target/classes/Menucli.class
java -jar menucli.jar
java -cp "menucli.jar;libs\json-20211205.jar;libs\picocli-4.6.2.jar" Menucli list-menus
```
