package b5676;

import java.beans.PropertyEditorSupport;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static int N,K, k;
    static int arr[] = new int[1_000_000];

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("b5676/input.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));




        StringBuilder sb = new StringBuilder();

        String str;
        while ((str = br.readLine()) != null) {
            String strArr[] = str.split(" ");
            N = Integer.parseInt(strArr[0]);
            K = Integer.parseInt(strArr[1]);
            System.out.println(N + " " +K);
            k = 0;
            while (Math.pow(2,++k) < N){}
            Arrays.fill(arr, 1);
            int start = (int) Math.pow(2, k);
            int end = start * 2;
            strArr = br.readLine().split(" ");
            for(int i = 0; i < N  ;i++) {
                arr[i + start] = Integer.parseInt(strArr[i]);
            }
            for(int i = end-1; i >= 1; i-=2) {
                arr[i/2] = arr[i] * arr[i-1] > 0 ? 1 :  arr[i] * arr[i-1] == 0 ? 0 : -1;
            }

            for(int i = 0;i  < K; i++) {
                StringTokenizer st = new  StringTokenizer(br.readLine());
                String a = st.nextToken();
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                if(a.equals("C")){
                    change(start + b -1, c );
                }else {
                    int print = print(start + b - 1 , start + c -1);
                    sb.append(print == 1 ? '+' : print == 0 ? '0' : '-');
                }
            }

            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    private static void change(int i, int c) {
        arr[i] = c > 0 ? 1 : c == 0 ? 0 : -1;
        while (i >= 1) {
            if(i%2 == 1) i--;
            arr[i/2] = arr[i] * arr[i + 1];
            i/=2;
        }
    }
    private static int print(int a , int b){
        int result = 1;
        while (a <= b) {
            if(a % 2 == 1) result*=arr[a++];
            if(b % 2 == 0) result*=arr[b--];
            a/=2;
            b/=2;
        }
        return result;
    }
}
