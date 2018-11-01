package arrays;

public class RotateMatrix {
	
	/**
	 * Rotating matrix by 90 degrees to right
	 * top->right
	 * right->bottom
	 * bottom->left
	 * left->top
	 * We can do this row by row, but we need O(N) unnecessary memory
	 * Implement it index by index
	 * Starting outerwards and then moving inwards
	 * Complexity is O(n^2)
	 * @param matrix
	 * @return
	 */
	private static boolean rotate(int[][] matrix){
		if(matrix.length==0 || matrix.length != matrix[0].length){
			return false;
		}
		int n= matrix.length;
		for(int layer=0;layer<n/2;layer++){
			int first=layer;
			int last=n-1-layer;
			for(int i=first;i<last;i++){
				int offset= i-first;
				int top= matrix[first][i];
				matrix[first][i]= matrix[last-offset][first];
				matrix[last-offset][first]=matrix[last][last-offset];
				matrix[last][last-offset]=matrix[i][last];
				matrix[i][last]=top;
			}
		}
		return true;
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
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16}
		};
		System.out.println("Matrix before rotating ");
		printMatrix(matrix);
		rotate(matrix);
		System.out.println("Matrix after rotating");
		printMatrix(matrix);
	}

}
