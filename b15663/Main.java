package b15663;
import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] numbers; // unique numbers
    static int[] counts;  // counts of unique numbers
    static int[] result;  // current sequence
    static int uniqueCount; // number of unique numbers

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] inputNumbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            inputNumbers[i] = Integer.parseInt(st.nextToken());
        }

        // Count occurrences
        Arrays.sort(inputNumbers);
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for(int num : inputNumbers){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        uniqueCount = map.size();
        numbers = new int[uniqueCount];
        counts = new int[uniqueCount];

        int idx = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            numbers[idx] = entry.getKey();
            counts[idx] = entry.getValue();
            idx++;
        }

        result = new int[M];
        permute(0);
        bw.flush();
        bw.close();
    }

    static void permute(int depth) throws IOException{
        if(depth == M){
            for(int i=0; i<M; i++){
                bw.write(result[i] + " ");
            }
            bw.newLine();
            return;
        }

        for(int i=0; i<uniqueCount; i++){
            if(counts[i] > 0){
                counts[i]--;
                result[depth] = numbers[i];
                permute(depth+1);
                counts[i]++;
            }
        }
    }
}
