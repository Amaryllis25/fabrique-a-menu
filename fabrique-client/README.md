== Projet de gestion de menu pour la cantina de Mos-Estafette - Reprise

=== Lancer le projet

```bash
mvn clean package
jar --create --manifest=MANIFEST.mf --file menucli.jar target/classes/Menucli.class
java -jar menucli.jar
java -cp "menucli.jar;C:\Users\clair\.m2\repository\info\picocli\picocli\4.6.2\picocli-4.6.2.jar" Menucli
```
