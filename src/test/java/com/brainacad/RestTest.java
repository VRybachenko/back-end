package com.brainacad;

import org.apache.http.HttpResponse;
import org.junit.Assert;
import org.junit.Test;
import java.io.IOException;


public class RestTest{

    private static final String URL="https://reqres.in/";

    @Test//GET метод
    public void checkGetResponseStatusCode() throws IOException {
        String endpoint="/api/users";
      /*  //TODO: Избавится он хедеров в тесте добавив методы с хедерами по умолчанию в класс HttpClientHelper
        //Создаём переменую headers типа Map
        Map<String, String> headers=new HashMap<>();
        //Добавляем в headers наш заголовок
        headers.put("Content-Type", "application/json");*/

        //Выполняем REST GET запрос с нашими параметрами
        // и сохраняем результат в переменную response.
        HttpResponse response = HttpClientHelper.get(URL+endpoint,"page=2");

        //получаем статус код из ответа
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("Response Code : " + statusCode);
        Assert.assertEquals("Response status code should be 200", 200, statusCode);
    }
    @Test//GET метод
    public void checkGetResponseBodyNotNull() throws IOException {
        String endpoint="/api/users";
        /*//TODO: Избавится он хедеров в тесте добавив методы с хедерами по умолчанию в класс HttpClientHelper
        //Создаём переменую headers типа Map
       // Map<String, String> headers=new HashMap<>();
        //Добавляем в headers наш заголовок
      //  headers.put("Content-Type", "application/json");*/

        //Выполняем REST GET запрос с нашими параметрами
        // и сохраняем результат в переменную response.
        HttpResponse response = HttpClientHelper.get(URL+endpoint,"page=2");

        //Конвертируем входящий поток тела ответа в строку
        String body=HttpClientHelper.getBodyFromResponse(response);
        System.out.println(body);
        Assert.assertNotEquals("Body shouldn't be null", null, body);
    }


    @Test//POST метод
    public void checkPostResponseStatusCode() throws IOException {
        String endpoint="/api/users";
       /* //TODO: Избавится он хедеров в тесте добавив методы с хедерами по умолчанию в класс HttpClientHelper
        //Создаём переменую headers типа Map
        //Map<String, String> headers=new HashMap<>();
        //Добавляем в headers наш заголовок
       // headers.put("Content-Type", "application/json");*/

        //создаём тело запроса
        String requestBody="{\"name\": \"morpheus\",\"job\": \"leader\"}";

        //Выполняем REST POST запрос с нашими параметрами
        // и сохраняем результат в переменную response.
        HttpResponse response = HttpClientHelper.post(URL+endpoint,requestBody);

        //получаем статус код из ответа
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("Response Code : " + statusCode);
        Assert.assertEquals("Response status code should be 201", 201, statusCode);
    }
    @Test//POST метод
    public void checkPostResponseBodyNotNull() throws IOException {
        String endpoint="/api/users";
        /*//TODO: Избавится он хедеров в тесте добавив методы с хедерами по умолчанию в класс HttpClientHelper
        //Создаём переменую headers типа Map
        //Map<String, String> headers=new HashMap<>();
        //Добавляем в headers наш заголовок
        //headers.put("Content-Type", "application/json");*/

        //создаём тело запроса
        String requestBody="{\"name\": \"morpheus\",\"job\": \"leader\"}";

        //Выполняем REST POST запрос с нашими параметрами
        // и сохраняем результат в переменную response.
        HttpResponse response = HttpClientHelper.post(URL+endpoint,requestBody);

        //Конвертируем входящий поток тела ответа в строку
        String body=HttpClientHelper.getBodyFromResponse(response);
        System.out.println(body);
        Assert.assertNotEquals("Body shouldn't be null", null, body);
    }


    @Test//PUT метод
    public void checkPutResponseStatusCode() throws IOException {
        String endpoint="/api/users";
        //создаём тело запроса
        String requestBody="{\"name\": \"TestTestovichPUT\",\"job\": \"QA\"}";
        HttpResponse response = HttpClientHelper.put(URL+endpoint,requestBody);

        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("Response Code : " + statusCode);
        Assert.assertEquals("Response status code should be 200", 200, statusCode);
    }
    @Test//PUT метод
    public void checkPutResponseBodyNotNull () throws IOException {
        String endpoint="/api/users";
        //создаём тело запроса
        String requestBody="{\"name\": \"TestTestovichPUT\",\"job\": \"QA\"}";
        HttpResponse response = HttpClientHelper.put(URL+endpoint,requestBody);

        //Конвертируем входящий поток тела ответа в строку
        String body=HttpClientHelper.getBodyFromResponse(response);
        System.out.println(body);
        Assert.assertNotEquals("Body shouldn't be null", null, body);
    }


    @Test //PATCH метод
    public void checkPatchResponseStatusCode () throws IOException {
        String endpoint = "/api/users/2";
        //создаём тело запроса
        String requestBody="{\"name\": \"TestTestovichPATCH\",\"job\": \"QA\"}";
        HttpResponse response = HttpClientHelper.patch(URL+endpoint,requestBody);

        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("Response Code : " + statusCode);
        Assert.assertEquals("Response status code should be 200", 200, statusCode);
    }
    @Test //PATCH метод
    public void checkPatchResponseBodyNotNull () throws IOException {
        String endpoint = "/api/users/2";
        //создаём тело запроса
        String requestBody="{\"name\": \"TestTestovichPATCH\",\"job\": \"QA\"}";
        HttpResponse response = HttpClientHelper.patch(URL+endpoint,requestBody);

        //Конвертируем входящий поток тела ответа в строку
        String body=HttpClientHelper.getBodyFromResponse(response);
        System.out.println(body);
        Assert.assertNotEquals("Body shouldn't be null", null, body);
    }

    @Test //DELETE метод
    public void checkDeleteResponseStatusCode () throws IOException {
        String endpoint = "/api/users/2";

        HttpResponse response = HttpClientHelper.delete(URL+endpoint);

        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("Response Code : " + statusCode);
        Assert.assertEquals("Response status code should be 204", 204, statusCode);
    }


    //TODO: напишите по тесткейсу на каждый вариант запроса на сайте https://reqres.in
    //TODO: в тескейсах проверьте Result Code и несколько параметров из JSON ответа (если он есть)

}
