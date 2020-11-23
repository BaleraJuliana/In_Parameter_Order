
public class Nivel {
	
	private int id_Fator;
	private int id_Valor;
	
	public Nivel(int _id_Fator, int _id_Valor){
		id_Fator = _id_Fator;
		id_Valor = _id_Valor;
	}

	public int getFator() {
		return id_Fator;
	}

	public int getValor() {
		return id_Valor;
	}
	
	public boolean compara(Nivel nivel){
		if(id_Fator!=nivel.getFator()) return false;
		if(id_Valor!=nivel.getValor()) return false;
		return true;
	}

	public void setValor(int valor) {
		id_Valor = valor;
	}
	
	public Nivel clonar(){
		return new Nivel(id_Fator, id_Valor);
	}

	public void setFator(int fator) {
		id_Fator = fator;
	}
}
  