package arrays;

public class ZeroMatrix {
	
	/**
	 * We just store the rows and columns
	 * on which there is a zero somewhere
	 * extra space is O(N+M)
	 * time complexity is O(N*M)
	 * @param matrix
	 */
	private static void setZeros(int[][] matrix){
		boolean rows[]= new boolean[matrix.length];
		boolean columns[]= new boolean[matrix[0].length];
		
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				if(matrix[i][j]==0){
					rows[i]=true;
					columns[j]=true;
				}
			}
		}
		
		for(int i=0;i<rows.length;i++){
			if(rows[i]){
				nullifyRow(matrix,i);
			}
		}
		
		for(int i=0;i<columns.length;i++){
			if(columns[i]){
				nullifyColumn(matrix,i);
			}
		}
	}

	private static void nullifyColumn(int[][] matrix, int i) {
		for(int row=0;row<matrix.length;row++){
			matrix[row][i]=0;
		}
	}

	private static void nullifyRow(int[][] matrix, int i) {
		for(int column=0;column<matrix[0].length;column++){
			matrix[i][column]=0;
		}
	}
	
	/**
	 * We can save space O(1)
	 * by using first row and first column
	 * as replacement to boolean arrays
	 * Doesn't cover all the test cases
	 * @param matrix
	 */
	private static void zeroMatrix(int[][] matrix){
		boolean rowHasZero=false;
		boolean columnHasZero=false;
		
		for(int i=0;i<matrix[0].length;i++){
			if(matrix[0][i]==0){
				rowHasZero=true;
				break;
			}
		}
		
		for(int i=0;i<matrix.length;i++){
			if(matrix[i][0]==0){
				columnHasZero=true;
				break;
			}
		}
		
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				if(matrix[i][j]==0){
					matrix[i][0]=0;
					matrix[0][j]=0;
				}
			}
		}
		
		for(int i=0;i<matrix[0].length;i++){
			if(matrix[0][i]==0){
				nullifyColumn(matrix, i);
			}
		}
		
		for(int i=0;i<matrix.length;i++){
			if(matrix[i][0]==0){
				nullifyRow(matrix, i);
			}
		}
		if(rowHasZero){
			nullifyRow(matrix, 0);
		}
		if(columnHasZero){
			nullifyColumn(matrix, 0);
		}
	}
	
	private static void printMatrix(int[][]matrix){
		int n= matrix.length;
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] matrix={
				{0,2,3,4},
				{5,6,7,8},
				{9,0,11,12},
				{13,14,15,16}
		};
		System.out.println("Matrix before nullifying ");
		printMatrix(matrix);
		setZeros(matrix);
		System.out.println("Zero Matrix");
		printMatrix(matrix);
		
	}
}
