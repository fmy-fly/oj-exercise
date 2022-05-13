import java.io.*;
import java.util.*;
public class Main {
    static int n;
    static int [] a = new int [5], b = new int [5];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer st = new StreamTokenizer(br);
    static PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
    public static int nextInt() throws Exception {
        st.nextToken();
        return (int)st.nval;
    }
    public static double nextDouble() throws Exception {
        st.nextToken();
        return st.nval;
    }
    public static String next() throws Exception {
        st.nextToken();
        return st.sval;
    }
    public static boolean compare(int [] c, int [] t){
        int cnt1 = 0,cnt2 = 0;
        for (int i = 1; i <= 4;i++){
            for(int j= 1; j<= 4;j++){
                if (c[i] > t[j]) cnt1++;
                else if (c[i] < t[j])cnt2++;
            }
        }
        if (cnt1 > cnt2) return true;
        else return false;
    }

    public static void main(String [] args) throws Exception {
        n = nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 4; j++) a[j] = nextInt();
            for (int j = 1; j <= 4; j++) b[j] = nextInt();
            boolean res  = false;
            for (int aa = 1; aa <= 10;aa++){
                for (int bb = 1; bb <= 10 ; bb++){
                    for (int cc  = 1;  cc <= 10; cc++){
                        for (int d = 1; d <= 10; d++){
                            int [] c = {0,aa,bb,cc,d};
                            if(compare(a,c) && compare(b,a) && compare(c,b)) {
                                res = true;
                            }
                            else if (compare(c,a) && compare(a,b) && compare(b,c)){
                                res = true;
                            }
                        }
                    }
                }
            }
            if(res) System.out.println("yes");
            else System.out.println("no");


        }

    }

}
