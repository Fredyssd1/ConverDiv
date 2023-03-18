import javax.swing.JOptionPane;

public class ConversorMonedasYtemperatura {

    public static void main(String[] args) {
        int opcion;

        do {
            Object[] opciones = {"USD", "EUR", "GBP", "Temperatura"};
            opcion = JOptionPane.showOptionDialog(null, "Seleccione la moneda a convertir a pesos Colombianos(COP):", "Conversor de moneda y temperatura",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

            String monedaConvertida = "";
            double tasaDeCambio = 0.0;

            switch (opcion) {
                case 0:
                    monedaConvertida = "USD";
                    tasaDeCambio = 4845;
                    break;
                case 1:
                    monedaConvertida = "EUR";
                    tasaDeCambio = 5168;
                    break;
                case 2:
                    monedaConvertida = "GBP";
                    tasaDeCambio = 5899;
                    break;
                case 3:
                    convertirTemperatura();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Operación cancelada");
                    System.exit(0);
            }

            if (opcion != 3) {
                String inputCantidad = JOptionPane.showInputDialog("Ingrese la cantidad a convertir en " + monedaConvertida + ":");
                double cantidad = Double.parseDouble(inputCantidad);

                double cantidadConvertida = cantidad * tasaDeCambio;
                JOptionPane.showMessageDialog(null, cantidad + " " + monedaConvertida + " equivalen a " + cantidadConvertida + " COP.");

                opcion = JOptionPane.showConfirmDialog(null, "¿Desea realizar otra conversión?", "Confirmar", JOptionPane.YES_NO_OPTION);
            }
        } while (opcion == JOptionPane.YES_OPTION);
    }

    private static void convertirTemperatura() {
        String inputTemperatura = JOptionPane.showInputDialog("Ingrese la temperatura en grados Celsius:");
        double temperaturaCelsius = Double.parseDouble(inputTemperatura);

        Object[] opcionesTemperatura = {"Fahrenheit", "Kelvin"};
        int opcion = JOptionPane.showOptionDialog(null, "Seleccione la unidad de temperatura a la que desea convertir:", "Conversor de temperatura",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesTemperatura, opcionesTemperatura[0]);

        if (opcion == -1) {
            JOptionPane.showMessageDialog(null, "Operación cancelada");
            return;
        }

        double temperaturaConvertida = 0.0;

        switch (opcion) {
            case 0: 
                temperaturaConvertida = temperaturaCelsius * 1.8 + 32;
                JOptionPane.showMessageDialog(null, temperaturaCelsius + " grados Celsius equivalen a " + temperaturaConvertida + " grados Fahrenheit.");
                break;
            case 1: 
                temperaturaConvertida = temperaturaCelsius + 273.15;
                JOptionPane.showMessageDialog(null, temperaturaCelsius + " grados Celsius equivalen a " + temperaturaConvertida + " grados Kelvin.");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Operación cancelada");
        }

        opcion = JOptionPane.showConfirmDialog(null, "¿Desea realizar otra conversión?", "Confirmar", JOptionPane.YES_NO_OPTION);
    }
}