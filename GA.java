package GeneticAlgorithm;

import java.util.Scanner;

public class GA {

	static Scanner console = new Scanner(System.in);
	
	public static void main(String[] args) {
		GeneticAlgorithm();
		
	}
	
	private static void GeneticAlgorithm(){
				System.out.print("Type here the desired target solution: ");
				String targetScanned = console.nextLine();
				// Set the gene length as the target length (Comment this to have default 64 length)
				Element.setDefaultGeneLength(targetScanned.length());
				// Set the target
				FitnessCalc.setTarget(targetScanned);		
				// Create an initial Population
				Population myPop1 = new Population(100, true);
				
				// Evolve our population until we reach an optimal solution
				int generationCounter = 0;
				while(myPop1.getFittest().getFitness() < FitnessCalc.getMaxFitness()){
					generationCounter++;
					System.out.println("Generation: "+generationCounter+" Fittest: "+myPop1.getFittest().getFitness());
					myPop1 = Algorithm.evolvePopulation(myPop1);
				}
				System.out.println("Solution found!");
				System.out.println("Generation: " + generationCounter);
				System.out.println("Genes: ");
				System.out.print(myPop1.getFittest());
	}

}
