import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Costos {	//clase encargada de calcular el costo de cada llamada
	
	private float costoLocal_Pico= (float) 0.20;
	private float costoLocal_NoPico= (float) 0.10;
	
	public float getCosto(Llamadas l){	//se asume que ninguna llamada durar� mas de 10 horas 
		String tipo= l.getTipo().getTipo();
		long duracion= l.getDuracion();
		float costototal=0;
		
		switch(tipo){
			case "Local":
				if(horaPico(l.getHoraLlamadaInicio()) && horaPico(l.getHoraLlamadaFin()))  //si la llamada ocurre durante el rango de hora pico{
					costototal= (duracion*costoLocal_Pico);
				if(!horaPico(l.getHoraLlamadaInicio()) && !horaPico(l.getHoraLlamadaFin())) //ocurre dentro del lapso de hora no pico 
					costototal= (duracion*costoLocal_NoPico);				
				if(!horaPico(l.getHoraLlamadaInicio()) && horaPico(l.getHoraLlamadaFin()))	//comienza en hora no pico y termina en hora pico		
					costototal= auxHoraPicoNoPico(l, 8);				
				if(horaPico(l.getHoraLlamadaInicio()) && !horaPico(l.getHoraLlamadaFin())) //comienza en hora pico y termina en no pico 
					costototal= auxHoraPicoNoPico(l, 20);						
			break;	
			
			case "Nacional": //se asume que con base de datos, cada destino tendra su costo 
				switch(l.getNroDestinatario().getCodigoArea()){
					case 291: costototal= (float) (duracion*0.15);
					break;
					case 011: costototal= (float) (duracion*0.11);
					break;
					case 297: costototal= (float) (duracion*0.14);
				}
				
			case "Internacional":
				switch(l.getNroDestinatario().getCodigoPais()){
					case 1:  costototal= (float) (duracion*0.50);
					break;
					case 57: costototal= (float) (duracion*0.70);
					break;
					case 64: costototal= (float) (duracion*0.60);
					break;
				}
		}
	
	return costototal;
		
	}
	
	private float auxHoraPicoNoPico(Llamadas l, int limite){ //metodo auxiliar que calcula los minutos ocurridos en hora pico y en hora no pico
		LocalTime aux= LocalTime.of(limite, 00);
		
		LocalTime aux2= LocalTime.of(l.getHoraLlamadaInicio().getHour(), l.getHoraLlamadaInicio().getMinute());
		LocalTime aux3= LocalTime.of(l.getHoraLlamadaFin().getHour(), l.getHoraLlamadaFin().getMinute());
		
		long minutosHoraNoPico=  Duration.between(aux2, aux).toMinutes();	//minutos de inicio de llamada hasta las 8/20 
		long minutosHoraPico=    Duration.between(aux, aux3).toMinutes();	//minutos desde las 8/20 hasta fin de llamda
		
		return minutosHoraPico*costoLocal_Pico + minutosHoraNoPico*costoLocal_NoPico;
		
	}
	
	private boolean horaPico(LocalDateTime t){	//retorna true si el horario pasado por par�metro est� dentro de la franja de hora pico
		int date = t.getDayOfWeek().getValue();
		int time = t.getHour();
		
		if(date>0 && date<6){ 		//esta entre lunes y viernes
			if(time>7 && time<20){ //entre las 8 y las 20 
				return true;
			}
		}
		return false;	
	}

}
