package com.example.numberreducer

import com.example.numberreducer.dtos.ResultDTO
import com.example.numberreducer.dtos.SampleDTO
import spock.lang.Specification;
import com.example.numberreducer.implementations.ByteBaseReducer

/**
 * There is a lot more that groovy can do which I not going into here, but I wanted to keep it
 *  simple.
 *
 * TODO:  Consolidate this spec with MathBasedReducerSpec such that it loops through implementations
 */
class ByteBaseReducerSpec extends Specification {
    ByteBaseReducer byteBaseReducer
    Samples sampleSet

    def setup() {
        byteBaseReducer = new ByteBaseReducer()
        sampleSet = new Samples()
    }

    def "Process already reduced numbers"() {
        given:
        Map<Integer,Integer> samples = sampleSet.getSamples().get("zero")
        Map<Integer,Integer> results = new HashMap<>()

        when:
        // For each sample in the sample set, process and save the result
        for ( Object sampleValue : samples.keySet() ) {
            results.put(sampleValue, byteBaseReducer.processNumber(sampleValue))
        }

        then:
        // Compare the result to the expected value
        for ( Object sampleValue : samples.keySet() ) {
            assert results.get(sampleValue).equals(samples.get(sampleValue))
        }

    }

    def "Process single pass"() {
        given:
        Map<Integer,Integer> samples = sampleSet.getSamples().get("one")
        Map<Integer,Integer> results = new HashMap<>()

        when:
        // For each sample in the sample set, process and save the result
        for ( Object sampleValue : samples.keySet() ) {
            results.put(sampleValue, byteBaseReducer.processNumber(sampleValue))
        }

        then:
        // Compare the result to the expected value
        for ( Object sampleValue : samples.keySet() ) {
            assert results.get(sampleValue).equals(samples.get(sampleValue))
        }
    }

    def "Process double pass full samples"() {
        given:
        Map<Integer,Integer> samples = sampleSet.getSamples().get("two")
        Map<Integer,ResultDTO> results = new HashMap<>()

        when:
        // For each sample in the sample set, create a sampleDTO and process
        for ( Object sampleValue : samples.keySet() ) {
            SampleDTO sampleDTO = SampleDTO.newBuilder()
                                            .withValue(sampleValue)
                                            .withSampleUUID(UUID.randomUUID())
                                            .build()

            results.put(sampleValue, byteBaseReducer.process(sampleDTO))
        }

        then:
        // Compare the result to the expected value and check resultDTO
        for ( Object sampleValue : samples.keySet() ) {
            ResultDTO resultDTO = results.get(sampleValue)

            assert resultDTO.getNumberOfReductions() == 2
            assert resultDTO.getStartTime() != null
            assert resultDTO.getProcessCompleteTime() != null
            assert resultDTO.getSample().getValue() == sampleValue
            assert resultDTO.getFinalResult().equals(samples.get(sampleValue))
        }
    }

}