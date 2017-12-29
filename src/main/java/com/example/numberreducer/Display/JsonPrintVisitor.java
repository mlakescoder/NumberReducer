package com.example.numberreducer.Display;

import com.example.numberreducer.dtos.ResultDTO;
import com.example.numberreducer.dtos.SampleDTO;

public class JsonPrintVisitor implements IDisplayVisitor {
    final String QUOTE = "\"";
    final String COLON = ":";
    final String COMMA = ",";

    @Override
    public String visit(ResultDTO result) {

        // There are libraries out there that will do json conversion but
        //  I am just demo'ing the visitor pattern here so I will roll my own
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        sb.append(QUOTE + "StartTime"  + QUOTE + COLON + QUOTE + result.getStartTime() + QUOTE + COMMA);
        sb.append(QUOTE + "CompleteTime" + QUOTE + COLON + QUOTE + result.getProcessCompleteTime() + QUOTE + COMMA);
        sb.append(QUOTE + "ReducedValue" + QUOTE + COLON + QUOTE + result.getFinalResult().toString() + QUOTE + COMMA);
        sb.append(QUOTE + "Iterations" + QUOTE + COLON + QUOTE + result.getNumberOfReductions().toString() + QUOTE + COMMA);
        sb.append(QUOTE + "Sample" + QUOTE + COLON + visit(result.getSample()));
        sb.append("}");
        return sb.toString();
    }

    @Override
    public String visit(SampleDTO sample) {
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        sb.append(QUOTE + "SampleUUID" + QUOTE + COLON + QUOTE + sample.getSampleUUID() + QUOTE + COMMA);
        sb.append(QUOTE + "SubmitTime" + QUOTE + COLON + QUOTE + sample.getSubmitTime() + QUOTE + COMMA);
        sb.append(QUOTE + "Value" + QUOTE + COLON + QUOTE + sample.getValue().toString() + QUOTE);
        sb.append("}");
        return sb.toString();
    }
}
