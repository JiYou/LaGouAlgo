import java.io.*;
import java.util.*;

public class Main {
  static private String binarySearch(long[] A, int n, long target) {
      int l = 0, r = n;
      while (l < r) {
          final int m = l + ((r-l)>>1);
          if (A[m] == target) {
              return new String("YES");
          }
          if (A[m] < target) {
              l = m + 1;
          } else {
              r = m;
          }
      }
      return new String("NO");
  }

  public static void main(String args[]) throws Exception {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    long[] A = new long[n];

    for (int i = 0; i < n; i++) {
      A[i] = sc.nextLong();
    }
    Arrays.sort(A);
    for (int i = 0; i < m; i++) {
        long target = sc.nextLong();
        System.out.println(binarySearch(A, n, target));
    }
  }
}
