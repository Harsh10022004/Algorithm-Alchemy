//Input Format:
//Suppose we have 3 equations in 3 variables which are as follows:
// 3x + 2y + z = 1
// 2x + 3y + 4z = 2
// 4x + 5y + 6z = 3
//The input format will be as follows: (First enter the size and than the matrix)
//3
//3 2 1 1
//2 3 4 2
//4 5 6 3
//The output will be received in array format corresponding to following input:
//Currently, It only works for system of equations having unique solutuion of x,y and z
//No solution and Infinite solution cases are not handled explicitely in this code

import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;
public class SolvingEquationsUsingGaussJordan {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of equations: ");
        int NumberOfRows = sc.nextInt();
        int NumberOfColumns = NumberOfRows + 1;
        System.out.println("Enter the coeefficients of the equations in the form of a matrix");
        ArrayList<ArrayList<Double>> SystemOfLinearEquations = new ArrayList<ArrayList<Double>>();
        for(int i = 0; i <= NumberOfRows - 1; i++){
            ArrayList<Double> subarray = new ArrayList<Double>();
            for(int j = 0; j <= NumberOfColumns - 1; j++){
                subarray.add(sc.nextDouble());
            }
            SystemOfLinearEquations.add(subarray);
        }
        HelperFunction(SystemOfLinearEquations, NumberOfColumns - 2 , 0);
        System.out.println(SystemOfLinearEquations);
    }

    static void HelperFunction(ArrayList<ArrayList<Double>> AugumentedEquationMatrix, int ColumnNumber, int RowNumber){
        if(ColumnNumber < 0){
            return;
        }
        if(RowNumber > AugumentedEquationMatrix.size() - 1){
            HelperFunction(AugumentedEquationMatrix, ColumnNumber - 1, 0);
            double NumberAsDivisor = AugumentedEquationMatrix.get(ColumnNumber).get(ColumnNumber);
            for(int i = 0; i <= AugumentedEquationMatrix.size(); i++){
                AugumentedEquationMatrix.get(ColumnNumber).set(i, (AugumentedEquationMatrix.get(ColumnNumber).get(i) / NumberAsDivisor));
            }
            return;
        }
        HelperFunction(AugumentedEquationMatrix, ColumnNumber, RowNumber + 1);
        if(ColumnNumber == RowNumber){
            return;
        }
        if(ColumnNumber != RowNumber){
            double NumberToBeMultiplied = AugumentedEquationMatrix.get(RowNumber).get(ColumnNumber);
            for(int i = 0; i <= AugumentedEquationMatrix.size(); i++){
                AugumentedEquationMatrix.get(RowNumber).set(i, (AugumentedEquationMatrix.get(RowNumber).get(i) - (NumberToBeMultiplied * AugumentedEquationMatrix.get(ColumnNumber).get(i))));
            }
            return;
        }
    }
}
