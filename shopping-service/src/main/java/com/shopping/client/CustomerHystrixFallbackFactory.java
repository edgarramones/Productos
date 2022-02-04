package com.shopping.client;



import com.shopping.model.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CustomerHystrixFallbackFactory  implements CustomerClient{
    @Override
    public ResponseEntity<Customer> getCustomer(long id) {
        Customer customer = Customer.builder()
                .firstName("Prueba")
                .lastName("Feign")
                .email("none")
                .photoUrl("none").build();
        return ResponseEntity.ok(customer);
    }
}
