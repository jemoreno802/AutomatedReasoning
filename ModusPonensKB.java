import java.util.List;
import java.util.Collection;


public class ModusPonensKB extends KB{
	Prover prove = new Prover();
	ResolutionProof r = new ResolutionProof();

	
	public ModusPonensKB() {
		super();
		Symbol P = intern("P");
		Symbol Q = intern("Q");
		
		add(P);
		add(new Implication(P,Q));
	}
	
	public void checkResolution() {
		System.out.println("KB entails Q: " + r.checkResolution(this, intern("Q")));
	}
	
	public void checkModels() {
		Negation n = new Negation(intern("Q"));
		//System.out.println("KB entails Q: " + prove.entails(this, n));

		System.out.println("KB entails Q: " + prove.entails(this, intern("Q")));
		
	}
}
