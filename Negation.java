

public class Negation extends UnaryCompoundSentence {
	
	public Negation(Sentence argument) {
		super(UnaryConnective.NOT, argument);
	}

	/**
	 * Return true if this Negation is satisfied by the given Model.
	 * That is, if its argument is not satisfied by the Model.
	 */
	public boolean isSatisfiedBy(Model model) {
	//	System.out.println("NOT " + argument.toString());
		return !argument.isSatisfiedBy(model);
	}

}