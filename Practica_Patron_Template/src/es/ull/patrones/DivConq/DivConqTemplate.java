package es.ull.patrones.DivConq;



abstract public class DivConqTemplate {
	private Problem p;
	private Solution[] ss; 
	/**
	 * @param args
	 */
	final public Solution solve (Problem p ){
		Problem[] pp;
		if(isSimple(p)){

			return simplySolve(p);
			
		} else{

			pp = descompose(p);
			
		}
		Solution[] ss = new Solution[pp.length];
		
		for (int i = 0; i < pp.length; i++) {
			ss[i] = solve(pp[i]);
		}
		return combine(p,ss);
	}
	
	abstract protected boolean isSimple(Problem p);
	abstract protected Solution simplySolve (Problem p);
	abstract protected Problem[] descompose (Problem p);
	abstract protected Solution combine(Problem p, Solution[] ss);
	
}