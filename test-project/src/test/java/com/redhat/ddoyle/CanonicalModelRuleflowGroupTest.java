package com.redhat.ddoyle;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * Main
 */
public class CanonicalModelRuleflowGroupTest {

    private static final String GROUP_ID = "com.redhat.ddoyle";
    private static final String ARTIFACT_ID = "sample-rules";
    private static final String VERSION = "1.0.0-SNAPSHOT";

    @Test
    public void testCanonicalModelRuleflowGroup() {
        KieServices kieServices = KieServices.Factory.get();
        ReleaseId releaseId = kieServices.newReleaseId(GROUP_ID, ARTIFACT_ID, VERSION);

        KieContainer kieContainer = kieServices.newKieContainer(releaseId);
       
        KieSession kieSession = kieContainer.newKieSession();
        
        kieSession.insert("Hello");
        kieSession.startProcess("sample-rules.ruleflow");
        kieSession.fireAllRules();        
        
        kieSession.dispose();
    }
}