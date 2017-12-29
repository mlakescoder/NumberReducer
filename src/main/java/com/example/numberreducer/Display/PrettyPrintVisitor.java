package com.example.numberreducer.Display;

import com.example.numberreducer.dtos.ResultDTO;
import com.example.numberreducer.dtos.SampleDTO;

public class PrettyPrintVisitor implements IDisplayVisitor {
    private final String CR = System.lineSeparator();

    @Override
    public String visit(ResultDTO result) {
        StringBuffer sb = new StringBuffer();
        sb.append("============Result=================================" + CR);
        sb.append("Sample UUID:   " + result.getSample().getSampleUUID() + CR);
        sb.append("Start Time:    " + result.getStartTime() + CR);
        sb.append("Complete Time: " + result.getProcessCompleteTime() + CR);
        sb.append("Input Value:   " + result.getSample().getValue().toString() + CR);
        sb.append("Reduced Value: " + result.getFinalResult().toString() + CR);
        sb.append("Iterations:    " + result.getNumberOfReductions().toString() + CR);
        sb.append("====================================================" + CR);
        return sb.toString();
    }

    @Override
    public String visit(SampleDTO sample) {
        StringBuffer sb = new StringBuffer();
        sb.append("**************Sample********************************" + CR);
        sb.append("Sample UUID:   " + sample.getSampleUUID().toString() + CR);
        sb.append("Time Submitted:" + sample.getSubmitTime() + CR);
        sb.append("Value:         " + sample.getValue().toString() + CR);
        sb.append("----------------------------------------------------" + CR);
        return sb.toString();
    }
}
