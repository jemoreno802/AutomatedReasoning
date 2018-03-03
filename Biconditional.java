

public class Biconditional extends BinaryCompoundSentence {
	
	public Biconditional(Sentence lhs, Sentence rhs) {
		super(BinaryConnective.IFF, lhs, rhs);
	}

	/**
	 * Return true if this Biconditional is satisfied by the given Model.
	 * That is, if either both its arguments are satisfied by the Model or
	 * both arguments are not satisfied by the Model.
	 */
	public boolean isSatisfiedBy(Model model) {
		/*
		System.out.println(lhs.toString() + " ");
		System.out.print("IFF ");
		System.out.print(rhs.toString());
		System.out.println();
		*/
		return lhs.isSatisfiedBy(model) == rhs.isSatisfiedBy(model);
	}

}