package com.example.unittests.task1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.math.BigDecimal;

import static com.example.unittests.task1.DiscountCalculator.Discount.*;
import static java.math.BigDecimal.valueOf;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DiscountCalculatorTests {
    private final DiscountCalculator discountCalculator = new SimpleDiscountCalculator();

    //task1 step1
    @Test
    public void shouldThrowExceptionWhenAmountIsNull() {
        //step 2
        BigDecimal am=  null;
        //bgste
        org.junit.jupiter.api.function.Executable actuDisc = () -> discountCalculator.calculate(am);
        RuntimeException actuExceptin = assertThrows(RuntimeException.class, actuDisc);
        assertEquals("Amount value must be greater than or equal to zero", actuExceptin.getMessage());
    }
    @Test
    public void shouldThrowExceptionWhenAmountIsLessThanZero() {
        //step2:
        BigDecimal am= valueOf(-1);
//        when
        Executable actuDisc = () -> discountCalculator.calculate(am);
//        fin
        RuntimeException actuExceptin = assertThrows(RuntimeException.class, actuDisc);
//        assertEquals("Am val have to be >= 0", actuExceptin.getMessage());
//        cant be the randm mssg: XD
        assertEquals("Amount value must be greater than or equal to zero", actuExceptin.getMessage());
    }
    @Test
    public void shouldNotApplyDiscountWhenAmountIsZero() {
        BigDecimal am= valueOf(0);
        DiscountCalculator.Discount actualDiscount = discountCalculator.calculate(am);
        assertEquals(NONE, actualDiscount);
    }
    @Test
    public void shouldNotApplyDiscountWhenAmountIsTooLow() {
        BigDecimal am = valueOf(500);
//        when
        DiscountCalculator.Discount actualDiscount = discountCalculator.calculate(am);
//        then
        assertEquals(NONE, actualDiscount);
    }
    @Test
    public void shouldApplyStandardDiscountWhenAmountIsBetweenStandardAndHighDiscountLevels() {
        BigDecimal am = valueOf(2500);
//        when
        DiscountCalculator.Discount actualDiscount = discountCalculator.calculate(am);
//        then
        assertEquals(STANDARD, actualDiscount);
    }
    @Test
    public void shouldApplyHighDiscountWhenAmountIsAboveHighDiscountLevel() {
        BigDecimal am = valueOf(6500);
//        when
        DiscountCalculator.Discount actualDiscount = discountCalculator.calculate(am);
//        then
        assertEquals(HIGH, actualDiscount);
    }
}
