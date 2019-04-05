public class MatrixOps
{
	public static double[][] multiply(double[][] matrix1, double[][] matrix2)
	{

		int m1rows = matrix1.length;
		int m1cols = matrix1[0].length;
		int m2rows = matrix2.length;
		int m2cols = matrix2[0].length;

		if (m1cols != m2rows){
			return null;
		}
		
		double[][] product = new double[m1rows][m2cols];
		for (int i=0; i<m1rows; i++)
			for (int j=0; j<m2cols; j++)
				for (int k=0; k<m1cols; k++)
					product[i][j] += matrix1[i][k] * matrix2[k][j];
		return product;
	}
}

