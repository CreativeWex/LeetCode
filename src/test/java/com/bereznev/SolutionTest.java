package com.bereznev;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = Solution.class)
class SolutionTest {
  @Autowired
  Solution solution;

//  @ParameterizedTest
//  @CsvSource({
//      ", 0",
//      "IX123, 0",
//      "I, 1",
//      "VI, 6",
//      "IIX, 8",
//      "LVIII, 58",
//      "MCMXCIV, 1994",
//  })
//  public void romanToIntTest(String input, String result) {
//    assertEquals(Integer.parseInt(result), solution.romanToInt(input));
//  }
}
