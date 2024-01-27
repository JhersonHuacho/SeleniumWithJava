package dev.selenium.tests;

import dev.selenium.utils.BaseTests;
import org.testng.annotations.Test;

public class LoginTest extends RegisterTest {

    @Test (dependsOnMethods = {"createNewAccount"})
    public void doLoginAfterRegister() {
        System.out.println("Method -> doLoginAfterRegister");
    }
}
