package com.example.numberreducer.display;

import com.example.numberreducer.dtos.ResultDTO;
import com.example.numberreducer.dtos.SampleDTO;

public interface DisplayVisitor {

    String visit(ResultDTO result);

    String visit(SampleDTO sample);
}
