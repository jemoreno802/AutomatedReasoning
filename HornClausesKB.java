
public class HornClausesKB extends KB{
	
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
			add(new Implication (h, ma)); //It horned then it's magical
	}
}