Pour la compilation des sources : jdk1.7 n�cessaire.

Se placer dans le dossier Exercice_Carre
$ javac -cp fr.deoliveira.exercices.carres src\fr\deoliveira\exercices\carres\*.java -d build\

Pour g�n�rer un jar :
Se placer dans le dossier des sources g�n�r�es :
$ cd build\
$ jar cfe SquareSearch.jar fr.deoliveira.exercices.carres.SquareSearch fr\deoliveira\exercices\carres\*.class


Pour l'�x�cution du programme :

Se placer dans le dossier des sources g�n�r�es : 
$ cd build\

Option 1 : 
$ java fr.deoliveira.exercices.carres.SquareSearch ..\ressources\exercice1.txt

Option 2 : Jar
$ java -jar SquareSearch.jar ..\ressources\exercice1.txt

ici l'exemple prend en param�tre le fichier exercice1.txt pr�sent dans 
le dossier ressources. Ce param�tre est changeable � souhait.

PS : le projet est �galement importable dans Eclipse.


