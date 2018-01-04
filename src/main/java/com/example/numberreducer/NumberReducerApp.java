package com.example.numberreducer;
import com.example.numberreducer.display.DisplayVisitorFactory;
import com.example.numberreducer.display.DisplayVisitor;
import com.example.numberreducer.api.NumberReducer;
import com.example.numberreducer.dtos.ResultDTO;
import com.example.numberreducer.dtos.SampleDTO;
import com.example.numberreducer.implementations.NumberReducerFactory;
import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.kohsuke.args4j.ExampleMode.ALL;

public class NumberReducerApp {
    //TODO: Add logging with log4j
    //final static Logger LOGGER = Logger.getLogger(NumberReducerApp.class.getName());

    // Implementations based on what the user specified
    private NumberReducer numberReducer;

    private DisplayVisitor displayVisitor;

    //*************************************************************************************************
    //*  Arg4j Argument Specification
    //*
    //*  NOTE: I haven't used args4j before but it provides similar functionality of other cmdline options
    //*        parsers that I have used in c++, C and python, with the benefits of annotations,
    //*        so I used it here
    //*************************************************************************************************

    @Option(name="-t", usage="specifies the type of reducer")
    private NumberReducerFactory.NUMBER_REDUCER reducerType;

    @Option(name="-d", usage="specifies how to display the result")
    private DisplayVisitorFactory.DISPLAY_TYPE displayType;

    @Argument
    private List<String> arguments = new ArrayList<>();




    /**
     * Main function.  Run application with no parameters to see usage
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            NumberReducerApp app = new NumberReducerApp();
            app.processArgs(args);
            app.process();
        } catch ( Exception e ) {
            System.err.println("Exception encountered: " + e);
        }
    }

    /**
     * Process the arguments passed in from the user, check syntax and if good
     *  create necessary classes in preparation to do work
     *
     * @param args
     * @throws IOException
     */
    private void processArgs(String[] args) throws IOException {
        CmdLineParser parser = new CmdLineParser(this);

        parser.setUsageWidth(80);

        try {
            // parse the arguments.
            parser.parseArgument(args);

            if( arguments.isEmpty() )
                throw new CmdLineException(parser,"No input values given");

            if ( reducerType == null )
                throw new CmdLineException(parser,"Reducer type was not specified");

            if ( displayType == null )
                throw new CmdLineException(parser,"display type was not specified");

            // Check the arguments are valid
            for( String arg : arguments ) {
                try {
                    Integer.parseInt(arg);
                } catch ( Exception e ) {
                    System.err.println("Value " + arg + " is invalid");
                    throw e;
                }
            }

        } catch( CmdLineException e ) {
            // Problem processing cmdline,
            System.err.println("Error:");
            System.err.println("   " + e.getMessage());
            System.err.println();
            System.err.println("------------------------------------------------------");
            System.err.println("java NumberReducerApp [options...] arguments...");

            // print the list of available options
            parser.printUsage(System.err);
            System.err.println();

            // print option sample.
            System.err.println("  Example: java NumberReducerApp " + parser.printExample(ALL));

            System.exit(1);
        }

        //********************************************************************************
        //* All good, ask the factories for the implementations that the user specified
        //********************************************************************************

        numberReducer = NumberReducerFactory.getNumberReducer(reducerType);

        displayVisitor = DisplayVisitorFactory.getDisplayVisitor(displayType);
    }

    /**
     * Process the input values that were given
     */
    private void process() {
        List<ResultDTO> results = new ArrayList<>();

        for( String s : arguments ) {
            System.out.println("Processing value: " + s);
            ResultDTO resultDTO = process(Integer.parseInt(s));
            results.add(resultDTO);
            System.out.println(resultDTO.accept(displayVisitor));

        }

        System.out.println("Processing complete");

    }

    /**
     * Create a sample for the given value and process it
     *
     * @param value
     */
    private ResultDTO process(Integer value) {
        SampleDTO sampleDTO = SampleDTO.newBuilder()
                                            .withSampleUUID(UUID.randomUUID())
                                            .withSubmitTime(LocalDateTime.now().toString())
                                            .withValue(value)
                                            .build();

        return process(sampleDTO);


    }

    /**
     * Process a sample
     *
     * @param sampleDTO
     * @return
     */
    private ResultDTO process(SampleDTO sampleDTO) {
        return numberReducer.process(sampleDTO);
    }
}
