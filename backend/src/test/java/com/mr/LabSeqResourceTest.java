package com.mr;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class LabSeqResourceTest {
    public static final String ROUTE = "/labseq/";

    @Test
    void testInvalidParameter() {
        given()
                .when().get(ROUTE+"-1")
                .then()
                .statusCode(400)
                .body(is("Parameter must be greater or equal to 0 and lower than 100000."));
    }
    @Test
    void test0() {
        given()
                .when().get(ROUTE+"0")
                .then()
                .statusCode(200)
                .body(is("0"));
    }
    @Test
    void test1() {
        given()
                .when().get(ROUTE+"1")
                .then()
                .statusCode(200)
                .body(is("1"));
    }
    @Test
    void test2() {
        given()
                .when().get(ROUTE+"2")
                .then()
                .statusCode(200)
                .body(is("0"));
    }
    @Test
    void test3() {
        given()
                .when().get(ROUTE+"3")
                .then()
                .statusCode(200)
                .body(is("1"));
    }
    @Test
    void test4() {
        given()
                .when().get(ROUTE+"3")
                .then()
                .statusCode(200)
                .body(is("1"));
    }
    @Test
    void test7() {
        given()
                .when().get(ROUTE+"7")
                .then()
                .statusCode(200)
                .body(is("2"));
    }
    @Test
    void test10000() {
        given()
          .when().get(ROUTE+"10000")
          .then()
             .statusCode(200)
             .body(is("69950566878097184013157744477635556727868849589082998911839343197880823215346221009722233023943602770307729191665655398407165768121564186987192397693071609846919453430811144389823875683774480880281479951416523467736343974525549960389427464841013320746241755697990287429747307066048835194835534301361435435171244963037487135503198565459610125773779110841477593382691667903942271834984619627946845583317271714790127086723614783681640902031022970893247841818337935296805019561967546398282596597404334400595273408222818081762762981879844447410743730739725556081175617700994424267694361314464204552899258977619983936670456553201627025301979470684612183482967552781789171894406131379502874476544298881442363169258726593616997962614541232149734611181684936265928412294383549494959124156102645749161099774806409315657803977415799277767229630141831326718534674913706653355139"));
    }
}