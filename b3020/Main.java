package b3020;

import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int arrH[] = new int[500001];
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("b3020/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++){
            int tmp = Integer.parseInt(br.readLine());
            if(i%2 == 0){
                arrH[1] += 1;
                arrH[tmp + 1] -= 1;
            }else {
                arrH[H - tmp + 1] += 1;
            }
        }

        int min = Integer.MAX_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i= 1; i <= H; i++){
            arrH[i] = arrH[i] + arrH[i-1];
            map.put(arrH[i], map.getOrDefault(arrH[i] , 0) + 1);
            min = min > arrH[i] ? arrH[i] : min;
        }

        System.out.println(min+ " "+ map.get(min));




    }
}

