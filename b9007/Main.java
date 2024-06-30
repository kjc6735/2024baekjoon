//package b9007;
//
//import java.io.BufferedReader;
//import java.io.FileInputStream;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.PriorityQueue;
//import java.util.StringTokenizer;
//
//public class Main {
//    public static void main(String[] args)throws Exception {
//        System.setIn(new FileInputStream("b9007/input.txt"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int t = Integer.parseInt(br.readLine());
//        StringBuilder sb = new StringBuilder();
//        StringTokenizer st;
//        for(int tc = 1; tc <= t; tc ++){
//            st = new StringTokenizer(br.readLine());
//            int k = Integer.parseInt(st.nextToken());
//            int n = Integer.parseInt(st.nextToken());
//            int arr[][] = new int [4][n];
//            for(int i = 0; i < 4 ; i++){
//                st = new StringTokenizer(br.readLine());
//                for(int j = 0; j < n; j++) {
//                    arr[i][j] = Integer.parseInt(st.nextToken());
//                }
//            }
//            int min = Integer.MAX_VALUE;
//            for(int a =0; a < n; a++){
//                    for(int b = 0; b<  n; b++){
//                        for(int c = 0; c < n ; c++) {
//                            for(int d = 0 ;d < n; d++) {
//                                int r = arr[ai][a] + arr[bi][b] + arr[ci][c] + arr[di][d] - k;
//
//                                if(Math.abs(min) > Math.abs(r)){
//                                    min = r;
//                                    System.out.println(r);
//                                }else if(Math.abs(min) ==  Math.abs(r)){
//                                    min = min > r ? r : min;
//                                    System.out.println(r);
//                                }
//                            }
//                        }
//                    }
//                }
//            System.out.println(min + k);
//        }
//
//    }
//}
