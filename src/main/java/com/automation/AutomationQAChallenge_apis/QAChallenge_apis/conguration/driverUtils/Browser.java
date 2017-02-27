package com.automation.AutomationQAChallenge_apis.QAChallenge_apis.conguration.driverUtils;

public enum Browser {

    /** Mozilla Firefox, using the execution environment installed one */
    FIREFOX("firefox"),
    CHROME("chrome"),
    /**
     * Microsoft Internet Explorer, using the execution environment installed one
     */
    INTERNET_EXPLORER("ie"),
    ANDROID("android");
    
    private final String browserName;


    Browser(String name) {
        this.browserName = name;
    }


    private String getName() {
        return browserName;
    }


    public static Browser getType(String name) {
        if (name != null) {
            for (Browser b : Browser.values()) {
                if (name.equalsIgnoreCase(b.getName())) {
                    return b;
                }
            }
        }
        return null;
    }


}
