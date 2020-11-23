import java.util.LinkedList;


public class ParesCobertos{	
	
	private LinkedList<Teste> listaTeste;
	private LinkedList<ParCobertura> conjunto;

	public ParesCobertos(){
		listaTeste = new LinkedList<Teste>();
		conjunto = new LinkedList<ParCobertura>();
	}
	
	public LinkedList<ParCobertura> getConjunto() {
		return conjunto;
	}
	 
	public void setListaTeste(LinkedList<Teste> listaTeste){
		this.listaTeste = listaTeste;
	}
  
	public void acharParesCobertos(){
		for(Teste t: listaTeste){
			armazenarParesCobertos(t);
		}
	}
	 
	public void armazenarParesCobertos(Teste teste){
		int tamanho = teste.getListaNiveis().size();
		for(int i=0; i<tamanho-1; i++){
			for(int j=1; j<tamanho; j++){
				if(i==j){
					continue;
				}
				ParCobertura par = new ParCobertura();
				par.getListaNiveis().add(teste.getListaNiveis().get(i));
				par.getListaNiveis().add(teste.getListaNiveis().get(j));
				conjunto.add(par);
			}
		}
	}
	
}
