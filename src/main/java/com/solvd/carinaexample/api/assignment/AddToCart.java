package com.solvd.carinaexample.api.assignment;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.api.http.HttpMethodType;

@Endpoint(url = "${config.cart_url}/carts", methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "api/random-user/add_to_cart_rq.json")
@ResponseTemplatePath(path = "api/random-user/add_to_cart_rs.json")
public class AddToCart extends AbstractApiMethodV2{
    public AddToCart() {
        ignorePropertiesProcessor(NotStringValuesProcessor.class);
    }
}
