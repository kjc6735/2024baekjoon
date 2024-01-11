//package b11053;
//
//import java.io.BufferedReader;
//import java.io.FileInputStream;
//import java.io.InputStreamReader;
//
//public class Main {
//    static BufferedReader br;
//    static int dp[][][];
//    public static void main(String[] args)throws Exception {
//        System.setIn(new FileInputStream("b11053/input.txt"));
//        br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        int arr[] = new int[n+1];
//        String str[] = br.readLine().split(" ");
//        for(int i =0; i < n; i++) arr[i] = Integer.parseInt(str[i]);
//        print(n+1);
//        dp= new int[n+1][n+1][2];
//        for(int i = 1; i < n ; i++){
//            if(arr[i-1] < arr[i]){
//                dp[0][i][0] = dp[i][0][0] =  arr[i];
//                dp[0][i][1] = dp[0][i][1] = dp[0][i -1][1] + 1;
//            }else {
//                dp[0][i][0] = dp[i][0][0] = dp[i-1][0][0];
//                dp[0][i][1] = dp[0][i][1] = dp[i-1][0][1];
//            }
//        }
//
//
//        for(int i = 0 ; i < n ; i++){
//            for(int k =i+1; k < n ;k++){
//                if(arr[i] > arr[k]){
//                    dp[i+1][k+1][0] = arr[i];
//                    dp[i+1][k+1][1] = dp[i][k][1] + 1;
//                    dp[k+1][i+1][0] = arr[i];
//                    dp[k+1][i+1][1] = dp[i][k][1] + 1;
//                }else {
//                    dp[i+1][k+1][0] = dp[i][k-1][0];
//                    dp[i+1][k+1][1] = dp[i][k][1];
//                }
//            }
//        }
//        System.out.println(dp[n][n][0]);
//    }
//
//    static void print(int n){
//        for(int i =0 ; i < n ; i++){
//            for(int k = 0; k < n ; k++){
//                System.out.print(dp[i][k][0] + " ");
//            }
//            System.out.println();
//        }
//    }
//}
