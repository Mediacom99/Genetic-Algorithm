package GeneticAlgorithm.GA;


public class Algorithm {

	//GA parameters
	private static final double uniformRate = 0.5;
	private static final double mutationRate = 0.015;					//0.015
	private static final int tournamentSize = 5;
	private static final boolean elitism = true;
	
	/* Public methods */
	
	//Evolve a Population
	public static Population evolvePopulation(Population pop){
		Population newPopulation = new Population(pop.size());
		
		//keep our best element
		if(elitism){
			newPopulation.saveElement(0, pop.getFittest());
		}
		
		//crossover population
		int elitismOffset;
		if(elitism){
			elitismOffset = 1;
		} else {
			elitismOffset = 0;
		}
		
		// Loop over the population size and create new elements with crossover
		for(int i = elitismOffset; i< pop.size(); i++){
			Element elem1 = tournamentSelection(pop);
			Element elem2 = tournamentSelection(pop);
			Element newElem = crossover(elem1, elem2);
			newPopulation.saveElement(i, newElem);
		}
		
		//mutate population
		for(int i = elitismOffset; i< pop.size(); i++){
			mutate(newPopulation.getElement(i));
		}
		
		return newPopulation;
	}
	
	// Crossover elements
	private static Element crossover(Element elem1, Element elem2){
		Element newSol = new Element();
		// Loop through genes
		for(int i = 0; i<elem1.size(); i++){
			//crossover
			if(Math.random() <= uniformRate){
				newSol.setGene(i, elem1.getGene(i));
			} else {
				newSol.setGene(i, elem2.getGene(i));
			}
		}
		return newSol;
	}
	
	// Mutate an element
	private static void mutate(Element elem){
		// Loop through genes
		for(int i = 0; i<elem.size(); i++){
			if(Math.random() <= mutationRate){
				// Create a random gene
				char gene = Element.generateRandomGene();
				elem.setGene(i, gene);
			}
		}
	}
	
	// Select two best elements for crossover
	private static Element tournamentSelection(Population pop){
		//create a tournament population
		Population tournament = new Population(tournamentSize);
		// For each place in the tournament get a random element
		for(int i = 0; i<tournamentSize; i++){
			int randomId = (int) (Math.random() * pop.size());
			tournament.saveElement(i, pop.getElement(randomId));
		}
		// Get the fittest
		Element fittest = tournament.getFittest();
		return fittest;
	}
	
	
	
	
	
	
	
	
}
