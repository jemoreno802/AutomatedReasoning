

public class WumpusWorldKB extends KB {
	Prover prove = new Prover();
	ResolutionProof r = new ResolutionProof();

	public WumpusWorldKB() {
		super();
		Symbol p11 = intern("P1,1");
		Symbol p12 = intern("P1,2");
		Symbol p21 = intern("P2,1");
		Symbol p22 = intern("P2,2");
		Symbol p31 = intern("P3,1");
		Symbol b11 = intern("B1,1");
		Symbol b21 = intern("B2,1");

		add(new Negation(p11));
		add(new Biconditional(b11, new Disjunction(p12, p21)));
		add(new Biconditional(b21, new Disjunction(p12, new Disjunction(p22, p31))));
		add(new Negation(b11));
		add(b21);
		
		
	}
	
	public void checkResolution() {
		System.out.println("Pit at (1, 2): " + r.checkResolution(this, intern("P1,2")));
	}
	
	public void checkModels() {
		Negation not = new Negation(intern("P1,2"));
		System.out.println("KB entails P1,2: " + prove.entails(this, intern("P1,2")));
	}
	

}