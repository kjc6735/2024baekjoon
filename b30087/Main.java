package b30087;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    static HashMap<String, String> map = new HashMap<>(){{
        put("Algorithm", "204");
        put("DataAnalysis", "207");
        put("ArtificialIntelligence", "302");
        put("CyberSecurity", "B101");
        put("Network", "303");
        put("Startup", "501");
        put("TestStrategy", "105");
    }};

    public static void main(String[] args)throws Exception {
        System.setIn(new FileInputStream("b30087/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N ; i++) sb.append(map.get(br.readLine())).append("\n");
        System.out.print(sb.toString());
    }
}
