package com.tonasolution;

import static org.junit.Assert.*;

public class BankAccountTest {
    private BankAccount bankAccount;
    private static int count;

    @org.junit.BeforeClass
    public static void beforeClass(){
        System.out.println("This executes before any test cases. Count " + count++);
    }

    @org.junit.Before
    @org.junit.Test
    public void setup(){
        bankAccount = new BankAccount("Zouhaire", "El akioui", 1000.00, BankAccount.CHECKING);
        System.out.println("Set up unit testing for bankAccount");
    }

    @org.junit.Test
    public void deposit() {
        double balance = bankAccount.deposit(200.00, true);
        assertEquals(1200.00, balance, 0);
    }

    @org.junit.Test
    public void withdraw_branch() {
        double balance = bankAccount.withdraw(600.00, true);
        assertEquals(400, balance, 0);
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void withdraw_atm() {
        double balance = bankAccount.withdraw(600.00, false);
        assertEquals(400, balance, 0);
    }

    @org.junit.Test
    public void getBalance_deposit() {
        bankAccount.deposit(200.00, true);
        assertEquals(1200.00, bankAccount.getBalance(), 0);
    }
    @org.junit.Test
    public void getBalance_withdraw() {
        bankAccount.withdraw(200.00, true);
        assertEquals(800.00, bankAccount.getBalance(), 0);
    }
    @org.junit.Test
    public void isChecking_true() {
        assertTrue("The account is not checking account", bankAccount.isChecking());
    }

    @org.junit.AfterClass
    public static void afterClass(){
        System.out.println("This executes after any tests. count = " + count++);
    }

    @org.junit.After
    public void tearDown(){
        System.out.println("Count = "+ count++);
    }
}
