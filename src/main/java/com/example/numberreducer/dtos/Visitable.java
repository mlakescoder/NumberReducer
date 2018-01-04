package com.example.numberreducer.dtos;

import com.example.numberreducer.display.DisplayVisitor;

/**
 * Interface to visit the different elements.
 */
public interface Visitable {
    /**
     * Accepts different kinds of display visitors
     * @param visitor
     * @return string containing the output requested as created by the implementation
     */
    String accept(DisplayVisitor visitor);
}
