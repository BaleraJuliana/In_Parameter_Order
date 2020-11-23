import java.util.LinkedList;
import java.util.List;


public class ManipuladorConjuntoCobertura {

	private static ManipuladorConjuntoCobertura uniqueInstance;
	private LinkedList<ParCobertura> listaParesCobertura;
	
	private ManipuladorConjuntoCobertura(){
		listaParesCobertura = new LinkedList<ParCobertura>();
	}
	
	public static ManipuladorConjuntoCobertura getInstance() {
		if(uniqueInstance==null)
			uniqueInstance = new ManipuladorConjuntoCobertura();
		return uniqueInstance;
	} 
  
	public void gerarConjuntoCoberturaInicial() { 
		 
		Dominio dominio = Dominio.getInstance();
		
		int tamanhoDominio = dominio.getListaFatores().size();
		int comandante = 0;
		List<Nivel> guia = new LinkedList<Nivel>();

		for(Fator fator: dominio.getListaFatores()){ 
			for(Nivel nivel: fator.getListaNiveis()){
				comandante = nivel.getFator(); 
				if(comandante==tamanhoDominio){
					break;
				} else{
					guia.add(nivel);
				}	 
			}
		}  

		for(Nivel nivelGuia: guia){
			for(Fator fator: dominio.getListaFatores()){
				if(nivelGuia.getFator()==fator.getListaNiveis().get(0).getFator()){ 
					continue; 
				}
				for(Nivel nivel: fator.getListaNiveis()){ 
					if(nivel.getFator()>nivelGuia.getFator()){
						ParCobertura parCobertura = new ParCobertura();
						parCobertura.getListaNiveis().add(nivelGuia);
						parCobertura.getListaNiveis().add(nivel);
						listaParesCobertura.add(parCobertura);
					}
				}
			}
		} 
	}
	
	public void removerTodosPares(LinkedList<ParCobertura> pC){
		for(ParCobertura par: pC){
			int i = find(par);
			if(i<listaParesCobertura.size())
				listaParesCobertura.remove(i);
		}
	}
	
/*Esse find sempre irá achar*/
	
	public int find(ParCobertura p){
	
		int indice = 0;
		for(ParCobertura par: listaParesCobertura){
			if(par.compara(p)){
				break;
			}
			indice=indice+1;
		}	
		return indice;
	}
 
	public LinkedList<ParCobertura> getListaParesCobertura() {
		return listaParesCobertura;
	}
	
	public boolean estaDentro(ParCobertura par){
		for(ParCobertura p: listaParesCobertura){
			if(p.compara(par)){
				return true;
			}
		}
		return false;
	}
	
}
