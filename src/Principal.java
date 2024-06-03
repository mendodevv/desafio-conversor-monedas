import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcion = -1;
        double cantidad = 0;
        FileWriter fileWriter = null;
        LocalDateTime fechaConHoraMinutos = LocalDateTime.now();


        try {
            fileWriter = new FileWriter("conversiones.txt", true);
            fileWriter.write("\n");
            fileWriter.write("Fecha: " + fechaConHoraMinutos + "\n");
            while (opcion != 0) {
                System.out.println("***************************************");
                System.out.println("Bienvenido al conversor de monedas!");
                String menu = """
                        1. Dólar --> Peso Mexicano
                        2. Peso Mexicano --> Dólar
                        3. Dólar --> Peso Chileno
                        4. Peso Chileno --> Dólar
                        5. Dólar --> Peso Argentino
                        6. Peso Argentino --> Dólar
                        7. Mostrar historial de conversiones
                        0. Salir
                        """;
                System.out.println(menu);
                System.out.println("Por favor elige una opción válida");

                ObtenerMoneda moneda = new ObtenerMoneda();
                ConvertirMoneda convertirMoneda = new ConvertirMoneda();

                if (entrada.hasNextInt()) {
                    opcion = entrada.nextInt();
                } else {
                    System.out.println("Opción no válida. Por favor, ingrese un número.");
                    entrada.next();
                    continue;
                }

                if (opcion > 0 && opcion < 7) {
                    System.out.println("Ingrese el valor que desea convertir: ");
                    if (entrada.hasNextDouble()) {
                        cantidad = entrada.nextDouble();
                    } else {
                        System.out.println("Cantidad no válida. Por favor, ingrese un número.");
                        entrada.next();
                        continue;
                    }
                }

                Moneda valores;
                double conversion;

                try {
                    switch (opcion) {
                        case 1:
                            valores = moneda.obtenerMoneda("usd", cantidad);
                            conversion = convertirMoneda.convertirMoneda(cantidad, valores.mxn(), opcion);
                            System.out.println("El valor de " + cantidad + "[USD] corresponde al valor de: " + conversion + "[MXN]");
                            fileWriter.write("USD a MXN: " + cantidad + " USD = " + conversion + " MXN\n");
                            break;
                        case 2:
                            valores = moneda.obtenerMoneda("mxn", cantidad);
                            conversion = convertirMoneda.convertirMoneda(cantidad, valores.usd(), opcion);
                            System.out.println("El valor de " + cantidad + "[MXN] corresponde al valor de: " + conversion + "[USD]");
                            fileWriter.write("MXN a USD: " + cantidad + " MXN = " + conversion + " USD\n");
                            break;
                        case 3:
                            valores = moneda.obtenerMoneda("usd", cantidad);
                            conversion = convertirMoneda.convertirMoneda(cantidad, valores.clp(), opcion);
                            System.out.println("El valor de " + cantidad + "[USD] corresponde al valor de: " + conversion + "[CLP]");
                            fileWriter.write("USD a CLP: " + cantidad + " USD = " + conversion + " CLP\n");
                            break;
                        case 4:
                            valores = moneda.obtenerMoneda("clp", cantidad);
                            conversion = convertirMoneda.convertirMoneda(cantidad, valores.usd(), opcion);
                            System.out.println("El valor de " + cantidad + "[CLP] corresponde al valor de: " + conversion + "[USD]");
                            fileWriter.write("CLP a USD: " + cantidad + " CLP = " + conversion + " USD\n");
                            break;
                        case 5:
                            valores = moneda.obtenerMoneda("usd", cantidad);
                            conversion = convertirMoneda.convertirMoneda(cantidad, valores.ars(), opcion);
                            System.out.println("El valor de " + cantidad + "[USD] corresponde al valor de: " + conversion + "[ARS]");
                            fileWriter.write("USD a ARS: " + cantidad + " USD = " + conversion + " ARS\n");
                            break;
                        case 6:
                            valores = moneda.obtenerMoneda("ars", cantidad);
                            conversion = convertirMoneda.convertirMoneda(cantidad, valores.usd(), opcion);
                            System.out.println("El valor de " + cantidad + "[ARS] corresponde al valor de: " + conversion + "[USD]");
                            fileWriter.write("ARS a USD: " + cantidad + " ARS = " + conversion + " USD\n");
                            break;
                        case 7:
                            System.out.println("Historial de conversiones:");
                            FileReader fileReader = new FileReader("conversiones.txt");
                            int c;
                            while ((c = fileReader.read()) != -1) {
                                System.out.print((char) c);
                            }
                            break;
                        case 0:
                            System.out.println("Cerrando aplicación...");
                            break;
                    }
                } catch (IOException e) {
                    throw new RuntimeException("Error al escribir en el historial de conversiones.", e);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error al escribir en el historial de conversiones.", e);
        } finally {
            try {
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException e) {
                throw new RuntimeException("Error al cerrar el archivo de conversiones.", e);
            }
        }
    }
}

