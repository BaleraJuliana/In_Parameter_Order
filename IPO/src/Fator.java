import java.util.LinkedList;


public class Fator {
	
	private int id;
	private LinkedList<Nivel> listaNiveis;
	
	public Fator(int _id){
		id = _id;
		listaNiveis = new LinkedList<Nivel>();
	}
	
	public void addNivel(Nivel novoNivel){
		listaNiveis.add(novoNivel);
	}

	public LinkedList<Nivel> getListaNiveis() {
		return listaNiveis;
	}
	
}
 