package GeneticAlgorithm.GA;

import java.util.Scanner;

public class CompilerBF {
	
	private Scanner console = new Scanner(System.in);
	private final int LENGTH = 65535;					        //length of the byte array
	private byte[] memory = new byte[LENGTH];
	private int pointer;
	private int scoreCounter = 0;
	//private String result = "";
	
	/**
	 * Esoteric Language Brainfuck compiler
	 * @author Edoardo Bertoli
	 * @param bfcode String of Brainfuck code to translate
	 */
	public String interpret(String bfcode){
		int check = 0;
		String result = "";
		for(int i = 0; i<bfcode.length(); i++){
			try{
				switch(bfcode.charAt(i)){
				case('>'): 
					// Increase the pointer to one more
					pointer++;	
					// If the pointer is in the last possible spot don't go on
					if(pointer == LENGTH - 1){
						break;
					}
					this.scoreCounter++;
					break;
				case('<'): 
					pointer--;
					if(pointer == 0){   
						break;
					}
					this.scoreCounter++;
					break;
				case('+'):
					memory[pointer]++;
					this.scoreCounter++;
					break;
				case('-'):
					memory[pointer]--;
					this.scoreCounter++;
					break;
				case('.'):
					String letter = Character.toString((char)memory[pointer]);
					result+=letter;
					this.scoreCounter++;
					break;
				case(','):
					memory[i] = (byte) console.nextLine().charAt(0);
					this.scoreCounter++;
					break;
				case('['):
					// If the loop counter is 0 than skip this char element 
					if(memory[pointer]==0){				
						i++;
						//  Keep moving the pointer forward by one until either you reach ] or check is less than 0
						while(check>0 || bfcode.charAt(i)!= ']'){
							if(i==bfcode.length()-1) break;
							if(bfcode.charAt(i)=='[') check++;
							if(bfcode.charAt(i) == ']') check--;
							i++;
						}
					}
					this.scoreCounter++;
					break;
				case(']'):
					// The counter should be 0 unless go back to the previous char element
					if(memory[pointer]!=0){
						i--;
					
						// Keep moving the pointer backwards by one until either you reach [ or check is less than 0
						while(check>0 || bfcode.charAt(i) != '['){
							if(i==0) break;
							if(bfcode.charAt(i) == ']') check++;
							if(bfcode.charAt(i) == '[') check--;
							i--;
						}
						i--;
					}
					this.scoreCounter++;
					break;
				}
			}
			catch(Exception e){
				return result;
			}
		}
		return result;
	}

	/* 	'[' and ']' work as a going back and forth from the two brackets 
	 * 	so when the pointer reaches the [ 
	 * 	it has to move to the next memory cell until it reaches the ] 
	 * 	when it has to go back and change the value of check
	 */
	
	// Get the score of the 
	public int getScore(){
		return this.scoreCounter;
	}
	
}
