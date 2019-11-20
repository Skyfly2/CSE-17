
/*
 * CSE 17 Fall 2019
 * @author Asher Hamrick
 * Homework Assignment #7
 * Program: SparseGenericMatrix
 */
import java.util.*;

public class SparseGenericMatrix<E extends Number> {
    private int[] rowArray;
    private int[] colArray;
    private Number[] valArray;

    /**
     * Creates new SparseGenericMatrix instance with generic values
     * 
     * @param matrix the standard format matrix
     */
    public SparseGenericMatrix(E[][] matrix) {
        int count = 0;
        // Find number of values
        for (int c = 0; c < matrix.length; c++) {
            for (int i = 0; i < matrix[0].length; i++) {
                if ((Number) matrix[c][i] != (Number) 0) {
                    count++;
                }
            }
        }
        // Set sizes
        rowArray = new int[count];
        colArray = new int[count];
        // Since generic value extends number, we can set the array values to numbers
        valArray = new Number[count];
        count = 0;
        // Set (i,j,k) values
        for (int c = 0; c < matrix.length; c++) {
            for (int i = 0; i < matrix[0].length; i++) {
                if ((Number) matrix[c][i] != (Number) 0) {
                    rowArray[count] = c;
                    colArray[count] = i;
                    valArray[count] = matrix[c][i];
                    count++;
                }
            }
        }
    }

    /**
     * Provides the row array for a particular SparseGenericMatrix
     * 
     * @return rowArray the rowArray
     */
    public int[] getRowArray() {
        return rowArray;
    }

    /**
     * Provides the column array for a particular SparseGenericMatrix
     * 
     * @return colArray the column Array
     */
    public int[] getColArray() {
        return colArray;
    }

    /**
     * Provides the values for a particular SparseGenericMatrix
     * 
     * @return valArray the values
     */
    public Number[] getValues() {
        return valArray;
    }
}