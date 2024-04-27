//package b13975;
//
//import java.io.BufferedReader;
//import java.io.FileInputStream;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.PriorityQueue;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//public class Main {
//    static long arr[] = new long[1_000_000];
//
//    public static void main(String[] args) throws Exception{
//        System.setIn(new FileInputStream("b13975/input.txt"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int test_case = Integer.parseInt(br.readLine());
//        StringBuilder sb = new StringBuilder();
//        for(int tc = 1; tc <= test_case; tc ++){
//            int N = Integer.parseInt(br.readLine());
//            StringTokenizer st = new StringTokenizer(br.readLine());
//
//            for(int i = 0; i < N; i++) arr[i] = Long.parseLong(st.nextToken());
//            long sum = 0;
//            Arrays.sort(arr);
//            while (N > 1){
//                if(N%2 == )
//                for(int i = 0; i < N; i+=2){
//                        arr[i/2] = arr[i] + arr[i+1];
//                }
//
//            }
//            sb.append(sum).append("\n");
//        }
//        System.out.println(sb.toString());
//    }
//}
