## Desafio - LLamadas telefónicas

Diseñar un sistema de facturación de llamadas telefónicas teniendo en cuenta los siguientes requerimientos:

1. La facturación se realiza de manera mensual

2. La facturación está compuesta por:  
    a. Un abono mensual básico  
    b. Consumo por llamadas Locales  
    c. Consumo por llamadas Nacionales e Internacionales

3. Las llamadas locales tienen distintos valores según la franja horaria en la que se realizan y el día. Para los días hábiles, de 8 a 20 hrs. el costo es de 0,20 centavos el minuto, mientras en el resto de las horas es de 0,10 centavos el minuto. Los sábados y domingos cuesta 0,10 centavos el minuto

4. Las llamadas Internacionales tienen un costo distinto según el país al que se llame

5. Las llamadas Nacionales tienen un costo distinto según la localidad a la que se llame

### Notas

- Debe ser resuelto en un lenguaje orientado a objetos.
- No es necesario realizar una interfaz de usuario visual.
- No es necesario realizar persistencia de los datos (conexión a base de datos, archivos, etc.). Alcanza con simular los datos creándolos en memoria.
- Como salida alcanza ver por pantalla como sería una factura (sin preocuparse por darle un formato especial)

### Consideraciones

- Se asume que no habrá llamadas que duren más de 12 horas, esto es, comiencen y terminen en horario pico habiendo una franja horaria NO pico en el medio (o viceversa). Ejemplo: Llamada que inicia a las 9AM, y finaliza a las 9AM del día siguiente (horarios pico), habiendo en el medio un lapso de hora no pico (20 PM a 8 AM). 

- Para las llamadas nacionales e internacionles se asume que para cada localidad/pais hay un costo definido, en este ejercicio se pusieron 3 ejemplos a modo ilustrativo. 


