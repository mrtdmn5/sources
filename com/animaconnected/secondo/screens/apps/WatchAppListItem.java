package com.animaconnected.secondo.screens.apps;

import androidx.compose.animation.AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0;
import com.animaconnected.secondo.screens.apps.AppsListItem;
import com.animaconnected.watch.display.WatchApp;
import kotlin.jvm.internal.Intrinsics;
import org.sqlite.jdbc3.JDBC3PreparedStatement$$ExternalSyntheticLambda3;

/* compiled from: WatchAppViewHolder.kt */
/* loaded from: classes3.dex */
public final class WatchAppListItem implements AppsListItem {
    public static final int $stable = 8;

    /* renamed from: app, reason: collision with root package name */
    private final WatchApp f134app;
    private final Integer iconResource;
    private boolean isActive;
    private final AppsListItem.Type itemType;
    private boolean supportsQuickActions;

    public WatchAppListItem(WatchApp app2, Integer num, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(app2, "app");
        this.f134app = app2;
        this.iconResource = num;
        this.isActive = z;
        this.supportsQuickActions = z2;
        this.itemType = AppsListItem.Type.App;
    }

    public static /* synthetic */ WatchAppListItem copy$default(WatchAppListItem watchAppListItem, WatchApp watchApp, Integer num, boolean z, boolean z2, int r5, Object obj) {
        if ((r5 & 1) != 0) {
            watchApp = watchAppListItem.f134app;
        }
        if ((r5 & 2) != 0) {
            num = watchAppListItem.iconResource;
        }
        if ((r5 & 4) != 0) {
            z = watchAppListItem.isActive;
        }
        if ((r5 & 8) != 0) {
            z2 = watchAppListItem.supportsQuickActions;
        }
        return watchAppListItem.copy(watchApp, num, z, z2);
    }

    public final WatchApp component1() {
        return this.f134app;
    }

    public final Integer component2() {
        return this.iconResource;
    }

    public final boolean component3() {
        return this.isActive;
    }

    public final boolean component4() {
        return this.supportsQuickActions;
    }

    public final WatchAppListItem copy(WatchApp app2, Integer num, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(app2, "app");
        return new WatchAppListItem(app2, num, z, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WatchAppListItem)) {
            return false;
        }
        WatchAppListItem watchAppListItem = (WatchAppListItem) obj;
        if (Intrinsics.areEqual(this.f134app, watchAppListItem.f134app) && Intrinsics.areEqual(this.iconResource, watchAppListItem.iconResource) && this.isActive == watchAppListItem.isActive && this.supportsQuickActions == watchAppListItem.supportsQuickActions) {
            return true;
        }
        return false;
    }

    public final WatchApp getApp() {
        return this.f134app;
    }

    public final Integer getIconResource() {
        return this.iconResource;
    }

    @Override // com.animaconnected.secondo.screens.apps.AppsListItem
    public AppsListItem.Type getItemType() {
        return this.itemType;
    }

    public final boolean getSupportsQuickActions() {
        return this.supportsQuickActions;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = this.f134app.hashCode() * 31;
        Integer num = this.iconResource;
        if (num == null) {
            hashCode = 0;
        } else {
            hashCode = num.hashCode();
        }
        return Boolean.hashCode(this.supportsQuickActions) + JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.isActive, (hashCode2 + hashCode) * 31, 31);
    }

    public final boolean isActive() {
        return this.isActive;
    }

    public final void setActive(boolean z) {
        this.isActive = z;
    }

    public final void setSupportsQuickActions(boolean z) {
        this.supportsQuickActions = z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("WatchAppListItem(app=");
        sb.append(this.f134app);
        sb.append(", iconResource=");
        sb.append(this.iconResource);
        sb.append(", isActive=");
        sb.append(this.isActive);
        sb.append(", supportsQuickActions=");
        return AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0.m(sb, this.supportsQuickActions, ')');
    }
}
