import java.util.Arrays;

public class matrixAdd {


    public static void main(String[] args){

        int a[][] = {{1, 2, 3}, {4, 4, 4}, {0, -1, 2}};
        int b[][] = {{5, 5, 6}, {0, -1, 2}, {4, 4, 4}};

        //System.out.println(matrixAdd(a, b));

        matrixAdd(a, b);
    }
    public static int[][] matrixAdd(int[][] a, int[][] b) {
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                a[i][j] = a[i][j] + b[i][j];
                System.out.println(a[i][j]);

            }
        }
        return a;
    }

}
