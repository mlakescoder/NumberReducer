package com.example.numberreducer

import com.example.numberreducer.dtos.ResultDTO
import com.example.numberreducer.dtos.SampleDTO
import com.example.numberreducer.implementations.MathBaseReducer
import spock.lang.Specification;


/**
 * There is a lot more that groovy can do which I not going into here, but I wanted to keep it
 *  simple.
 *
 * TODO:  Consolidate this spec with ByteBasedReducerSpec such that it loops through implementations
 */
class MathBasedReducerSpec extends Specification {
    MathBaseReducer mathBaseReducer
    Samples sampleSet

    def setup() {
        mathBaseReducer = new MathBaseReducer()
        sampleSet = new Samples()
    }

    def "Process already reduced numbers"() {
        given:
        Map<Integer,Integer> samples = sampleSet.getSamples().get("zero")
        Map<Integer,Integer> results = new HashMap<>()

        when:
        // For each sample in the sample set, process and save the result
        for ( Object key : samples.keySet() ) {
            results.put(key, mathBaseReducer.processNumber(key))
        }

        then:
        // Compare the result to the expected value
        for ( Object key : samples.keySet() ) {
            assert results.get(key).equals(samples.get(key))
        }

    }

    def "Process single pass"() {
        given:
        Map<Integer,Integer> samples = sampleSet.getSamples().get("one")
        Map<Integer,Integer> results = new HashMap<>()

        when:
        // For each sample in the sample set, process and save the result
        for ( Object key : samples.keySet() ) {
            results.put(key, mathBaseReducer.processNumber(key))
        }

        then:
        // Compare the result to the expected value
        for ( Object key : samples.keySet() ) {
            assert results.get(key).equals(samples.get(key))
        }
    }

    def "Process double pass full samples"() {
        given:
        Map<Integer,Integer> samples = sampleSet.getSamples().get("two")
        Map<Integer,ResultDTO> results = new HashMap<>()

        when:
        // For each sample in the sample set, create a sampleDTO and process
        for ( Object key : samples.keySet() ) {
            SampleDTO sample = SampleDTO.newBuilder()
                                            .withValue(key)
                                            .withSampleUUID(UUID.randomUUID())
                                            .build()

            results.put(key, mathBaseReducer.process(sample))
        }

        then:
        // Compare the result to the expected value and check resultDTO
        for ( Object key : samples.keySet() ) {
            ResultDTO resultDTO = results.get(key)

            assert resultDTO.getNumberOfReductions() == 2
            assert resultDTO.getStartTime() != null
            assert resultDTO.getProcessCompleteTime() != null
            assert resultDTO.getSample().getValue() == key
            assert resultDTO.getFinalResult().equals(samples.get(key))
        }
    }

}
