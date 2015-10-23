####### Makefile #########

JFLAGS = -g

# typing 'make' will invoke the first target entry in the makefile 
# (the default one in this case)

all: default Servidor.class Cliente.class
	@echo "Build Pronta"

default: Requisicao.class Resposta.class

Servidor: default Servidor.class
		@echo "Build Servidor Pronta"
		java Servidor

Cliente: default Cliente.class
		@echo "Build Cliente Pronto"
		java ClienteForm

Requisicao.class: Requisicao.java
		javac $(JFLAGS) Requisicao.java

Resposta.class: Resposta.java
		javac $(JFLAGS) Resposta.java

Servidor.class: Servidor.java
		javac $(JFLAGS) Servidor.java

Cliente.class: ClienteForm.java
		javac $(JFLAGS) ClienteForm.java

#### clean ####
clean:
	rm -rf *.class
	@echo "clean"