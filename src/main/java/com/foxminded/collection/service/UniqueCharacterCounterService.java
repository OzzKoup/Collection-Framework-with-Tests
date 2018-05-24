package com.foxminded.collection.service;

import com.foxminded.collection.exception.IncorrectInputDataException;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/*
 * It tests UniqueCharacterCounterService.java;
 * Consists of functions :
 *  - countCharacters()
 *  - printResult()
 *
 * @version 1.2 1 November 2017
 * @author Yaroslav Temchenko
 *
 */
public class UniqueCharacterCounterService {
    private final Map<String, Map<Character, Integer>> cache = new HashMap<>();

    public Map<Character, Integer> countCharacters(final String inputData) throws IncorrectInputDataException {
        if (inputData == null) {
            throw new IncorrectInputDataException("The method parameter can't be null");
        }
        Map<Character, Integer> value = cache.get(inputData);
        if (value != null) {
            return value;
        }
        Map<Character, Integer> result = count(inputData);
        cache.put(inputData, result);
        return result;
    }

    public void printResult(Map<Character, Integer> input) {
        input.forEach((key, value) -> System.out.println("\"" + key + "\"" + " - " + value));
    }

    private Map<Character, Integer> count(final String inputData) {
        Map<Character, Integer> countMap = new LinkedHashMap<>();
        char symbol;
        Integer counter;
        char inputAsCharArray[] = inputData.toCharArray();
        for (int j = 0; j < inputAsCharArray.length; j++) {
            symbol = inputAsCharArray[j];
            counter = countMap.get(symbol);
            if (counter != null) {
                countMap.put(symbol, counter + 1);
            } else {
                countMap.put(symbol, 1);
            }
        }
        return countMap;
    }
}
