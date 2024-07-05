package b2412;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main2{
    static Set<String> set = new HashSet<>();
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("b2412/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n ;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            set.add(a + " " + b);
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0, 0});
        while (!queue.isEmpty()){
            int[] curr = queue.poll();
            if(curr[1] == T){
                System.out.println(curr[2]);
                return ;
            }
            for(int x = -2; x < 3; x++){
                for(int y = -2 ; y < 3; y++){
                    if(set.contains((curr[0] + x) +" "+(curr[1] + y))){
                        set.remove((curr[0] + x) +" "+(curr[1] + y));
                        queue.add(new int[]{curr[0] + x , curr[1] + y, curr[2] +1 });
                    }
                }
            }
        }
        System.out.println(-1);
    }

}
