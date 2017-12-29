package com.example.numberreducer.implementations;

import com.example.numberreducer.api.INumberReducer;
import com.example.numberreducer.dtos.ResultDTO;
import com.example.numberreducer.dtos.SampleDTO;

import java.time.LocalDateTime;

public class MathBaseReducer extends BaseReducer implements INumberReducer {


    /**
     * Process the number by dividing by 10 to get each digit
     *
     * @param value
     * @return
     */
    @Override
    protected Integer processNumber(Integer value) {
        Integer reducedValue = 0;
        Integer baseValue = value;
        Integer digit = 0;

        do  {
            if (baseValue > 9) {
                digit = baseValue % 10;
            } else {
                digit = baseValue;
            }

            // Add to the reduced value
            reducedValue += digit;

            // Move to the next digit
            baseValue = baseValue / 10;

        } while ( baseValue > 0 );

        return reducedValue;
    }

}
