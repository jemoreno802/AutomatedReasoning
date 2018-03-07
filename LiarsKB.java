
public class LiarsKB extends KB{
	Prover prove = new Prover();
	ResolutionProof r = new ResolutionProof();
	public LiarsKB(int i) {
		super();
		Symbol A = intern("A");
		Symbol B = intern("B");
		Symbol C = intern("C");
		
		if(i == 1) {
			add(C);
			add(new Implication(A, new Conjunction(A, C))); 					//A->A ^ C
			add(new Implication(B, new Negation(C)));						//B->NOT(C)
			add(new Implication(C, new Disjunction(B, new Negation(A))));		//C->B V NOT(A)  SHOULD RETURN TRUE if we know C is true
		
		}if(i==2) {
			add(new Implication(A, new Negation(C)));
			add(new Implication(B, new Conjunction(A,C)));
			add(new Implication(C,B));
		}if(i == 3) {
			Symbol D = intern("D");
			Symbol E = intern("E");
			Symbol F = intern("F");
			Symbol G = intern("G");
			Symbol H = intern("H");
			Symbol I = intern("I");
			Symbol J = intern("J");
			Symbol K = intern("K");
			Symbol L = intern("L");
			
			add(new Implication(A, new Conjunction(H, I)));
			add(new Implication(B, new Conjunction(A, L)));
			add(new Implication(C, new Conjunction(B, G)));
			add(new Implication(D, new Conjunction(E, L)));
			add(new Implication(E, new Conjunction(C, H)));
			add(new Implication(F, new Conjunction(D, I)));
			add(new Implication(G, new Conjunction(new Negation(E), new Negation(J))));
			add(new Implication(H, new Conjunction(new Negation(F), new Negation(K))));
			add(new Implication(I, new Conjunction(new Negation(G), new Negation(K))));
			add(new Implication(J, new Conjunction(new Negation(A), new Negation(C))));
			add(new Implication(K, new Conjunction(new Negation(D), new Negation(F))));
			add(new Implication(L, new Conjunction(new Negation(B), new Negation(J))));
		}
		
	}
	
	public void checkResolution(int i ) {
		if(i == 1|| i==2) {
			System.out.println("Amy is a liar: " + r.checkResolution(this, new Negation(intern("A"))));
			System.out.println("Bob is a liar: " + r.checkResolution(this, new Negation(intern("B"))));
			System.out.println("Cal is a liar: " + r.checkResolution(this, new Negation(intern("C"))));
		}
		if(i==3) {
			System.out.println("KB entails(Amy is a truth teller): " + r.checkResolution(this, intern("A")));
			System.out.println("KB entails(Bob is a truth teller): " + r.checkResolution(this, intern("B")));
			System.out.println("KB entails(Cal is a truth teller): " + r.checkResolution(this, intern("C")));
			System.out.println("KB entails(Dee is a truth teller): " + r.checkResolution(this, intern("D")));
			System.out.println("KB entails(Eli is a truth teller): " + r.checkResolution(this, intern("E")));
			System.out.println("KB entails(Fay is a truth teller): " + r.checkResolution(this, intern("F")));
			System.out.println("KB entails(Gil is a truth teller): " + r.checkResolution(this, intern("G")));
			System.out.println("KB entails(Hal is a truth teller): " + r.checkResolution(this, intern("H")));
			System.out.println("KB entails(Ida is a truth teller): " + r.checkResolution(this, intern("I")));
			System.out.println("KB entails(Jay is a truth teller): " + r.checkResolution(this, intern("J")));
			System.out.println("KB entails(Kay is a truth teller): " + r.checkResolution(this, intern("K")));
			System.out.println("KB entails(Lee is a truth teller): " + r.checkResolution(this, intern("L")));
		}
	}
	
	public void checkModels(int i) {
		if(i == 1||i==2) {
			System.out.println("Amy is a liar: " + prove.entails(this, new Negation(intern("A"))));
			System.out.println("Bob is a liar: " + prove.entails(this, new Negation(intern("B"))));
			System.out.println("Cal is a liar: " + prove.entails(this, new Negation(intern("C"))));
		}if(i==3) {
			System.out.println("KB entails(Amy is a truth teller): " + prove.entails(this, intern("A")));
			System.out.println("KB entails(Bob is a truth teller): " + prove.entails(this, intern("B")));
			System.out.println("KB entails(Cal is a truth teller): " + prove.entails(this, intern("C")));
			System.out.println("KB entails(Dee is a truth teller): " + prove.entails(this, intern("D")));
			System.out.println("KB entails(Eli is a truth teller): " + prove.entails(this, intern("E")));
			System.out.println("KB entails(Fay is a truth teller): " + prove.entails(this, intern("F")));
			System.out.println("KB entails(Gil is a truth teller): " + prove.entails(this, intern("G")));
			System.out.println("KB entails(Hal is a truth teller): " + prove.entails(this, intern("H")));
			System.out.println("KB entails(Ida is a truth teller): " + prove.entails(this, intern("I")));
			System.out.println("KB entails(Jay is a truth teller): " + prove.entails(this, intern("J")));
			System.out.println("KB entails(Kay is a truth teller): " + prove.entails(this, intern("K")));
			System.out.println("KB entails(Lee is a truth teller): " + prove.entails(this, intern("L")));
		}
		

		
	}

}
