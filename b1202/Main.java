package b1202;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public  class Main {
    static class Jewelry {
        int w, v;
        Jewelry(int w, int v){
            this.w = w;
            this.v = v;
        }
    }
    static Jewelry jewelry[]= new Jewelry[300001];
    static int bag[] = new int[300001];
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b1202/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[]  = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);
        for(int i =0 ; i < N ; i++){
            str = br.readLine().split(" ");
            int w = Integer.parseInt(str[0]);
            int v = Integer.parseInt(str[1]);
            jewelry[i] = new Jewelry(w,v);
        }
        for(int i = 0 ; i < K; i++){
            bag[i] = Integer.parseInt(br.readLine());
        }


    }
}
