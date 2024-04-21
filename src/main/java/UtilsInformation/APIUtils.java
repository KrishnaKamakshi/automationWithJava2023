package UtilsInformation;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.specification.RequestSpecification;

import java.io.*;
import java.util.Properties;

public class APIUtils {
    RequestSpecification req;

    public RequestSpecification requestBuilder(String keyName) throws IOException {
        PrintStream stream = new PrintStream(new FileOutputStream("src/test/resources/loggingFile/logRunTimeFile.log"));
        if (req == null) {
            req = new RequestSpecBuilder().
                    setBaseUri(getGlobalProp(keyName)).
                    addFilter(RequestLoggingFilter.logRequestTo(stream)).
                    addFilter(
                            RequestLoggingFilter.logRequestTo(stream)
                    ).build();
            return req;
        }
        return req;
    }
    public static String getGlobalProp(String key) throws IOException {
        Properties p = new Properties();
        FileInputStream file = new FileInputStream("src/main/resources/global.properties");
        p.load(file);
        return p.getProperty(key);
    }
}
