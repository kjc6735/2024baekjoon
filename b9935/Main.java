package b9935;
import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br;
    static Deque<Character> deque = new LinkedList<>();
    static String str1;
    static String str2;
    public static void main(String[] args)throws Exception {
        System.setIn(new FileInputStream("b9935/input.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));

        str1 = br.readLine();
        str2 = br.readLine();
        int str2Len = str2.length()-1;
        for(int i = 0; i < str1.length(); i++) {
            deque.addLast(str1.charAt(i));
            if (str1.charAt(i) == str2.charAt(str2Len)) check();
        }

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) sb.append(deque.pollFirst());
        System.out.println(sb.toString().length() == 0 ? "FRULA" : sb.toString());
    }

    private static void check(){
        Stack<Character> stack = new Stack<>();
        for(int i=str2.length()-1 ; i >=0; i--){
            char curr = deque.pollLast();
            stack.add(curr);
            if(str2.charAt(i) != curr) {
                while (!stack.isEmpty()) deque.addLast(stack.pop());
                return ;
            }
        }
    }
}
