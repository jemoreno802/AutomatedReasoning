
public class HornClausesKB extends KB{
	Prover prove = new Prover();
	ResolutionProof r = new ResolutionProof();

	public HornClausesKB() {
			super();
			Symbol my = intern("My"); //Is mythical?
			Symbol mag = intern("Mag"); //Is magical?
			Symbol ma = intern ("Ma"); // Is a mammal?
			Symbol h = intern ("H"); //Is horned?
			Symbol mo = intern ("Mo"); //Is mortal?

			add(new Implication (my, new Negation(mo)));
			add(new Implication (new Negation(my), new Conjunction (mo, ma)));
			add(new Implication (new Disjunction(new Negation (mo), ma), h));
			add(new Implication (h, mag)); //If horned then it's magical
	}
	
	public void checkResolution() {
		System.out.println("Unicorn is mythical:" + r.checkResolution(this, intern("My")));
		System.out.println("Unicorn is magical:" + r.checkResolution(this, intern("Mag")));
		System.out.println("Unicorn is horned:" + r.checkResolution(this, intern("H")));

	}
	
	public void checkModels() {
		System.out.println("KB entails(Unicorn is Mythical): " + prove.entails(this, intern("My")));
		System.out.println("KB entails(Unicorn is Magical): " + prove.entails(this, intern("Mag") ));
		System.out.println("KB entails (Unicorn is Horned): " + prove.entails(this, intern("H") ));
	} 
	
}