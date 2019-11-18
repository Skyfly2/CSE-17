
/*
 * CSE 17 Fall 2019
 * @author Asher Hamrick
 * Homework Assignment #7
 * Program: GenericMatrixOperations
 */
import java.util.*;

public class GenericMatrixOperations {
    SparseGenericMatrix matrix1, matrix2;
    int[] rowArray1, colArray1, rowArray2, colArray2;
    Number[] valArray1, valArray2;

    /**
     * Creates a new instance of GenericMatrixOperations
     * 
     * @param matrix1 first matrix in operations
     * @param matrix  2 second matrix in operations
     */
    public GenericMatrixOperations(SparseGenericMatrix matrix1, SparseGenericMatrix matrix2) {
        // Set instance values
        this.valArray1 = matrix1.getValues();
        this.valArray2 = matrix2.getValues();
        this.rowArray1 = matrix1.getRowArray();
        this.rowArray2 = matrix2.getRowArray();
        this.colArray1 = matrix1.getColArray();
        this.colArray2 = matrix2.getColArray();

    }

    /**
     * Adds matrices together and returns the matrix in (i,j,k) format
     */
    public SparseGenericMatrix addMatrices() {
        // Find length of rows and cols
        int l1 = rowArray1[rowArray1.length - 1];
        int l2 = rowArray2[rowArray2.length - 1];
        int length = 0;
        if (l1 > l2) {
            length = rowArray1[rowArray1.length - 1] + 1;
        } else {
            length = rowArray2[rowArray2.length - 1] + 1;
        }
        // Create matrices to add values
        Number[][] result1 = new Number[length][length];
        Number[][] result2 = new Number[length][length];
        Number[][] result = new Number[length][length];
        // Default matrices to 0
        for (int c = 0; c < result1.length; c++) {
            for (int i = 0; i < result1[0].length; i++) {
                result1[c][i] = 0;
                result2[c][i] = 0;
            }
        }
        // Set matrices with values from (i,j,k)
        for (int c = 0; c < rowArray1.length; c++) {
            result1[rowArray1[c]][colArray1[c]] = valArray1[c];
        }
        for (int c = 0; c < rowArray2.length; c++) {
            result2[rowArray2[c]][colArray2[c]] = valArray2[c];
        }
        // Add matrices and display matrix
        for (int c = 0; c < length; c++) {
            System.out.println(" ");
            for (int i = 0; i < length; i++) {
                result[c][i] = result1[c][i].doubleValue() + result2[c][i].doubleValue();
                System.out.print(result[c][i] + " ");
            }
        }
        // Return in (i,j,k) format
        return new SparseGenericMatrix(result);
    }

    /**
     * Subtracts matrices from one another and returns the matrix in (i,j,k) format
     */
    public SparseGenericMatrix subtractMatrices() {
        // Find length of rows and cols
        int l1 = rowArray1[rowArray1.length - 1];
        int l2 = rowArray2[rowArray2.length - 1];
        int length = 0;
        if (l1 > l2) {
            length = rowArray1[rowArray1.length - 1] + 1;
        } else {
            length = rowArray2[rowArray2.length - 1] + 1;
        }
        // Create matrices to add values of generic matrices
        Number[][] result1 = new Number[length][length];
        Number[][] result2 = new Number[length][length];
        Number[][] result = new Number[length][length];
        // Default matrices to 0
        for (int c = 0; c < result1.length; c++) {
            for (int i = 0; i < result1[0].length; i++) {
                result1[c][i] = 0;
                result2[c][i] = 0;
            }
        }
        // Set matrices with values from (i,j,k)
        for (int c = 0; c < rowArray1.length; c++) {
            result1[rowArray1[c]][colArray1[c]] = valArray1[c];
        }
        for (int c = 0; c < rowArray2.length; c++) {
            result2[rowArray2[c]][colArray2[c]] = valArray2[c];
        }
        // Subtract matrices and display matrix
        for (int c = 0; c < length; c++) {
            System.out.println(" ");
            for (int i = 0; i < length; i++) {
                result[c][i] = result1[c][i].doubleValue() - result2[c][i].doubleValue();
                System.out.print(result[c][i] + " ");
            }
        }
        // Return in (i,j,k) format
        return new SparseGenericMatrix(result);
    }
}