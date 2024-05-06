import com.google.gson.stream.JsonToken;

import java.io.IOException;

public class Principal {
    public static void main(String[] args) {
        ConvertirMoneda moneda = new ConvertirMoneda();
        Moneda prueba = moneda.convertirMoneda("mxn");

        System.out.println(prueba);


        double resultado = prueba.mxn() * prueba.usd();
        System.out.println(resultado);


    }
}
