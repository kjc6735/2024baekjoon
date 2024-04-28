package b2304;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int arr[] = new int [1001];
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("b2304/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int max = 0;
        for(int i = 0 ; i < N ;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a =Integer.parseInt(st.nextToken());
            arr[a] = Integer.parseInt(st.nextToken());
            if(arr[a] > max) max = arr[a];

        }
        int left = 0;
        int right = 1000;
        int total = 0;
        while (left <= right &&  !(arr[left] == max && arr[right] == max)){
            int tmpIdx = left;
            while (arr[tmpIdx] >= arr[left] && left <= right && max != arr[tmpIdx]) left++;
            total += (arr[tmpIdx] * (left - tmpIdx));

            tmpIdx = right;
            while (arr[tmpIdx] >= arr[right] && left <= right && max != arr[tmpIdx]) right--;
            total += (arr[tmpIdx] * (tmpIdx - right));
        }
        if(left <= right){
            total += (arr[left] * (right - left + 1));
        }
        System.out.println(total);
    }
}
