package com.solvd.carinaexample.api.assignment;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.solvd.carinaexample.api.assignment.domain.Info;
import com.solvd.carinaexample.api.assignment.domain.UserApiResponse;
import com.solvd.carinaexample.api.assignment.domain.RandomUser;
import com.solvd.carinaexample.api.lecture.GetUserByUsername;
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
        String jsonFilePath = "src/test/resources/api/random-user/get_random_user_rs_results.json";
        try {
            String jsonContent = new String(Files.readAllBytes(Paths.get(jsonFilePath)));
//            System.out.println("JSON Content: " + jsonContent);
            ObjectMapper objectMapper = new ObjectMapper();
             this.userApiResponse = objectMapper.readValue(jsonContent, UserApiResponse.class);

//            // Access the mapped data
//            System.out.println("Results:");
//            for (RandomUser randomUser : this.userApiResponse.getResults()) {
//                System.out.println("Gender: " + randomUser.getGender());
//                System.out.println("Name: " + randomUser.getName().getTitle() + " " + randomUser.getName().getFirst() + " " + randomUser.getName().getLast());
//                System.out.println("Email: " + randomUser.getEmail());
//                System.out.println("Date of Birth: " + randomUser.getDateOfBirth().getDate() + ", Age: " + randomUser.getDateOfBirth().getAge());
//                System.out.println("Phone: " + randomUser.getPhone());
//                System.out.println("Cell: " + randomUser.getCell());
//                System.out.println("Nationality: " + randomUser.getNat());
//                System.out.println("-----------------------");
//            }
//
//            System.out.println("Info:");
//            Info info = this.userApiResponse.getInfo();
//            System.out.println("Seed: " + info.getSeed());
//            System.out.println("Results: " + info.getResults());
//            System.out.println("Page: " + info.getPage());
//            System.out.println("Version: " + info.getVersion());

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
//        System.out.println("Seed --> " + seed);
//        System.out.println(userApiResponse.getResults().get(0));
//
//        GetRandomUser getRandomUser = new GetRandomUser(userApiResponse.getInfo().getSeed());
//
//        getRandomUser.addProperty("randomuser", userApiResponse); // user.firstName in get_user_rs.json -- key is user
//        // value is object
//        // property is last parameter for super(null,"src/test/resources/api/users/get_user_rs.json"); in GetUserByUsername class
//
//        // each response has http code and we are checking if response was successful
//        getRandomUser.expectResponseStatus(HttpResponseStatusType.OK_200);
//        //sending request and validate response
//        getRandomUser.callAPI();

        RandomUser randomUser = userApiResponse.getResults().get(0);
        GetRandomUser getRandomUser = new GetRandomUser(seed);
        getRandomUser.addProperty("randomuser", randomUser);
        getRandomUser.addProperty("name", randomUser.getName());
        getRandomUser.addProperty("dateofbirth", randomUser.getDateOfBirth());
        getRandomUser.expectResponseStatus(HttpResponseStatusType.OK_200);
        System.out.println("Nieee --> ");
        getRandomUser.callAPI();

        // Validate the response using Carina's JSON validation capabilities
//        JsonComparatorContext comparatorContext = new JsonComparatorContext();
//        comparatorContext.withIgnoreDefaults();
        getRandomUser.validateResponse();

//        assertThat(userApiResponse.getResults().get(0).getGender(), equalTo("male"));
//        assertThat(userApiResponse.getResults().get(0).getEmail(), equalTo("dustin.watts@example.com"));

    }
}
