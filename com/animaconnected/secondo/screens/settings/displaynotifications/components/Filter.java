package com.animaconnected.secondo.screens.settings.displaynotifications.components;

import androidx.compose.animation.AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0;
import androidx.room.util.TableInfo$ForeignKey$$ExternalSyntheticOutline0;
import com.animaconnected.watch.filter.FilterSettings;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CallsTextComponents.kt */
/* loaded from: classes3.dex */
public final class Filter {
    public static final int $stable = 0;
    private final FilterSettings.Allowed allowed;
    private final String description;
    private final boolean showBadge;
    private final String title;

    public Filter(String title, String description, FilterSettings.Allowed allowed, boolean z) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(allowed, "allowed");
        this.title = title;
        this.description = description;
        this.allowed = allowed;
        this.showBadge = z;
    }

    public static /* synthetic */ Filter copy$default(Filter filter, String str, String str2, FilterSettings.Allowed allowed, boolean z, int r5, Object obj) {
        if ((r5 & 1) != 0) {
            str = filter.title;
        }
        if ((r5 & 2) != 0) {
            str2 = filter.description;
        }
        if ((r5 & 4) != 0) {
            allowed = filter.allowed;
        }
        if ((r5 & 8) != 0) {
            z = filter.showBadge;
        }
        return filter.copy(str, str2, allowed, z);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.description;
    }

    public final FilterSettings.Allowed component3() {
        return this.allowed;
    }

    public final boolean component4() {
        return this.showBadge;
    }

    public final Filter copy(String title, String description, FilterSettings.Allowed allowed, boolean z) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(allowed, "allowed");
        return new Filter(title, description, allowed, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Filter)) {
            return false;
        }
        Filter filter = (Filter) obj;
        if (Intrinsics.areEqual(this.title, filter.title) && Intrinsics.areEqual(this.description, filter.description) && this.allowed == filter.allowed && this.showBadge == filter.showBadge) {
            return true;
        }
        return false;
    }

    public final FilterSettings.Allowed getAllowed() {
        return this.allowed;
    }

    public final String getDescription() {
        return this.description;
    }

    public final boolean getShowBadge() {
        return this.showBadge;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return Boolean.hashCode(this.showBadge) + ((this.allowed.hashCode() + TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.description, this.title.hashCode() * 31, 31)) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Filter(title=");
        sb.append(this.title);
        sb.append(", description=");
        sb.append(this.description);
        sb.append(", allowed=");
        sb.append(this.allowed);
        sb.append(", showBadge=");
        return AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0.m(sb, this.showBadge, ')');
    }

    public /* synthetic */ Filter(String str, String str2, FilterSettings.Allowed allowed, boolean z, int r5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, allowed, (r5 & 8) != 0 ? false : z);
    }
}
