package b2668;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int arr[] = new int[101];
    public static void main(String[] args)throws Exception {
        System.setIn(new FileInputStream("b2668/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i = 1; i <= N ; i++) arr[i] = Integer.parseInt(br.readLine());

        Set<Integer> resultSet = new HashSet<>();

        for(int i = 1; i <= N ; i++){
            if(resultSet.contains(i)) continue;
            Set<Integer> set = new HashSet<>();
            int idx = i;
            while (!set.contains(arr[idx])) {
                set.add(arr[idx]);
                idx = arr[idx];
            }
            if(idx == i){
                set.add(arr[idx]);
                resultSet.addAll(set);
            }
        }

        StringBuilder sb = new StringBuilder();
        List<Integer> result = new ArrayList<>(resultSet);

        Collections.sort(result);
        sb.append(result.size()).append("\n");
        for(int r : result) sb.append(r).append("\n");

        System.out.print(sb.toString());
    }


}
