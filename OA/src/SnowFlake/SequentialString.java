package SnowFlake;

/**
 * https://www.1point3acres.com/bbs/thread-990167-1-1.html
 * 题目是给你一个由0-9数字组成的String s, 然后给你一个长度为m的String array arr, 问要用s的substring组成arr里的String，每一个需要的最短长度, 如果不能组成则返回-1
 * Example：s = "112234", m = 2, arr = ["13", "1234", "15"]
 * Output: [5, 6, -1]
 * Explanation:
 * arr[0] = "13", 需要s的substring"11223"里的数字才能组成，所以最短长度是5
 * n: 1-10^5
 * q: 1-2*10^4
 * Sum of length of strings in arr: 1-5*10^5
 * All string consists of characters ’0’ - ‘9’ only
 *
 * 我的solution是把s和每个arr[i]都map，然后先查能不能组成，可以组成的话从左到右loop s，直到所有arr[i]的字符都被cover，停止并返回当前index，获得length
 * 这个solution出来结果是错的，不知道是不是我的理解有问题，如果有小伙伴有别的理解欢迎来讨论！
 *
 * (第一题划窗但不移动左边，右边take in新的元素，只要跟target一样了之后就break loop 返回当前的length加入答案list即可)
 */
public class SequentialString {
}
