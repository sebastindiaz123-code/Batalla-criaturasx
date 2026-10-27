
public class Main {

    
    public static Criatura simularBatalla(Criatura criatura1, Criatura criatura2) {
        if (criatura1 == null || criatura2 == null) {
            throw new IllegalArgumentException("Las criaturas no pueden ser nulas");
        }

        System.out.println("=== " + criatura1.getNombre() + " VS " + criatura2.getNombre() + " ===");
        Criatura atacante = criatura1;
        Criatura defensor = criatura2;
        int turno = 1;

        
        while (criatura1.estaViva() && criatura2.estaViva()) {
            System.out.println("-- Turno " + turno + " --");
            atacante.atacar(defensor);
            
            System.out.println("  Estado: " + criatura1 + " | " + criatura2);

            
            Criatura temp = atacante;
            atacante = defensor;
            defensor = temp;
            turno++;
        }

        
        Criatura ganador = criatura1.estaViva() ? criatura1 : criatura2;
        System.out.println(">>> Ganador: " + ganador.getNombre() + " con " + ganador.getSalud() + " de salud\n");
        return ganador;
    }

    public static void main(String[] args) {
        // Cada fila es un combate: {criatura que ataca primero, rival}
        Criatura[][] combates = {
            { new Dragon("Smaug", 100, 15, "obsidiana"), new Mago("Merlín", 80, 12, "Bola de fuego") },
            { new Guerrero("Conan", 120, 14, "espada"), new Dragon("Drogon", 90, 10, "hierro") },
            { new Mago("Gandalf", 85, 13, "Rayo arcano"), new Guerrero("Aragorn", 100, 12, "espada larga") }
        };

        // Se simula cada batalla y se guarda el ganador
        Criatura[] ganadores = new Criatura[combates.length];
        for (int i = 0; i < combates.length; i++) {
            ganadores[i] = simularBatalla(combates[i][0], combates[i][1]);
        }

        // Resultado final de todas las batallas
        System.out.println("===== RESULTADOS FINALES ;3 =====");
        for (int i = 0; i < combates.length; i++) {
            System.out.println("Batalla " + (i + 1) + ": " + combates[i][0].getNombre()
                    + " vs " + combates[i][1].getNombre()
                    + " -> ganó " + ganadores[i].getNombre()
                    + " (salud restante: " + ganadores[i].getSalud() + ")");
        }
    }
}
