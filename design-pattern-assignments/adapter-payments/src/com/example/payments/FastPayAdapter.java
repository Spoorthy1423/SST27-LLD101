package com.example.payments;

import java.util.Objects;

/**
 * FastPayAdapter - adapts FastPayClient to PaymentGateway interface
 * This adapter implements the Adapter pattern by converting the FastPayClient's
 * payNow method to match the PaymentGateway's charge method signature
 */
public class FastPayAdapter implements PaymentGateway {
    private final FastPayClient fastPayClient;
    
    public FastPayAdapter(FastPayClient fastPayClient) {
        this.fastPayClient = Objects.requireNonNull(fastPayClient, "fastPayClient");
    }
    
    @Override
    public String charge(String customerId, int amountCents) {
        Objects.requireNonNull(customerId, "customerId");
        if (amountCents <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        
        // Adapt the FastPayClient's payNow method to our charge interface
        return fastPayClient.payNow(customerId, amountCents);
    }
}
