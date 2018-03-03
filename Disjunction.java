public class Disjunction extends BinaryCompoundSentence {

	public Disjunction(Sentence lhs, Sentence rhs) {
		super(BinaryConnective.OR, lhs, rhs);
	}

	/**
	 * Return true if this Disjunction is satisfied by the given Model.
	 * That is, if either of its arguments are satisfied by the Model.
	 */
	public boolean isSatisfiedBy(Model model) {
		/*
		System.out.println(lhs.toString() + " ");
		System.out.print("OR ");
		System.out.print(rhs.toString());
		System.out.println();
		*/
		return lhs.isSatisfiedBy(model) || rhs.isSatisfiedBy(model);
	}

}