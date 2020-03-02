import java.util.ArrayList;
import java.util.Calendar;

import java.time.LocalDateTime; // Import the LocalDateTime class
import java.time.format.DateTimeFormatter;

public class Factura {
	
	public static void main(String args[]){
		
		Costos costo= new Costos();
		
	    LocalDateTime facturaEmision = LocalDateTime.of(2020, 03, 01, 00, 00);
		
	    LocalDateTime date0 = LocalDateTime.of(2020, 02, 18, 18, 30);
	    LocalDateTime date1 = LocalDateTime.of(2020, 02, 18, 19, 30);
	    LocalDateTime date2 = LocalDateTime.of(2020, 02, 18, 20, 30);
	    LocalDateTime date3 = LocalDateTime.of(2020, 02, 18, 21, 30);

	    LocalDateTime date3_1 = LocalDateTime.of(2020, 02, 18, 7, 30);
	    LocalDateTime date4 = LocalDateTime.of(2020, 02, 18, 8, 30);
	    

		Facturacion facturacion= new Facturacion(500, facturaEmision, costo );
		
		ArrayList<Llamadas> llamadas =new ArrayList<Llamadas>();
		
		NroTelefono n1= new NroTelefono(54, 291, 154128089);
		NroTelefono n2= new NroTelefono(54, 291, 154912312);
		NroTelefono n3= new NroTelefono(54, 291, 12312474);
		NroTelefono n4= new NroTelefono(1,  22,  12312474);
		NroTelefono n5= new NroTelefono(54, 011, 12312474);

		Llamadas l0= new Llamadas(n1, n3, date0, date1);
		Llamadas l1= new Llamadas(n1, n2, date1, date2);
		Llamadas l2= new Llamadas(n1, n2, date1, date2);
		Llamadas l3= new Llamadas(n1, n3, date2, date3);
		Llamadas l4= new Llamadas(n1, n4, date3_1, date4);
		Llamadas l5= new Llamadas(n1, n5, date3_1, date4);

		
		llamadas.add(l0);
		llamadas.add(l1);
		llamadas.add(l2);
		llamadas.add(l3);
		llamadas.add(l4);
		llamadas.add(l5);

		System.out.println("Sistema de Facturación");
		System.out.println("Abono mensual: $" + facturacion.abonoMensual);
		System.out.println("Consumo de llamadas");
		System.out.println("Tipo de llamada | Número Destino | Fecha y hora de inicio de llamada | Fecha y hora de fin de llamada | Duración | Costo de la llamada");
        
        for(Llamadas l: llamadas){
        	
        	System.out.print(l.getTipo().getTipo().toString() + " | ");     
        	
        	System.out.print(l.getNroDestinatario().toString() + " | ");
        	
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        	System.out.print(l.getHoraLlamadaInicio().format(myFormatObj) + " | ");
        	System.out.print(l.getHoraLlamadaFin().format(myFormatObj) + " | ");
        	
        	System.out.print(l.getDuracion() + " minutos | ");
        	
        	System.out.print("$" + facturacion.getCostoLlamada(l));

        	System.out.println();             
        	
        }
        
        float costoTotalLlamadas= facturacion.getCostoTotalLlamadas(llamadas);

        System.out.println("Costo total en llamadas: $" + costoTotalLlamadas);

        System.out.println("Costo total de la factura: $" + (costoTotalLlamadas+facturacion.getAbonoMensual()));                

 	
	}

}
