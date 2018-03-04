import java.util.List;
import java.util.Collection;


public class ModusPonensKB extends KB{
	//ModelChecking check = new ModelChecking();
	Prover prove = new Prover();
	
	public ModusPonensKB() {
		super();
		Symbol P = intern("P");
		Symbol Q = intern("Q");
		
		add(P);
		add(new Implication(P,Q));
	}
	
	public void checkModels() {
		Negation n = new Negation(intern("Q"));
		//System.out.println("KB entails Q: " + prove.entails(this, n));

		System.out.println("KB entails Q: " + prove.entails(this, intern("Q")));
		
	}
}
