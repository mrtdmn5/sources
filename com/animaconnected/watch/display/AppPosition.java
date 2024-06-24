package com.animaconnected.watch.display;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: WatchAppInterfaces.kt */
/* loaded from: classes3.dex */
public final class AppPosition {
    private final AppId appId;
    private final int position;

    public AppPosition(int r2, AppId appId) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        this.position = r2;
        this.appId = appId;
    }

    public static /* synthetic */ AppPosition copy$default(AppPosition appPosition, int r1, AppId appId, int r3, Object obj) {
        if ((r3 & 1) != 0) {
            r1 = appPosition.position;
        }
        if ((r3 & 2) != 0) {
            appId = appPosition.appId;
        }
        return appPosition.copy(r1, appId);
    }

    public final int component1() {
        return this.position;
    }

    public final AppId component2() {
        return this.appId;
    }

    public final AppPosition copy(int r2, AppId appId) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        return new AppPosition(r2, appId);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppPosition)) {
            return false;
        }
        AppPosition appPosition = (AppPosition) obj;
        if (this.position == appPosition.position && this.appId == appPosition.appId) {
            return true;
        }
        return false;
    }

    public final AppId getAppId() {
        return this.appId;
    }

    public final int getPosition() {
        return this.position;
    }

    public int hashCode() {
        return this.appId.hashCode() + (Integer.hashCode(this.position) * 31);
    }

    public String toString() {
        return "AppPosition(position=" + this.position + ", appId=" + this.appId + ')';
    }
}
