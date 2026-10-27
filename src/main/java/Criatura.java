/**
 * Clase abstracta que representa a una criatura genérica del juego.
 * Define los atributos comunes y los comportamientos que cada subclase
 * debe implementar a su manera (polimorfismo).
 */
public abstract class Criatura {

    private final String nombre;
    private int salud;
    private final int fuerza;

    /**
     * @param nombre nombre de la criatura
     * @param salud  puntos de salud iniciales
     * @param fuerza fuerza base usada para calcular el daño
     */
    public Criatura(String nombre, int salud, int fuerza) {
        this.nombre = nombre;
        this.salud = Math.max(0, salud);
        this.fuerza = fuerza;
    }

    /** Ataca a otra criatura. Cada subclase define su forma de atacar. */
    public abstract void atacar(Criatura objetivo);

    /**
     * Recibe un ataque. Cada subclase define cómo se defiende y cuánto
     * daño real recibe a partir del daño entrante.
     */
    public abstract void defender(int daño);

    /** @return true si la salud es mayor que 0 */
    public boolean estaViva() {
        return salud > 0;
    }

    /** Resta salud sin permitir valores negativos. Uso interno de las subclases. */
    protected void recibirDaño(int daño) {
        salud = Math.max(0, salud - daño);
    }

    public String getNombre() { return nombre; }
    public int getSalud() { return salud; }
    public int getFuerza() { return fuerza; }

    @Override
    public String toString() {
        return nombre + " (salud: " + salud + ")";
    }
}
