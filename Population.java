package GeneticAlgorithm.GA;

public class Population{
	
	Element[] element;
	
	/*
	 * Constructors
	 */
	
	//create Population
	public Population(int popSize) {
		
		element = new Element[popSize];
		for(int i=0; i<popSize; i++) {
			element[i] = new Element();
			element[i].generateElement();
		}
		//System.out.println(element);
	
	}
	
	public Element getElement(int index){
		return element[index];
	}
	
	public Element getFittest() {
	/*If the fittest number is <= the current Element (dopo che è passato dal getFitness method)
	 * then the fittest number is that current element.
	 */
		Element fittest = element[0];
		for(int i = 0; i< size(); i++){
			if(fittest.getFitness()<= getElement(i).getFitness()){  
				fittest = getElement(i);
			}
		}
		return fittest;
	}
	
	//get population size
	public int size() {
		return element.length;
	}
	
	//save element 
	public void saveElement(int index, Element elem) {
		element[index] = elem;
	}
	
	
	
}