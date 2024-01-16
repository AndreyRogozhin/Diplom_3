package org.example.apiobject;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.example.apiobject.Credentials;
import org.example.apiobject.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import org.hamcrest.MatcherAssert;


public class UserClient {


    private String BASE_URL = "https://stellarburgers.nomoreparties.site";
    private String CREATE_URL = "/api/auth/register";
    private String LOGIN_URL = "/api/auth/login";
    private String EDIT_URL = "/api/auth/user";
    private String ORDERS_URL = "/api/orders";
    private String INGREDIENTS_URL = "/api/ingredients";

@Step("Создание пользователя {user}")
    public Response create (User user){
    Response response  =        given()
                    .header("Content-type", "application/json")
                    .body(user)
                    .when()
                    .post(CREATE_URL);

    return response;
    }




    @Step ("Авторизация пользователя с учётными данными {credentials}")
    public Response login (Credentials credentials/*, String token*/ ) {
        Response response =  given()
                .header("Content-type", "application/json")
                //.header("accessToken", token)
                .body(credentials)
                .when()
                .post(LOGIN_URL);

        return response;
    }

    @Step ("Получение данных пользователя")
    public Response read ( Credentials credentials, String token ) {
        Response response= given()
                .header("Content-type", "application/json")
                .header("Authorization", token)
                .body(credentials)
                .when()
                .get(EDIT_URL);

        return  response;
    }


    @Step ("Удаление клиента")
    public Response delete(String token) {

        Response response =  given()
                .header("Content-type", "application/json")
                .header("Authorization", token)
                .when()
                .delete(EDIT_URL);
				
		return response;
		
    }


}
