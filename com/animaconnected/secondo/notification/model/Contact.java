package com.animaconnected.secondo.notification.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = Contact.TABLE_NAME_USERS)
/* loaded from: classes3.dex */
public class Contact {
    public static final String FIELD_EMAIL = "email";
    public static final String FIELD_FILTER_CALLS = "filterCalls";
    public static final String FIELD_FILTER_EMAIL = "filterEmail";
    public static final String FIELD_FILTER_MESSAGES = "filterMessages";
    public static final String FIELD_NAME_NAME = "name";
    public static final String FIELD_NAME_URI = "uri";
    public static final String FIELD_PHONE_NUMBER = "phoneNumber";
    public static final String PHONE_NUMBERS_DELIMITER = "&";
    public static final String TABLE_NAME_USERS = "users";

    @DatabaseField(columnName = FIELD_FILTER_CALLS)
    private boolean mCallsFilterEnabled;

    @DatabaseField(columnName = "email")
    private String mEmail;

    @DatabaseField(columnName = FIELD_FILTER_EMAIL)
    private boolean mEmailFilterEnabled;

    @DatabaseField(columnName = FIELD_FILTER_MESSAGES)
    private boolean mMessagesFilterEnabled;

    @DatabaseField(columnName = "name")
    private String mName;

    @DatabaseField(columnName = FIELD_PHONE_NUMBER)
    private String mPhoneNumber;

    @DatabaseField(columnName = FIELD_NAME_URI, id = true)
    private String mUri;

    public String getEmail() {
        return this.mEmail;
    }

    public String getName() {
        return this.mName;
    }

    public String getPhoneNumber() {
        return this.mPhoneNumber;
    }

    public String getUri() {
        return this.mUri;
    }

    public boolean isCallsFilterEnabled() {
        return this.mCallsFilterEnabled;
    }

    public boolean isEmailFilterEnabled() {
        return this.mEmailFilterEnabled;
    }

    public boolean isMessagesFilterEnabled() {
        return this.mMessagesFilterEnabled;
    }

    public void setCallsFilterEnabled(boolean z) {
        this.mCallsFilterEnabled = z;
    }

    public void setEmail(String str) {
        this.mEmail = str;
    }

    public void setEmailFilterEnabled(boolean z) {
        this.mEmailFilterEnabled = z;
    }

    public void setMessagesFilterEnabled(boolean z) {
        this.mMessagesFilterEnabled = z;
    }

    public Contact setName(String str) {
        this.mName = str;
        return this;
    }

    public void setPhoneNumber(String str) {
        this.mPhoneNumber = str;
    }

    public Contact setUri(String str) {
        this.mUri = str;
        return this;
    }

    public String toString() {
        return "Contact{name='" + this.mName + "'phonenumber='" + this.mPhoneNumber + "'email='" + this.mEmail + "'mCallsFilterEnabled='" + this.mCallsFilterEnabled + "'mMessagesFilterEnabled='" + this.mMessagesFilterEnabled + "'mEmailFilterEnabled='" + this.mEmailFilterEnabled + "'}";
    }
}
