package com.brainacad;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpec {
    public static final RequestSpecification REQUEST_SPEC_REGRES_IN =
            new RequestSpecBuilder()
                    .setBaseUri("https://reqres.in")
                    .setContentType(ContentType.JSON)
                    .setBasePath("/api/users?{page}")
                    // .setBasePath("/api/users/{id}")
                    .build();
}
