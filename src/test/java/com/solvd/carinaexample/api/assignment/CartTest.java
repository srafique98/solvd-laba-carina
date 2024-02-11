package com.solvd.carinaexample.api.assignment;

import com.solvd.carinaexample.api.assignment.domain.Cart;
import com.solvd.carinaexample.api.assignment.domain.Product;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    @Test()
    public void verifyUpdateCart(){
        UpdateCart updateCart = new UpdateCart(this.cart.getId());
        updateCart.addProperty("cart",this.cart);
        updateCart.addProperty("product",this.cart.getProducts().get(0));
        updateCart.callAPI();
        updateCart.validateResponse();
    }

    @Test()
    public void verifyAddToCart(){
        AddToCart addToCart = new AddToCart();
        addToCart.addProperty("cart",this.cart);
        addToCart.addProperty("product",this.cart.getProducts().get(0));

        addToCart.callAPI();
        addToCart.validateResponse();
    }

    @DataProvider(name = "cartIDs")
    public Object[][] cartIDs(){
        return new Object[][] {
                {3}, {5}, {6}
        };
    }

    @Test(dataProvider="cartIDs")
    public void verifyDeleteCart(Integer cartID){
        DeleteCart addToCart = new DeleteCart(cartID);
        addToCart.addProperty("cart",this.cart);
        addToCart.addProperty("product",this.cart.getProducts().get(0));
        addToCart.callAPI();
        addToCart.validateResponse();
    }




}


// add new cart -- post
// update a cart == put can use patch if u want
// delete a cart completed
