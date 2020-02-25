package com.mi.zhang.algorithm;

import android.text.TextUtils;

/**
 * 正则表达式匹配
 * <p>
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * <p>
 * 说明:
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * <p>
 * 示例 1:
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * <p>
 * 示例 2:
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * <p>
 * 示例 3:
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * <p>
 * 示例 4:
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/regular-expression-matching
 */
public class Algorithm4 {

    public static void main(String[] args) {
        System.out.println(new Algorithm4().isMatch("aaa", "a*"));
    }

//    public boolean isMatch(String text, String pattern) {
//        if (pattern.isEmpty()) return text.isEmpty();
//        boolean first_match = (!text.isEmpty() &&
//                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));
//
//        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
//            return (isMatch(text, pattern.substring(2)) ||
//                    (first_match && isMatch(text.substring(1), pattern)));
//        } else {
//            return first_match && isMatch(text.substring(1), pattern.substring(1));
//        }
//    }

    private boolean isMatch(String s, String p) {
        if (isEmpty(s) && isEmpty(p)) {
            return true;
        } else if (isEmpty(s)) {
            return false;
        } else if (isEmpty(p)) {
            return false;
        } else if (!p.contains(".") && !p.contains("*")) {
            return s.equals(p);
        } else {
            return innerMatch(s, p, 0, 0);
        }
    }

    private boolean innerMatch(String s, String p, int matchIndexS, int startIndexP) {
        if (startIndexP >= p.length()) {
            startIndexP = p.length() - 1;
        }
        char matchS = s.charAt(matchIndexS);
        for (int pIndex = startIndexP; pIndex < p.length(); pIndex++) {
            if (matchS == p.charAt(pIndex)) {
                return innerMatch(s, p, ++matchIndexS, ++pIndex);
            } else if (p.charAt(pIndex) == '.') {
                return innerMatch(s, p, ++matchIndexS, ++pIndex);
            } else if (p.charAt(pIndex) == '*') {
                if (pIndex > 0) {
                    if (p.charAt(--pIndex) == matchS) {
                        return innerMatch(s, p, ++matchIndexS, ++pIndex);
                    }
                } else {
                    return false;
                }
            }
        }

        return false;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }
}
