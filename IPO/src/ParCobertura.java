import java.util.LinkedList;

public class ParCobertura implements Cloneable{
	
	
	private LinkedList<Nivel> listaNiveis;
	
	public ParCobertura(){
		listaNiveis = new LinkedList<Nivel>();
	}

	public void addNivel(Nivel n) {
		listaNiveis.add(n);
	}

	public LinkedList<Nivel> getListaNiveis() {
		return listaNiveis;
	}
	
	public boolean compara(ParCobertura par){
		int aux = 0;
		for(Nivel nivel: par.getListaNiveis()){
			if(!nivel.compara(listaNiveis.get(aux)))
					return false;
			aux = aux + 1;
		}
		return true;
	}

	public ParCobertura clonar(){
		try{
			return (ParCobertura) super.clone();	
		} catch (CloneNotSupportedException e){
			System.out.println("Não foi possível realizar o clone do objeto ParCobertura, interface Clonable não foi implementada");
			return this;
		}
	}	
}
