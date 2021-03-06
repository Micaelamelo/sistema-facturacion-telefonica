import java.time.LocalDateTime;
import java.util.ArrayList;

public class Facturacion {

	protected Costos costo;
	protected int abonoMensual;
	protected LocalDateTime fechaEmision;
	
	public Facturacion(int am, LocalDateTime fe, Costos c){
		abonoMensual=am;
		fechaEmision= fe;
		costo=c;
	}
	
	public float getCostoTotalLlamadas(ArrayList<Llamadas> L){
		float total=0;
	
		for(Llamadas l: L)
			 total=total+costo.getCosto(l);
		
		return total;
	}
	
	public float getCostoTipo(ArrayList<Llamadas> L, String T){
		float total=0;
		
		for(Llamadas l: L){
			if(l.getTipo().getTipo().equals(T))
			 total=total+costo.getCosto(l);
		}
		
		return total;
	}
	
	public float getCostoLlamada(Llamadas l){
		return costo.getCosto(l);
	}

	public int getAbonoMensual() {
		return abonoMensual;
	}

	public void setAbonoMensual(int abonoMensual) {
		this.abonoMensual = abonoMensual;
	}

	public LocalDateTime getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(LocalDateTime fechaEmision) {
		this.fechaEmision = fechaEmision;
	}
	
}
