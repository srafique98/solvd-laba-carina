package com.solvd.carinaexample.api.assignment;

import com.solvd.carinaexample.api.assignment.domain.DateOfBirth;
import com.solvd.carinaexample.api.assignment.domain.Name;
import com.solvd.carinaexample.api.assignment.domain.UserApiResponse;
import com.solvd.carinaexample.api.assignment.domain.RandomUser;
import com.zebrunner.carina.api.apitools.validation.JsonComparatorContext;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class RandomUserTest {

    private UserApiResponse userApiResponse;
    @BeforeClass
    public void setUp(){
        String jsonFilePath = "src/test/resources/api/random-user/get_random_user_expected_results.json";
        try {
            String jsonContent = new String(Files.readAllBytes(Paths.get(jsonFilePath)));
//            System.out.println("JSON Content: " + jsonContent);
            ObjectMapper objectMapper = new ObjectMapper();
             this.userApiResponse = objectMapper.readValue(jsonContent, UserApiResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @DataProvider(name = "userID")
    public Object[][] userID() {
        return new Object[][]{
                {"90a61cc400c227d0"}
        };
    }

    @Test(dataProvider = "userID")
    public void verifyGetRandomUser(String seed) {
        RandomUser randomUser = userApiResponse.getResults().get(0);
        GetRandomUser getRandomUser = new GetRandomUser(seed);
        getRandomUser.addProperty("randomuser", randomUser);
        getRandomUser.addProperty("name", randomUser.getName());
        getRandomUser.addProperty("dateofbirth", randomUser.getDateOfBirth());
        getRandomUser.expectResponseStatus(HttpResponseStatusType.OK_200);
        System.out.println();
        getRandomUser.callAPI();
        getRandomUser.validateResponse();
    }

}
