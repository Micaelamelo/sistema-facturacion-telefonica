
public class NroTelefono {
	
	protected int codigoPais, codigoArea, numero;
	
	public NroTelefono(int cp, int ca, int n){
		codigoPais=cp;
		codigoArea=ca;
		numero=n;
	}

	public int getCodigoPais() {
		return codigoPais;
	}

	public void setCodigoPais(int codigoPais) {
		this.codigoPais = codigoPais;
	}

	public int getCodigoArea() {
		return codigoArea;
	}

	public void setCodigoArea(int codigoArea) {
		this.codigoArea = codigoArea;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public String toString(){
		return codigoPais+ " " +codigoArea+ " "+ numero;
	}
	

}
