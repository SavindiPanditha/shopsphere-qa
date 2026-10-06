package com.shopsphere.qa.utils;

import io.github.cdimascio.dotenv.Dotenv;

public final class Config {
    private static final Dotenv DOTENV = Dotenv.configure().ignoreIfMissing().load();

    public static final String BASE_URL = getEnv("SHOPSPHERE_BASE_URL", "http://shopspherelocal.local");
    public static final String SHOP_URL = BASE_URL + "/shop/";
    public static final String CART_URL = BASE_URL + "/cart/";
    public static final String CHECKOUT_URL = BASE_URL + "/checkout/";
    public static final String ACCOUNT_URL = BASE_URL + "/my-account/";
    public static final String ADMIN_URL = BASE_URL + "/wp-admin/";

    public static final String ADMIN_USER = getEnv("SHOPSPHERE_ADMIN_USER", "");
    public static final String ADMIN_PASS = getEnv("SHOPSPHERE_ADMIN_PASS", "");
    public static final String TEST_USER = getEnv("SHOPSPHERE_TEST_USER", "");
    public static final String TEST_PASS = getEnv("SHOPSPHERE_TEST_PASS", "");

    private Config() {
    }

    public static boolean isHeadless() {
        return Boolean.parseBoolean(getEnv("SHOPSPHERE_HEADLESS", "false"));
    }

    private static String getEnv(String key, String defaultValue) {
        String value = DOTENV.get(key);
        if (value == null || value.isBlank()) {
            value = System.getenv(key);
        }
        if (value == null || value.isBlank()) {
            return defaultValue;
        }
        return value;
    }
}
