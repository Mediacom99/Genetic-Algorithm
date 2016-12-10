package GeneticAlgorithm;

//** Improving by using ArrayList **//
public class Element {
	
	static int defaultGeneLength = 64;								//length of the gene
	private byte[] genes = new byte[defaultGeneLength];				//array of genes which make a element
	
	//Cache
	private int fitness = 0;
	
	//create a random element
	public void generateElement(){
		for(int i = 0; i<size(); i++){
			byte gene = (byte)Math.round(Math.random());			//random number which can be either 0 or 1
			genes[i] = gene;
		}
	}
	
	/*Gets and Sets*/
	
	//use this if you want to create elements with different gene lengths
	public static void setDefaultGeneLength(int length){
		defaultGeneLength = length;
	}
	
	public byte getGene(int index){
		return genes[index];
	}
	
	public void setGene(int index, byte value){
		genes[index] = value;
		fitness = 0;
	}
	
	/*Public methods*/
	
	public int size(){
		return genes.length;
	}
	
	public int getFitness(){
		if(fitness == 0){
			fitness = FitnessCalc.getFitness(this);
		}
		return fitness;
	}
	
	public String toString(){
		String geneString = "";
		for(int i = 0; i < size(); i++){
			geneString += getGene(i);
		}
		return geneString;
	}
	
	
	

}
