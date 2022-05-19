package clientapplication;

import clientapplication.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class ClientApplication implements CommandLineRunner {
    @Autowired
    @Lazy
    private RestOperations restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("\n");
        System.out.println("\nAdding Product");
        System.out.println("***********************************************************************");
        restTemplate.postForLocation("http://localhost:8080/product/add",
                new ProductDto(1, "D-001", "Dell", 1000, true, 5.5, "Laptop", 10, null));
        System.out.println("Added Product 1::" + restTemplate.getForObject("http://localhost:8080/product/view/1", ProductDto.class));
        System.out.println("\n");
        System.out.println("***********************************************************************");

        restTemplate.postForLocation("http://localhost:8080/product/add",
                new ProductDto(2, "D-002", "Headset", 10, true, 10, "Headset", 10, null));
        System.out.println("Added Product 2::" + restTemplate.getForObject("http://localhost:8080/product/view/2", ProductDto.class));

        System.out.println("\n");
        System.out.println("\nModify Product");
        System.out.println("***********************************************************************");
        restTemplate.put("http://localhost:8080/product/update",
                new ProductDto(1, "D-001", "Dell-Modified", 1000 * 0.01, true, 5.5, "Laptop with latest gen", 10, null));
        System.out.println("Product 1 Updated::" + restTemplate.getForObject("http://localhost:8080/product/view/1", ProductDto.class));

        System.out.println("***********************************************************************");
        restTemplate.put("http://localhost:8080/product/update",
                new ProductDto(2, "D-002", "Headset-Updated", 10 * 0.01, true, 10, "Headset - black in color", 10, null));

        System.out.println("Product 2 Updated::" + restTemplate.getForObject("http://localhost:8080/product/view/2", ProductDto.class));

        System.out.println("\n***********************************************************************");
        System.out.println("***********************************************************************");
        System.out.println("Get all products");
        ProductDto[] product = restTemplate.getForObject("http://localhost:8080/product/list", ProductDto[].class);
        Arrays.asList(product).forEach(System.out::println);
        System.out.println("\n*************************************************************************");

        System.out.println("Adding Customer");
        System.out.println("***********************************************************************");
        restTemplate.postForLocation("http://localhost:8080/customer/add",
                new CustomerDto(1, "Ritesh", "Maharjan", new AddressDto("1000N", "City", "52557"), "98367362626", "riteshmaharjan@miu.edu"));
        restTemplate.postForLocation("http://localhost:8080/customer/add",
                new CustomerDto(2, "Saugat", "Pageni", new AddressDto("1000N", "City", "52557"), "1233453", "saugatpageni@miu.edu"));
        restTemplate.postForLocation("http://localhost:8080/customer/add",
                new CustomerDto(3, "Rajendra", "Maharjan", new AddressDto("1000N", "City", "52557"), "564234556", "rajendramaharjan@miu.edu"));

        System.out.println("\n");
        System.out.println("***********************************************************************");
        System.out.println("Getting customer list");
        CustomerDto[] customers = restTemplate.getForObject("http://localhost:8080/customer/list", CustomerDto[].class);
        Arrays.asList(customers).forEach(System.out::println);


        System.out.println("\nCreating cart and adding product to the cart");
        System.out.println("***********************************************************************");
        restTemplate.postForLocation("http://localhost:8080/shoppingcart/create",
                new ShoppingCartDto(1, new CustomerDto(2, "Ritesh", "Maharjan", new AddressDto("1000 N", "Fairfield", "IOWA"), "98367362626", "ritesh@miu.edu"), new ArrayList<>() {
                    {
                        add(new ProductDto(1
                                , "D-001"
                                , "Dell-Modified"
                                , 1000 * 0.01
                                , true
                                , 5.5
                                , "Laptop with latest gen"
                                , 10
                                , null));
                    }
                }, null), ShoppingCartDto.class);

        System.out.println("Adding product to cart.");
        restTemplate.put("http://localhost:8080/shoppingcart/addproduct/1",
                new ProductDto(2
                        , "D-002"
                        , "Headset-Updated"
                        , 10 * 0.01
                        , true
                        , 10
                        , "Headset - black in color"
                        , 10
                        , null));

        System.out.println("***********************************************************************");
        System.out.println("\nShowing the cart");
        System.out.println("***********************************************************************");
        System.out.println("Cart::" + restTemplate.getForObject("http://localhost:8080/shoppingcart/view/1", ShoppingCartDto.class));
        System.out.println("Remove product from the cart (Request body is not allowed with delete. However it working with postman)");
////      http://localhost:8080/shoppingcart/removeproduct/1
//        {
//            "id":2,
//                "productNumber":"D-002",
//                "name":"Dell",
//                "price":1000,
//                "taxable":true,
//                "applicableDiscount":5.5,
//                "description":"Laptop",
//                "quantity":10,
//                "status":null
//        }
        System.out.println("\nChanging quantity");
        System.out.println("================");
        restTemplate.put("http://localhost:8080/shoppingcart/addproduct/1",
                new ProductDto(2
                        , "D-002"
                        , "Headset-Updated"
                        , 10 * 0.01
                        , true
                        , 10
                        , "Headset - black in color"
                        , 10
                        , null));
        System.out.println("Showing the updated shopping cart::" + restTemplate.getForObject("http://localhost:8080/shoppingcart/view/1", ShoppingCartDto.class));

        System.out.println("\nChanging quantity");
        System.out.println("***********************************************************************=");
        restTemplate.put("http://localhost:8080/shoppingcart/addproduct/1",
                new ProductDto(2
                        , "D-002"
                        , "Headset-Updated"
                        , 10 * 0.01
                        , true
                        , 10
                        , "Headset - black in color"
                        , 10
                        , null));

        System.out.println("Showing the updated shopping cart:: " + restTemplate.getForObject("http://localhost:8080/shoppingcart/view/1", ShoppingCartDto.class));

        System.out.println("***********************************************************************=");
        System.out.println("***********************************************************************=");
        System.out.println("\nCheck out cart");
        System.out.println("***********************************************************************=");

        ShoppingCartDto cartDto = restTemplate.getForObject("http://localhost:8080/shoppingcart/view/1", ShoppingCartDto.class);
        restTemplate.put("http://localhost:8080/shoppingcart/checkout/1", cartDto);

        System.out.println("\nShowing the placed order");
        System.out.println("**********************************************************************************************************************************************");
        System.out.println("Order:" + restTemplate.getForObject("http://localhost:8080/order/view/1", ShoppingOrderDto.class));

    }

    @Bean
    RestOperations restTemplate() {
        return new RestTemplate();
    }
}
