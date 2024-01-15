package b5639;
import java.io.*;
import java.util.*;
public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws  Exception {
        System.setIn(new FileInputStream("b5639/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        Node nodes = new Node(0);
        while ((str = br.readLine()) != null) {
            int v = Integer.parseInt(str);
            Node newNode = new Node(v);
            Node tmp = nodes;
            Node prev = nodes;
            while (tmp != null){
                prev = tmp;
                if(tmp.value < v) tmp = tmp.left;
                else tmp = tmp.right;
            }
            if(prev.value < v) prev.left=  newNode;
            else prev.right = newNode;
        }
        print(nodes);
        sb.deleteCharAt(sb.length() - 2);
        System.out.println(sb.toString());
    }

    public static void print(Node n){
        if(n.right != null) print(n.right);
        if(n.left != null) print(n.left);
        sb.append(n.value).append("\n");
    }

    static class Node{
        int value;
        Node left = null;
        Node right = null;
        public Node(int value){
            this.value = value;
        }


    }
}
