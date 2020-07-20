package com.brainacad;

import java.util.Collection;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.PendingException;
import io.cucumber.java.Scenario;
import org.junit.Assert;

public class Hooks {
    private boolean isFirstRun = true;

    @Before(order = 1)
    public void init() {
        if (isFirstRun) {
            System.out.println("Before1 is work");
            isFirstRun = false;
        }
    }

    @Before(order = 10)
    public void init2(Scenario scenario) {
        System.out.println("Before2 is work");
        Collection<String> tags = scenario.getSourceTagNames();
        for (String tag : tags) {
            if ("@Defect".equalsIgnoreCase(tag)) {
                throw new PendingException(
                        String.format("Skip scenario by tag %s", tag));
            }
        }
    }

    @After
    public void clear(Scenario scenario) {
        System.out.println("After is work");
        System.out.println(scenario.isFailed() ? "Scenario failed" : "Scenario passed");
    }
}
