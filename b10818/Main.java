package b10818;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("b10818/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int[] arr = new int[a];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        String[] str = br.readLine().split(" ");
        for(int i = 0; i < a; i++){
            int tmp = Integer.parseInt(str[i]);
            max = Math.max(max, tmp);
            min = Math.min(min, tmp);
        }
        System.out.println(min + " " + max);

    }
}

