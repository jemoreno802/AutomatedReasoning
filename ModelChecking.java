import java.util.Collection;
public class ModelChecking implements Model{
	/**
	 * Set the value assigned to the given PropositionSymbol in this
	 * Model to the given boolean VALUE.
	 */
	Collection<Symbol> symbols;
	
	public void set(Symbol sym, boolean value) {
		sym.value = value;
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
	public boolean satisfies(KB kb) {
		return true;
	}

	/**
	 * Return true if this Model satisfies (makes true) the given Sentence.
	 */
	public boolean satisfies(Sentence sentence) {
		return true;
	}
	
	/**
	 * Print the assignments in this Model to System.out.
	 */
	public void dump() {
		for(Symbol S : symbols) {
			System.out.println(S.name + " : " + S.value);
		}
	}
}
