package b1039;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("b1039/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        char s[] = str[0].toCharArray();
        int k = Integer.parseInt(str[1]);
        Set<String> set = new HashSet<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(clone(s), k));
        int max =0;
        while (!queue.isEmpty()){
            Node curr = queue.poll();
            if(curr.cnt == 0) {
                max = Math.max(Integer.parseInt(String.valueOf(curr.str)), max);
                continue;
            }
            for(int i = 0; i <curr.str.length-1; i++){
                for(int a = i+1; a <curr.str.length; a++) {
                    swap(curr.str,i,a);
                    String tmpStr = String.valueOf(curr.str);
                    String tmpStr2 = String.valueOf(Integer.parseInt(tmpStr));
                    if(tmpStr.length() != tmpStr2.length()) {
                        swap(curr.str, a,i);
                        continue;
                    }
                    if (set.contains(tmpStr +" "+ String.valueOf(curr.cnt))) {
                        swap(curr.str, a,i);
                        continue;
                    }
                    set.add(tmpStr + " "+String.valueOf(curr.cnt));
                    queue.add(new Node(clone(curr.str), curr.cnt - 1));
                    swap(curr.str, a,i);
                }
            }
        }
        System.out.println(max);

    }

    static void swap (char[] str, int a, int b){
        char tmp = str[a];
        str[a] = str[b];
        str[b] = tmp;
    }
    static char[] clone(char[] arr){
        char[] tmp = new char[arr.length];
        for(int i = 0; i < arr.length; i++){
            tmp[i] = arr[i];
        }
        return tmp;
    }

    static class Node{
        char[] str;
        int cnt;
        int changeIndex;
        Node(char[] str,int cnt, int changeIndex){
            this.str = str;
            this.cnt = cnt;
            this.changeIndex = changeIndex;
        }
        Node(char[] str,int cnt){
            this.str = str;
            this.cnt = cnt;
        }
    }

}
