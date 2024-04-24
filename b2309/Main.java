package b2309;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    static int arr[] = new int[9];
    static boolean check = false;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("b2309/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        find(0,0,0);

    }

    private static void find(int cnt, int total, int bit){
        if(total > 100) return ;
        if(check) return ;
        if(total == 100 && Integer.bitCount(bit) == 7) {
            for(int i = 0;i < 9; i++){
                if((bit & 1 << i) != 0) System.out.println(arr[i]);
            }
            check = true;
            return ;
        }
        if(cnt == 9) return ;

        find(cnt + 1, total, bit);
        find(cnt + 1, total + arr[cnt], bit | 1 << cnt);
    }
}
