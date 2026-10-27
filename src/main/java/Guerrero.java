
public class Guerrero extends Criatura {

    
    private final String arma;

   
    public Guerrero(String nombre, int salud, int fuerza, String arma) {
        super(nombre, salud, fuerza);
        this.arma = arma;
    }

    
    @Override
    public void atacar(Criatura objetivo) {
        if (!puedeAtacar(objetivo)) {
            return;
        }
        int daño = getFuerza();
        System.out.println(getNombre() + " golpea con " + arma + " (" + daño + " de daño) a " + objetivo.getNombre());
        objetivo.defender(daño);
    }

    
    @Override
    public void defender(int daño) {
        int real = Math.max(1, daño / 2);
        System.out.println("  " + getNombre() + " bloquea con el escudo y recibe " + real);
        recibirDaño(real);
    }

    /** @return arma del guerrero */
    public String getArma() { return arma; }
}
