import java.util.LinkedList;

public class CrescimentoHorizontal {
	
	private Dominio dominio = Dominio.getInstance();
	private ManipuladorConjuntoCobertura manipuladorConjuntoCobertura = ManipuladorConjuntoCobertura.getInstance();
	private ManipuladorSuiteTeste manipuladorSuiteTeste = ManipuladorSuiteTeste.getInstance();
	
	private ParesCobertos paresCobertos; 
	private LinkedList<Teste> listaTeste = new LinkedList<Teste>();
	private Nivel v;
	
	private LinkedList<ParCobertura> aux1 = new LinkedList<ParCobertura>();
	private LinkedList<ParCobertura> aux2 = new LinkedList<ParCobertura>();
	private LinkedList<ParCobertura> aux3 = new LinkedList<ParCobertura>();
	private static CrescimentoHorizontal uniqueInstance;
		
	private CrescimentoHorizontal(){
		paresCobertos = new ParesCobertos();
		v = new Nivel(0, 0);
	}
	 
	public static CrescimentoHorizontal getInstance() {
		if(uniqueInstance==null)
			uniqueInstance = new CrescimentoHorizontal();
		return uniqueInstance;
	} 

	@SuppressWarnings("unchecked")
	public void init(int i){
		
		int s = Math.min(dominio.getListaFatores().get(i).getListaNiveis().size(), manipuladorSuiteTeste.getListaTestes().size());
		
		for(int j=0; j<s; j++){
			manipuladorSuiteTeste.getListaTestes().get(j).addElemento(dominio.getListaFatores().get(i).getListaNiveis().get(j));
		}
		
		paresCobertos.setListaTeste(manipuladorSuiteTeste.getListaTestes());
		paresCobertos.acharParesCobertos();
		manipuladorConjuntoCobertura.removerTodosPares(paresCobertos.getConjunto());
		paresCobertos.getConjunto().clear();
		
		if(s==manipuladorSuiteTeste.getListaTestes().size()){
			return;
		}
		
		for(int j=s; j<manipuladorSuiteTeste.getListaTestes().size(); j++){
			
			listaTeste.add(manipuladorSuiteTeste.getListaTestes().get(j)); 
			
			for(Nivel n: dominio.getListaFatores().get(i).getListaNiveis()){
				
				listaTeste.get(0).getListaNiveis().add(n); 
				paresCobertos.setListaTeste(listaTeste);
				paresCobertos.acharParesCobertos();			
				this.retirarParesJaCobertos(); 
				
				if(aux2.size()>aux1.size()){
					aux1 = (LinkedList<ParCobertura>) aux2.clone();
					v.setFator(n.getFator());
					v.setValor(n.getValor());	
				}
				
				paresCobertos.getConjunto().clear();
				listaTeste.get(0).getListaNiveis().remove(listaTeste.get(0).getListaNiveis().size()-1);
			}	
			
			manipuladorConjuntoCobertura.removerTodosPares(aux1);
			aux1.clear();
			Nivel nv = v.clonar(); 
			manipuladorSuiteTeste.getListaTestes().get(j).addElemento(nv);
			listaTeste.remove(0);
		}
	}
	
	public void retirarParesJaCobertos(){
		
		for(ParCobertura p: paresCobertos.getConjunto()){
		
			if(manipuladorConjuntoCobertura.estaDentro(p)){
				aux3.add(p);
			}
		}
		
		aux2 = (LinkedList<ParCobertura>)aux3.clone();
		aux3.clear();
	}
}
