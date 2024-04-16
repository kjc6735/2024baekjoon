package b1090;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int X[],Y[];
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("b1090/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<int[]> arr= new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        X = new int[N];
        Y = new int[N];
        for(int i = 0; i < N ; i++ ){
            String[] str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            arr.add(new int[]{a,b});
            X[i] = a;
            Y[i] = b;
        }

        for(int t = 1 ;t <= N; t++){
            PriorityQueue<Integer> result = new PriorityQueue<>();
            for(int x = 0; x < N; x++){
                for(int y = 0 ; y < N; y++){
                    PriorityQueue<Integer> pq = new PriorityQueue<>();
                    for(int idx = 0; idx < N; idx ++){
                        int gapX = Math.abs(X[x] - arr.get(idx)[0]);
                        int gapY = Math.abs(Y[y] - arr.get(idx)[1]);
                        pq.add(gapX + gapY);
                    }
                    int sum = 0;
                    for(int i = 0; i < t; i++) sum += (pq.isEmpty() ? 0 : pq.poll());
                    result.add(sum);
                }
            }
            sb.append(result.isEmpty() ? 0 : result.poll()).append(" ");
        }
        System.out.println(sb.toString());
    }
}
