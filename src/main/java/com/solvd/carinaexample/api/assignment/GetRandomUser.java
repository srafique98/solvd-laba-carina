package com.solvd.carinaexample.api.assignment;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.api.http.HttpMethodType;

@Endpoint(url = "${config.random_user_url}/api/1.4/${config.parameters}&seed=${seed}", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/random-user/get_random_user_rs.json")
public class GetRandomUser extends AbstractApiMethodV2 {
    public GetRandomUser(String seed) {
        replaceUrlPlaceholder("seed", seed);
        ignorePropertiesProcessor(NotStringValuesProcessor.class);

    }
}
