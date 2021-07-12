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
		//THIS IS WRONG; Dunno what I was thinking here, but there is always a system for the numbers here.
		//Might get sorted by the an iterator later.
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

			//--------
			ArrayList<Integer> aColumn = new ArrayList<Integer>();
			ArrayList<Integer> bColumn = new ArrayList<Integer>();
			ArrayList<Integer> cColumn = new ArrayList<Integer>();
			ArrayList<Integer> a2Column = new ArrayList<Integer>();
			ArrayList<Integer> b2Column = new ArrayList<Integer>();
			ArrayList<Integer> c2Column = new ArrayList<Integer>();
			ArrayList<Integer> choosenColumn = new ArrayList<Integer>();
			

			aColumn.add(sudoku[1]);
			aColumn.add(sudoku[10]);
			aColumn.add(sudoku[19]);
			aColumn.add(sudoku[2]);
			aColumn.add(sudoku[11]);
			aColumn.add(sudoku[20]);
			
			bColumn.add(sudoku[0]);
			bColumn.add(sudoku[9]);
			bColumn.add(sudoku[18]);
			bColumn.add(sudoku[2]);
			bColumn.add(sudoku[11]);
			bColumn.add(sudoku[20]);
			
			cColumn.add(sudoku[0]);
			cColumn.add(sudoku[9]);
			cColumn.add(sudoku[18]);
			cColumn.add(sudoku[1]);
			cColumn.add(sudoku[10]);
			cColumn.add(sudoku[19]);
			int i=0;
			ArrayList<Boolean> temp = new ArrayList<Boolean>();
			temp.add(false);
			temp.add(false);
			temp.add(false);
			
			functions func = new functions();
			int tempNumber;
			while(choosenColumn.size() < 9) {
				if(!aColumn.isEmpty()) {
					//Random number which is in aColumn but not ChoosenColumn
					tempNumber = func.getFittingRandomNumber(aColumn, choosenColumn);
					sudoku[27 + i * 9] = tempNumber;
					choosenColumn.add(tempNumber);
					System.out.println("tempNumber:" + tempNumber);
					System.out.println("aColumn"+aColumn.toString());
					aColumn.remove(aColumn.indexOf(tempNumber));
					if(!bColumn.isEmpty() && b2Column.size() < 3)
					if(bColumn.contains(tempNumber)) {
						b2Column.add(tempNumber); 
						bColumn.remove(bColumn.indexOf(tempNumber));
					}
					if(!cColumn.isEmpty() && c2Column.size() < 3)
						if(c2Column.contains(tempNumber)) {
							c2Column.add(tempNumber); 
							cColumn.remove(cColumn.indexOf(tempNumber));
						}
					/*
					rand = r.nextInt(aColumn.size());
					if(choosenColumn.contains(aColumn.get(rand)) || temp.get(0)) {
						aColumn.remove(rand);
						temp.set(0,false);}
						
					else {
						sudoku[27 + i * 9] = aColumn.get(rand);
						choosenColumn.add(aColumn.get(rand));
						if(!bColumn.isEmpty() && b2Column.size() < 3)
						if(bColumn.contains(aColumn.get(rand)) ) {	
							b2Column.add(aColumn.get(rand)); 
							bColumn.remove(bColumn.indexOf(aColumn.get(rand)));
						}
						if(!cColumn.isEmpty() && c2Column.size() < 3)
						if(cColumn.contains(aColumn.get(rand)) ) {
							c2Column.add(aColumn.get(rand));
							cColumn.remove(cColumn.indexOf(aColumn.get(rand)));
						}
						aColumn.remove(rand);
						temp.set(0,true);
					}*/
				}
				if(!bColumn.isEmpty()) {
					//Random number which is in aColumn but not ChoosenColumn
					tempNumber = func.getFittingRandomNumber(bColumn, choosenColumn);
					sudoku[28 + i * 9] = tempNumber;
					choosenColumn.add(tempNumber);
					System.out.println("tempNumber:" + tempNumber);
					System.out.println("bColumn"+bColumn.toString());
					bColumn.remove(bColumn.indexOf(tempNumber));
					if(!aColumn.isEmpty() && a2Column.size() < 3)
					if(aColumn.contains(tempNumber)) {
						a2Column.add(tempNumber); 
						aColumn.remove(aColumn.indexOf(tempNumber));
					}
					if(!cColumn.isEmpty() && c2Column.size() < 3)
						if(c2Column.contains(tempNumber)) {
							c2Column.add(tempNumber); 
							cColumn.remove(cColumn.indexOf(tempNumber));
						}
					
					/*
					rand = r.nextInt(bColumn.size());
					if(choosenColumn.contains(bColumn.get(rand)) || temp.get(1)) {
						bColumn.remove(rand);
						temp.set(1,false);}
					
					else {
						sudoku[28 + i * 9] = bColumn.get(rand);
						choosenColumn.add(bColumn.get(rand));
						if(!aColumn.isEmpty() && a2Column.size() < 3)
						if(aColumn.contains(bColumn.get(rand))) {
							a2Column.add(bColumn.get(rand));
							aColumn.remove(aColumn.indexOf(bColumn.get(rand)));
						}
						if(!cColumn.isEmpty() && c2Column.size() < 3)
						if(cColumn.contains(bColumn.get(rand)) ) {
							c2Column.add(bColumn.get(rand));
							cColumn.remove(cColumn.indexOf(bColumn.get(rand)));
						}
						bColumn.remove(rand);
						temp.set(1,true);
					}*/
				}
				if(!cColumn.isEmpty()) {
					//Random number which is in aColumn but not ChoosenColumn
					tempNumber = func.getFittingRandomNumber(cColumn, choosenColumn);
					sudoku[29 + i * 9] = tempNumber;
					System.out.println("tempNumber:" + tempNumber);
					System.out.println("cColumn"+cColumn.toString());
					choosenColumn.add(tempNumber);
					cColumn.remove(cColumn.indexOf(tempNumber));
					if(!bColumn.isEmpty() && b2Column.size() < 3)
					if(bColumn.contains(tempNumber)) {
						b2Column.add(tempNumber); 
						bColumn.remove(bColumn.indexOf(tempNumber));
					}
					if(!aColumn.isEmpty() && a2Column.size() < 3)
						if(aColumn.contains(tempNumber)) {
							a2Column.add(tempNumber); 
							aColumn.remove(aColumn.indexOf(tempNumber));
						}
					/*
					rand = r.nextInt(cColumn.size());
					if(choosenColumn.contains(cColumn.get(rand)) || temp.get(2)) {
						cColumn.remove(rand);
						temp.set(2,false);}
					
					else {
						sudoku[29 + i * 9] = cColumn.get(rand);
						choosenColumn.add(cColumn.get(rand));
						if(!bColumn.isEmpty() && b2Column.size() < 3)
						if(bColumn.contains(cColumn.get(rand)) ) {
							b2Column.add(cColumn.get(rand));
							bColumn.remove(bColumn.indexOf(cColumn.get(rand)));
						}
						if(!aColumn.isEmpty() && a2Column.size() < 3)
						if(aColumn.contains(cColumn.get(rand))) {
							a2Column.add(cColumn.get(rand));
							aColumn.remove(aColumn.indexOf(cColumn.get(rand)));
						}
						cColumn.remove(rand);
						temp.set(2,true);
					}*/
				}
				//if( temp.get(0) && temp.get(1) && temp.get(2)) {
					i++;
					temp.set(0,false);
					temp.set(1,false);
					temp.set(2,false);
			//	}
				System.out.println(i);
				if(i == 2) {
						System.out.println("");
					}

				
			}
			
			
			
			
			
			
		printArray print = new printArray();
		print.print(sudoku);
		System.out.println("");
		System.out.print(a2Column.toString()); System.out.println(aColumn.toString());
		System.out.print(b2Column.toString()); System.out.println(bColumn.toString());
		System.out.print(c2Column.toString()); System.out.println(cColumn.toString());
		System.out.println(choosenColumn.toString());
		
	}
	


}
class functions{
	 /**
	  * 
	  * @param column
	  * @param choosen
	  * @return integer which isn't in the choosen column
	  */
	public int getFittingRandomNumber(ArrayList<Integer> column,ArrayList<Integer> choosen) {
		Random r = new Random();
		functions recursive = new functions();
		System.out.println(column);
		System.out.println(choosen);
		int temp = 0;
		for(int i = 0 ; i < column.size() ;i++) {
			if(choosen.contains(column.get(i))) {
				temp++;
			}
		}
		if(temp == column.size()) {
			return -1;
		}
		int rand = r.nextInt(column.size());
		if(choosen.contains(column.get(rand))) {
			return recursive.getFittingRandomNumber(column, choosen);
		}
		else {
			return column.get(rand);
		}
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