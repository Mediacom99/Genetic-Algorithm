package GeneticAlgorithm;

public class FitnessCalc {
	
	static byte[] target = new byte[64];
	
	/* Public methods */
	//set a candidate target as a byte array
	public static void setSolution(byte[] newSolution){
		target = newSolution;
	}
	
	// In order to make it easier by setting the solution as a String we use this to convert it into byte
	static void setTarget(String newTarget){
		target = new byte[newTarget.length()];
		// Loop through each character of the String and put it in our array of byte
		for(int i = 0; i< newTarget.length(); i++){
			String character = newTarget.substring(i, i + 1);
			if(character.contains("0") || character.contains("1")){
				target[i] = Byte.parseByte(character);		//turn from string to byte
			}else{
				target[i] = 0;
			}
		}
	}
	
	// Calculate element fitness by comparing to our target 
	static int getFitness(Element element){
		int fitness = 0;
		// Loop through our element's genes and compare them to our target
		for(int i = 0; i < element.size() && i < target.length; i++){
			if(element.getGene(i) == target[i]){
				fitness ++;
			}
		}
		return fitness;
	}
	
	// Get optimum fitness
	static int getMaxFitness(){
		int maxFitness = target.length;
		return maxFitness;
	}
	
	
	

}
