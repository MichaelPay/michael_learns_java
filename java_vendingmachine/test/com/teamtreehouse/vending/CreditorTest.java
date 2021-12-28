package com.teamtreehouse.vending;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreditorTest {
    private Creditor creditor;

    @BeforeEach
    void setUp() {
        creditor = new Creditor();
    }

    @Test
     void addingFundsIncrementsAvailableFund() {
        creditor.addFunds(50);
        assertEquals(50, creditor.getAvailableFunds());
    }

    @Test
    void refundGivenSuccess() {
        creditor.addFunds(40);
        creditor.refund();

        assertEquals(0,creditor.getAvailableFunds());
    }
}