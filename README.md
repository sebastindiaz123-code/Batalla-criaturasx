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