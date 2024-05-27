package b3967;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static char arr[][] = new char[9][9];
    static boolean used[] = new boolean[12];
    static int ans[] = new int[12];
    static int idxArr[][] = {
            {0,2,5,7},
            {1,2,3,4},
            {0,3,6,10},
            {7,8,9,10},
            {1,5,8,11},
            {4,6,9,11},
    };
    static boolean check = false;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("b3967/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int idx = 0;
        int cnt = 0;
        Arrays.fill(ans, -1);
        for(int i = 0; i < 5; i++){
            arr[i] = br.readLine().toCharArray();
            for (int k = 0; k < 9; k++){
                if(arr[i][k] == '.') continue;
                if(arr[i][k] != 'x'){
                    used[arr[i][k] - 'A'] = true;
                    ans[idx] = arr[i][k] - 'A';
                    cnt ++;
                }
                idx++;
            }
        }
        fn(0, 0);
    }

    static void fn(int index, int cnt ){
        if(check) return ;
        if(index == 12 ){
            int sumCnt = 0;
           for(int i = 0; i < idxArr.length; i++){
               int sum = 0;
               for(int k = 0; k < idxArr[i].length; k++){
                   sum += ans[idxArr[i][k]];
               }
               if(sum == 22) sumCnt ++;
               else return ;
           }
           check = true;
//            for(int i = 0; i < ans.length; i++) {
//                System.out.print((char)(ans[i] + 'A') +" ");
//            }
            int idx = 0;
            for(int i = 0; i < 5; i++){
                for (int k = 0; k < 9; k++){
                    if(arr[i][k] == '.') sb.append('.');
                    else sb.append((char)(ans[idx++] + 'A'));
                }
                sb.append('\n');
            }
            System.out.println(sb.toString());
           return ;
        }

        if(ans[index] != -1) {
            fn(index + 1, cnt + 1);
        }else {
            for(int i = 0; i < ('L' - 'A') + 1; i++){
                if(used[i]) continue;
                used[i] = true;
                ans[index] = i;
                fn(index + 1, cnt+ 1);
                if(check) return;;
                used[i] = false;
                ans[index] = -1;
            }
        }

    }
}
