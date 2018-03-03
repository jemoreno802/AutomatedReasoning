import java.util.List;
import java.util.Collection;


public class ModusPonensKB extends KB{
	ModelChecking check = new ModelChecking();
	
	public ModusPonensKB() {
		super();
		Symbol P = intern("P");
		Symbol Q = intern("Q");
		
		add(P);
		add(new Implication(P,Q));
	}
	
	public void checkModels() {
		//Negation n = new Negation(intern("Q"));
		System.out.println(check.entails(this, intern("Q")));
		
	}
	
	public static void main(String[] argv) {
		//new ModusPonensKB().dump();
		new ModusPonensKB().checkModels();
	}
}
