####### Makefile #########

JFLAGS = -g

# typing 'make' will invoke the first target entry in the makefile 
# (the default one in this case)

default: Requisicao.class Resposta.class Servidor.class

Servidor: Requisicao.class Resposta.class Servidor.class
		@echo "Build Pronta"
		java Servidor

Requisicao.class: Requisicao.java
		javac $(JFLAGS) Requisicao.java

Resposta.class: Resposta.java
		javac $(JFLAGS) Resposta.java

Servidor.class: Servidor.java
		javac $(JFLAGS) Servidor.java


#### clean ####
clean:
	rm -rf *.class
	@echo "clean"