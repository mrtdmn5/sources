package com.animaconnected.secondo.screens.settings.displaynotifications;

import androidx.compose.ui.graphics.vector.VectorGroup$$ExternalSyntheticOutline0;
import androidx.compose.ui.text.intl.LocaleList$$ExternalSyntheticOutline0;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DisplayNotificationViewModel.kt */
/* loaded from: classes3.dex */
public final class AppsUIState {
    public static final int $stable = 8;
    private final boolean allEnabled;
    private final List<AppState> apps;
    private final List<AppState> filteredApps;

    public AppsUIState() {
        this(false, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AppsUIState copy$default(AppsUIState appsUIState, boolean z, List list, List list2, int r4, Object obj) {
        if ((r4 & 1) != 0) {
            z = appsUIState.allEnabled;
        }
        if ((r4 & 2) != 0) {
            list = appsUIState.apps;
        }
        if ((r4 & 4) != 0) {
            list2 = appsUIState.filteredApps;
        }
        return appsUIState.copy(z, list, list2);
    }

    public final boolean component1() {
        return this.allEnabled;
    }

    public final List<AppState> component2() {
        return this.apps;
    }

    public final List<AppState> component3() {
        return this.filteredApps;
    }

    public final AppsUIState copy(boolean z, List<AppState> apps, List<AppState> filteredApps) {
        Intrinsics.checkNotNullParameter(apps, "apps");
        Intrinsics.checkNotNullParameter(filteredApps, "filteredApps");
        return new AppsUIState(z, apps, filteredApps);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppsUIState)) {
            return false;
        }
        AppsUIState appsUIState = (AppsUIState) obj;
        if (this.allEnabled == appsUIState.allEnabled && Intrinsics.areEqual(this.apps, appsUIState.apps) && Intrinsics.areEqual(this.filteredApps, appsUIState.filteredApps)) {
            return true;
        }
        return false;
    }

    public final boolean getAllEnabled() {
        return this.allEnabled;
    }

    public final List<AppState> getApps() {
        return this.apps;
    }

    public final List<AppState> getFilteredApps() {
        return this.filteredApps;
    }

    public int hashCode() {
        return this.filteredApps.hashCode() + VectorGroup$$ExternalSyntheticOutline0.m(this.apps, Boolean.hashCode(this.allEnabled) * 31, 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AppsUIState(allEnabled=");
        sb.append(this.allEnabled);
        sb.append(", apps=");
        sb.append(this.apps);
        sb.append(", filteredApps=");
        return LocaleList$$ExternalSyntheticOutline0.m(sb, this.filteredApps, ')');
    }

    public AppsUIState(boolean z, List<AppState> apps, List<AppState> filteredApps) {
        Intrinsics.checkNotNullParameter(apps, "apps");
        Intrinsics.checkNotNullParameter(filteredApps, "filteredApps");
        this.allEnabled = z;
        this.apps = apps;
        this.filteredApps = filteredApps;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ AppsUIState(boolean r2, java.util.List r3, java.util.List r4, int r5, kotlin.jvm.internal.DefaultConstructorMarker r6) {
        /*
            r1 = this;
            r6 = r5 & 1
            if (r6 == 0) goto L5
            r2 = 0
        L5:
            r6 = r5 & 2
            kotlin.collections.EmptyList r0 = kotlin.collections.EmptyList.INSTANCE
            if (r6 == 0) goto Lc
            r3 = r0
        Lc:
            r5 = r5 & 4
            if (r5 == 0) goto L11
            r4 = r0
        L11:
            r1.<init>(r2, r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.settings.displaynotifications.AppsUIState.<init>(boolean, java.util.List, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
