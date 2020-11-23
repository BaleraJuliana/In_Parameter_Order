## In Parameter Order (IPO)

In-Parameter-Order (IPO) é um algoritmo desenvolvido por (Yu Lei and K. C. Tai, 1998) para a geração de dados de teste para Teste Combinatorial. Nesse repositório se encontra a implementação do IPO na linguagem de programação Java utilizada no contexto de uma dissertação de mestrado. 

# Como utilizar


```
@Test
	public void testeExemplo(){
			
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
		
		CrescimentoVertical crescimentoVertical = new CrescimentoVertical();
		crescimentoVertical.init();
		
		impressora.imprimirSuiteTeste();	 
	}

```	
     



# Aplicando Teste Combinatorial para a geração de testes de unidade 




# Referências

Yu Lei and K. C. Tai, "In-parameter-order: a test generation strategy for pairwise testing," Proceedings Third IEEE International High-Assurance Systems Engineering Symposium (Cat. No.98EX231), Washington, DC, USA, 1998, pp. 254-261, doi: 10.1109/HASE.1998.731623.

BALERA, JULIANA M.; SANTIAGO JÚNIOR, VALDIVINO A. DE . An algorithm for combinatorial interaction testing: definitions and rigorous evaluations. JOURNAL OF SOFTWARE ENGINEERING RESEARCH AND DEVELOPMENT, v. 5, p. 1, 2017.

Balera, Juliana Marino; de Santiago Júnior, Valdivino Alexandre . T-Tuple Reallocation: An Algorithm to Create Mixed-Level Covering Arrays to Support Software Test Case Generation. In: O. Gervasi; B. Murgante; S. Misra; M. L. Gavrilova; A. M. A. C. Rocha; C. Torre; D. Taniar; B. O. Apduhan. (Org.). Lecture Notes in Computer Science. IVed.: Springer International Publishing, 2015, v. 9158, p. 503-517.
