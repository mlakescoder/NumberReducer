package com.example.numberreducer.Display;

import com.example.numberreducer.dtos.ResultDTO;
import com.example.numberreducer.dtos.SampleDTO;

public interface IDisplayVisitor {

    String visit(ResultDTO result);

    String visit(SampleDTO sample);
}
