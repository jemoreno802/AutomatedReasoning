import java.util.Iterator;


public class Clause extends ArraySet<Literal> {

	public Clause (){
		super();
	}
	public Clause(Sentence s) throws IllegalArgumentException {
		super();
		toClauses(s, this);
	}

	public Clause copyClause() {
		Clause newC = new Clause();
		Iterator<Literal> iterator = this.iterator();
		while (iterator.hasNext()){
			newC.add(iterator.next());
		}
		return newC;
		}
	
	protected static void toClauses(Sentence s, Clause c) throws IllegalArgumentException {
		if (s instanceof BinaryCompoundSentence) {
			BinaryCompoundSentence bcs = (BinaryCompoundSentence)s;
			BinaryConnective conn = bcs.getConnective();
			if (conn == BinaryConnective.OR) {
				Sentence lhs = bcs.getLhs();
				Sentence rhs = bcs.getRhs();
				toClauses(lhs, c);
				toClauses(rhs, c);
				return;
			}
		}
		// Otherwise
		c.add(new Literal(s));
	}

/**
 * Return the string representation of this Clause.
 */
	public String toString() {
		StringBuilder buf = new StringBuilder();
		buf.append("{");
		boolean first = true;
		for (Literal literal : this) {
			if (!first) {
				buf.append(",");
			} else {
				first = false;
			}
			buf.append(literal.toString());
		}
		buf.append("}");
		return buf.toString();
	}

	public boolean isSatisfiedBy(Model model) {
		for (Literal literal : this) {
			if (literal.isSatisfiedBy(model)) {
				return true;
			}
		}
		return false;
	}

}
