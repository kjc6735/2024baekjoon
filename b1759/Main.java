package b1759;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int L,C;
    static char[] arr;
    static char[] tmp;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("b1759/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[C];
        tmp = new char[L];
        st= new StringTokenizer(br.readLine());
        for(int i = 0; i  < C; i++) arr[i] = st.nextToken().charAt(0);

        Arrays.sort(arr);

        find(0, 0);
        System.out.println(sb.toString());
    }

    static void find(int start, int bit){
        if(Integer.bitCount(bit) == L){
            int idx = 0;
            int m = 0;
            int j = 0;
            for(int i = 0 ; i < C; i++){
                if((bit & (1 << i)) != 0){
                    if(arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') m++;
                    else j ++;
                    tmp[idx++] = arr[i];
                }
            }
            if(m >= 1 && j >= 2){
                sb.append(tmp);
                sb.append('\n');
            }
            return ;
        }
        if(start >= C ) return ;

        find(start + 1 , bit | (1 << start));
        find(start + 1 , bit );

    }



}
