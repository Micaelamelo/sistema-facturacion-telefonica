import java.time.Duration;
import java.time.LocalDateTime; // Import the LocalDateTime class

public class Llamadas {

	protected NroTelefono nroEmisor, nroDestinatario;
	protected TipoLlamada tipo;
	protected long duracion; //en minutos
	protected LocalDateTime horaLlamadaInicio, horaLlamadaFin;
	
	public Llamadas(NroTelefono ne, NroTelefono nd, LocalDateTime hi, LocalDateTime hf){
		nroEmisor=ne;
		nroDestinatario=nd;
		tipo=new TipoLlamada(ne, nd);
		duracion= Duration.between(hi, hf).toMinutes();
		horaLlamadaInicio=hi;
		horaLlamadaFin=hf;
	}

	public long getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public LocalDateTime getHoraLlamadaInicio() {
		return horaLlamadaInicio;
	}
	
	public LocalDateTime getHoraLlamadaFin() {
		return horaLlamadaFin;
	}

	public void setHoraLlamadaInicio(LocalDateTime horaLlamadaInicio) {
		this.horaLlamadaInicio = horaLlamadaInicio;
	}

	public void setHoraLlamadaFin(LocalDateTime horaLlamadaFin) {
		this.horaLlamadaFin = horaLlamadaFin;
	}

	public NroTelefono getNroEmisor() {
		return nroEmisor;
	}

	public void setNroEmisor(NroTelefono nroEmisor) {
		this.nroEmisor = nroEmisor;
	}

	public NroTelefono getNroDestinatario() {
		return nroDestinatario;
	}

	public void setNroDestinatario(NroTelefono nroDestinatario) {
		this.nroDestinatario = nroDestinatario;
	}

	public TipoLlamada getTipo() {
		return tipo;
	}

	public void setTipo(TipoLlamada tipo) {
		this.tipo = tipo;
	}
	
	
}
