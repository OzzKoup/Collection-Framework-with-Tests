package com.foxminded.collection;

import com.foxminded.collection.exception.IncorrectInputDataException;
import com.foxminded.collection.service.UniqueCharacterCounterService;
import org.apache.log4j.Logger;

import java.util.Map;

/*
 * It start UniqueCharacterCounterService.java.java;
 *
 * @version 2.1 7 October 2017
 * @author Yaroslav Temchenko
 *
 */
class Main {
    final private static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) throws IncorrectInputDataException {
        try {
            UniqueCharacterCounterService characterCounter = new UniqueCharacterCounterService();
            Map<Character, Integer> result = characterCounter.countCharacters("12345 lololo 44554");
            characterCounter.printResult(result);
            result = characterCounter.countCharacters("Hello");
            characterCounter.printResult(result);
        } catch (IncorrectInputDataException e) {
            logger.error(e.getMessage());
        }
    }
}
