
public class Main {

    /**
      
     
     * @return la criatura ganadora
     */
    public static Criatura simularBatalla(Criatura criatura1, Criatura criatura2) {
        System.out.println("=== " + criatura1.getNombre() + " VS " + criatura2.getNombre() + " ===");
        Criatura atacante = criatura1;
        Criatura defensor = criatura2;
        int turno = 1;

        while (criatura1.estaViva() && criatura2.estaViva()) {
            System.out.println("-- Turno " + turno + " --");
            atacante.atacar(defensor);
            System.out.println("  Estado: " + criatura1 + " | " + criatura2);

            // Intercambio de roles
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
        simularBatalla(new Dragon("Smaug", 100, 15, "obsidiana"),
                       new Mago("Merlín", 80, 12, "Bola de fuego"));

        simularBatalla(new Guerrero("Conan", 120, 14, "espada"),
                       new Dragon("Drogon", 90, 10, "hierro"));

        simularBatalla(new Mago("Gandalf", 85, 13, "Rayo arcano"),
                       new Guerrero("Aragorn", 100, 12, "espada larga"));
    }
}
