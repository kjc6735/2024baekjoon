package b2752;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int arr[] = new int[3];
        String str[] = br.readLine().split(" ");
        for(int i = 0; i < 3;i++){
            arr[i] =Integer.parseInt(str[i]);
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 3; i++) sb.append(arr[i]).append(" ");
        System.out.println(sb.toString());
    }
}
