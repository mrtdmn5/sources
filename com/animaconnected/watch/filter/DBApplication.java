package com.animaconnected.watch.filter;

import androidx.compose.animation.Scale$$ExternalSyntheticOutline0;
import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DBApplication.kt */
/* loaded from: classes3.dex */
public final class DBApplication {
    private final String display_name;
    private final String identifier;
    private final long setting;

    public DBApplication(String identifier, long j, String display_name) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(display_name, "display_name");
        this.identifier = identifier;
        this.setting = j;
        this.display_name = display_name;
    }

    public static /* synthetic */ DBApplication copy$default(DBApplication dBApplication, String str, long j, String str2, int r5, Object obj) {
        if ((r5 & 1) != 0) {
            str = dBApplication.identifier;
        }
        if ((r5 & 2) != 0) {
            j = dBApplication.setting;
        }
        if ((r5 & 4) != 0) {
            str2 = dBApplication.display_name;
        }
        return dBApplication.copy(str, j, str2);
    }

    public final String component1() {
        return this.identifier;
    }

    public final long component2() {
        return this.setting;
    }

    public final String component3() {
        return this.display_name;
    }

    public final DBApplication copy(String identifier, long j, String display_name) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(display_name, "display_name");
        return new DBApplication(identifier, j, display_name);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DBApplication)) {
            return false;
        }
        DBApplication dBApplication = (DBApplication) obj;
        if (Intrinsics.areEqual(this.identifier, dBApplication.identifier) && this.setting == dBApplication.setting && Intrinsics.areEqual(this.display_name, dBApplication.display_name)) {
            return true;
        }
        return false;
    }

    public final String getDisplay_name() {
        return this.display_name;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final long getSetting() {
        return this.setting;
    }

    public int hashCode() {
        return this.display_name.hashCode() + Scale$$ExternalSyntheticOutline0.m(this.setting, this.identifier.hashCode() * 31, 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DBApplication(identifier=");
        sb.append(this.identifier);
        sb.append(", setting=");
        sb.append(this.setting);
        sb.append(", display_name=");
        return OpaqueKey$$ExternalSyntheticOutline0.m(sb, this.display_name, ')');
    }
}
