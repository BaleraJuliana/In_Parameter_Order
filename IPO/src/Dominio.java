import java.util.LinkedList;


public class Dominio {
	
	private LinkedList<Fator> listaFatores;
	private static Dominio uniqueInstance;
	
	private Dominio(){
		listaFatores = new LinkedList<Fator>();
	}
	
	public static Dominio getInstance(){
		if(uniqueInstance==null)
			uniqueInstance = new Dominio();
		return uniqueInstance;
	}
	
	public void addFator(Fator novoFator){
		listaFatores.add(novoFator);
	}

	public LinkedList<Fator> getListaFatores() {
		return listaFatores;
	}
}
 