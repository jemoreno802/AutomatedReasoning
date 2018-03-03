import java.util.Collection;
import java.util.HashMap;
public class ModelChecking implements Model{
	/**
	 * Set the value assigned to the given PropositionSymbol in this
	 * Model to the given boolean VALUE.
	 */
	HashMap<Symbol, Boolean> model = new HashMap<Symbol, Boolean>();
	
	
	public Model set(Symbol sym, boolean value) {
		sym.value = value;
		model.put(sym, value);
		return this;
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
		/*
	for(Symbol s :this.model.keySet()) {
		System.out.print(s.name + ": " + model.get(s) + " ");
	}System.out.println();
	*/
		boolean satisfies = true;
		for(Sentence S : kb.sentences) {
			if(S.isSatisfiedBy(this) == false) {
				satisfies = false;
			}
		}
		
		return satisfies;
	}

	/**
	 * Return true if this Model satisfies (makes true) the given Sentence.
	 */
	public boolean satisfies(Sentence sentence) {
		/*for(Symbol s :this.model.keySet()) {
			System.out.print(s.name + ": " + model.get(s) + " ");
		}System.out.println();
		*/
		this.model.values().toString();
		System.out.println(sentence.isSatisfiedBy(this));
		return sentence.isSatisfiedBy(this);
		//return true;
	}
	
	/**
	 * Print the assignments in this Model to System.out.
	 */
	public void dump() {
		for(Symbol S : model.keySet()) {
			System.out.println(S.name + " : " + S.value);
		}
	}
	
	public boolean entails(KB kb, Sentence alpha) {
		Collection<Symbol> symbols = kb.symbols();
	//	symbols.add(alpha);
		return checkAll(kb, alpha, symbols, this, 0);
	}
	
	public boolean checkAll(KB kb, Sentence alpha, Collection<Symbol> symbols, Model m, int i) {
		System.out.println("depth: " + i);
		//System.out.println(model.size());
		if(symbols.isEmpty()) {
			for(Symbol s :this.model.keySet()) {
				System.out.print(s.name + ": " + model.get(s) + " ");
			}System.out.println();
			if(satisfies(kb)) {
				return satisfies(alpha);
			}else {
				return true;
			}
		}else {
			Symbol temp = symbols.iterator().next();
			symbols.remove(temp);
			System.out.println("temp:" + temp.name);
			return (checkAll(kb, alpha, symbols, set(temp, true), i+1) && checkAll(kb, alpha, symbols, set(temp, false),i+1));

		}
	}
}
