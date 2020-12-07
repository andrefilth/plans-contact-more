package br.com.vivo.api.plans;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.enableLoggingOfRequestAndResponseIfValidationFails;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

/**
 * Class comments go here...
 *
 * @author André Franco
 * @version 1.0 05/12/2020
 */
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class BaseTest {

    public static final String path = "/api";
    @Value("http://localhost:${local.server.port}")
    protected String baseUri;
    @BeforeEach
    public void init(){
        baseURI = baseUri;
        basePath = path;
        enableLoggingOfRequestAndResponseIfValidationFails();
        // deleteAllDataBases
    }
}
