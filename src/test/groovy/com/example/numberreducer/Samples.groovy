package com.example.numberreducer

/**
 * Create a set of test values to use in testing.
 *
 */
class Samples {
    // Map of input to its associated result
    Map<Integer, Integer> zeroPassSamples = new HashMap<>();
    Map<Integer, Integer> onePassSamples  = new HashMap<>();
    Map<Integer, Integer> twoPassSamples = new HashMap<>();

    // Map of sample set by name to the associated samples set
    Map<String, Map<Integer, Integer>> samples = new HashMap<>();

    Samples() {
        createZeroPassSamples()
        createOnePassSamples()
        createTwoPassSamples()
    }

    public Map<String, Map<Integer, Integer>> getSampleSet() {
        return samples;
    }

    private void createZeroPassSamples() {

        Integer sample1 = 0
        Integer sample2 = 7
        Integer sample3 = 9

        zeroPassSamples = new HashMap<>();
        zeroPassSamples.put(sample1, sample1)
        zeroPassSamples.put(sample2, sample2)
        zeroPassSamples.put(sample3, sample3)

        samples.put("zero", zeroPassSamples)
    }

    private void createOnePassSamples() {

        Integer sample1 = 10;
        Integer sample2 = 234;
        Integer sample3 = 111111111;

        onePassSamples = new HashMap<>();
        onePassSamples.put(sample1, 1)
        onePassSamples.put(sample2, 9)
        onePassSamples.put(sample3, 9)

        samples.put("one", onePassSamples)
    }

    private void createTwoPassSamples() {

        Integer sample1 = 19;
        Integer sample2 = 99;
        Integer sample3 = 1111111111;

        twoPassSamples = new HashMap<>();
        twoPassSamples.put(sample1, 1)
        twoPassSamples.put(sample2, 9)
        twoPassSamples.put(sample3, 1)

        samples.put("two", twoPassSamples)
    }

}
