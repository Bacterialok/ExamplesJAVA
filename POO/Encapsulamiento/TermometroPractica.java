public class TermometroPractica {
    private float temperatura;

    public void setTemperatura(float temperatura) {
        if (temperatura >= -273.15)
            this.temperatura = temperatura;
        else
            System.out.println("No se permiten temperaturas menores a -273.15");
    }

    public float getTemperatura() {
        return temperatura;
    }

    public static void main(String[] args) {
        TermometroPractica termometroPractica = new TermometroPractica();

        termometroPractica.setTemperatura((float)-273.15);
        System.out.println(termometroPractica.getTemperatura());
    }
}
