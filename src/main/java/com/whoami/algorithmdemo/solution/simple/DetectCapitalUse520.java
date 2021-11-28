package com.whoami.algorithmdemo.solution.simple;

/**
 * 520. 检测大写字母
 * 我们定义，在以下情况时，单词的大写用法是正确的:
 * · 全部字母都是大写，比如"USA"。
 * · 单词中所有字母都不是大写，比如"leetcode"。
 * · 如果单词不只含有一个字母，只有首字母大写，比如"Goolgle"
 * 给你一个字符串word。如果大写用法正确，返回true；否则，返回false。
 * 示例1：
 * 输入：word="USA"
 * 输出：true
 * 示例2：
 * 输入：word="FlaG"
 * 输出：false
 * 提示：
 * · 1 <= word.length <= 100
 * · word 由小写和大写英文字母组成
 *
 * @author whoami
 * @date 2021-11-13 11:08
 */
public class DetectCapitalUse520 {
    public static void main(String[] args) {
        String word = "Google";
        String word1 = "good";
        String word2 = "YES";
        String word3 = "HellO";
        System.out.println(detectCapitalUse2(word));
        System.out.println(detectCapitalUse2(word1));
        System.out.println(detectCapitalUse2(word2));
        System.out.println(detectCapitalUse2(word3));
    }

    /**
     * 方法二：复杂度为 O(n) , 常数为1，O(1)
     * @param word 字符串
     * @return boolean
     */
    public static boolean detectCapitalUse2(String word){
        int n = word.length(), cnt = 0;
        for (int i = 0; i < n; i++) {
            if (Character.isUpperCase(word.charAt(i))){
                cnt++;
            }
        }
        return cnt == n || cnt == 0 || (cnt == 1 && Character.isUpperCase(word.charAt(0)));
    }
}
