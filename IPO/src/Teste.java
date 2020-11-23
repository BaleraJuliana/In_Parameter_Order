import java.util.LinkedList;

public class Teste {
	
	private LinkedList<Nivel> listaNiveis;
	
	public Teste(int tamanho){ 
		listaNiveis = new LinkedList<Nivel>();
		this.iniciarTeste(tamanho);
	} 
	
	public void addElemento(Nivel elemento){
		for(Nivel nivel : listaNiveis){ 
			if(nivel.getFator()==elemento.getFator()){
				nivel.setValor(elemento.getValor());
			}
		} 
	}  

	public boolean compara(Teste t1) {
		for(Nivel nivel :listaNiveis){
			if(!(nivel.compara(t1.getListaNiveis().get(nivel.getFator()-1))))
				return false;
		}
		return true;
	}
	
	private void iniciarTeste(int tamanho){
		for(int i = 1; i<(tamanho+1); i++){
			Nivel novo = new Nivel(i, 0);
			listaNiveis.add(novo);
		}
	}
	
	public LinkedList<Nivel> getListaNiveis(){
		return listaNiveis;
	}

	@SuppressWarnings("unchecked")
	public void replace(int posicao, Nivel nivel){
		LinkedList<Nivel> aux = new LinkedList<Nivel>();
		
		int i=1;
		for(Nivel n: listaNiveis){
			if(i==posicao){
				aux.add(nivel);
				i = i + 1;
				continue;
			}
			aux.add(n);
			i = i + 1;
		}
		listaNiveis = ((LinkedList<Nivel>)aux.clone());
	}	
}
