
import java.util.LinkedList;

public class CrescimentoVertical {

	private ManipuladorConjuntoCobertura manipuladorConjuntoCobertura;
	private ManipuladorSuiteTeste manipuladorSuiteTeste;
	
	public CrescimentoVertical(){
		
		manipuladorConjuntoCobertura = ManipuladorConjuntoCobertura.getInstance();
		manipuladorSuiteTeste = ManipuladorSuiteTeste.getInstance();
		
	}
	
	public void init(){	
		
		LinkedList<ParCobertura> paresCobertos = new LinkedList<ParCobertura>();
		LinkedList<Teste> listaTeste = new LinkedList<Teste>(); 
 
		for(ParCobertura par: manipuladorConjuntoCobertura.getListaParesCobertura()){
			
			if(listaTeste.isEmpty()){				
				listaTeste.add(this.adicionarValoresSemImportancia(par));
				paresCobertos.add(par.clonar());
				continue; 
			} 
			
			if(!verificarTesteComValorSemImportanciaCobrePar(listaTeste, par, paresCobertos)){
				
				listaTeste.add(this.adicionarValoresSemImportancia(par));
				paresCobertos.add(par.clonar());
				continue;	 
			} 
		}  
		
		for(Teste teste: listaTeste){
			manipuladorSuiteTeste.getListaTestes().add(teste);
		}
			
		manipuladorConjuntoCobertura.removerTodosPares(paresCobertos);
	} 
	
	public boolean verificarTesteComValorSemImportanciaCobrePar(LinkedList<Teste> listaTeste, ParCobertura par, LinkedList<ParCobertura> paresCobertos){
	
		for(Teste teste: listaTeste){
			
			if(teste.getListaNiveis().get(par.getListaNiveis().get(0).getFator()-1).getValor()==0 || 
				teste.getListaNiveis().get(par.getListaNiveis().get(0).getFator()-1).getValor()==par.getListaNiveis().get(0).getValor()){
				if(teste.getListaNiveis().get(par.getListaNiveis().get(1).getFator()-1).getValor()==par.getListaNiveis().get(1).getValor() || 
					teste.getListaNiveis().get(par.getListaNiveis().get(1).getFator()-1).getValor()==0){
					
						teste.replace(par.getListaNiveis().get(0).getFator(), par.getListaNiveis().get(0));
						teste.replace(par.getListaNiveis().get(1).getFator(), par.getListaNiveis().get(1));
						paresCobertos.add(par.clonar());
						return true; 
				}
			}
		}   
		return false;  
	}
	
	public Teste adicionarValoresSemImportancia(ParCobertura par){
		
		Teste teste = new Teste(Dominio.getInstance().getListaFatores().size()); 
		
		int i=1; 
		
		for(Nivel nivel: par.getListaNiveis()){
			if(i==nivel.getFator()){
				teste.addElemento(nivel);
				i = i + 1;
				continue;
			} 
			if(i<nivel.getFator()){
				int k = i;
				for(int j=k; j<nivel.getFator(); j++){
					Nivel ni = new Nivel(i, 0);
					teste.addElemento(ni);
					i = i + 1;
				}
			}
			teste.addElemento(nivel);
			i = i + 1;
		}
		 
		while(i<=Dominio.getInstance().getListaFatores().size()){
			Nivel nivel = new Nivel(i, 0);
			teste.addElemento(nivel);
			i = i + 1;
		}
		
		return teste;				
	}
	
}