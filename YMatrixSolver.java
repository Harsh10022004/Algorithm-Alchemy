// YMatrixSolver is a program that calculates determinant of remaining matrix after eliminating elimination row and column
// If some negative values are assigned to elimination row and column, it will calculate determinant of the complete matrix without eliminating anything.
import java.util.Scanner;
import java.util.ArrayList;
public class YMatrixSolver{
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int inputMatrixSize = sc.nextInt();
        int eliminationRowIndex = sc.nextInt();
        int eliminationColumnIndex = sc.nextInt();
        ArrayList<ArrayList<Integer>> inputMatrix = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i <= inputMatrixSize - 1; i++){
            ArrayList<Integer> inputSubMatrix = new ArrayList<Integer>();
            for(int j = 0; j <= inputMatrixSize - 1; j++){
                inputSubMatrix.add(sc.nextInt());
            }
            inputMatrix.add(inputSubMatrix);
        }
        System.out.println(HelperFunction(inputMatrix, eliminationRowIndex, eliminationColumnIndex));
    }

    static int HelperFunction(ArrayList<ArrayList<Integer>> matrix, int eliminationRow, int eliminationColumn){
        if(matrix.size() == 1){
            return matrix.get(0).get(0);
        }
        if(eliminationRow < 0 && eliminationColumn < 0){
            int summationOfSmallerDeterminants = 0;
            for(int i = 0; i <= matrix.get(0).size() - 1; i++){
                int pivotElement = (i % 2 == 0) ? matrix.get(0).get(i) : (-1 * matrix.get(0).get(i));
                summationOfSmallerDeterminants += pivotElement * HelperFunction(matrix, 0, i);
            }
            return summationOfSmallerDeterminants;
        }
        if(eliminationRow >= 0 && eliminationColumn >= 0){
            ArrayList<ArrayList<Integer>> array = new ArrayList<ArrayList<Integer>>();
            initialiseOurEmptyArray(array, matrix, eliminationRow, eliminationColumn);
            return HelperFunction(array, -5, -5);
        }
        return -9;
    }

    static void initialiseOurEmptyArray(ArrayList<ArrayList<Integer>> array, ArrayList<ArrayList<Integer>> matrix, int eliminationRow, int eliminationColumn){
        for(int i = 0; i <= matrix.size() - 1; i++){
            ArrayList<Integer> subarray = new ArrayList<Integer>();
            for(int j = 0; j <= matrix.get(0).size() - 1; j++){
                if(i != eliminationRow && j != eliminationColumn){
                   subarray.add(matrix.get(i).get(j));
                }
            }
            if(subarray.size() == 0){
                continue;
            }
            array.add(subarray);
        }
    }
    
}
