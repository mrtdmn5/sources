package com.animaconnected.secondo.notification;

import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeviceNotification.kt */
/* loaded from: classes3.dex */
public final class DeviceNotification {
    public static final String CATEGORY_CALL = "call";
    public static final String CATEGORY_EMAIL = "email";
    public static final String CATEGORY_EVENT = "event";
    public static final String CATEGORY_MESSAGE = "msg";
    public static final String SMS_RECEIVER_PACKAGE_NAME = "com.animaconnected.secondo.notification.receiver";
    private final String category;
    private final String message;
    private final String packageName;
    private final String sender;
    private final Set<String> texts;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: DeviceNotification.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public DeviceNotification(String str, String str2, String str3, String str4, Set<String> set) {
        this.category = str;
        this.sender = str2;
        this.message = str3;
        this.packageName = str4;
        this.texts = set;
    }

    public static /* synthetic */ DeviceNotification copy$default(DeviceNotification deviceNotification, String str, String str2, String str3, String str4, Set set, int r9, Object obj) {
        if ((r9 & 1) != 0) {
            str = deviceNotification.category;
        }
        if ((r9 & 2) != 0) {
            str2 = deviceNotification.sender;
        }
        String str5 = str2;
        if ((r9 & 4) != 0) {
            str3 = deviceNotification.message;
        }
        String str6 = str3;
        if ((r9 & 8) != 0) {
            str4 = deviceNotification.packageName;
        }
        String str7 = str4;
        if ((r9 & 16) != 0) {
            set = deviceNotification.texts;
        }
        return deviceNotification.copy(str, str5, str6, str7, set);
    }

    public final String component1() {
        return this.category;
    }

    public final String component2() {
        return this.sender;
    }

    public final String component3() {
        return this.message;
    }

    public final String component4() {
        return this.packageName;
    }

    public final Set<String> component5() {
        return this.texts;
    }

    public final DeviceNotification copy(String str, String str2, String str3, String str4, Set<String> set) {
        return new DeviceNotification(str, str2, str3, str4, set);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceNotification)) {
            return false;
        }
        DeviceNotification deviceNotification = (DeviceNotification) obj;
        if (Intrinsics.areEqual(this.category, deviceNotification.category) && Intrinsics.areEqual(this.sender, deviceNotification.sender) && Intrinsics.areEqual(this.message, deviceNotification.message) && Intrinsics.areEqual(this.packageName, deviceNotification.packageName) && Intrinsics.areEqual(this.texts, deviceNotification.texts)) {
            return true;
        }
        return false;
    }

    public final String getCategory() {
        return this.category;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getSender() {
        return this.sender;
    }

    public final Set<String> getTexts() {
        return this.texts;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        String str = this.category;
        int r1 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int r0 = hashCode * 31;
        String str2 = this.sender;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        String str3 = this.message;
        if (str3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str3.hashCode();
        }
        int r03 = (r02 + hashCode3) * 31;
        String str4 = this.packageName;
        if (str4 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = str4.hashCode();
        }
        int r04 = (r03 + hashCode4) * 31;
        Set<String> set = this.texts;
        if (set != null) {
            r1 = set.hashCode();
        }
        return r04 + r1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Notification{mType=");
        sb.append(this.category);
        sb.append(", mSender='");
        sb.append(this.sender);
        sb.append("', mPackageName='");
        return ComponentActivity$2$$ExternalSyntheticOutline0.m(sb, this.packageName, "'}");
    }
}
