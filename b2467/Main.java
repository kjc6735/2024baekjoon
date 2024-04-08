package b2467;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static Integer N, arr[] = new Integer[100001];
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("b2467/input.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr,0,N,(o1,o2)->Integer.compare(Math.abs((Integer) o1),Math.abs((Integer) o2)));
        int diff = Integer.MAX_VALUE;
        int curr = 0;
        for(int i = 0; i < N -1; i++){
            if(Math.abs(arr[i] + arr[i+1]) < diff) {
                diff = Math.abs(arr[i] + arr[i+1]);
                curr = i;
            }
        }
        System.out.println(Math.min(arr[curr], arr[curr + 1]) + " " + Math.max(arr[curr], arr[curr + 1]));
    }
}
