
  public class Impressora {
 
	
	public Impressora(){}

	public void imprimirNivel(Nivel n){
		System.out.print("("+n.getFator()+","+n.getValor()+")");
	}
	
	public void imprimirParCobertura(ParCobertura par){
		for(Nivel n: par.getListaNiveis()){
			this.imprimirNivel(n);
		} 
	}
	  
	public void imprimirTeste(Teste teste){
		
		for(Nivel n: teste.getListaNiveis()){
			if(n.getValor()==0){ 
				System.out.print("_");
				System.out.print("   ");
				continue;
			}
			System.out.printf("%-3d", n.getValor());
			System.out.print(" ");
		}
		System.out.println("");
		  
	}
	
	public void imprimirSuiteTeste(){
		
		ManipuladorSuiteTeste manipuladorSuiteTeste = ManipuladorSuiteTeste.getInstance();
		
		System.out.println("Conjunto de testes completo: ");
		int i=1;
		
		for(Teste teste: manipuladorSuiteTeste.getListaTestes()){
		
			System.out.printf("%-6d", i);
			System.out.print(" "+"|"+"\t ");
			for(Nivel n: teste.getListaNiveis()){
				if(n.getValor()==0){
					System.out.print("_");
					System.out.print("   ");
					continue;
				}
				System.out.printf("%-3d", n.getValor());
				System.out.print(" ");
			}
			i = i + 1;
			System.out.println("");
		}
	}
}
