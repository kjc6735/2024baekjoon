//package b19949;
//
//import java.io.BufferedReader;
//import java.io.FileInputStream;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Main {
//    static int arr[] = new int [10];
//    static int cnt = 0;
//    static int[] tmp = new int[10];
//    public static void main(String[] args)throws Exception {
//        System.setIn(new FileInputStream("b19949/input.txt"));
//        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        for(int i = 0; i < 10 ; i++) arr[i] = Integer.parseInt(st.nextToken());
//        tmp = new int[10];
//        for(int i = 1; i <= 5; i++) {
//            tmp[0] = i;
////            fn(1,  arr[0] == tmp[0] ? 1 : 0);
//        }
//    }
//
//    static void  fn(int depth,int cnt,  int score){
//        if(depth == 10) {
//            if(score >= 5) cnt ++;
//            return ;
//        }
//
//        for(int i = 1; i <= 5; i++){
//            tmp[i] = i;
//            fn(depth + 1,tmp[i] == i ? cnt + 1 , 0 ,  score);
//            int
//        }
//    }
//}
