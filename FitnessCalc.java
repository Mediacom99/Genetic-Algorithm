package GeneticAlgorithm.GA;

public class FitnessCalc {
	

	// Calculate element fitness by compiling and getting a score 
	static int getFitness(Element element){
		String elStr = "";
		CompilerBF compiler = new CompilerBF();
		// Ogni elemento deve passare dal compiler come String
		elStr = element.toStringGenesArray();
		// Risultato dopo che è passato dal compiler
		String result = compiler.interpret(elStr);
		System.out.println(result);
		// Ottieni score di quell'elemento
		int fitness = compiler.getScore();
		// se tutto il codice funziona allora controlla il risultato della stringa e comparalo al target
		if(fitness == element.size()){
			System.out.println("100% working bf code");
		}
		return fitness;
		
	}
}
