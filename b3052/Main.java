package b3052;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i < 10 ; i++){
            int a = Integer.parseInt(br.readLine());
            set.add(a%42);
        }

        System.out.println(set.size());

    }
}
