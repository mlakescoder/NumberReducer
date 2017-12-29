package com.example.numberreducer.Display;

public class DisplayVisitorFactory {
    /**
     * The display types that are currently available.
     */
    public enum DISPLAY_TYPE {
        PRETTY_PRINT, JSON
    }

    /**
     * Create the v
     * @param displayType
     * @return
     */
    public static IDisplayVisitor getDisplayVisitor(DISPLAY_TYPE displayType){
        if(displayType == null){
            throw new IllegalArgumentException("Reducer Type not specified");
        }
        if(displayType.equals(DISPLAY_TYPE.PRETTY_PRINT)){
            return new PrettyPrintVisitor();

        } else if(displayType.equals(DISPLAY_TYPE.JSON)){
            return new JsonPrintVisitor();

        }

        throw new IllegalArgumentException("Reducer Type: " + displayType.toString() + " is unknown");
    }
}
