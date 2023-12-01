package pl.akademiaqa.requests;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import pl.akademiaqa.url.ClickUpUrl;
import pl.akademiaqa.url.propertise.ClickUpProperties;

public class BaseRequest {

    private static RequestSpecBuilder requestBuilder;

    public static RequestSpecification requestSpec() {
        requestBuilder = new RequestSpecBuilder();
        requestBuilder.setBaseUri(ClickUpUrl.getBaseUrl()); //pozwala nam to zmienjszyc ilość kodu w clickupurl klasie
        // -> w każdym requeście będziemy mieć basowy url wywołany request builderem, podajemy w metadach w clickupurl tylko endpointy
        requestBuilder.setContentType(ContentType.JSON);
        requestBuilder.addHeader("Authorization", ClickUpProperties.getToken());
        requestBuilder.addFilter(new AllureRestAssured()); //dodanie generowanie raportów

        return requestBuilder.build();

    }

    public static RequestSpecification requestSpecWithLogs() {
        requestBuilder = new RequestSpecBuilder();
        requestBuilder.setBaseUri(ClickUpUrl.getBaseUrl());
        requestBuilder.setContentType(ContentType.JSON);
        requestBuilder.addHeader("Authorization", ClickUpProperties.getToken());
        requestBuilder.addFilter(new RequestLoggingFilter()); //
        requestBuilder.addFilter(new ResponseLoggingFilter());
        requestBuilder.addFilter(new AllureRestAssured());

        return requestBuilder.build();

    }
}
