package co.com.sofka.stepdefinition;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.apache.log4j.PropertyConfigurator;

import static co.com.sofka.util.Log4jValues.LOG4J_PROPERTIES_FILE_PATH;
import static io.cucumber.messages.internal.com.google.common.base.StandardSystemProperty.USER_DIR;

public class Reqresin {
    private static final String BASE_URL="https://reqres.in/";
    private static final String BASE_PATH="api/";
    protected static final String RESOURCE_GET="/users/2";
    protected static final String RESOURCE_DELETE="/users/2";


    protected void generalSetUp(){
        setUplog4j();
        configurationForRestAssured();

    }
    private void configurationForRestAssured(){
        RestAssured.baseURI=BASE_URL;
        RestAssured.basePath=BASE_PATH;
        RestAssured.filters(new RequestLoggingFilter(),new ResponseLoggingFilter(), new ErrorLoggingFilter());
        RestAssured.requestSpecification=new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .build();
    }
    //LOG4J

    private void setUplog4j(){
        PropertyConfigurator.configure(USER_DIR.value() + LOG4J_PROPERTIES_FILE_PATH.getValue());
    }

}
