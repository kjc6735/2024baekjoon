package b1090;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static Set<Integer> setX = new HashSet<>();
    static Set<Integer> setY = new HashSet<>();
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("b1090/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<int[]> arr= new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N ; i++ ){
            String[] str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            arr.add(new int[]{a,b});
            setX.add(a);
            setY.add(b);
        }

        for(int t = 1 ;t <= N; t++){
            Iterator<Integer> iterX = setX.iterator();
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            while (iterX.hasNext()){
                int x = iterX.next();
                PriorityQueue<Integer> tmp = new PriorityQueue<>();

                Iterator<Integer> iterY = setY.iterator();
                while (iterY.hasNext()){
                    int y = iterY.next();
                    //x y 를 선택했을 때
                    for(int k = 0; k< arr.size();k ++) {
                        int gapX = Math.abs(arr.get(k)[0] - x);
                        int gapY = Math.abs(arr.get(k)[1] - y);
                        tmp.add(gapX + gapY);
                    }
                    int sum = 0;
                    for(int i = 0 ; i < t; i++) sum += (tmp.isEmpty() ? 0 : tmp.poll());
                    pq.add(sum);
                }
            }
            sb.append(pq.poll()).append(" ");

        }

        System.out.println(sb.toString());

    }
}
