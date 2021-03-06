####### Makefile #########

JFLAGS = -g

# typing 'make' will invoke the first target entry in the makefile 
# (the default one in this case)

all: default Servidor.class Cliente.class Controller.class
	@echo "Build Pronta"

default: Requisicao.class Resposta.class

Servidor: default Servidor.class
		@echo "Build Servidor Pronta"
		java Servidor 9500
		java Servidor 9501
		java Servidor 9502

Cliente: default Cliente.class
		@echo "Build Cliente Pronto"
		java ClienteForm

Controller: default Controller.class
		@echo "Build Controller Pronto"
		java MainController

Requisicao.class: Requisicao.java
		javac $(JFLAGS) Requisicao.java

Resposta.class: Resposta.java
		javac $(JFLAGS) Resposta.java

Servidor.class: Servidor.java
		javac $(JFLAGS) Servidor.java

Cliente.class: ClienteForm.java
		javac $(JFLAGS) ClienteForm.java

Controller.class: MainController.java
		javac $(JFLAGS) MainController.java

#### clean ####
clean:
	rm -rf *.class
	@echo "clean"
