import java.util.Collection;
import java.util.HashMap;
public class ModelChecking implements Model{
	/**
	 * Set the value assigned to the given PropositionSymbol in this
	 * Model to the given boolean VALUE.
	 */
	HashMap<Symbol, Boolean> model = new HashMap<Symbol, Boolean>();
	
	
	public Model set(Symbol sym, boolean value, Model m) {
		sym.value = value;
		m.model.put(sym, value);
		return m;
	}

	/**
	 * Returns the boolean value associated with the given PropositionalSymbol
	 * in this Model.
	 */
	public boolean get(Symbol sym) {
		return sym.value;
	}
	
	/**
	 * Return true if this Model satisfies (makes true) the given KB.
	 */
	public boolean satisfies(KB kb, Model m) {
		boolean satisfies = true;
		for(Sentence S : kb.sentences) {
			if(S.isSatisfiedBy(m) == false) {
				satisfies = false;
			}
		}
		return satisfies;
	}

	/**
	 * Return true if this Model satisfies (makes true) the given Sentence.
	 */
	public boolean satisfies(Sentence sentence, Model m) {
		return sentence.isSatisfiedBy(m);
	}
	
	/**
	 * Print the assignments in this Model to System.out.
	 */
	public void dump() {
		for(Symbol S : model.keySet()) {
			System.out.println(S.name + " : " + S.value);
		}
	}

}
