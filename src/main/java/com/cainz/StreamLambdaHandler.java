package com.cainz;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import java.io.*;
import java.nio.charset.Charset;
import java.util.HashMap;
import com.google.gson.GsonBuilder;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StreamLambdaHandler implements RequestStreamHandler {
    private static final Logger log = LoggerFactory.getLogger(StreamLambdaHandler.class);
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    @Override
    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("US-ASCII")));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream, Charset.forName("US-ASCII"))));
        try
        {
            HashMap event = gson.fromJson(reader, HashMap.class);
            log.info("STREAM TYPE: " + inputStream.getClass().toString());
            log.info("EVENT TYPE: " + event.getClass().toString());
            log.warn("TEST FOR WARN!!");
            log.error("TEST FOR ERROR!!");
            log.info(gson.toJson(event));
            writer.write(gson.toJson(event));
            if (writer.checkError())
            {
                log.info("WARNING: Writer encountered an error.");
            }
        }
        catch (IllegalStateException | JsonSyntaxException exception)
        {
            log.info(exception.toString());
        }
        finally
        {
            reader.close();
            writer.close();
        }
    }
}