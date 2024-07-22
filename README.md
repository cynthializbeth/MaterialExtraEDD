# Recursos para EDD

## ¿Qué es maven?
Maven es una herramienta que nos permite crear y ejecutar proyectos de manera más sencilla y ordenada, también nos permite ejecutar pruebas para revisar nuestro código.
Puedes usar las formas tradicionales de ejecutar como son ```javac *.java``` y ```java ClasePrincipal``` o usar maven, para usar este último debes tenerlo instalado en tu computadora.
En el caso de ubuntu basta con teclear ```sudo apt install maven```.

## ¿Cómo compilar los recursos?
Debes estar en la carpeta del recurso que quieras compilar es decir si quieres ejecutar el primer recurso ingresas a la carpeta Recurso-01 y ya estando allí puedes escribir ```mvn compile```, con esto se compilaran los archivos o puedes compilarlos y empaquetarlos con ```mvn package```, al ejecutar estos comandos puede que se descarguen cosas necesarias para la compilación y ejecución pero sólo pasara la primera vez.

## ¿Cómo ejecutar los recursos?
Una vez que hayas compilado y empaquetado el recurso, bastara con que escribas ```java -jar target/archivoEjecutable.jar```, con eso ya deberías poder ver el menú de inicio del recurso correspondiente.