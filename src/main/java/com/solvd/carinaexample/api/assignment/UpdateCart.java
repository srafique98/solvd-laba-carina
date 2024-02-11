package com.solvd.carinaexample.api.assignment;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.api.http.HttpMethodType;

@Endpoint(url = "${config.cart_url}/carts/4", methodType = HttpMethodType.PUT)
@RequestTemplatePath(path = "api/random-user/update_cart_rq.json")
@ResponseTemplatePath(path = "api/random-user/update_cart_rs.json")
public class UpdateCart extends AbstractApiMethodV2 {
    public UpdateCart(Integer id) {
        replaceUrlPlaceholder("id", String.valueOf(id));
        ignorePropertiesProcessor(NotStringValuesProcessor.class);

    }
}
