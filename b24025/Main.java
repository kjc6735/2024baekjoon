package b24025;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static BufferedReader br;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("b24025/input.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] arr = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        stack.add(arr[0]);
        int idx = 1;
        while(!stack.empty()){
            if(isOper(arr[idx]));
        }

    }
    static boolean isOper(char c){
        return c =='+' || c == '*' || c == '/' || c == '-';
    }
}
