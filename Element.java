package GeneticAlgorithm.GA;

import java.util.Random;

//** Improving by using ArrayList **//
public class Element {
	
	private static int defaultGeneLength = 50;								//length of the gene 
	private char[] genes = new char[defaultGeneLength];				//array of genes which make an element
	private Random rand = new Random();
	private int score = 0;
	
	//Cache
	private int fitness = 0;
	
	//create a random element
	public void generateElement(){
		for(int i = 0; i<size(); i++){
			int geneInt = rand.nextInt(7);							//random number between 0 and 8 (8 non inclusive)
			genes[i] = translateIntChar(geneInt);
		}
	}

	// Translate from number to character
	private static char translateIntChar(int geneInt){
		if(geneInt == 0){
			return '>';						
		} else if(geneInt == 1){
			return '<';						
		} else if(geneInt == 2){
			return '+';						
		} else if(geneInt == 3){
			return '-';						
		} else if(geneInt == 4){
			return '.';						
		} else if(geneInt == 5){
			return '[';						
		} else {
			return ']';						
		}
		
	}
	
	/*Gets and Sets*/
	
	
	
	public char getGene(int index){
		return genes[index];
	}
	
	public void setGene(int index, char value){
		genes[index] = value;
		fitness = 0;
	}
	
	public int getScore(){
		return this.score;
	}
	
	
	public int size(){
		return genes.length;
	}
	
	public int getFitness(){
		if(fitness == 0){
			fitness = FitnessCalc.getFitness(this);
		}
		return fitness;
	}
	
	public void printGenesArray(){
		for(char x : genes){
			System.out.print(x);
		}
	}
	
	public String toStringGenesArray(){
		String geneString = "";
		for(int i = 0; i < size(); i++){
			geneString += getGene(i);
		}
		return geneString;
	}
	
	public static char generateRandomGene(){
		Random randy = new Random();
		int geneInt = randy.nextInt(8);
		return translateIntChar(geneInt);
	}
	
	
	

}
