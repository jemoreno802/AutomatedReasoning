import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Prover {
	//print TT 
	/*for(Symbol s :m.model.keySet()) {
	if(m.model.get(s) == true) {
		System.out.print(  m.model.get(s) + "  | ");

	}else {
		System.out.print(  m.model.get(s) + " | ");

	}
}System.out.println();
*/
	
	public boolean entails(KB kb, Sentence alpha) {
		//Collection<Symbol> symbols = kb.symbols();
		List<Symbol> symbols = new ArrayList<Symbol>(); 
		symbols.addAll(kb.symbols());
		Model empty = new ModelChecking();
		System.out.print(" ");
		for(Symbol s : symbols) {
		//	System.out.print(s.name + "    |  ");
		}
		System.out.println();
		//System.out.println("______________");
		return checkAll(kb, alpha, symbols, empty);
	}

	public boolean checkAll(KB kb, Sentence alpha, List<Symbol> symbols, Model m) {
		if(symbols.isEmpty()) {
			if(m.satisfies(kb, m)) {     //if the model satisfies the KB, check if the model satisfies alpha
				return m.satisfies(alpha, m);
			}else {
				return true;
			}
		}else {
			Symbol temp = symbols.get(0);
			List<Symbol> rest = symbols.subList(1, symbols.size());
			boolean checkT = checkAll(kb, alpha, rest, m.set(temp, true, m));
			boolean checkF = checkAll(kb, alpha, rest, m.set(temp, false,m));
			return (checkT && checkF );
		}
	}
}
