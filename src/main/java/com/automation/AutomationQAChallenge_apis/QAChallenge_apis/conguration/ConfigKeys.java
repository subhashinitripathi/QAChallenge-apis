package com.automation.AutomationQAChallenge_apis.QAChallenge_apis.conguration;

/**
 * All configuration keys and their configuration mapping are added here. They must end
 * with the postfix "_KEY" and they must have a correct configuration property set.
 *  
 *
 */
public enum ConfigKeys {

    DEFAULT_BROWSER_KEY("default.browser"),
    
	DATABASE_SERVER_KEY("database.server"),
	DATABASE_NAME_KEY("database.name"),
    DATABASE_USER_NAME_KEY("database.user.name"),
    DATABASE_PASSWORD_KEY("database.password"),
    
    TIMEOUT_LARGE_MS_KEY("timeout.large"),
    TIMEOUT_MEDIUM_MS_KEY("timeout.medium"),
    TIMEOUT_SMALL_MS_KEY("timeout.small"),
    
	APPLICATION_URL_KEY("application.url"),
	
	DEVICE_TYPE_KEY("device.type"),
    DEVICE_NAME_KEY("device.name"),
    PLATFORM_VERSION_KEY("platform.version"),
    PLATFORM_NAME_KEY("platform.name"),
    
    CARD_NO_KEY("card.no"),
    EXPIRATION_DATE_KEY("expiration.date"),
    CVV_NO_KEY("cvv.no");
    
	
    private String key;
    private ConfigKeys(String key) {
        this.key = key;
    }
    public String getKey() {
        return key;
    }
    public String getName() {
        return name().substring(0,name().length()-"_KEY".length());
    }
}
