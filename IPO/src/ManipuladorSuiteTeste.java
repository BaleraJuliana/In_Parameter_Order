import java.util.LinkedList;

public class ManipuladorSuiteTeste {
	
	private LinkedList<Teste> listaTestes;
	private static ManipuladorSuiteTeste uniqueInstance;
	
    private ManipuladorSuiteTeste() {
		listaTestes = new LinkedList<Teste>();
	}
	  
	public void gerarConjuntoTesteInicial() {

		Dominio  dominio = Dominio.getInstance();
	 
		int comandante = 0;
		LinkedList<Nivel> guia = new LinkedList<Nivel>();

		for(Fator fator: dominio.getListaFatores()){
			for(Nivel nivel: fator.getListaNiveis()){
				comandante = nivel.getFator();
				if(comandante>=3){
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
					if(nivel.getFator()>=3){
						break;
					}
					if(nivel.getFator()>nivelGuia.getFator()){
						Teste teste = new Teste(dominio.getListaFatores().size());
						teste.addElemento(nivelGuia);
						teste.addElemento(nivel);
						listaTestes.add(teste);
					} 
				}
			}
		}
		
	}  
 
	public static ManipuladorSuiteTeste getInstance() {
		if(uniqueInstance==null)
			uniqueInstance = new ManipuladorSuiteTeste();
		return uniqueInstance;
	}

	public LinkedList<Teste> getListaTestes() {
		return listaTestes; 
	}	

}
