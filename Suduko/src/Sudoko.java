import java.util.ArrayList;
import java.util.Random;

public class Sudoko {

	public static void main(String[] args) {


		ArrayList<Integer> colContain = new ArrayList<Integer>();
		int soduko[] = new int[81];
		

		for(int j = 0; j < 81; j = j + 9) {
			row row = new row();
			row.generateRRow();
			
			for(int i = 0;i<=8;i++) {
				//Generates all values in a column
				for(int k = j; k >= 0;k = k - 9) {
					colContain.add(soduko[8 - i + k]);
				}
				boolean positionEmpty = true;
				//Adds an non-existant value to column + row.
				int i1 = 0;
				while(positionEmpty) {

					if(!colContain.contains(row.rNumbers.get(i1))) {
							soduko[8 - i + j] = row.rNumbers.get(i);
							positionEmpty = false;
						}

					else
						i1++;
				}
				colContain.clear();
			}
		}
		
		printArray print = new printArray();
		print.print(soduko);
	}


}


//Generates an arraylist containing 1-9 in random order.
class row{
	public ArrayList<Integer> rNumbers = new ArrayList<Integer>();
	
	public void generateRRow(){
		int refNum[] = {1,2,3,4,5,6,7,8,9};
		ArrayList<Integer> numbers  = new ArrayList<Integer>();
		Random r = new Random();
		int rand;
		for(int i = 0; i < 9;i++) {
			numbers.add(refNum[i]);
		}
		
		int i = 8;
		do {
			if(i == 0) {
				rNumbers.add(numbers.get(i));
			}
			else {
				rand = r.nextInt(numbers.size());
				rNumbers.add(numbers.get(rand));
				numbers.remove(rand);
			}
			i--;
		}while(i != -1);
	}
}
//Printing a sudoko in desired format
class printArray {
	
	public void print(int array[]) {
		for(int j = 0;j < 81; j = j + 9) {
			for(int i = 0; i <= 8; i++) {
				System.out.print(array[i+j] + " ");	
			}
			System.out.println("");
		}	
	}
}