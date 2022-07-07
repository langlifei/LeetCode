package com.offer.leetcode.medium;

import com.offer.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * 你有一个单词列表 words 和一个模式  pattern，你想知道 words 中的哪些单词与模式匹配。
 *
 * 如果存在字母的排列 p ，使得将模式中的每个字母 x 替换为 p(x) 之后，我们就得到了所需的单词，那么单词与模式是匹配的。
 *
 * （回想一下，字母的排列是从字母到字母的双射：每个字母映射到另一个字母，没有两个字母映射到同一个字母。）
 *
 * 返回 words 中与给定模式匹配的单词列表。
 *
 * 你可以按任何顺序返回答案。
 * @Example:
 * 输入：words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
 * 输出：["mee","aqq"]
 * 解释：
 * "mee" 与模式匹配，因为存在排列 {a -> m, b -> e, ...}。
 * "ccc" 与模式不匹配，因为 {a -> c, b -> c, ...} 不是排列。
 * 因为 a 和 b 映射到同一个字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-and-replace-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: zz
 * @Date: 2022/6/12 16:50
 */
class Solution890 {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
//        if(StringUtils.isEmpty(words) || StringUtils.isEmpty(pattern)){
//            return res;
//        }
        char[] target = pattern.toCharArray();
        for (String word : words) {
            if(word.length() != pattern.length()){
                continue;
            }
            char[] object = word.toCharArray();
            //重点：构建双映射，a->b与b->a都成立时才能形成单一映射。
            if(isMatch(object, target) && isMatch(target, object)){
                res.add(word);
            }
        }
        return res;
    }

    private boolean isMatch(char[] object, char[] target) {
        boolean isMatch = true;
        Map<Character,Character> map = new HashMap<>();
        for (int i = 0; i < object.length; i++) {
            Character character = map.get(target[i]);
            if(character == null){
                map.put(target[i], object[i]);
                character = object[i];
            }
            if(!character.equals(object[i])){
                isMatch = false;
                break;
            }
        }
        return isMatch;
    }

}
