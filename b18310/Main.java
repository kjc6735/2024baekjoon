package b18310;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args)throws Exception {
        System.setIn(new FileInputStream("b18310/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int arr[] = new int[N];
        String str[] = br.readLine().split(" ");

        for(int i = 0; i < N ; i++) arr[i] = Integer.parseInt(str[i]);

        Arrays.sort(arr);
        System.out.println(arr[(N-1)/2]);
    }
}
