# Conversor de Moneda
<img src="/imagenes-conversor/BANNER-CONVERSOR.png">

Este proyecto, llamado "Conversor de Moneda", es una aplicación de consola en Java que permite a los usuarios convertir diferentes tipos de monedas.

## Descripción del proyecto
El proyecto utiliza Java como lenguaje de programación. La estructura del proyecto está organizada en varias clases, incluyendo `ObtenerMoneda`, `ConvertirMoneda` y `Moneda`.

La aplicación permite a los usuarios convertir entre diferentes tipos de monedas, incluyendo USD, MXN, CLP y ARS. Los usuarios pueden ingresar la cantidad que desean convertir y la aplicación mostrará el resultado de la conversión.

La comunicación con la aplicación se realiza a través de la consola, con el siguiente menú:

                    1 - Convertir de USD a MXN
                    2 - Convertir de MXN a USD
                    3 - Convertir de USD a CLP
                    4 - Convertir de CLP a USD
                    5 - Convertir de USD a ARS
                    6 - Convertir de ARS a USD
                    7 - Mostrar historial de conversiones
                    0 - Salir

## Organización del código
El proyecto está organizado en varias clases:

- `ObtenerMoneda`: Esta clase se encarga de obtener los valores de conversión para las diferentes monedas.
- `ConvertirMoneda`: Esta clase se encarga de realizar las conversiones de moneda.
- `Moneda`: Esta clase define los valores de conversión para las diferentes monedas.

Además, contamos con la clase `Principal` que maneja la lógica principal de la aplicación. Esta clase maneja la interacción con el usuario y la ejecución de las funcionalidades. Cada opción mostrada en el menú se realiza con su propio método interno, definido en `Principal`.

## Dependencias
El proyecto no requiere de dependencias externas.

## Ejecución de la aplicación
Para ejecutar la aplicación, simplemente ejecute la clase `Principal`. La aplicación se comunicará con el usuario a través de la consola.