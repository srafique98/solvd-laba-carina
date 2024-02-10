package com.solvd.carinaexample.api.lecture;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${config.api_url}/users/${username}", methodType = HttpMethodType.GET) // Get request
@ResponseTemplatePath(path = "api/users/get_user_rs.json") // post put patch request with body
public class GetUserByUsername extends AbstractApiMethodV2 {
    public GetUserByUsername(String username) {
//        super(null,"api/users/get_user_rs.json"); // don't need this because @ResponseTemplatePath line 11 and addProperty in UserTest.java
//        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        replaceUrlPlaceholder("username", username);

        ignorePropertiesProcessor(NotStringValuesProcessor.class);
    }
}
