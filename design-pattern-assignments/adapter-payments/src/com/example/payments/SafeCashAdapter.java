package com.example.payments;

import java.util.Objects;

/**
 * SafeCashAdapter - adapts SafeCashClient to PaymentGateway interface
 * This adapter implements the Adapter pattern by converting the SafeCashClient's
 * createPayment method and SafeCashPayment's confirm method to match the 
 * PaymentGateway's charge method signature
 */
public class SafeCashAdapter implements PaymentGateway {
    private final SafeCashClient safeCashClient;
    
    public SafeCashAdapter(SafeCashClient safeCashClient) {
        this.safeCashClient = Objects.requireNonNull(safeCashClient, "safeCashClient");
    }
    
    @Override
    public String charge(String customerId, int amountCents) {
        Objects.requireNonNull(customerId, "customerId");
        if (amountCents <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        
        // Adapt the SafeCashClient's createPayment method to our charge interface
        // SafeCashClient expects (amount, user) and returns SafeCashPayment
        // SafeCashPayment has a confirm() method that returns the transaction ID
        SafeCashPayment payment = safeCashClient.createPayment(amountCents, customerId);
        return payment.confirm();
    }
}
