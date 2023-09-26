import java.util.*;

public class BallClock {
	
	protected Stack<Balls> minRack = new Stack<>();  		//rack holding the balls on the one min rack
	protected Stack<Balls> fiveMinRack = new Stack<>();		//rack holding the balls on the five min rack
	protected Stack<Balls> hourRack = new Stack<>();		//rack holding the balls on the hour rack

	public long timeMethod(Queue<Balls> provided) {			// method that takes in a queue of balls 
		int originalSize = provided.size();
		long mins = 0;

		while (!provided.isEmpty()) { 					// while loop that executes while the provided balls queue is not empty

			Balls current = provided.poll(); 			// removes head of ball queue
			mins++;

			addToMinRack(provided, current);
			if (originalSize == provided.size()) {

				int previous = 0;

				Queue<Balls> copy = new LinkedList<>(); // new instance of linked list used to store the new ordering of providedBalls

				boolean correctOrder = true;

				while (!provided.isEmpty()) {			// while loop checks ordering of the previous and current ball numbers
					Balls newBall = provided.poll();
					if (previous + 1 != newBall.num) {
						correctOrder = false;

					}
					
					previous = newBall.num;
					copy.add(newBall);
				}
				if (correctOrder) {			// conditionals statements that checks if the ordering of the balls is correct.
					
					break;
				} else {
					while (!copy.isEmpty()) {		// continues if condition is true
						provided.add(copy.poll());
					}
				}

			}

		}

		return minsToDays(mins);

	}

	public long minsToDays(long mins) {  // method responsible for converting mins into days

		long hours = mins / 60;
		long days = hours / 24;

		return days;

	}

	public void addToMinRack(Queue<Balls> providedBalls, Balls current) {  // method responsible for taking in the provided and current balls, and adds them unto rack 

		if (minRack.size() == 4) { // provided that the rack size is equal to 4, the while loop will continuously execute
			

			while (!minRack.isEmpty()) {
				providedBalls.add(minRack.pop());		// takes the recently added ball and directs it to providedballs
			}
			addToFiveMinRack(providedBalls, current);
		}

		else {
			minRack.add(current);
		}

	}

	public void addToFiveMinRack(Queue<Balls> providedBalls, Balls current) { // method responsible for taking in the provided and current balls, and adds them unto rack

		if (fiveMinRack.size() == 11) { // provided that the rack size is equal to 11, the while loop will continuously execute
			

			while (!fiveMinRack.isEmpty()) {
				providedBalls.add(fiveMinRack.pop());
			}
			addTohourRack(providedBalls, current);

		}

		else {

			fiveMinRack.add(current);
		}

	}

	public void addTohourRack(Queue<Balls> providedBalls, Balls current) { // method responsible for taking in the provided and current balls, and adds them unto rack

		if (hourRack.size() == 11) {	// provided that the rack size is equal to 11, the while loop will continuously execute
			
			while (!hourRack.isEmpty()) {
				providedBalls.add(hourRack.pop());
			}
			providedBalls.add(current);
			

		}

		else {
			hourRack.add(current);
		}

	}
}