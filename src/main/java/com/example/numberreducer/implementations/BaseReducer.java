package com.example.numberreducer.implementations;

import com.example.numberreducer.dtos.ResultDTO;
import com.example.numberreducer.dtos.SampleDTO;

import java.time.LocalDateTime;

public abstract class BaseReducer {

    /**
     * Processes a sample and returns the result
     *
     * @param sample - SampleDTO with the sample and meta data about it
     * @return ResultDTO
     */
    public ResultDTO process(SampleDTO sample) {

        LocalDateTime startTime = LocalDateTime.now();

        int iterations = 0;
        Integer currentValue = sample.getValue();

        while ( !isFinal(currentValue) ) {
            currentValue = processNumber(currentValue);
            iterations++;
        }

        return ResultDTO.newBuilder()
                            .withNumberOfReductions(iterations)
                            .withFinalResult(currentValue)
                            .withStartTime(startTime.toString())
                            .withProcessCompleteTime(LocalDateTime.now().toString())
                            .withSample(sample)
                            .build();
    }

    /**
     * Each implementation will provide it own version of how to process the number
     *
     * @param value
     * @return reduced value or original value if no reduction necessary
     */
    protected abstract Integer processNumber(Integer value);


    /**
     * Checks to see if the value meets the final value criteria
     *
     * @param value
     * @return true - value is final
     */
    protected Boolean isFinal(Integer value) {
        return value < 10;
    }
}
