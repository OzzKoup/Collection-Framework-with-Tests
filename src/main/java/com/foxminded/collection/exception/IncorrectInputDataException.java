package com.foxminded.collection.exception;
/*
* This class throw custom exception to UniqueCharacterCounterService.java.java.
* It throws when input is null.
*
* @version 1.1 21 Sep 2017
* @author Yaroslav Temchenko
*
*/

public class IncorrectInputDataException extends Exception {
    public IncorrectInputDataException(String massage) {
        super(massage);
    }
}
