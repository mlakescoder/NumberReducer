package com.example.numberreducer.implementations;

import com.example.numberreducer.api.NumberReducer;

public class MathBaseReducer extends BaseReducer implements NumberReducer {


    /**
     * Process the number by dividing by 10 to get each digit
     *
     * @param value - the number to be reduced
     * @return the reduced number (one pass)
     */
    @Override
    protected Integer processNumber(Integer value) {
        Integer reducedValue = 0;
        Integer baseValue = value;
        Integer digit;

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
