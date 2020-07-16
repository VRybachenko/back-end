package com.brainacad;

import java.util.Map;

import com.jayway.jsonpath.JsonPath;

public class JsonUtils {
    //TODO: Используя библиотеку com.jayway.jsonpath (Maven) напишите метод извлечения строки из JSON по JSON Path:

    public static String stringFromJSONByPath(String json, String jsonPath) {
        //ReadContext ctx = JsonPath.parse(json);
        Object jsonPathResult = JsonPath.read(json, jsonPath);
        //String jsonPathResult = JsonPath.read(json,jsonPath);
        return jsonPathResult.toString();
    }


    //TODO: Используя библиотеку com.jayway.jsonpath (Maven) напишите метод извлечения int из JSON по JSON Path:

    public static int intFromJSONByPath(String json, String jsonPath) {
        Integer jsonPathResult = JsonPath.read(json, jsonPath);

        return jsonPathResult;
    }


    //TODO: Используя библиотеку com.jayway.jsonpath (Maven) напишите метод извлечения double из JSON по JSON Path:
    /*
    public static double doubleFromJSONByPath(String json, String jsonPath){
    }
    */

    //TODO: Используя библиотеку com.jayway.jsonpath (Maven) напишите метод извлечения списка (List) из JSON по JSON Path:
    /*
    public static List listFromJSONByPath(String json, String jsonPath){
    }
    */

}
