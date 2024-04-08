package b1068;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static ArrayList<Integer>[] arr = new ArrayList[51];
    static BufferedReader br;
    static int total = 0, cut = 0, start = 0;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("b1068/input.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String str[] = br.readLine().split(" ");
        int start = 0;
        for(int i = 0; i < N ; i++) arr[i] = new ArrayList<>();
        for(int i = 0 ; i < N; i++){
            int a=  Integer.parseInt(str[i]);
            if(a == -1 ){
                start = i;
            }else {
                arr[a].add(i);
            }
        }
        cut = Integer.parseInt(br.readLine());
        if(cut == start) {
            System.out.println(0);
            return ;
        }
        find(start);
        System.out.println(total);
    }
    static void find(int d){

        if(arr[d].size() == 0 && d == cut){
//            total++;
            return ;
        }else if(arr[d].size() != 0 && d == cut){
            total++;
            return ;
        }
        if(arr[d].size() == 0){
            total ++;
            return ;
        }

        for(int i = 0; i < arr[d].size(); i++){
            if(arr[d].size() == 1 && arr[d].get(i) ==cut){
                total ++;
                continue;
            }
            if(arr[d].size() != 1 && arr[d].get(i) ==cut){
                continue;
            }
            find(arr[d].get(i));
        }
    }
}
