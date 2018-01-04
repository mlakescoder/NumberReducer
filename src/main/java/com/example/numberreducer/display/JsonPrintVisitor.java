package com.example.numberreducer.display;

import com.example.numberreducer.dtos.ResultDTO;
import com.example.numberreducer.dtos.SampleDTO;
import com.google.gson.Gson;

public class JsonPrintVisitor implements DisplayVisitor {

    @Override
    public String visit(ResultDTO result) {
        // User Gson to serialize to json
        Gson gson = new Gson();

        return gson.toJson(result);
    }

    @Override
    public String visit(SampleDTO sample) {
        Gson gson = new Gson();

        return gson.toJson(sample);
    }
}
