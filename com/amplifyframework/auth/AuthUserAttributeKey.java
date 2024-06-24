package com.amplifyframework.auth;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import androidx.core.util.ObjectsCompat$Api19Impl;

/* loaded from: classes.dex */
public final class AuthUserAttributeKey {
    private static final String ADDRESS = "address";
    private static final String BIRTHDATE = "birthdate";
    private static final String EMAIL = "email";
    private static final String EMAIL_VERIFIED = "email_verified";
    private static final String FAMILY_NAME = "family_name";
    private static final String GENDER = "gender";
    private static final String GIVEN_NAME = "given_name";
    private static final String LOCALE = "locale";
    private static final String MIDDLE_NAME = "middle_name";
    private static final String NAME = "name";
    private static final String NICKNAME = "nickname";
    private static final String PHONE_NUMBER = "phone_number";
    private static final String PHONE_NUMBER_VERIFIED = "phone_number_verified";
    private static final String PICTURE = "picture";
    private static final String PREFERRED_USERNAME = "preferred_username";
    private static final String PROFILE = "profile";
    private static final String UPDATED_AT = "updated_at";
    private static final String WEBSITE = "website";
    private static final String ZONE_INFO = "zoneinfo";
    private final String attributeKey;

    public AuthUserAttributeKey(String str) {
        this.attributeKey = str;
    }

    public static AuthUserAttributeKey address() {
        return new AuthUserAttributeKey("address");
    }

    public static AuthUserAttributeKey birthdate() {
        return new AuthUserAttributeKey(BIRTHDATE);
    }

    public static AuthUserAttributeKey custom(String str) {
        return new AuthUserAttributeKey(str);
    }

    public static AuthUserAttributeKey email() {
        return new AuthUserAttributeKey("email");
    }

    public static AuthUserAttributeKey emailVerified() {
        return new AuthUserAttributeKey(EMAIL_VERIFIED);
    }

    public static AuthUserAttributeKey familyName() {
        return new AuthUserAttributeKey(FAMILY_NAME);
    }

    public static AuthUserAttributeKey gender() {
        return new AuthUserAttributeKey(GENDER);
    }

    public static AuthUserAttributeKey givenName() {
        return new AuthUserAttributeKey(GIVEN_NAME);
    }

    public static AuthUserAttributeKey locale() {
        return new AuthUserAttributeKey(LOCALE);
    }

    public static AuthUserAttributeKey middleName() {
        return new AuthUserAttributeKey(MIDDLE_NAME);
    }

    public static AuthUserAttributeKey name() {
        return new AuthUserAttributeKey("name");
    }

    public static AuthUserAttributeKey nickname() {
        return new AuthUserAttributeKey(NICKNAME);
    }

    public static AuthUserAttributeKey phoneNumber() {
        return new AuthUserAttributeKey(PHONE_NUMBER);
    }

    public static AuthUserAttributeKey phoneNumberVerified() {
        return new AuthUserAttributeKey(PHONE_NUMBER_VERIFIED);
    }

    public static AuthUserAttributeKey picture() {
        return new AuthUserAttributeKey("picture");
    }

    public static AuthUserAttributeKey preferredUsername() {
        return new AuthUserAttributeKey(PREFERRED_USERNAME);
    }

    public static AuthUserAttributeKey profile() {
        return new AuthUserAttributeKey(PROFILE);
    }

    public static AuthUserAttributeKey updatedAt() {
        return new AuthUserAttributeKey(UPDATED_AT);
    }

    public static AuthUserAttributeKey website() {
        return new AuthUserAttributeKey(WEBSITE);
    }

    public static AuthUserAttributeKey zoneInfo() {
        return new AuthUserAttributeKey(ZONE_INFO);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && AuthUserAttributeKey.class == obj.getClass()) {
            return ObjectsCompat$Api19Impl.equals(getKeyString(), ((AuthUserAttributeKey) obj).getKeyString());
        }
        return false;
    }

    public String getKeyString() {
        return this.attributeKey;
    }

    public int hashCode() {
        return ObjectsCompat$Api19Impl.hash(getKeyString());
    }

    public String toString() {
        return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("AuthUserAttributeKey {attributeKey="), this.attributeKey, '}');
    }
}
