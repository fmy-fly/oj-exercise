import java.io.*;
import java.util.*;

public class lca {
    static final int N = 40010, M = 80010;
    static int n,m,idx;
    static int [] head = new int [N],next = new int [M],ver = new int [M],depth = new int [N];
    static int [][] fa = new int [N][16];
    static int [] q = new int [N];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer st = new StreamTokenizer(br);
    static PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
    public static int nextInt() throws Exception {
        st.nextToken();
        return (int)st.nval;
    }
    public static void add(int x,int y){
        ver[++idx] = y;
        next[idx] = head[x];
        head[x] = idx;

    }
    public static void bfs(int root){
        Arrays.fill(depth,0x3f3f3f3f);
        depth[0] = 0;
        depth[root] = 1;
        int hh = 0 ,tt = 0;
        q[0] = root;
        while(hh <= tt){
            int t = q[hh++];
            for (int i = head[t] ; i > 0; i = next[i]){
                int j = ver[i];
                if (depth[j] > depth[t] + 1){
                    depth[j] = depth[t] + 1;
                    q[++tt] = j;
                    fa[j][0] = t;
                    for (int k = 1; k <= 15; k++){
                        fa[j][k] = fa[fa[j][k-1]][k-1];
                    }
                }
            }
        }

    }
    public static int lca(int a,int b){
        if (depth[a]  < depth[b]){
            int t = a;
            a = b ;
            b = t;
        }
        for (int k = 15;k >=0 ;k --){
            if (depth[fa[a][k]] >= depth[b]) {
                a = fa[a][k];
            }
        }
        if (a == b) return a;
        for (int k = 15 ;  k >= 0; k--){
            if (fa[a][k] != fa[b][k]){
                a = fa[a][k];
                b = fa[b][k];
            }
        }
        return fa[a][0];
    }
    public static void main(String [] args) throws Exception{
        n = nextInt();
        int root = 0;
        for (int i = 1 ; i <= n ;i++){
            int a = nextInt(), b = nextInt();
            if (b == -1) root = a;
            else {
                add(a, b);
                add(b, a);
            }
        }
        bfs(root);
        m = nextInt();
        while(m-- > 0 ){
            int a = nextInt(), b = nextInt();
            int p = lca(a,b);
            if ( p == a)System.out.println(1);
            else  if ( p == b)System.out.println(2);
            else System.out.println(0);
        }

    }






}
