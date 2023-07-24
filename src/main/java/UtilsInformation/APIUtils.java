package UtilsInformation;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.specification.RequestSpecification;

import java.io.*;
import java.util.Properties;

public class APIUtils {
    RequestSpecification req;
    public RequestSpecification requestBuilder() throws IOException {
        PrintStream stream = new PrintStream(new FileOutputStream("src/test/resources/loggingFile/logRunTimeFile.log"));
        req = new RequestSpecBuilder().
                setBaseUri(getGlobalProp("baseURl")).
                addFilter(RequestLoggingFilter.logRequestTo(stream)).
                addFilter(
                        RequestLoggingFilter.logRequestTo(stream)
                ).build();
        return req;
    }

    public static String getGlobalProp(String key) throws IOException {
        Properties p = new Properties();
        FileInputStream file = new FileInputStream("src/main/resources/global.properties");
        p.load(file);
        return p.getProperty(key);
    }

}
