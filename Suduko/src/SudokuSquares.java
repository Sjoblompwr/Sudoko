import java.util.ArrayList;
import java.util.Random;

public class SudokuSquares {

	public static void main(String[] args) {
		int squareCounter = 0;
		//81 positions.
		int sudoku[] = new int[81];
		if(sudoku[0] == 0) {
			square square = new square();
			square.generateRSquare();
			for(int i = 0;i<3;i++) {
				for(int j = 0;j<3;j++) {
					sudoku[i * 9 + j] = square.square[i][j];
				}
			}
			squareCounter++;
		}

			//second square time.
			//pick element from second row+2 from third and place on first row.
			sudoku[3] = sudoku[9];
			sudoku[4] = sudoku[18];
			sudoku[5] = sudoku[19];
			
			sudoku[12] = sudoku[20];
			sudoku[13] = sudoku[0];
			sudoku[14] = sudoku[1];
			
			sudoku[21] = sudoku[2];
			sudoku[22] = sudoku[10];
			sudoku[23] = sudoku[11];
		
			
			//third square put remaining elements in random order and place them on the 
			//correct row.
			ArrayList<Integer> numbers  = new ArrayList<Integer>();
			ArrayList<Integer> Rnumbers  = new ArrayList<Integer>();
			Random r = new Random();
			int rand;
			for(int j = 0;j<3;j++) {
				//----this generates the numbers in random order----
				for(int i = 1; i <= 9;i++) {
					numbers.add(i);
				}
				for(int i = 1; i <= 9;i++) {
					rand = r.nextInt(numbers.size());
					Rnumbers.add(numbers.get(rand));
					numbers.remove(rand);
				}
				//------
				
				//places the numbers on the correct row
				for(int i = 0; i < 6 ; i++) {
					Rnumbers.remove(Rnumbers.indexOf(sudoku[i + 9 *j]));	
				}
				for(int i = 0; i < 3 ; i++) {
					sudoku[i + 6 + 9 * j] = Rnumbers.get(i); 
				}
				numbers.clear(); // already clear I think, but its fine.
				Rnumbers.clear();
			}

		printArray print = new printArray();
		print.print(sudoku);
	}
	


}

class square{
	
	int square[][] = new int[3][3];
	public void generateRSquare(){
		
		ArrayList<Integer> numbers  = new ArrayList<Integer>();
		Random r = new Random();
		int rand;
		for(int i = 1; i <= 9;i++) {
			numbers.add(i);
		}
		int i = 0,j = 0;
		while(!numbers.isEmpty()) {

			rand = r.nextInt(numbers.size());
			square[i][j] = numbers.get(rand);
			numbers.remove(rand);
			j++;
			if(j == 3) {
				i++;
				j = 0;
			}
		}
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