package com.animaconnected.watch.filter;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import androidx.room.util.TableInfo$ForeignKey$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DBImportantContact.kt */
/* loaded from: classes3.dex */
public final class DBImportantContact {
    private final String display_name;
    private final String email;
    private final String phone_number;
    private final String platform_specific_identifier;

    public DBImportantContact(String platform_specific_identifier, String display_name, String str, String str2) {
        Intrinsics.checkNotNullParameter(platform_specific_identifier, "platform_specific_identifier");
        Intrinsics.checkNotNullParameter(display_name, "display_name");
        this.platform_specific_identifier = platform_specific_identifier;
        this.display_name = display_name;
        this.phone_number = str;
        this.email = str2;
    }

    public static /* synthetic */ DBImportantContact copy$default(DBImportantContact dBImportantContact, String str, String str2, String str3, String str4, int r5, Object obj) {
        if ((r5 & 1) != 0) {
            str = dBImportantContact.platform_specific_identifier;
        }
        if ((r5 & 2) != 0) {
            str2 = dBImportantContact.display_name;
        }
        if ((r5 & 4) != 0) {
            str3 = dBImportantContact.phone_number;
        }
        if ((r5 & 8) != 0) {
            str4 = dBImportantContact.email;
        }
        return dBImportantContact.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.platform_specific_identifier;
    }

    public final String component2() {
        return this.display_name;
    }

    public final String component3() {
        return this.phone_number;
    }

    public final String component4() {
        return this.email;
    }

    public final DBImportantContact copy(String platform_specific_identifier, String display_name, String str, String str2) {
        Intrinsics.checkNotNullParameter(platform_specific_identifier, "platform_specific_identifier");
        Intrinsics.checkNotNullParameter(display_name, "display_name");
        return new DBImportantContact(platform_specific_identifier, display_name, str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DBImportantContact)) {
            return false;
        }
        DBImportantContact dBImportantContact = (DBImportantContact) obj;
        if (Intrinsics.areEqual(this.platform_specific_identifier, dBImportantContact.platform_specific_identifier) && Intrinsics.areEqual(this.display_name, dBImportantContact.display_name) && Intrinsics.areEqual(this.phone_number, dBImportantContact.phone_number) && Intrinsics.areEqual(this.email, dBImportantContact.email)) {
            return true;
        }
        return false;
    }

    public final String getDisplay_name() {
        return this.display_name;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getPhone_number() {
        return this.phone_number;
    }

    public final String getPlatform_specific_identifier() {
        return this.platform_specific_identifier;
    }

    public int hashCode() {
        int hashCode;
        int m = TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.display_name, this.platform_specific_identifier.hashCode() * 31, 31);
        String str = this.phone_number;
        int r2 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int r0 = (m + hashCode) * 31;
        String str2 = this.email;
        if (str2 != null) {
            r2 = str2.hashCode();
        }
        return r0 + r2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DBImportantContact(platform_specific_identifier=");
        sb.append(this.platform_specific_identifier);
        sb.append(", display_name=");
        sb.append(this.display_name);
        sb.append(", phone_number=");
        sb.append(this.phone_number);
        sb.append(", email=");
        return OpaqueKey$$ExternalSyntheticOutline0.m(sb, this.email, ')');
    }
}
