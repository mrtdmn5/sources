package com.amplifyframework.statemachine.codegen.data;

import android.app.Activity;
import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HostedUIOptions.kt */
/* loaded from: classes.dex */
public final class HostedUIOptions {
    private final String browserPackage;
    private final Activity callingActivity;
    private final HostedUIProviderInfo providerInfo;
    private final List<String> scopes;

    public HostedUIOptions(Activity callingActivity, List<String> list, HostedUIProviderInfo providerInfo, String str) {
        Intrinsics.checkNotNullParameter(callingActivity, "callingActivity");
        Intrinsics.checkNotNullParameter(providerInfo, "providerInfo");
        this.callingActivity = callingActivity;
        this.scopes = list;
        this.providerInfo = providerInfo;
        this.browserPackage = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HostedUIOptions copy$default(HostedUIOptions hostedUIOptions, Activity activity, List list, HostedUIProviderInfo hostedUIProviderInfo, String str, int r5, Object obj) {
        if ((r5 & 1) != 0) {
            activity = hostedUIOptions.callingActivity;
        }
        if ((r5 & 2) != 0) {
            list = hostedUIOptions.scopes;
        }
        if ((r5 & 4) != 0) {
            hostedUIProviderInfo = hostedUIOptions.providerInfo;
        }
        if ((r5 & 8) != 0) {
            str = hostedUIOptions.browserPackage;
        }
        return hostedUIOptions.copy(activity, list, hostedUIProviderInfo, str);
    }

    public final Activity component1() {
        return this.callingActivity;
    }

    public final List<String> component2() {
        return this.scopes;
    }

    public final HostedUIProviderInfo component3() {
        return this.providerInfo;
    }

    public final String component4() {
        return this.browserPackage;
    }

    public final HostedUIOptions copy(Activity callingActivity, List<String> list, HostedUIProviderInfo providerInfo, String str) {
        Intrinsics.checkNotNullParameter(callingActivity, "callingActivity");
        Intrinsics.checkNotNullParameter(providerInfo, "providerInfo");
        return new HostedUIOptions(callingActivity, list, providerInfo, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HostedUIOptions)) {
            return false;
        }
        HostedUIOptions hostedUIOptions = (HostedUIOptions) obj;
        if (Intrinsics.areEqual(this.callingActivity, hostedUIOptions.callingActivity) && Intrinsics.areEqual(this.scopes, hostedUIOptions.scopes) && Intrinsics.areEqual(this.providerInfo, hostedUIOptions.providerInfo) && Intrinsics.areEqual(this.browserPackage, hostedUIOptions.browserPackage)) {
            return true;
        }
        return false;
    }

    public final String getBrowserPackage() {
        return this.browserPackage;
    }

    public final Activity getCallingActivity() {
        return this.callingActivity;
    }

    public final HostedUIProviderInfo getProviderInfo() {
        return this.providerInfo;
    }

    public final List<String> getScopes() {
        return this.scopes;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = this.callingActivity.hashCode() * 31;
        List<String> list = this.scopes;
        int r2 = 0;
        if (list == null) {
            hashCode = 0;
        } else {
            hashCode = list.hashCode();
        }
        int hashCode3 = (this.providerInfo.hashCode() + ((hashCode2 + hashCode) * 31)) * 31;
        String str = this.browserPackage;
        if (str != null) {
            r2 = str.hashCode();
        }
        return hashCode3 + r2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("HostedUIOptions(callingActivity=");
        sb.append(this.callingActivity);
        sb.append(", scopes=");
        sb.append(this.scopes);
        sb.append(", providerInfo=");
        sb.append(this.providerInfo);
        sb.append(", browserPackage=");
        return OpaqueKey$$ExternalSyntheticOutline0.m(sb, this.browserPackage, ')');
    }
}
