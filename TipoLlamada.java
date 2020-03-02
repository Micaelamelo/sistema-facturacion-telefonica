
public class TipoLlamada {

	protected String tipo;
	
	public TipoLlamada(NroTelefono origen, NroTelefono destino){
		int codigopaisO= origen.getCodigoPais();
		int codigoareaO= origen.getCodigoArea();
		int codigopaisD= destino.getCodigoPais();
		int codigoareaD= destino.getCodigoArea();
		
		if (codigopaisO==codigopaisD){
			if(codigoareaO==codigoareaD){
				tipo="Local";
			}
			else{
				tipo="Nacional";
			}
		}
		else{
			tipo="Internacional";
		}
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
