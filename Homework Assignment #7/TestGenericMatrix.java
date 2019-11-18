
/*
 * CSE 17 Fall 2019
 * @author Asher Hamrick
 * Homework Assignment #7
 * Program: TestGenericMatrix
 */
import java.util.*;

public class TestGenericMatrix {
    /**
     * Tests the SparseGenericMatrix class and its operations class
     * 
     * @param args arguments
     */
    public static void main(String[] args) {
        // Add and subtract 2 integer matrices
        Integer[][] mat1 = { { 0, 1, 0, 0, 4 }, { 1, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0 }, { 4, 0, 0, 2, 0 },
                { 0, 0, 3, 7, 0 } };
        SparseGenericMatrix<Integer> matrix1 = new SparseGenericMatrix<>(mat1);

        Integer[][] mat2 = { { 0, 2, 0, 1, 0 }, { 0, 1, 0, 0, 0 }, { 0, 0, 3, 0, 0 }, { 0, 0, 1, 1, 0 },
                { 1, 0, 0, 0, 0 } };
        SparseGenericMatrix<Integer> matrix2 = new SparseGenericMatrix<>(mat2);

        GenericMatrixOperations ops1 = new GenericMatrixOperations(matrix1, matrix2);
        SparseGenericMatrix<Integer> matrix3;
        if (mat1.length != mat2.length || mat1[0].length != mat2[0].length) {
            System.out.println("Matrices must be of equal dimensions.");
        } else {
            // Display addition and subtraction of 2 integer matrices
            System.out.println("Two integer matrices added: \n");
            matrix3 = ops1.addMatrices();
            System.out.println("\nTwo integer matrices subtracted: \n");
            matrix3 = ops1.subtractMatrices();
        }

        // Add and subtract 2 double matrices
        Double[][] mat3 = { { 0.0, 0.0, 1.0, 2.6, 0.0 }, { 0.0, 1.0, 1.9, 0.0, 0.0 }, { 3.0, 0.0, 1.0, 0.0, 4.0 },
                { 0.0, 0.0, 2.8, 0.0, 0.0 }, { 0.0, 2.0, 0.0, 0.0, 6.7 } };
        SparseGenericMatrix<Double> matrix4 = new SparseGenericMatrix<>(mat3);

        Double[][] mat4 = { { 0.0, 2.0, 1.0, 0.0, 0.0 }, { 1.0, 0.0, 0.0, 3.4, 0.0 }, { 1.0, 0.0, 3.9, 0.0, 0.0 },
                { 0.0, 0.0, 1.2, 0.0, 0.0 }, { 0.0, 1.0, 0.0, 1.3, 0.0 } };
        SparseGenericMatrix<Double> matrix5 = new SparseGenericMatrix<>(mat4);

        GenericMatrixOperations ops2 = new GenericMatrixOperations(matrix4, matrix5);
        SparseGenericMatrix<Double> matrix6;
        if (mat1.length != mat2.length || mat1[0].length != mat2[0].length) {
            System.out.println("Matrices must be of equal dimensions.");
        } else {
            // Display addition and subtraction of 2 double matrices
            System.out.println("\nTwo double matrices added: \n");
            matrix6 = ops2.addMatrices();
            System.out.println("\nTwo double matrices subtracted: \n");
            matrix6 = ops2.subtractMatrices();
        }

        // Add and subtract an integer and a double matrix
        // This works because when adding the generic types, the integer is able to be
        // cast as a double. Therefore the values end up being the double values of
        // addition and subtractions if the integer values were just doubles with a .0
        // on the end
        Integer[][] mat5 = { { 0, 0, 1, 2, 0 }, { 0, 1, 1, 0, 0 }, { 3, 0, 1, 0, 4 }, { 0, 0, 2, 0, 0 },
                { 0, 2, 0, 0, 6 } };
        SparseGenericMatrix<Integer> matrix7 = new SparseGenericMatrix<>(mat5);

        Double[][] mat6 = { { 0.0, 2.0, 1.0, 0.0, 0.0 }, { 1.0, 0.0, 0.0, 3.4, 0.0 }, { 1.0, 0.0, 3.9, 0.0, 0.0 },
                { 0.0, 0.0, 1.2, 0.0, 0.0 }, { 0.0, 1.0, 0.0, 1.3, 0.0 } };
        SparseGenericMatrix<Double> matrix8 = new SparseGenericMatrix<>(mat6);

        GenericMatrixOperations ops3 = new GenericMatrixOperations(matrix7, matrix8);
        SparseGenericMatrix<Double> matrix9;
        if (mat1.length != mat2.length || mat1[0].length != mat2[0].length) {
            System.out.println("Matrices must be of equal dimensions.");
        } else {
            // Display addition and subtraction of an integer and a double matrix
            System.out.println("\nTwo double matrices added: \n");
            matrix9 = ops3.addMatrices();
            System.out.println("\nTwo double matrices subtracted: \n");
            matrix9 = ops3.subtractMatrices();
        }
    }
}