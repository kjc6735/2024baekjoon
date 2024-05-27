package b16943;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char[] A;
    static int[] intA;
    static char[] B;
    static int[] intB;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("b16943/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = br.readLine().split(" ");
        A = str[0].toCharArray();
        intA = new int[A.length];
        for(int i = 0; i < A.length; i++) intA[i] = ( A[i] - '0');

        fn(0);

    }
    static void fn(int cnt ){

    }
}
