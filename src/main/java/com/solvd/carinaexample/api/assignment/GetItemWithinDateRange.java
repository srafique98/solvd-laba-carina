package com.solvd.carinaexample.api.assignment;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.apitools.builder.NotStringValuesProcessor;
import com.zebrunner.carina.api.http.HttpMethodType;

@Endpoint(url = "${config.cart_url}/carts?${date_range}", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/random-user/get_item_within_date_range.json")
public class GetItemWithinDateRange extends AbstractApiMethodV2 {
    public GetItemWithinDateRange(String dateRange) {
        replaceUrlPlaceholder("date_range", dateRange);
        ignorePropertiesProcessor(NotStringValuesProcessor.class);

    }
}
