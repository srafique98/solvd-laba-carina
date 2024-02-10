package com.solvd.carinaexample.api.lecture;

import com.solvd.carinaexample.api.lecture.GetUserByUsername;
import com.solvd.carinaexample.api.lecture.domain.User;
import com.zebrunner.carina.api.apitools.validation.JsonComparatorContext;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;

public class UserTest {
    @DataProvider(name = "userNames")
    public Object[][] userNames() {
        return new Object[][] {
                {"brutskov","Bahdan","Rutskou","Solvd Inc."}, // has to be exactly like json values b4 putting ${user.company}
//                {"v", "blah", "nope","none"}
        };
    }

    // after running verifyGetUserByUserNameTest method
    // we have no body for GET request -- Body:			<none>
    // many headers for response
    // & have response body
    @Test(description = "verifies users", dataProvider = "userNames")
    public void verifyGetUserByUserNameTest(String userName, String firstName,String lastName, String company){
        User user = new User();
        user.setUsername(userName);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setCompany(company);
        GetUserByUsername getUserByUsername = new GetUserByUsername(user.getUsername());

        getUserByUsername.addProperty("user", user); // user.firstName in get_user_rs.json -- key is user
                                                    // value is object
        // property is last parameter for super(null,"src/test/resources/api/users/get_user_rs.json"); in GetUserByUsername class

        // each response has http code and we are checking if response was successful
        getUserByUsername.expectResponseStatus(HttpResponseStatusType.OK_200);
        //sending request and validate response
        getUserByUsername.callAPI();

        JsonComparatorContext comparatorContext = JsonComparatorContext.context()
                .<String>withPredicate("datePredicate", date -> isDateValid(date) &&
                        ZonedDateTime.parse(date) // "2024-01-25T10:35:32Z" has Z at end so using ZonedDateTime
                                .isAfter(LocalDate.of(2000,1,1)
                                        .atStartOfDay(ZoneId.systemDefault())));
                                    // .withPredicate is generic.. check by command then click

        // blank is fine but we want to use predicate -- "updated_at": "predicate:datePredicate" (in json file)
        getUserByUsername.validateResponse(comparatorContext);

    }

    private static boolean isDateValid(String date){
        try {
            ZonedDateTime.parse(date);
            return true;
        }catch (DateTimeParseException e){
            return false;
        }
    }
}
