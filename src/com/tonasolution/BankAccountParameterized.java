package com.tonasolution;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BankAccountParameterized {

    private BankAccount account;
    private double amount;
    private boolean branch;
    private double expected;

    public BankAccountParameterized(double amount, boolean branch, double expected) {
        this.amount = amount;
        this.branch = branch;
        this.expected = expected;
    }

    @org.junit.Before
    public void setup(){
        account = new BankAccount("zouhaire", "El akioui", 1000.00, BankAccount.CHECKING);
        System.out.println("Running a test ...");
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testConditions(){
        return Arrays.asList(new Object[][]{
                {100.00, true, 1100.00},
                {200.00, true, 1200.00},
                {325.14, true, 1325.14}
        });
    }

    @org.junit.Test
    public void deposit() {
        account.deposit(amount, branch);
        assertEquals(expected, account.getBalance(), 0.01);
    }
}
