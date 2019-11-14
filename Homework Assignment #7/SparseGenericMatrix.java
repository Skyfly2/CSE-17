import java.util.*;

public class SparseGenericMatix<E extends Number<E>> {
    private E[] rowArray;
    private E[] colArray;
    private E[] valArray;

    public SparseGenericMatrix(E[][] matrix){
        int count = 0;
        for(int c = 0; c < matrix.length; c++){
            for(int i = 0; i < matrix[0].length; i++){
                if(matrix[c][i] != 0){
                    count++;
                }
            }
        }
        rowArray = new E[count];
        colArray = new E[count];
        valArray = new E[count];
        count = 0;
        for(int c = 0; c < matrix.length; c++){
            for(int i = 0; i < matrix[0].length; i++){
                if(matrix[c][i] != 0){
                    rowArray[count] = c;
                    colArray[count] = i;
                    valArray[count] = matrix[c][i];
                    count++;
                }
            }
        }
    }

    public E[] getRowArray() {
        return rowArray;
    }

    public E[] getColArray() {
        return colArray;
    }

    public E[] getValArray() {
        return valArray;
    }
}