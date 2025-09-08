package com.example.payments;

/**
 * PaymentGateway interface - the target interface for the Adapter pattern
 * This provides a unified interface for different payment providers
 */
public interface PaymentGateway {
    /**
     * Charge a customer for a given amount
     * @param customerId the customer identifier
     * @param amountCents the amount to charge in cents
     * @return transaction ID
     */
    String charge(String customerId, int amountCents);
}