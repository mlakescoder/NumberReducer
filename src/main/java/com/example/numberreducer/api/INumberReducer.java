package com.example.numberreducer.api;

import com.example.numberreducer.dtos.ResultDTO;
import com.example.numberreducer.dtos.SampleDTO;

public interface INumberReducer {
    /**
     * Process a sample and return a Result
     * @param sampleDTO
     * @return ResultDTO
     */
    public ResultDTO process(SampleDTO sampleDTO);

}
