
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

    
    public abstract void atacar(Criatura objetivo);

    
    public abstract void defender(int daño);

    /** @return true si la salud es mayor que 0 */
    public boolean estaViva() {
        return salud > 0;
    }

    
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
