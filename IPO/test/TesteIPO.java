import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TesteIPO {

	private Dominio dominio;
	private ManipuladorConjuntoCobertura manipuladorConjuntoCobertura;
	private ManipuladorSuiteTeste manipuladorSuiteTeste;	
    private Impressora impressora;

	@Before
	public void init(){
		
		dominio = Dominio.getInstance();
		manipuladorConjuntoCobertura = ManipuladorConjuntoCobertura.getInstance();
		manipuladorSuiteTeste = ManipuladorSuiteTeste.getInstance();
		impressora = new Impressora();
		
	} 

	@Test
	public void testeGeracaoConjuntoCoberturaComUmFator(){
		
		this.limpar();
		Nivel n1 = new Nivel(1, 1);
		Fator f1 = new Fator(1);
		f1.addNivel(n1);
		dominio.addFator(f1);
		ParCobertura p1 = new ParCobertura();
		p1.addNivel(n1);
		manipuladorConjuntoCobertura.gerarConjuntoCoberturaInicial(); 
		Assert.assertEquals(0, manipuladorConjuntoCobertura.getListaParesCobertura().size());

	}

	@Test
	public void testeGeracaoConjuntoCoberturaComDoisFatores() {

		this.limpar();

		Nivel n1 = new Nivel(1, 1);
		Nivel n2 = new Nivel(1, 2);
		Nivel n3 = new Nivel(2, 1);
		Nivel n4 = new Nivel(2, 2); 

		Fator f1 = new Fator(1);
		Fator f2 = new Fator(2); 

		f1.addNivel(n1);
		f1.addNivel(n2);
		f2.addNivel(n3); 
		f2.addNivel(n4);

		dominio.addFator(f1);
		dominio.addFator(f2);

		ParCobertura p1 = new ParCobertura();
		ParCobertura p2 = new ParCobertura();
		ParCobertura p3 = new ParCobertura();
		ParCobertura p4 = new ParCobertura();

		p1.addNivel(n1);
		p1.addNivel(n3);
		p2.addNivel(n1);
		p2.addNivel(n4);
		p3.addNivel(n2);
		p3.addNivel(n3);
		p4.addNivel(n2);
		p4.addNivel(n4);

		manipuladorConjuntoCobertura.gerarConjuntoCoberturaInicial();
		Assert.assertEquals(4, manipuladorConjuntoCobertura.getListaParesCobertura().size());

		Assert.assertTrue(manipuladorConjuntoCobertura.getListaParesCobertura().get(0).compara(p1)); 
		Assert.assertTrue(manipuladorConjuntoCobertura.getListaParesCobertura().get(1).compara(p2)); 
		Assert.assertTrue(manipuladorConjuntoCobertura.getListaParesCobertura().get(2).compara(p3)); 
		Assert.assertTrue(manipuladorConjuntoCobertura.getListaParesCobertura().get(3).compara(p4)); 

	}
	
	@Test
	public void testeGeracaoConjuntoCoberturaComDoisFatoresVariosNiveis() {

		this.limpar();

		Nivel n1 = new Nivel(1, 1);
		Nivel n2 = new Nivel(1, 2);
		Nivel n3 = new Nivel(2, 1);
		Nivel n4 = new Nivel(2, 2);
		Nivel n5 = new Nivel(2, 3);


		Fator f1 = new Fator(1);
		Fator f2 = new Fator(2);

		f1.addNivel(n1);
		f1.addNivel(n2);
		f2.addNivel(n3); 
		f2.addNivel(n4);
		f2.addNivel(n5);


		dominio.addFator(f1);
		dominio.addFator(f2);

		ParCobertura p1 = new ParCobertura();
		ParCobertura p2 = new ParCobertura();
		ParCobertura p3 = new ParCobertura();
		ParCobertura p4 = new ParCobertura();
		ParCobertura p5 = new ParCobertura();
		ParCobertura p6 = new ParCobertura();


		p1.addNivel(n1);
		p1.addNivel(n3);
		p2.addNivel(n1);
		p2.addNivel(n4);
		p3.addNivel(n1);
		p3.addNivel(n5);
		p4.addNivel(n2);
		p4.addNivel(n3);
		p5.addNivel(n2);
		p5.addNivel(n4);
		p6.addNivel(n2);
		p6.addNivel(n5);  


		manipuladorConjuntoCobertura.gerarConjuntoCoberturaInicial();
		Assert.assertEquals(6, manipuladorConjuntoCobertura.getListaParesCobertura().size());

		Assert.assertTrue(manipuladorConjuntoCobertura.getListaParesCobertura().get(0).compara(p1)); 
		Assert.assertTrue(manipuladorConjuntoCobertura.getListaParesCobertura().get(1).compara(p2)); 
		Assert.assertTrue(manipuladorConjuntoCobertura.getListaParesCobertura().get(2).compara(p3)); 
		Assert.assertTrue(manipuladorConjuntoCobertura.getListaParesCobertura().get(3).compara(p4)); 
		Assert.assertTrue(manipuladorConjuntoCobertura.getListaParesCobertura().get(4).compara(p5)); 
		Assert.assertTrue(manipuladorConjuntoCobertura.getListaParesCobertura().get(5).compara(p6)); 

	}

	@Test
	public void testeGeracaoConjuntoCoberturaComTresFatoresDoisNiveis() {

		this.limpar();

		Nivel n1 = new Nivel(1, 1);
		Nivel n2 = new Nivel(1, 2);
		Nivel n3 = new Nivel(2, 1);
		Nivel n4 = new Nivel(2, 2);
		Nivel n5 = new Nivel(3, 1);
		Nivel n6 = new Nivel(3, 2);


		Fator f1 = new Fator(1);
		Fator f2 = new Fator(2);
		Fator f3 = new Fator(3);

		
		f1.addNivel(n1);
		f1.addNivel(n2);
		f2.addNivel(n3); 
		f2.addNivel(n4);
		f3.addNivel(n5);
		f3.addNivel(n6);
		
		dominio.addFator(f1);
		dominio.addFator(f2);
		dominio.addFator(f3);
		
		ParCobertura p1 = new ParCobertura();
		ParCobertura p2 = new ParCobertura();
		ParCobertura p3 = new ParCobertura();
		ParCobertura p4 = new ParCobertura();
		ParCobertura p5 = new ParCobertura();
		ParCobertura p6 = new ParCobertura();
		ParCobertura p7 = new ParCobertura();
		ParCobertura p8 = new ParCobertura();
		ParCobertura p9 = new ParCobertura();
		ParCobertura p10 = new ParCobertura();
		ParCobertura p11 = new ParCobertura();
		ParCobertura p12 = new ParCobertura();
		
		
		p1.addNivel(n1);
		p1.addNivel(n3);
		p2.addNivel(n1);
		p2.addNivel(n4);
		p3.addNivel(n2);
		p3.addNivel(n3);
		p4.addNivel(n2);
		p4.addNivel(n4);
		p5.addNivel(n1);
		p5.addNivel(n5);
		p6.addNivel(n1);
		p6.addNivel(n6);
		p7.addNivel(n2);
		p7.addNivel(n5);
		p8.addNivel(n2);
		p8.addNivel(n6);
		p9.addNivel(n3);
		p9.addNivel(n5);
		p10.addNivel(n3);
		p10.addNivel(n6);
		p11.addNivel(n4);
		p11.addNivel(n5);
		p12.addNivel(n4);
		p12.addNivel(n6);
		
		

		manipuladorConjuntoCobertura.gerarConjuntoCoberturaInicial();
		Assert.assertEquals(12, manipuladorConjuntoCobertura.getListaParesCobertura().size());
		
		Assert.assertTrue(manipuladorConjuntoCobertura.getListaParesCobertura().get(0).compara(p1)); 
		Assert.assertTrue(manipuladorConjuntoCobertura.getListaParesCobertura().get(1).compara(p2)); 
		Assert.assertTrue(manipuladorConjuntoCobertura.getListaParesCobertura().get(2).compara(p5)); 
		Assert.assertTrue(manipuladorConjuntoCobertura.getListaParesCobertura().get(3).compara(p6)); 
		Assert.assertTrue(manipuladorConjuntoCobertura.getListaParesCobertura().get(4).compara(p3)); 
		Assert.assertTrue(manipuladorConjuntoCobertura.getListaParesCobertura().get(5).compara(p4)); 
		Assert.assertTrue(manipuladorConjuntoCobertura.getListaParesCobertura().get(6).compara(p7)); 
		Assert.assertTrue(manipuladorConjuntoCobertura.getListaParesCobertura().get(7).compara(p8)); 
		Assert.assertTrue(manipuladorConjuntoCobertura.getListaParesCobertura().get(8).compara(p9)); 
		Assert.assertTrue(manipuladorConjuntoCobertura.getListaParesCobertura().get(9).compara(p10)); 
		Assert.assertTrue(manipuladorConjuntoCobertura.getListaParesCobertura().get(10).compara(p11)); 
		Assert.assertTrue(manipuladorConjuntoCobertura.getListaParesCobertura().get(11).compara(p12)); 	
		
	}

	
	@Test
	public void testeGerarConjuntoCasosdeTesteInicialDoisFatores(){

		this.limpar();  

		Nivel n1 = new Nivel(1, 1);
		Nivel n2 = new Nivel(1, 2);
		Nivel n3 = new Nivel(2, 1);
		Nivel n4 = new Nivel(2, 2); 

		Fator f1 = new Fator(1);
		Fator f2 = new Fator(2); 

		f1.addNivel(n1);
		f1.addNivel(n2);
		f2.addNivel(n3); 
		f2.addNivel(n4);

		dominio.addFator(f1);
		dominio.addFator(f2);
		
		manipuladorConjuntoCobertura.gerarConjuntoCoberturaInicial();
		manipuladorSuiteTeste.gerarConjuntoTesteInicial();
		
		int tamanho = dominio.getInstance().getListaFatores().size();
		
		Teste t1 = new Teste(tamanho);
		Teste t2 = new Teste(tamanho);
		Teste t3 = new Teste(tamanho);
		Teste t4 = new Teste(tamanho); 
		
		t1.addElemento(n1);
		t1.addElemento(n3);
		t2.addElemento(n1);
		t2.addElemento(n4); 
		t3.addElemento(n2);
		t3.addElemento(n3);
		t4.addElemento(n2);
		t4.addElemento(n4);

		Assert.assertTrue(manipuladorSuiteTeste.getListaTestes().get(0).compara(t1));
		Assert.assertTrue(manipuladorSuiteTeste.getListaTestes().get(1).compara(t2));
		Assert.assertTrue(manipuladorSuiteTeste.getListaTestes().get(2).compara(t3));
		Assert.assertTrue(manipuladorSuiteTeste.getListaTestes().get(3).compara(t4));

	}
	
	@Test
	public void testeGerarConjuntoCasosdeTesteInicialTresFatores(){

		this.limpar();

		Nivel n1 = new Nivel(1, 1);
		Nivel n2 = new Nivel(1, 2);
		Nivel n3 = new Nivel(2, 1);
		Nivel n4 = new Nivel(2, 2);
		Nivel n5 = new Nivel(3, 1);
		Nivel n6 = new Nivel(3, 2);


		Fator f1 = new Fator(1);
		Fator f2 = new Fator(2);
		Fator f3 = new Fator(3);

		
		f1.addNivel(n1);
		f1.addNivel(n2);
		f2.addNivel(n3);  
		f2.addNivel(n4); 
		f3.addNivel(n5);
		f3.addNivel(n6);
		
		dominio.addFator(f1);
		dominio.addFator(f2);
		dominio.addFator(f3);

		manipuladorConjuntoCobertura.gerarConjuntoCoberturaInicial();
		manipuladorSuiteTeste.gerarConjuntoTesteInicial();
		
		int tamanho = dominio.getInstance().getListaFatores().size();
		
		Teste t1 = new Teste(tamanho);
		Teste t2 = new Teste(tamanho);
		Teste t3 = new Teste(tamanho);
		Teste t4 = new Teste(tamanho); 
		
		t1.addElemento(n1);
		t1.addElemento(n3);
		t2.addElemento(n1);
		t2.addElemento(n4); 
		t3.addElemento(n2);
		t3.addElemento(n3);
		t4.addElemento(n2);
		t4.addElemento(n4);

		Assert.assertTrue(manipuladorSuiteTeste.getListaTestes().get(0).compara(t1));
		Assert.assertTrue(manipuladorSuiteTeste.getListaTestes().get(1).compara(t2));
		Assert.assertTrue(manipuladorSuiteTeste.getListaTestes().get(2).compara(t3));
		Assert.assertTrue(manipuladorSuiteTeste.getListaTestes().get(3).compara(t4));

	}
	
	@Test
	public void testeCrescimentoHorizontalCompletoTresFatoresDoisNiveis(){
			
		/**
		 *  O Intuito é apenas utilizar o método de crescimento horizontal. 
		 *  Para isso é necessário tomar cuidado com quais entradas vc irá submeter
		 *  Um exemplo de caso de teste que utiliza somente crescimento horizontal é composto por dois fatores com dois níveis cada um.
		 *  
		 *  Suite de teste esperada:
		 * 
		 * 		 	A	B	C
		 * 		1	1	1	1
		 * 		2	1	2	2	
		 * 		3	2	1	2
		 * 		4	2	2	1
		 * 	
		 **/
		
		this.limpar();  
		
		Nivel n1 = new Nivel(1, 1);
		Nivel n2 = new Nivel(1, 2);
		Nivel n3 = new Nivel(2, 1);
		Nivel n4 = new Nivel(2, 2);
		Nivel n5 = new Nivel(3, 1);
		Nivel n6 = new Nivel(3, 2);

		Fator f1 = new Fator(1);
		Fator f2 = new Fator(2);
		Fator f3 = new Fator(3);
		
		f1.addNivel(n1);
		f1.addNivel(n2);
		f2.addNivel(n3);  
		f2.addNivel(n4); 
		f3.addNivel(n5);
		f3.addNivel(n6);
		
		dominio.addFator(f1);
		dominio.addFator(f2);
		dominio.addFator(f3);
		
		manipuladorConjuntoCobertura.gerarConjuntoCoberturaInicial();
		manipuladorSuiteTeste.gerarConjuntoTesteInicial();
		
		CrescimentoHorizontal crescimentoHorizontal = CrescimentoHorizontal.getInstance();
		crescimentoHorizontal.init(2);
	
	}
	
	@Test
	public void testeCrescimentoVerticalTresFatores(){
			
		/**
		 *  O Intuito é apenas utilizar o método de crescimento horizontal. 
		 *  Para isso é necessário tomar cuidado com quais entradas vc irá submeter
		 *  Um exemplo de caso de teste que utiliza somente crescimento horizontal é composto por tres fatores com respectivamente dois, dois e 3 níveis cada um.
		 *  
		 *  Suite de teste esperada:
		 * 
		 * 		 	A	B	C
		 * 		1	1	1	1
		 * 		2	1	2	2	
		 * 		3	2	1	2
		 * 		4	2	2	1
		 * 	
		 **/
		
		this.limpar();

		Nivel n1 = new Nivel(1, 1);
		Nivel n2 = new Nivel(1, 2);
		Nivel n3 = new Nivel(2, 1);
		Nivel n4 = new Nivel(2, 2);
		Nivel n5 = new Nivel(3, 1);
		Nivel n6 = new Nivel(3, 2);
		Nivel n7 = new Nivel(3, 3);

		Fator f1 = new Fator(1);
		Fator f2 = new Fator(2);
		Fator f3 = new Fator(3);

		
		f1.addNivel(n1);
		f1.addNivel(n2);
		f2.addNivel(n3); 
		f2.addNivel(n4);
		f3.addNivel(n5);
		f3.addNivel(n6);
		f3.addNivel(n7);
		
		dominio.addFator(f1);
		dominio.addFator(f2);
		dominio.addFator(f3);
		
		manipuladorConjuntoCobertura.gerarConjuntoCoberturaInicial();
		manipuladorSuiteTeste.gerarConjuntoTesteInicial();
		
		CrescimentoHorizontal crescimentoHorizontal = CrescimentoHorizontal.getInstance();
		crescimentoHorizontal.init(2);
		
		impressora.imprimirSuiteTeste();
		
		System.out.println("Ainda Faltam: " + manipuladorConjuntoCobertura.getListaParesCobertura().size());
		System.out.println("Por isso o crescimento vertical...");
		
		CrescimentoVertical crescimentoVertical = new CrescimentoVertical();
		crescimentoVertical.init();
		
		impressora.imprimirSuiteTeste();
		 
	}
	
	public void limpar(){
		dominio.getListaFatores().clear();
		manipuladorConjuntoCobertura.getListaParesCobertura().clear();
		manipuladorSuiteTeste.getListaTestes().clear();
	}
}
