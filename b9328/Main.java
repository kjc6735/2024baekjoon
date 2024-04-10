package b9328;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static int test_case;
    static char map[][] = new char[101][101];

    static int dir[][] = {
        {0,1}, {0,-1},{1,0}, {-1,0}
    };
    static int w,h;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("b9328/input.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        test_case = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= test_case; tc ++){
            Queue<int[]> entrance = new LinkedList<>();
            Set<Character> key = new HashSet<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            int cnt = 0;

            for(int i = 0; i < h; i++) {
                map[i] = br.readLine().toCharArray();
            }
            String keyStr = br.readLine();
            keyStr = keyStr.toUpperCase();
            for(int i = 0; i < keyStr.length(); i++) key.add(keyStr.charAt(i));

            Queue<int[]> blockQueue = new LinkedList<>();

            for(int i = 0; i < h; i++){
                for(int k = 0; k < w; k++){
                    if(((i == 0 || i== h-1) ||(k == 0 || k== w-1))){
                        if(map[i][k] == '*') continue;
                        if(map[i][k] == '.') {
                            entrance.add(new int[]{i,k});
                            map[i][k] = '*';
                        } else if(key.contains(map[i][k])){
                            entrance.add(new int[]{i,k});
                            map[i][k] = '*';
                        }else if (map[i][k] == '$'){
                            entrance.add(new int[]{i,k});
                            cnt++;
                            map[i][k] = '*';
                        }else if(map[i][k] >= 'a' && map[i][k] <= 'z'){
                            key.add(Character.toUpperCase(map[i][k]));
                            map[i][k] = '*';

                        }else {
                            blockQueue.add(new int[]{i,k});
                        }
                    }
                }
            }

            //------입력 끝------//
            while (!entrance.isEmpty()){
                int[] pos = entrance.poll();
                int currX = pos[0];
                int currY = pos[1];
                for(int i = 0; i < 4; i++){
                    int x = currX + dir[i][0];
                    int y = currY + dir[i][1];

                    if(!inRange(x,y)) continue;
                    if(map[x][y] == '*') continue;

                    if(map[x][y] >= 'A' && map[x][y] <= 'Z' && !key.contains(map[x][y])){
                        blockQueue.add(new int[]{x,y});
                        continue;
                    }
                    if(map[x][y] >='a' && map[x][y] <= 'z') key.add(Character.toUpperCase(map[x][y]));
                    if(map[x][y] == '$') cnt ++;
                    entrance.add(new int[]{x,y});
                    map[x][y] = '*';
                }
            }

            while (!blockQueue.isEmpty()){
                boolean check = false;
                int queueSize = blockQueue.size();
                for(int a = 0; a < queueSize; a++){
                    int[] pos = blockQueue.poll();
                    int currX = pos[0];
                    int currY = pos[1];
                    Queue<int[]> tmpQueue = new LinkedList<>();

                    if(!key.contains(map[currX][currY])){
                        blockQueue.add(pos);
                        continue;
                    }else {
                        map[currX][currY] = '*';
                        tmpQueue.add(new int[]{currX, currY});
                    }

                    while (!tmpQueue.isEmpty()){
                        int[] tmp = tmpQueue.poll();
                        for(int i = 0; i < 4; i++){
                            int x = tmp[0] + dir[i][0];
                            int y = tmp[1] + dir[i][1];

                            if(!inRange(x,y)) continue;
                            if(map[x][y] == '*') continue;
                            if(map[x][y] >= 'A' && map[x][y] <= 'Z' && !key.contains(map[x][y])){
                                blockQueue.add(new int[]{x,y});
                                continue;
                            }
                            if(map[x][y] >='a' && map[x][y] <= 'z') {
                                char t = Character.toUpperCase(map[x][y]);
                                if(!key.contains(t)){
                                    check = true;
                                    key.add(t);
                                }
                            }
                            if(map[x][y] == '$') cnt ++;
                            tmpQueue.add(new int[]{x,y});
                            map[x][y] = '*';
                        }
                    }
                }
                if(!check) break;

            }

            sb.append(cnt).append("\n");
        }
        System.out.print(sb.toString());
    }

    static void print(){
        for(int i = 0; i < h; i++){
            for(int k =0 ; k < w; k++){
                System.out.print(map[i][k ]+ " ");
            }
            System.out.println();
        }
    }
    static boolean inRange(int x, int y){
        return x >= 0 && y>= 0 && x < h && y < w;
    }
}
