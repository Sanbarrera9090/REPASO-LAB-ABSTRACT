package edu.sabana.poob.sabanapayroll;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class SavingTest {

    @Test
    public void shouldGetDepositDiscount() {
        Savings account = new Savings();
        assertTrue(Double.compare(2000, account.getDepositDiscount()) == 0);
    }

    @Test
    public void shouldDepositAmount() {
        Savings account = new Savings();
        boolean result = account.deposit(10000);

        assertTrue(result);
        assertTrue(Double.compare(8000, account.getBalance()) == 0);
    }

    @Test
    public void shouldNotDepositAmount() {
        Savings account = new Savings();

        assertFalse(account.deposit(1000));
        assertFalse(account.deposit(2000));
        assertTrue(Double.compare(0, account.getBalance()) == 0);
    }
    @Test
    public void shouldGetAnnualInterestRate() {
        Savings account = new Savings();
        assertTrue(Double.compare(0.01, account.getANNUAL_INTEREST_RATE()) == 0);
    }
    @Test
    public void shouldMontlyInterest() {

        Savings account = new Savings();
        account.deposit(10000);
        assertTrue(Double.compare(100, account.depositMontlyInterest()) == 0);
    }


}