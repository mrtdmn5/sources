package com.animaconnected.secondo.screens.settings.displaynotifications;

import android.graphics.drawable.Drawable;
import androidx.compose.animation.AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0;
import androidx.room.util.TableInfo$ForeignKey$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DisplayNotificationViewModel.kt */
/* loaded from: classes3.dex */
public final class AppState {
    public static final int $stable = 8;
    private final Drawable icon;
    private final boolean isSelected;
    private final String name;
    private final String packageName;

    public AppState(String name, String packageName, Drawable icon, boolean z) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(icon, "icon");
        this.name = name;
        this.packageName = packageName;
        this.icon = icon;
        this.isSelected = z;
    }

    public static /* synthetic */ AppState copy$default(AppState appState, String str, String str2, Drawable drawable, boolean z, int r5, Object obj) {
        if ((r5 & 1) != 0) {
            str = appState.name;
        }
        if ((r5 & 2) != 0) {
            str2 = appState.packageName;
        }
        if ((r5 & 4) != 0) {
            drawable = appState.icon;
        }
        if ((r5 & 8) != 0) {
            z = appState.isSelected;
        }
        return appState.copy(str, str2, drawable, z);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.packageName;
    }

    public final Drawable component3() {
        return this.icon;
    }

    public final boolean component4() {
        return this.isSelected;
    }

    public final AppState copy(String name, String packageName, Drawable icon, boolean z) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(icon, "icon");
        return new AppState(name, packageName, icon, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppState)) {
            return false;
        }
        AppState appState = (AppState) obj;
        if (Intrinsics.areEqual(this.name, appState.name) && Intrinsics.areEqual(this.packageName, appState.packageName) && Intrinsics.areEqual(this.icon, appState.icon) && this.isSelected == appState.isSelected) {
            return true;
        }
        return false;
    }

    public final Drawable getIcon() {
        return this.icon;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public int hashCode() {
        return Boolean.hashCode(this.isSelected) + ((this.icon.hashCode() + TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.packageName, this.name.hashCode() * 31, 31)) * 31);
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AppState(name=");
        sb.append(this.name);
        sb.append(", packageName=");
        sb.append(this.packageName);
        sb.append(", icon=");
        sb.append(this.icon);
        sb.append(", isSelected=");
        return AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0.m(sb, this.isSelected, ')');
    }
}
