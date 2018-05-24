package com.foxminded;

import com.foxminded.collection.exception.IncorrectInputDataException;
import com.foxminded.collection.service.UniqueCharacterCounterService;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.never;
import static org.powermock.api.mockito.PowerMockito.verifyPrivate;

/*
 * It tests UniqueCharacterCounterService.java.java;
 *
 * @version 1.2 1 Nobember 2017
 * @author Yaroslav Temchenko
 *
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UniqueCharacterCounterService.class)
public class UniqueCharacterCounterServiceTest {

    @Test
    public void testInputWhichConsistsOfDifferentCharacters() throws IncorrectInputDataException {
        UniqueCharacterCounterService characterCounter = new UniqueCharacterCounterService();
        Map<Character, Integer> expected = new LinkedHashMap<>();
        expected.put('a', 1);
        expected.put('b', 1);
        expected.put('c', 1);
        expected.put('d', 1);
        Map<Character, Integer> actual = characterCounter.countCharacters("abcd");
        assertThat(expected, is(actual));
    }

    @Test
    public void testInputWhichConsistsOfNumbers() throws IncorrectInputDataException {
        UniqueCharacterCounterService characterCounter = new UniqueCharacterCounterService();
        Map<Character, Integer> expected = new LinkedHashMap<>();
        expected.put('1', 2);
        expected.put('2', 1);
        expected.put('3', 1);
        Map<Character, Integer> actual = characterCounter.countCharacters("1231");
        assertThat(expected, is(actual));
    }

    @Test
    public void testIdenticalCharacters() throws IncorrectInputDataException {
        UniqueCharacterCounterService characterCounter = new UniqueCharacterCounterService();
        Map<Character, Integer> expected = new LinkedHashMap<>();
        expected.put('a', 4);
        Map<Character, Integer> actual = characterCounter.countCharacters("aaaa");
        assertThat(expected, is(actual));
    }

    @Test
    public void testNullInput() throws IncorrectInputDataException {
        UniqueCharacterCounterService characterCounter = new UniqueCharacterCounterService();
        Map<Character, Integer> expect = new LinkedHashMap<>();
        ExpectedException exception = ExpectedException.none();
        exception.expect(IncorrectInputDataException.class);
        Map<Character, Integer> actual = characterCounter.countCharacters(null);
        assertThat(expect, is(actual));
    }

    @Test
    public void testEmptyFieldsInput() throws IncorrectInputDataException {
        UniqueCharacterCounterService characterCounter = new UniqueCharacterCounterService();
        Map<String, Integer> expected = Collections.emptyMap();
        Map<Character, Integer> actual = characterCounter.countCharacters("");
        assertThat(actual, is(expected));
    }

    @Test
    public void testCache() throws Exception {
        UniqueCharacterCounterService characterCounter = new UniqueCharacterCounterService();
        UniqueCharacterCounterService mockCharacterCounter = PowerMockito.spy(characterCounter);
        UniqueCharacterCounterService resetMockCharacterCounter = PowerMockito.spy(characterCounter);

        final String inputString = "Hello";
        final String countMethodName = "count";
        Map<Character, Integer> expected = new LinkedHashMap<>();
        Map<Character, Integer> actual;
        expected.put('H', 1);
        expected.put('e', 1);
        expected.put('l', 2);
        expected.put('o', 1);

        actual = mockCharacterCounter.countCharacters(inputString);
        verifyPrivate(mockCharacterCounter).invoke(countMethodName, inputString);
        assertThat(expected, is(actual));

        actual = resetMockCharacterCounter.countCharacters(inputString);
        verifyPrivate(resetMockCharacterCounter, never()).invoke(countMethodName, inputString);
        assertThat(expected, is(actual));
    }
}
