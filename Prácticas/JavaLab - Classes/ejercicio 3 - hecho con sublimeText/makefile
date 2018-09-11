#MAKEFILE

programa.jar: ejercicio3.class Model.class View.class Controller.class Partido.class
	jar cmfv manifest programa.jar ejercicio3.class Model.class View.class Controller.class Partido.class

ejercicio3.class : ejercicio3.java
	javac ejercicio3.java

Model.class : Model.java
	javac Model.java

View.class : View.java
	javac View.java

Controller.class : Controller.java
	javac Controller.java

Partido.class : Partido.java
	javac Partido.java

clean:
	rm *.class
	rm*.jar
lean:
	rm *.jar