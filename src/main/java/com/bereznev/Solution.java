package com.bereznev;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Component
public class Solution {
//  public int romanToInt(String s) {
//    Map<String, Integer> romanDigits = Map.of(
//        "I", 1,
//        "V", 5,
//        "X", 10,
//        "L", 50,
//        "C", 100,
//        "D", 500,
//        "M", 1000
//    );
//    if (s == null || s.isEmpty() || Stream.of(s.toCharArray()).map(String::valueOf).allMatch(romanDigits::containsKey)) {
//      return 0;
//    }
//    if (romanDigits.containsKey(s)) {
//      return romanDigits.get(s);
//    }
//    char[] input = s.toCharArray();
//    int result = 0;
//    for (int i = 1; i < input.length; i++) {
//      int previousDigit = romanDigits.get(String.valueOf(input[i - 1]));
//      int currentDigit = romanDigits.get(String.valueOf(input[i]));
//      if (previousDigit < currentDigit) {
//        result += (currentDigit - previousDigit);
//      } else {
//        result += previousDigit + currentDigit;
//      }
//    }
//    return result;
//  }
//
//  private boolean isRomanInputValid(String s, Map<String, Integer> romanDigits) {
//    return Stream.of(s.toCharArray()).map(String::valueOf).allMatch(romanDigits::containsKey);
//  }

//  https://leetcode.com/problems/two-sum/
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> value2Index = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      for (Map.Entry<Integer, Integer> entry : value2Index.entrySet()) {
        int value = entry.getKey();
        int index = entry.getValue();
        if (value + nums[i] == target) {
          return new int[]{i, index};
        }
      }
      if (!value2Index.containsKey(nums[i])) {
        value2Index.put(nums[i], i);
      }
    }
    return new int[]{0, 0};
  }
}
