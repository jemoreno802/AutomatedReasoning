import java.util.List;
import java.util.Collection;


public class ModusPonensKB extends KB{
	ModelChecking check = new ModelChecking();
	
	public ModusPonensKB() {
		super();
		Symbol P = intern("P");
		Symbol Q = intern("Q");
		
		add(P);
		add(new Implication(P,Q));
	}
	
	public void checkModels() {
		Collection<Sentence> S = sentences();
		Collection<Symbol> sym = symbols();
		check.symbols = sym;
		
		for(Symbol x: sym) {
			check.set(x, true);
		}
		check.dump();
		
	}
	
	public static void main(String[] argv) {
		new ModusPonensKB().dump();
		new ModusPonensKB().checkModels();
	}
}
