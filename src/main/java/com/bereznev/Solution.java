package com.bereznev;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Component
public class Solution {

// https://leetcode.com/problems/roman-to-integer/
public int romanToInt(String s) {
  Map<Character, Integer> romanDigits = Map.of(
      'I', 1,
      'V', 5,
      'X', 10,
      'L', 50,
      'C', 100,
      'D', 500,
      'M', 1000
  );

  if (s == null || s.isEmpty()) {
    return 0;
  }
  int result = 0;
  int prevValue = 0;

  for (int i = s.length() - 1; i >= 0; i--) {
    int currValue = romanDigits.get(s.charAt(i));
    if (currValue < prevValue) {
      result -= currValue;
    } else {
      result += currValue;
    }
    prevValue = currValue;
  }
  return result;
}

//  https://leetcode.com/problems/two-sum/
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> value2Index = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      for (Map.Entry<Integer, Integer> entry : value2Index.entrySet()) {
        int value = entry.getKey();
        int index = entry.getValue();
        if (value + nums[i] == target) {
          int[] result = new int[]{i, index};
          Arrays.sort(result);
          return result;
        }
      }
      if (!value2Index.containsKey(nums[i])) {
        value2Index.put(nums[i], i);
      }
    }
    return new int[]{0, 0};
  }
}
