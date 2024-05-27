package b19942;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Ingredient {
        int a,b,c,d,e;
        Ingredient(String str){
            StringTokenizer st = new StringTokenizer(str);
             a = Integer.parseInt(st.nextToken());
             b = Integer.parseInt(st.nextToken());
             c = Integer.parseInt(st.nextToken());
             d = Integer.parseInt(st.nextToken());
             e = Integer.parseInt(st.nextToken());

        }
    }

    static Ingredient[] ing = new Ingredient[15];
    static int N, min = Integer.MAX_VALUE;
    static int index = -1;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("b19942/input.txt"));
        PriorityQueue<String> pq = new PriorityQueue<>();
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int r1,r2,r3,r4;
        StringTokenizer st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        r3 = Integer.parseInt(st.nextToken());
        r4 = Integer.parseInt(st.nextToken());

        for(int i =0; i < N ; i++){
            ing[i] = new Ingredient(br.readLine());
        }

        for(int i = 0; i < (1 << N); i++){
            int a = 0;
            int b = 0;
            int c = 0;
            int d = 0;
            int e = 0;
            for(int k = 0; k < N; k++){
                if((i & (1 << k)) == 0) continue;
                a += ing[k].a;
                b += ing[k].b;
                c += ing[k].c;
                d += ing[k].d;
                e += ing[k].e;
            }
            if(a >= r1 && b >= r2 && c >= r3 && d >= r4){
                if(e < min){
                    min = e;
                    pq.clear();
                    pq.add(intToString(i));
                }else if(e == min){
                    pq.add(intToString(i));
                }
            }
        }
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
        if(min != Integer.MAX_VALUE){
            System.out.println(pq.poll());
        }


    }
    static String intToString(int a){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            if((a& (1 << i)) == 0) continue;
            sb.append(i+1).append(" ");
        }
        return sb.toString();
    }
}
