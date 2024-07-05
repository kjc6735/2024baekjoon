package b11899;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("b11899/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        Stack<Character> stack = new Stack<>();
        int cnt = 0;
        for(int i = 0; i < str.length() ; i++){
            if(str.charAt(i) == '('){
                stack.add('(');
            }else{
                if(!stack.isEmpty()){
                    stack.pop();
                }else cnt ++;
            }
        }

        System.out.println(cnt + stack.size());
    }
}
