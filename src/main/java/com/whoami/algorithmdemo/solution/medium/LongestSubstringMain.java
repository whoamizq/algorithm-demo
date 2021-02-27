package com.whoami.algorithmdemo.solution.medium;

/**
 * @Title:  至少有K个重复字符的最长子串
 * @ClassName: com.whoami.algorithmdemo.solution.medium.LongestSubstringMain.java
 * @Description: 给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串，
 * 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
 *
 * 示例1：
 * 输入：s = "aaabb", k = 3
 * 输出：3
 * 解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
 *
 * 示例2：
 * 输入：s = "ababbc", k = 2
 * 输出：5
 * 解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
 *
 * 提示：
 * ------ 1 <= s.length <= 104
 * ------ s 仅由小写英文字母组成
 * ------ 1 <= k <= 105
 *
 * @Copyright 2021 - Powered By whoami
 * @author: whoamizq
 * @date:  2021-02-27 15:00
 * @version V1.0
 */
public class LongestSubstringMain {
    public static void main(String[] args) {
        String s = "ababacb";
        int k = 3;
        System.out.println(longestSubstringAnswer(s, k));
    }

    private static int longestSubstring(String s, int k){
        return 0;
    }


    /**
     * 方法一： 分治
     * 对于字符串s，如果存在某个字符串ch，他的出现次数大于0且小于k，则任何包含ch的子串都不可能满足要求。
     * 也就是说，我们将字符串按照ch切分成若干段，则满足要求的最长子串一定出现在某个被切分的段内，
     * 而不能跨越一个或多个段。
     * @param s
     * @param k
     * @return
     */
    private static int longestSubstringAnswer(String s, int k) {
        int n = s.length();
        return dfs(s, 0, n - 1, k);
    }

    private static int dfs(String s, int l, int r, int k) {
        int[] cnt = new int[26];
        for (int i = l; i <= r; i++) {
            cnt[s.charAt(i) - 'a']++;
        }

        char split = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0 && cnt[i] < k) {
                split = (char) (i + 'a');
                break;
            }
        }
        if (split == 0) {
            return r - l + 1;
        }

        int i = l;
        int ret = 0;
        while (i <= r) {
            while (i <= r && s.charAt(i) == split) {
                i++;
            }
            if (i > r) {
                break;
            }
            int start = i;
            while (i <= r && s.charAt(i) != split) {
                i++;
            }

            int length = dfs(s, start, i - 1, k);
            ret = Math.max(ret, length);
        }
        return ret;
    }
}
