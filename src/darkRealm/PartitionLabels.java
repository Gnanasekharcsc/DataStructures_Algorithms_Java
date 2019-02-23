package darkRealm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {

//763. Partition Labels
//  A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that
//  each letter appears in at most one part, and return a list of integers representing the size of these parts.
//
//  Example 1:
//  Input: S = "ababcbacadefegdehijhklij"
//  Output: [9,7,8]
//  Explanation:
//  The partition is "ababcbaca", "defegde", "hijhklij".
//  This is a partition so that each letter appears in at most one part.
//  A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
//
//  Note:
//  S will have length in range [1, 500].
//  S will consist of lowercase letters ('a' to 'z') only.


  public static List<Integer> partitionLabels(String S) {
    List<Integer> res = new ArrayList<>();

    if (S == null || S.length() < 0) return res;

    Map<Character, Integer> map = new HashMap<>();
    char[] carr = S.toCharArray();

    for (int i = carr.length - 1; i > -1; i--)
      if (!map.containsKey(carr[i]))
        map.put(carr[i], i);

    int max = Integer.MIN_VALUE;

    for (int i = 0, len = 0; i < carr.length; i++) {
      len++;
      max = Math.max(map.get(carr[i]), max);
      if (i == max) {
        res.add(len);
        len = 0;
      }
    }
    return res;
  }

  public static void main(String[] args) {
    String ste = "zzababcbacadefegdehijhklij";
    List<Integer> res = partitionLabels(ste);
    System.out.println(ste);
    System.out.println(res);
  }
}
