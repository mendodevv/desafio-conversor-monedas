import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("***************************************");
        System.out.println("Bienvenido al conversor de monedas!");
        String menu = """
                1. Dólar --> Peso Mexicano
                2. Peso Mexicano --> Dólar
                3. Dólar --> Peso Chileno
                4. Peso Chileno --> Dólar
                5. Dólar --> Peso Argentino
                6. Peso Argentino --> Dólar
                7. Salir
                """;
        System.out.println(menu);
        System.out.println("Por favor elige una opción válida");

        ObtenerMoneda moneda = new ObtenerMoneda();
        ConvertirMoneda convertirMoneda = new ConvertirMoneda();
        int opcion = entrada.nextInt();

        System.out.println("Ingrese el valor que desea convertir: ");
        double cantidad = entrada.nextDouble();

        Moneda valores;
        double conversion;

        switch (opcion) {
            case 1: valores = moneda.obtenerMoneda("usd", cantidad);
                    conversion = convertirMoneda.convertirMoneda(cantidad, valores.mxn(),opcion);
                    System.out.println("El valor de " + cantidad + "[USD] corresponde al valor de: " + conversion + "[MXN]");
                    break;
            case 2: valores = moneda.obtenerMoneda("mxn", cantidad);
                    conversion = convertirMoneda.convertirMoneda(cantidad, valores.usd(),opcion);
                    System.out.println("El valor de " + cantidad + "[MXN] corresponde al valor de: " + conversion + "[USD]");
                    break;
            case 3: valores = moneda.obtenerMoneda("usd", cantidad);
                    conversion = convertirMoneda.convertirMoneda(cantidad, valores.clp(),opcion);
                    System.out.println("El valor de " + cantidad + "[USD] corresponde al valor de: " + conversion + "[CLP]");
                    break;
            case 4: valores = moneda.obtenerMoneda("clp", cantidad);
                    conversion = convertirMoneda.convertirMoneda(cantidad, valores.usd(),opcion);
                    System.out.println("El valor de " + cantidad + "[CLP] corresponde al valor de: " + conversion + "[USD]");
                    break;
            case 5: valores = moneda.obtenerMoneda("usd", cantidad);
                    conversion = convertirMoneda.convertirMoneda(cantidad, valores.ars(),opcion);
                    System.out.println("El valor de " + cantidad + "[USD] corresponde al valor de: " + conversion + "[ARS]");
                    break;
            case 6: valores = moneda.obtenerMoneda("ars", cantidad);
                    conversion = convertirMoneda.convertirMoneda(cantidad, valores.usd(),opcion);
                    System.out.println("El valor de " + cantidad + "[ARS] corresponde al valor de: " + conversion + "[USD]");
                    break;
        }
    }
}
