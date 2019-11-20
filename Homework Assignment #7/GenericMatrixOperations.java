
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
    Number[] valArray1, valArray2, valArray3, valArray4;
    ArrayList<Number> rowResult = new ArrayList<>();
    ArrayList<Number> colResult = new ArrayList<>();
    ArrayList<Number> valResult = new ArrayList<>();
    ArrayList<Integer> array2indices = new ArrayList<>();

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
        int length = 0;
        int height = 0;
        // Determine the number of rows and columns
        if (rowArray1[rowArray1.length - 1] > rowArray2[rowArray2.length - 1]) {
            length = rowArray1[rowArray1.length - 1];
        } else {
            length = rowArray2[rowArray2.length - 1];
        }
        if (colArray1[colArray1.length - 1] > colArray2[colArray2.length - 1]) {
            height = colArray1[colArray1.length - 1];
        } else {
            height = colArray2[colArray2.length - 1];
        }

        // Add matrix values
        for (int c = 0; c < rowArray1.length; c++) {
            boolean same = false;
            // Run through other array looking for match
            for (int i = 0; i < rowArray2.length; i++) {
                if (rowArray1[c] == rowArray2[i] && colArray1[c] == colArray2[i]) {
                    rowResult.add(rowArray1[c]);
                    colResult.add(colArray1[c]);
                    valResult.add(valArray1[c].doubleValue() + valArray2[i].doubleValue());
                    // Store added index so it isn't added again
                    array2indices.add(i);
                    same = true;
                }
            }
            // Add value if there isn't a match
            if (!same) {
                rowResult.add(rowArray1[c]);
                colResult.add(colArray1[c]);
                valResult.add(valArray1[c]);
            }
        }
        // Add values that were skipped
        for (int c = 0; c < rowArray2.length; c++) {
            Integer index = c;
            if (!array2indices.contains(index)) {
                rowResult.add(rowArray2[c]);
                colResult.add(colArray2[c]);
                valResult.add(valArray2[c]);
            }
        }
        // Now that we have IJK, Create Matrix to run as parameter for
        // SparseGenericMatrix
        Number[][] resultant = new Number[height][length];
        // Default matrix to 0
        for (int c = 0; c < height; c++) {
            for (int i = 0; i < length; i++) {
                Integer zero = 0;
                resultant[c][i] = zero;
            }
        }
        for (int c = 0; c < height; c++) {
            for (int i = 0; i < length; i++) {
                Number row = c;
                Number col = i;
                // Make sure they exist before adding anything
                if (colResult.contains(col) && rowResult.contains(row)) {
                    for (int m = 0; m < rowResult.size(); m++) {
                        if (colResult.get(m) == col && rowResult.get(m) == row) {
                            resultant[c][i] = valResult.get(m);
                            break;
                        }
                    }
                }
            }
        }
        // Display Matrix
        for (int c = 0; c < height; c++) {
            System.out.println(" ");
            for (int i = 0; i < length; i++) {
                System.out.print(resultant[c][i] + " ");
            }
        }
        // Clear lists for reuse on other operations
        rowResult.clear();
        colResult.clear();
        valResult.clear();
        // Return in (i,j,k) format
        return new SparseGenericMatrix(resultant);

    }

    /**
     * Subtracts matrices from one another and returns the matrix in (i,j,k) format
     */
    public SparseGenericMatrix subtractMatrices() {
        int length = 0;
        int height = 0;
        // Determine the number of rows and columns
        if (rowArray1[rowArray1.length - 1] > rowArray2[rowArray2.length - 1]) {
            length = rowArray1[rowArray1.length - 1];
        } else {
            length = rowArray2[rowArray2.length - 1];
        }
        if (colArray1[colArray1.length - 1] > colArray2[colArray2.length - 1]) {
            height = colArray1[colArray1.length - 1];
        } else {
            height = colArray2[colArray2.length - 1];
        }

        // Subtract matrix values
        for (int c = 0; c < rowArray1.length; c++) {
            boolean same = false;
            // Run through other array looking for match
            for (int i = 0; i < rowArray2.length; i++) {
                if (rowArray1[c] == rowArray2[i] && colArray1[c] == colArray2[i]) {
                    rowResult.add(rowArray1[c]);
                    colResult.add(colArray1[c]);
                    valResult.add(valArray1[c].doubleValue() - valArray2[i].doubleValue());
                    // Store added index so it isn't added again
                    array2indices.add(i);
                    same = true;
                }
            }
            // Add value if there isn't a match
            if (!same) {
                rowResult.add(rowArray1[c]);
                colResult.add(colArray1[c]);
                valResult.add(valArray1[c]);
            }
        }
        // Add values that were skipped
        for (int c = 0; c < rowArray2.length; c++) {
            Integer index = c;
            if (!array2indices.contains(index)) {
                rowResult.add(rowArray2[c]);
                colResult.add(colArray2[c]);
                valResult.add(valArray2[c]);
            }
        }
        // Now that we have IJK, Create Matrix to run as parameter for
        // SparseGenericMatrix
        Number[][] resultant = new Number[height][length];
        // Default matrix to 0
        for (int c = 0; c < height; c++) {
            for (int i = 0; i < length; i++) {
                Integer zero = 0;
                resultant[c][i] = zero;
            }
        }
        for (int c = 0; c < height; c++) {
            for (int i = 0; i < length; i++) {
                Number row = c;
                Number col = i;
                // Make sure they exist before adding anything
                if (colResult.contains(col) && rowResult.contains(row)) {
                    for (int m = 0; m < rowResult.size(); m++) {
                        if (colResult.get(m) == col && rowResult.get(m) == row) {
                            resultant[c][i] = valResult.get(m);
                            break;
                        }
                    }
                }
            }
        }
        // Display Matrix
        for (int c = 0; c < height; c++) {
            System.out.println(" ");
            for (int i = 0; i < length; i++) {
                System.out.print(resultant[c][i] + " ");
            }
        }
        // Clear lists for reuse on other operations
        rowResult.clear();
        colResult.clear();
        valResult.clear();
        // Return in (i,j,k) format
        return new SparseGenericMatrix(resultant);
    }
}