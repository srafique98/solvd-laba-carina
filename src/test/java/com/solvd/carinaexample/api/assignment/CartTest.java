package com.solvd.carinaexample.api.assignment;

import com.solvd.carinaexample.api.assignment.domain.Cart;
import com.solvd.carinaexample.api.assignment.domain.Product;
import com.zebrunner.carina.api.apitools.validation.JsonComparatorContext;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class CartTest {
    private Cart cart;
    @BeforeClass
    public void setUp(){
        this.cart = new Cart(4,3,"2020-01-01T00:00:00.000Z",0);
        List<Product> productList = new ArrayList<>();
        Product p1 = new Product(1,4);
        productList.add(p1);
        cart.setProducts(productList);
    }
    @Test(description = "Validating PUT request")
    public void verifyUpdateCart(){
        UpdateCart updateCart = new UpdateCart(this.cart.getId());
        updateCart.addProperty("cart",this.cart);
        updateCart.addProperty("product",this.cart.getProducts().get(0));
        updateCart.expectResponseStatus(HttpResponseStatusType.OK_200);
        updateCart.callAPI();
        updateCart.validateResponse();
    }

    @Test(description = "Validating POST request")
    public void verifyAddToCart(){
        AddToCart addToCart = new AddToCart();
        addToCart.addProperty("cart",this.cart);
        addToCart.addProperty("product",this.cart.getProducts().get(0));
        addToCart.expectResponseStatus(HttpResponseStatusType.OK_200);
        addToCart.callAPI();
        addToCart.validateResponse();
    }

    @DataProvider(name = "cartIDs")
    public Object[][] cartIDs(){
        return new Object[][] {
                {3}, {5}, {6}
        };
    }

    @Test(description = "Validating DELETE request", dataProvider="cartIDs")
    public void verifyDeleteCart(Integer cartID){
        DeleteCart addToCart = new DeleteCart(cartID);
        addToCart.addProperty("cart",this.cart);
        addToCart.addProperty("product",this.cart.getProducts().get(0));
        addToCart.expectResponseStatus(HttpResponseStatusType.OK_200);
        addToCart.callAPI();
        addToCart.validateResponse();
    }

    @DataProvider(name = "dateRange")
    public Object[][] dateRange(){
        return new Object[][] {
                {"startdate=2019-12-10&enddate=2020-10-10"},
                {"startdate=2018-12-10&enddate=2020-10-10"},
                {"startdate=2017-12-10&enddate=2020-10-10"}
        };
    }

    @Test(description = "Verify GET request", dataProvider="dateRange")
    public void verifyGetCartInRange(String dateRange){
        GetItemWithinDateRange cartItems = new GetItemWithinDateRange(dateRange);
        cartItems.addProperty("cart",this.cart);
        cartItems.addProperty("product",this.cart.getProducts().get(0));
        cartItems.expectResponseStatus(HttpResponseStatusType.OK_200);
        cartItems.callAPI();

        JsonComparatorContext comparatorContext = JsonComparatorContext.context()
                .<String>withPredicate("datePredicate", date -> isDateValid(date) &&
                        ZonedDateTime.parse(date)
                                .isAfter(LocalDate.of(2019,1,1)
                                        .atStartOfDay(ZoneId.systemDefault())));

        cartItems.validateResponse(comparatorContext);
    }

    private static boolean isDateValid(String date){
        try {
            ZonedDateTime.parse(date);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}