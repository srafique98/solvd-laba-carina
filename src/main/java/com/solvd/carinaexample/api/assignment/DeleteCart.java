package com.solvd.carinaexample.api.assignment;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.api.http.HttpMethodType;

import java.util.Properties;

@Endpoint(url = "${config.cart_url}/carts/${cartID}", methodType = HttpMethodType.DELETE)
@ResponseTemplatePath(path = "api/random-user/delete_cart_rs.json")
public class DeleteCart extends AbstractApiMethodV2 {
    public DeleteCart(Integer cartID) {
        replaceUrlPlaceholder("cartID", String.valueOf(cartID));
        ignorePropertiesProcessor(NotStringValuesProcessor.class);
    }
}
