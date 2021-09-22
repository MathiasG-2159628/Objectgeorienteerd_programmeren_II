public class Matrix {


    public void MultiplyMatrices(int[][] matrix1, int[][] matrix2){

        int[][] multipliedMatrix = new int[3][3];

        for(int i = 0; i < matrix1.length; i++){
            for(int j = 0; j < matrix1[0].length; j++) {
                multipliedMatrix[i][j] = matrix1[i][j] * matrix2[i][j];
            }
        }

        printMatrix(multipliedMatrix);
    }

    public void SumMatrices(int[][] matrix1, int[][] matrix2){

        int[][] multipliedMatrix = new int[3][3];

        for(int i = 0; i < matrix1.length; i++){
            for(int j = 0; j < matrix1[0].length; j++) {
                multipliedMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        printMatrix(multipliedMatrix);
    }

    private void printMatrix(int[][] matrix){
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[0].length; j++)
            {
                System.out.format("%d \t", matrix[i][j]);
            }
            System.out.println("\n");
        }
    }
}

class MatrixApp{
    public static void main(String[] args) {
        Matrix matrix = new Matrix();
        int[][] matrix1 = {{1,2,3}, {4,5,6}, {7,8,9}};
        int[][] matrix2 = {{1,2,3}, {4,5,6}, {7,8,9}};

        matrix.SumMatrices(matrix1, matrix2);
        System.out.println("\n");
        matrix.MultiplyMatrices(matrix1, matrix2);
    }
}