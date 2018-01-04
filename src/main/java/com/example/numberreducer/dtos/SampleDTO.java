package com.example.numberreducer.dtos;

import com.example.numberreducer.display.DisplayVisitor;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO class for moving around a sample
 */
public class SampleDTO implements Visitable, Serializable {

    private static final long serialVersionUID = -2661954469717455385L;

    private UUID sampleUUID;
    private String owner;
    private String submitTime;
    private Integer value;

    //*******************
    //*  GETTER/SETTER
    //*******************

    public String getOwner() {
        return owner;
    }

    public String getSubmitTime() {
        return submitTime;
    }

    public Integer getValue() {
        return value;
    }

    public UUID getSampleUUID() {
        return sampleUUID;
    }

    //*******************
    //*  VISITORS
    //*******************

    @Override
    public String accept(DisplayVisitor visitor) {
        return visitor.visit(this);
    }

    //************************
    //*  BUILDER
    //************************
    public static Builder newBuilder() { return new Builder(); }


    public static final class Builder {
        private UUID sampleUUID;
        private String owner;
        private String submitTime;
        private Integer value;

        private Builder() {
        }

        public static Builder aSampleDTO() {
            return new Builder();
        }

        public Builder withSampleUUID(UUID sampleUUID) {
            this.sampleUUID = sampleUUID;
            return this;
        }

        public Builder withOwner(String owner) {
            this.owner = owner;
            return this;
        }

        public Builder withSubmitTime(String submitTime) {
            this.submitTime = submitTime;
            return this;
        }

        public Builder withValue(Integer value) {
            this.value = value;
            return this;
        }

        public SampleDTO build() {
            SampleDTO sampleDTO = new SampleDTO();
            sampleDTO.submitTime = this.submitTime;
            sampleDTO.sampleUUID = this.sampleUUID;
            sampleDTO.value = this.value;
            sampleDTO.owner = this.owner;
            return sampleDTO;
        }
    }
}
