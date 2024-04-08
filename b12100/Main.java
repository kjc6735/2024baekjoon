package b12100;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br;

    static int idx = 0;
    static int max = 0;
    static int N;
    public static void main(String[] args)throws Exception {
        System.setIn(new FileInputStream("b12100/input.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        int arr[][] = new int[20][20];

        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            String str[] = br.readLine().split(" ");
            for(int k = 0; k < N ;k ++){
                arr[i][k] = Integer.parseInt(str[k]);
            }
        }
        t(0, arr);


        System.out.println(max);
    }
    static void print(int arr[][]){
        System.out.println("===========");
        for(int i = 0; i < N ; i++){
            for(int k = 0; k < N ; k++){
                System.out.print(arr[i][k] + " ");
            }
            System.out.println();
        }
        System.out.println("===========");
    }

    static void t(int cnt, int arr[][]){
        if(cnt == 1) {
            int find = find(arr);
            if(find > max) max = find;
            print(arr);
            return ;
        }
        int a[][] = copy(arr);
        left(a);
        t(cnt +1, a);

        int b[][] = copy(arr);
        right(b);
        t(cnt + 1, b);

        int c[][] = copy(arr);
        up(c);
        t(cnt + 1, c);

        int d[][] = copy(arr);
        down(d);
        t(cnt + 1, d);
    }
    static int[][] copy (int arr[][]){
        int newArr[][] = new int[N][N];
        for(int i = 0; i <  N ; i++){
            for(int k = 0; k < N; k++){
                newArr[i][k] = arr[i][k];
            }
        }
        return newArr;
    }
    static void left(int arr[][]){
        for(int i = 0; i < N; i++){
            for(int k = 0; k  < N- 1; k++){
                if(arr[i][k+1] != 0){
                    int tmp = k;
                    while (tmp >= 0 && arr[i][tmp] == 0){
                        arr[i][tmp] = arr[i][tmp + 1];
                        arr[i][tmp + 1] = 0;
                        tmp --;
                    }
                    if(tmp >= 0 && arr[i][tmp] == arr[i][tmp+1]){
                        arr[i][tmp]*=2;
                        arr[i][tmp+1] = 0;
                    }
                }
            }
        }
    }

    static void right (int arr[][]){
        for(int i = 0; i < N; i++){
            for(int k = N-1; k  >= 1; k--){
                if(arr[i][k-1] != 0){
                    int tmp = k;
                    while (tmp < N && arr[i][tmp] == 0){
                        arr[i][tmp] = arr[i][tmp - 1];
                        arr[i][tmp - 1] = 0;
                        tmp ++;
                    }
                    if(tmp < N && arr[i][tmp] == arr[i][tmp-1]){
                        arr[i][tmp]*=2;
                        arr[i][tmp-1] = 0;
                    }
                }

            }
        }
    }
    static void down(int arr[][]){
        for(int i = 0; i < N; i++){

            for(int k = N-1; k  >= 1; k--){
                if(arr[k-1][i] != 0){
                    int tmp = k;
                    while (tmp < N && arr[tmp][i] == 0){
                        arr[tmp][i] = arr[tmp -1][i];
                        arr[tmp -1][i] = 0;
                        tmp ++;
                    }
                    if(tmp < N && arr[tmp][i] == arr[tmp-1][i]){
                        arr[tmp][i]*=2;
                        arr[tmp-1][i] = 0;
                    }
                }
            }
        }
    }
    static void up (int arr[][]){
        for(int i = 0; i < N; i++){
            for(int k = 0; k  < N-1; k++){
                if(arr[k+1][i] != 0){
                    int tmp = k;
                    while (tmp >= 0 && arr[tmp][i] == 0){
                        arr[tmp][i] = arr[tmp + 1][i];
                        arr[tmp + 1][i] = 0;
                        tmp--;
                    }
                    if(tmp >= 0 && arr[tmp][i] == arr[tmp+1][i]){
                        arr[tmp][i]*=2;
                        arr[tmp+1][i] = 0;
                    }
                }
            }
        }
    }
    static int find (int arr[][]){
        int max = 0;
        for(int i = 0; i <  N ; i++){
            for(int k = 0; k < N; k++){
                if(max < arr[i][k]) max = arr[i][k];
            }
        }
        return max;
    }
}
