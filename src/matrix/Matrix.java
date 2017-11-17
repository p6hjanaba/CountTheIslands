package matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Matrix {
	
	static int rows;
	static int columns;
	static Random random = new Random();
	
	// Main function that asks for input, generates the matrix and checks the neighbours
	public static void main(String[] args) throws IOException {
		System.out.println("Reminder: Please enter values bigger than 1!");
		rows = question(1);
		columns = question(2);
		// If any value is 1 or below, gives error
		if (rows <= 1 || columns <= 1) {
			System.out.println("Please enter values that are bigger than 1");
		} else {
		System.out.println("number of islands: "+ Matrix.checkMatrix(generateMatrix(rows, columns)));
		}
	}
	
	// Universal question function to get both rows and columns number
	private static int question(int s){
		String word = null;
		if(s == 1){
			word = "rows";
		}else if (s == 2) {
			word = "columns";
		}
		System.out.println("How many "+ word +"?");
		BufferedReader m = new BufferedReader(new InputStreamReader(System.in));
		String temp1 = null;
		try {
			temp1 = m.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int count = Integer.parseInt(temp1);
		
		// Returns the number that was input by user
		return count;
	}
	
	public static int[][] generateMatrix(int m, int n) {
		// Creating 2D array
		int[][] matrix = new int[m][n];
		
		System.out.println("Generating matrix with given dimensions...");
	    
		// Goes through every row
	    for (int i = 0; i < matrix.length; i++) {
	    	// Goes through every column
	        for (int j = 0; j < matrix[i].length; j++) {
	        	// Generates random float 0 to 1, if below 0.5 then 1 will be put to array
	            if (random.nextDouble() < 0.5) {
	                matrix[i][j] = 1;
	                System.out.print(matrix[i][j] + " ");
	            } else {
	            	// else if value is over 0.5 then 0 will be put to array
	                matrix[i][j] = 0;
	                System.out.print(matrix[i][j] + " ");
	            }
	        }
	        System.out.println("");
	    }
	    return matrix;
	}
	
	// General function that checks the Matrix and calls out the function to check neighbours
	static int checkMatrix(int M[][]) {
		// New array to keep in mind visited positions
		boolean visited[][] = new boolean[rows][columns];

		// Number of islands counted
		int answer = 0;

		// Count islands, first for loop goes through rows
		for (int i = 0; i < rows; ++i) {
			// Goes through columns
			for (int j = 0; j < columns; ++j) {
				// if position value is 1 and not visited runs function checkNeighbour
				if (M[i][j]==1 && !visited[i][j]){
					checkNeighbour(M, i, j, visited);
					// 
					++answer;
				}
			}
		}
		return answer;
	}
	
	// Separate function to check which kind of neighbour does each position have, groups them
	public static void checkNeighbour(int M[][], int rows, int cols, boolean visited[][]) {
        // Arrays with neighbour positions. left=(-1;0),up=(0;1),down=(0;-1),right=(1,0)
        int rowNbr[] = new int[] {-1, 0, 0, 1};
        int colNbr[] = new int[] {0, 1, -1, 0};
 
        // Marks position as visited
        visited[rows][cols] = true;
 
        // Checking all neighbours where k is number of neighbours (up to 4)
        for (int k = 0; k < 4; ++k) {
        	// Checks if it has been visited
            if (safePos(M, rows + rowNbr[k], cols + colNbr[k], visited)) {
            	// If position is safe (true - not visited and number 1), checks neighbours
                checkNeighbour(M, rows + rowNbr[k], cols + colNbr[k], visited);
            }
        }
	}
	
	// Helping function that checks if given position in array has been visited or not
	// returns only values that are not visited and number 1 (true or false)
    static boolean safePos(int M[][], int row, int col, boolean visited[][]) {
        return (row >= 0) && (row < rows) &&
               (col >= 0) && (col < columns) &&
               (M[row][col]==1 && !visited[row][col]);
    }
}