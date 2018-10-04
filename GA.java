package GeneticAlgorithm.GA;


import java.util.Scanner;



public class GA {

	private static Scanner console = new Scanner(System.in);
	private static String targetScanned = "";
	public static void main(String[] args) {

		//User data
//		int populSize = console.nextInt();
//		String wordToMake = console.nextLine();
		// Create an initial Population
		Population myPop1 = new Population(10);
		
		CompilerBF result = new CompilerBF();
		//loop:
		if(result.interpret(myPop1.getFittest().toStringGenesArray()).matches("Hello")) {
			System.out.println(result.interpret(myPop1.getFittest().toStringGenesArray()));
		}else{
			Algorithm.evolvePopulation(myPop1);	
			}
			
		
		System.out.println(myPop1.getFittest().toStringGenesArray());
		
	}
	
	
	/* Getters */
	public static String getTargetScanned(){
		return targetScanned;
	}
	
	
}
