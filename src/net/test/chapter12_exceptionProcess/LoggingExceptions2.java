package net.test.chapter12_exceptionProcess;

import java.util.logging.*;
import java.io.*;

public class LoggingExceptions2 {
    private static Logger log = Logger.getLogger(LoggingExceptions2.class.getName());
    public static void loggingException(Exception e)
    {
        StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw));
        log.severe(sw.toString());
    }
    public static void main(String[] args)
    {
        try {
            throw new NullPointerException();
        } catch (Exception e) {
            loggingException(e);
        }
    }
}
