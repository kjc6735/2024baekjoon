package b1799;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br;
    static int max = 0;

    static int N = 0;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("b1799/input.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));

    }
}
