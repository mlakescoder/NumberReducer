package com.example.numberreducer.dtos;

import com.example.numberreducer.Display.IDisplayVisitor;

import java.io.Serializable;

public class ResultDTO implements Visitable, Serializable{


    private static final long serialVersionUID = -4214478210884059302L;

    private String startTime;
    private SampleDTO sample;
    private String processCompleteTime;
    private Integer numberOfReductions;
    private Integer finalResult;

    //*******************
    //*  GETTER/SETTER
    //*******************

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public SampleDTO getSample() {
        return sample;
    }

    public void setSample(SampleDTO sample) {
        this.sample = sample;
    }

    public String getProcessCompleteTime() {
        return processCompleteTime;
    }

    public void setProcessCompleteTime(String processCompleteTime) {
        this.processCompleteTime = processCompleteTime;
    }

    public Integer getNumberOfReductions() {
        return numberOfReductions;
    }

    public void setNumberOfReductions(Integer numberOfReductions) {
        this.numberOfReductions = numberOfReductions;
    }

    public Integer getFinalResult() {
        return finalResult;
    }

    public void setFinalResult(Integer finalResult) {
        this.finalResult = finalResult;
    }

    //*******************
    //*  VISITORS
    //*******************

    @Override
    public String accept(IDisplayVisitor visitor) {
        return visitor.visit(this);
    }

    //*******************
    //*  BUILDER
    //*******************

    public static Builder newBuilder() { return new Builder(); }


    public static final class Builder {
        private String startTime;
        private SampleDTO sample;
        private String processCompleteTime;
        private Integer numberOfReductions;
        private Integer finalResult;

        private Builder() {
        }

        public static Builder aResultDTO() {
            return new Builder();
        }

        public Builder withStartTime(String startTime) {
            this.startTime = startTime;
            return this;
        }

        public Builder withSample(SampleDTO sample) {
            this.sample = sample;
            return this;
        }

        public Builder withProcessCompleteTime(String processCompleteTime) {
            this.processCompleteTime = processCompleteTime;
            return this;
        }

        public Builder withNumberOfReductions(Integer numberOfReductions) {
            this.numberOfReductions = numberOfReductions;
            return this;
        }

        public Builder withFinalResult(Integer finalResult) {
            this.finalResult = finalResult;
            return this;
        }

        public ResultDTO build() {
            ResultDTO resultDTO = new ResultDTO();
            resultDTO.setStartTime(startTime);
            resultDTO.setSample(sample);
            resultDTO.setProcessCompleteTime(processCompleteTime);
            resultDTO.setNumberOfReductions(numberOfReductions);
            resultDTO.setFinalResult(finalResult);
            return resultDTO;
        }
    }
}
