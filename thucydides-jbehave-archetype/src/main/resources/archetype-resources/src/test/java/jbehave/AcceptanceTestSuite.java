package jbehave;

import net.thucydides.jbehave.ThucydidesJUnitStories;

public class AcceptanceTestSuite extends ThucydidesJUnitStories {
    public AcceptanceTestSuite() {
        runThucydides().inASingleSession();
    }
}
