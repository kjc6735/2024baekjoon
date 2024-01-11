package b17070;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static int N;
    static HashMap<Integer, Integer> hashMap;
    static  ArrayList<int[]>[] dirList =  new ArrayList[3];
    static Set<Integer> set;
    static int result = 0;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b17070/input.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i =0; i < 3; i++) dirList[i] = new ArrayList<int[]>();
        dirList[0].add(new int[]{0,1});
        dirList[0].add(new int[]{1,1});

        dirList[1].add(new int[]{1,0});
        dirList[1].add(new int[]{1,1});

        dirList[2].add(new int[]{0,1});
        dirList[2].add(new int[]{1,0});
        dirList[2].add(new int[]{1,1});
        set = new HashSet<>();
        for(int i = 1; i <= N ; i++){
            String[] str = br.readLine().split(" ");
            for(int k = 1;  k <= N; k++){
                int tmp = Integer.parseInt(str[k-1]);
                if(tmp == 1) set.add(i*100+k);
            }
        }

        hashMap = new HashMap<>();
        hashMap.put(10,0);
        hashMap.put(100, 1);
        hashMap.put(110, 2);
        fn(1,2,10);
        System.out.println(result);

    }

    static void fn(int x, int y, int dir){
        if(x == N  && y == N){
            result+=1;
            return ;
        }
        dir = hashMap.get(dir);
        for(int i = 0; i < dirList[dir].size() ; i++){
            int dx = x + dirList[dir].get(i)[0];
            int dy = y + dirList[dir].get(i)[1];
            int currDir = dirList[dir].get(i)[0] * 100 + dirList[dir].get(i)[1]*10;
            if(!inRange(dx,dy)) continue;
            if(set.contains(dx*100+dy)) continue;
            if(i == dirList[dir].size()-1
                    && (set.contains(x* 100 + y+1)
                    || set.contains((x+1) * 100 + y))
            ) {
                continue;
            }
            fn(dx,dy, currDir);
        }
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
