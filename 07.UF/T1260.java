
// https://nanti.jisuanke.com/t/T1260


// https://nanti.jisuanke.com/t/T1260
import java.io.*;
import java.util.*;

class Solution {
  private int[] F = null;

  private void Init(int n) {
    F = new int[n + 1];
    for (int i = 0; i <= n; i++) {
      F[i] = i;
    }
  }

  private int Find(int x) {
    if (x == F[x]) {
      return x;
    }
    F[x] = Find(F[x]);
    return F[x];
  }

  private void Union(int x, int y) {
    F[Find(x)] = Find(y);
  }

  public int findGangNumber(int n, int[][] conn) {
      Init(n);
      
      int m = conn.length;
      for (int i = 0; i < m; i++) {
          Union(conn[i][0], conn[i][1]);
      }
      
      // 一定要路径再压缩一次
      // 否则如果出现没有压缩的情况，那么统计结果就不准确了
      for (int i = 1; i <= n; i++) {
          Find(i);
      }
      
      // 统计帮派里面帮主的个数
      Set<Integer> s = new HashSet<>();
      for (int i = 1; i <= n; i++) {
        s.add(F[i]);
      }
      
      return s.size();
  }
}

public class Main {
  public static void main(String args[]) throws Exception {
    Scanner sc = new Scanner(System.in);

    int testCase = 0;

    while (true) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[][] conn = new int[m][2];

      if (n == 0 && m == 0) {
        break;
      }

      for (int i = 0; i < m; i++) {
          conn[i][0] = sc.nextInt();
          conn[i][1] = sc.nextInt();
      }
        
      Solution s = new Solution();
      int ans = s.findGangNumber(n, conn);
      ++testCase;
      System.out.println("Case " + testCase + ": " + ans);
    }
  }
}
