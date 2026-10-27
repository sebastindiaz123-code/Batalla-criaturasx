
public class Dragon extends Criatura {

    private final String escamas;

    public Dragon(String nombre, int salud, int fuerza, String escamas) {
        super(nombre, salud, fuerza);
        this.escamas = escamas;
    }

    @Override
    public void atacar(Criatura objetivo) {
        int daño = getFuerza() * 2;
        System.out.println(getNombre() + " lanza una llamarada de " + daño + " de daño a " + objetivo.getNombre());
        objetivo.defender(daño);
    }

    @Override
    public void defender(int daño) {
        
        int real = Math.max(1, (int) (daño * 0.8));
        System.out.println("  " + getNombre() + " se protege con sus escamas de " + escamas + " y recibe " + real);
        recibirDaño(real);
    }

    public String getEscamas() { return escamas; }
}
