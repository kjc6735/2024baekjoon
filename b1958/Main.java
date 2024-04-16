//package b1958;
//
//import java.io.BufferedReader;
//import java.io.FileInputStream;
//import java.io.InputStreamReader;
//
//public class Main {
//    static int indexTable[][][] = new int[3][101][101];
//    static int lcsTable[][][] = new int[3][101][101];
//    public static void main(String[] args) throws Exception{
//        System.setIn(new FileInputStream("b1958/input.txt"));
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] strArr = new String[3];
//        for(int i = 0; i < 3; i++) strArr[i] = " " + br.readLine();
//
//        for(int i = 0 ;i < 2; i++){
//            for(int a = 0; a < strArr[i].length(); a++){
//                for(int b = 0; b < strArr[i+1].length(); b++){
//                    if(strArr[i].charAt(a) == strArr[i+1].charAt(b)){
//                        lcsTable[i][a][b] = lcsTable[i][a-1][b-1] + 1;
//                        indexTable[i][`][]
//                    }else if(){
//
//                    }else {
//
//                    }
//                }
//            }
//        }
//
//
//
//    }
//}
