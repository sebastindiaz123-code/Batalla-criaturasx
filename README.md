# Batalla-criaturasx

Taller practico tipo parcial 2 programacion 2

Juego de batallas por turnos que usa **clases abstractas** y **polimorfismo**.

BY

Juan Sebastian Charrupi 

# la Estructura


src/main/java/   Criatura, Dragon, Mago, Guerrero, Main
src/test/java/   CriaturaTest (JUnit 5)
pom.xml

Diseño

- `Criatura` (abstracta): atributos `nombre`, `salud`, `fuerza`; métodos abstractos `atacar` y `defender`; método concreto `estaViva()`.
- `Dragon`: ataca con `fuerza * 2`; sus escamas reducen 20% del daño recibido.
- `Mago`: ataca con `fuerza`; su barrera mágica reduce 2 puntos de daño.
- `Guerrero`: ataca con `fuerza`; su escudo bloquea la mitad del daño.
- En todos los casos el daño recibido mínimo es 1 (así la batalla siempre termina).
- `Main.simularBatalla(c1, c2)`: alterna ataques hasta que una criatura muere, mostrando cada ataque y la salud actual.

# Mejoras realizadas

- Se agregaron comentarios para mejorar la documentación del código.
- Se incorporó `puedeAtacar() para validar que el atacante y el objetivo estén vivos.
- Se añadieron validaciones para nombres vacíos y criaturas nulas.
- Main muestra los resultados finales y el ganador de cada batalla.
- Las pruebas unitarias aumentaron de 10 a 14.

## Flujo de Git

El trabajo se realiza en ramas de desarrollo, como juan, y se integra a main mediante Pull Requests. No se deben realizar commits directamente en `main.

# SU EJECUCION ES


Con Maven (Java 17+):

```bash
mvn test                 # ejecuta las pruebas unitarias
mvn compile exec:java -Dexec.mainClass=Main
```

Sin Maven:

```bash
javac -d out src/main/java/*.java
java -cp out Main
```

## Flujo de git

Rama `main`; el trabajo se hace en ramas `feature/...` y se integra con Pull Requests.
