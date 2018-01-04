package com.example.numberreducer.implementations;

import com.example.numberreducer.api.NumberReducer;

public class NumberReducerFactory {

    public enum NUMBER_REDUCER {
        BYTE_BASED, MATH_BASED
    }

    /**
     * Return the implementation that the user asked for
     *
     * @param reducerType - the type of the reducer desired
     * @return
     */
    public static NumberReducer getNumberReducer(NUMBER_REDUCER reducerType){
        if(reducerType == null){
            throw new IllegalArgumentException("Reducer Type not specified");
        }
        if(reducerType.equals(NUMBER_REDUCER.BYTE_BASED)){
            return new ByteBaseReducer();

        } else if(reducerType.equals(NUMBER_REDUCER.MATH_BASED)){
            return new MathBaseReducer();

        }

        throw new IllegalArgumentException("Reducer Type: " + reducerType.toString() + " is unknown");
    }
}
