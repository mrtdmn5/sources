package com.animaconnected.secondo.behaviour.distress.model;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: User.kt */
/* loaded from: classes3.dex */
public class User {
    public static final int $stable = 8;
    private String firstName;
    private boolean isRegistered;
    private long lastModified;
    private String lastName;
    private String phoneNumber;
    private String userId;

    public User() {
        this(null, null, null, null, 0L, false, 63, null);
    }

    public final String getFirstName() {
        return this.firstName;
    }

    public final long getLastModified() {
        return this.lastModified;
    }

    public final String getLastName() {
        return this.lastName;
    }

    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final boolean isRegistered() {
        return this.isRegistered;
    }

    public final void setFirstName(String str) {
        this.firstName = str;
    }

    public final void setLastModified(long j) {
        this.lastModified = j;
    }

    public final void setLastName(String str) {
        this.lastName = str;
    }

    public final void setPhoneNumber(String str) {
        this.phoneNumber = str;
    }

    public final void setRegistered(boolean z) {
        this.isRegistered = z;
    }

    public final void setUserId(String str) {
        this.userId = str;
    }

    public User(String str, String str2, String str3, String str4, long j, boolean z) {
        this.firstName = str;
        this.lastName = str2;
        this.phoneNumber = str3;
        this.userId = str4;
        this.lastModified = j;
        this.isRegistered = z;
    }

    public /* synthetic */ User(String str, String str2, String str3, String str4, long j, boolean z, int r13, DefaultConstructorMarker defaultConstructorMarker) {
        this((r13 & 1) != 0 ? null : str, (r13 & 2) != 0 ? null : str2, (r13 & 4) != 0 ? null : str3, (r13 & 8) == 0 ? str4 : null, (r13 & 16) != 0 ? 0L : j, (r13 & 32) != 0 ? false : z);
    }
}
