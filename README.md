Pour la compilation des sources : jdk1.7 nécessaire.

Se placer dans le dossier Exercice_Carre
$ javac -cp fr.deoliveira.exercices.carres src\fr\deoliveira\exercices\carres\*.java -d build\

Pour générer un jar :
Se placer dans le dossier des sources générées :
$ cd build\
$ jar cfe SquareSearch.jar fr.deoliveira.exercices.carres.SquareSearch fr\deoliveira\exercices\carres\*.class


Pour l'éxécution du programme :

Se placer dans le dossier des sources générées : 
$ cd build\

Option 1 : 
$ java fr.deoliveira.exercices.carres.SquareSearch ..\ressources\exercice1.txt

Option 2 : Jar
$ java -jar SquareSearch.jar ..\ressources\exercice1.txt

ici l'exemple prend en paramètre le fichier exercice1.txt présent dans 
le dossier ressources. Ce paramètre est changeable à souhait.

PS : le projet est également importable dans Eclipse.


