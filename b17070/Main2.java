package b17070;

import java.io.*;
import java.util.*;

public class Main2 {
    static BufferedReader br;
    static int N;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b17070/input.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ArrayList[] dirList = new ArrayList[3];
        for(int i =0; i < 3; i++) dirList[i] = new ArrayList();
        dirList[0].add(new int[]{0,1});
        dirList[0].add(new int[]{1,1});

        dirList[1].add(new int[]{1,0});
        dirList[1].add(new int[]{1,1});

        dirList[2].add(new int[]{0,1});
        dirList[2].add(new int[]{1,0});
        dirList[2].add(new int[]{1,1});
        int result = 0;
        Set<Integer> set = new HashSet<>();
        for(int i = 1; i <= N ; i++){
            String[] str = br.readLine().split(" ");
            for(int k = 1;  k <= N; k++){
                int tmp = Integer.parseInt(str[k-1]);
                if(tmp == 1) set.add(i*100+k);
            }
        }

        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(0, new int[]{1,2}));
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(10,0);
        hashMap.put(100, 1);
        hashMap.put(110, 2);

        System.out.println(result);

    }
    static boolean inRange(int x, int y){
        return  x <= N && y <= N;
    }

    static class Node{
        int type;
        int[] currPos = new int[2];
        public  Node(int type, int[] currPos){
            this.type = type;
            this.currPos = currPos;
        }
    }
}
