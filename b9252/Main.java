package b9252;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static int cnt;
    static int arr[][];
    static String strA, strB;
    static int indexTable[][];
    static Stack<Character> stack = new Stack<>();
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b9252/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        strA = " " + br.readLine();
        strB = " " + br.readLine();
        arr = new int[strA.length()][strB.length()];
        indexTable = new int[strA.length()][strB.length()];
        StringBuilder strSB = new StringBuilder();
        for(int i =1 ; i<strA.length(); i++){
            for(int k = 1; k < strB.length(); k++){
                if(strA.charAt(i) == strB.charAt(k)){
                    arr[i][k] = arr[i-1][k-1] + 1;
                    indexTable[i][k] = 1;
                }else {
                    arr[i][k] = Math.max(arr[i][k -1], arr[i-1][k]);
                    indexTable[i][k] = arr[i][k-1] < arr[i-1][k] ? 3 : 2;
                }
            }
        }

        int aIndex = strA.length()-1;
        int bIndex = strB.length()- 1;
        while (!(aIndex == 0 || bIndex == 0)){
            if(indexTable[aIndex][bIndex] == 1){
                stack.push(strA.charAt(aIndex));
                aIndex--;
                bIndex--;
            }else if(indexTable[aIndex][bIndex] == 2){
                bIndex--;
            }else{
                aIndex--;
            }
        }


        StringBuilder sb = new StringBuilder();
        sb.append(arr[strA.length()-1][strB.length() -1]).append("\n");
        boolean check = stack.isEmpty();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }

        System.out.println(sb.toString() );
        System.out.print(check ? "" : "\n");
    }

}
