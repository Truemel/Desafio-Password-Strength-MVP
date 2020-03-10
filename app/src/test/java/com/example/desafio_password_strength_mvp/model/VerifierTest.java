package com.example.desafio_password_strength_mvp.model;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VerifierTest {

    private final String WEAK_STRING = "aC18";
    private final String MEDIUM_STRING = "ac180";
    private final String STRONG_STRING = "aCbcD";
    private final String VERY_STRONG_STRING = "aC85D6";

    @Test
    @DisplayName("Minimum Test")
    public void isMinTest(){
        assertFalse(Verifier.isMinimum(WEAK_STRING));
    }

    @Test
    @DisplayName("UpperCase Test")
    public void haveUpperTest(){
        assertFalse(Verifier.haveUpperCase(MEDIUM_STRING));
    }

    @Test
    @DisplayName("Number Test")
    public void haveNumberTest(){
        assertFalse(Verifier.haveNumber(STRONG_STRING));
    }

    @Test
    @DisplayName("How Secure Weak Test")
    public void securityWeakLevelTest(){
        assertEquals(0, Verifier.howSecurePassword(WEAK_STRING));
    }

    @Test
    @DisplayName("How Secure Medium Test")
    public void securityMediumLevelTest(){
        assertEquals(1, Verifier.howSecurePassword(MEDIUM_STRING));
    }

    @Test
    @DisplayName("How Secure Strong Test")
    public void securityStrongLevelTest(){
        assertEquals(2, Verifier.howSecurePassword(STRONG_STRING));
    }

    @Test
    @DisplayName("How Secure Very Strong Test")
    public void securityVeryStrongLevelTest(){
        assertEquals(3, Verifier.howSecurePassword(VERY_STRONG_STRING));
    }
}
