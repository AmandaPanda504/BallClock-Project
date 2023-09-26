import java.util.*;


 public class Runner extends BallClock{
	
 	public static void main(String[] args){


 		Scanner input = new Scanner(System.in);
 		
 		BallClock clock = new BallClock();  	// new BallClock object

 		while(input.hasNextLine()){ 			// loop continously takes input until the number 0 is typed

 			int in = input.nextInt(); 			 //takes integers from scanner until it is terminated by 0
 			if(in == 0){
 				break;
 			}

 			Queue<Balls> providedBalls = new LinkedList<>(); 	// assigns the balls a unique number using ball constrcutor

 			for(int i = 1; i <= in; i++){

 				providedBalls.add(new Balls(i)); 				// used to store the balls and their unique numbers


 			}

 			long days = clock.timeMethod(providedBalls); 			// pushes BallClock object clock, unto timeMethod() 


 			System.out.println(in + " balls will take "+ days); 	// output statement


 			input.nextLine();

 		}
		 
	}

}