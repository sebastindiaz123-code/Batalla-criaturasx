
public abstract class Criatura {

    
    private final String nombre;
    
    private int salud;
    
    private final int fuerza;

    /**
     * Crea una criatura con sus atributos básicos.
     *
     * @param nombre nombre de la criatura (no puede estar  vacío o nulo :C)
     * @param salud  puntos de salud iniciales (si es negativo practicamente  se toma 0)
     * @param fuerza fuerza base usada para calcular el daño
     * @throws IllegalArgumentException si el nombre es nulo o vacío
     */
    public Criatura(String nombre, int salud, int fuerza) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre de la criatura no puede estar vacío");
        }
        this.nombre = nombre;
        this.salud = Math.max(0, salud);
        this.fuerza = fuerza;
    }

    /**
     * Ataca a otra criatura. Cada subclase define su propia forma de atacar
     * y calcula el daño que le envía al objetivo.
     *
     * @param objetivo criatura que recibe el ataque
     */
    public abstract void atacar(Criatura objetivo);

    
    public abstract void defender(int daño);

    
    public boolean estaViva() {
        return salud > 0;
    }

    
    protected boolean puedeAtacar(Criatura objetivo) {
        if (objetivo == null) {
            return false;
        }
        if (!estaViva()) {
            System.out.println(nombre + " está muerta y no puede atacar.");
            return false;
        }
        if (!objetivo.estaViva()) {
            System.out.println(objetivo.getNombre() + " ya está muerta.");
            return false;
        }
        return true;
    }

    
    protected void recibirDaño(int daño) {
        salud = Math.max(0, salud - daño);
    }

    /** @return nombre de la criatura */
    public String getNombre() { return nombre; }

    /** @return salud actual de la criatura */
    public int getSalud() { return salud; }

    /** @return fuerza base de la criatura */
    public int getFuerza() { return fuerza; }

    /** @return texto con el nombre y la salud actual, útil para mostrar el estado */
    @Override
    public String toString() {
        return nombre + " (salud: " + salud + ")";
    }
}
