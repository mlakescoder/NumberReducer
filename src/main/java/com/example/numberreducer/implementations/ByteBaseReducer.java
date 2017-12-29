package com.example.numberreducer.implementations;

import com.example.numberreducer.api.INumberReducer;
import com.example.numberreducer.dtos.ResultDTO;
import com.example.numberreducer.dtos.SampleDTO;

import java.math.BigInteger;
import java.time.LocalDateTime;

public class ByteBaseReducer extends BaseReducer implements INumberReducer {

    /**
     * Split the number by getting each char of the string that represents it
     *
     * @param value
     * @return
     */
    @Override
    protected Integer processNumber(Integer value) {
        // Split the string into chars, convert to value and store to array
        int[] digits = Integer.toString(value).chars().map(c -> c -= '0').toArray();

        return processNumber(digits);
    }

    /**
     * Process an array of digits into a a reduced number based on rule of adding the
     * digits together
     *
     * @param digits - array of digits to be processed
     * @return
     */
    private Integer processNumber(int[] digits) {
        Integer value = 0;

        // Add each of the digits together
        for ( int digit : digits ) {
            value += digit;
        }

        return value;

    }
}
