
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ResolutionProof {

	/*
	 * if clause 1 and clause2 contain complementary literals, remove them from each clause and add the resulting 
	 * clauses to a new clause
	 */
	public Set<Clause> PL_Resolve(Clause c1, Clause c2){
		Set<Clause> ret = new HashSet<Clause>(); 
		Clause clause1 = c1.copyClause();
		Clause clause2 = c2.copyClause();
		Iterator<Literal> c1_It = c1.iterator();
		Iterator<Literal> c2_It = c2.iterator();
		while(c1_It.hasNext()){ //compare every literal in clause 1
			Literal l1 = c1_It.next();
			while(c2_It.hasNext()){ //compare every literal in clause 2
				Literal l2 = c2_It.next();
				if (l1.isComplement(l2)){ //if the literals are complementary, remove them from each clause
					clause1.remove(l1);
					clause2.remove(l2);
					Clause clause3 = clause1.copyClause(); //make a new clause containing the resolution of clause1 and clause2
					clause3.addAll(clause2);
					ret.add(clause3);
				}
			}
		}
		return ret;
	}
	
/*
 * checks resolves each clause in the KB with another clause until an empty clause is  found
 * or until no new clauses are found
 */
	public boolean checkResolution(KB kb, Sentence alpha){
		Set <Clause> clauses = CNFConverter.convert(kb); //convert KB to CNF
		Set <Clause> negateA = CNFConverter.convert(new Negation(alpha)); // negate alpha and add it to clauses
		clauses.addAll(negateA);
		Set <Clause> newClauses = new HashSet<Clause>();
		while (true){
			for(Clause X : clauses) {		
				for(Clause Y : clauses) {
					if(!X.equals(Y)) { //for each distinct pair of clauses, resolve them
						Set <Clause> resolvents; 
						resolvents = PL_Resolve(X, Y);
						for(Clause Z: resolvents) {  // if any clause in the resolvents is empty we succeed in proof by resolution
							if (Z.isEmpty()){
								return true;
							}
						}
						newClauses.addAll(resolvents);
					}
				}
			}
			if (clauses.containsAll(newClauses)){ //if no new clauses can be added return false
				return false;
			}
			clauses.addAll(newClauses);
		}
	}
}

