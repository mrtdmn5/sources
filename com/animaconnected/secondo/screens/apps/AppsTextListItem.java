package com.animaconnected.secondo.screens.apps;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import com.animaconnected.secondo.screens.apps.AppsListItem;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WatchAppViewHolder.kt */
/* loaded from: classes3.dex */
public final class AppsTextListItem implements AppsListItem {
    public static final int $stable = 0;
    private final String info;
    private final AppsListItem.Type itemType;
    private final String title;

    public AppsTextListItem(String title, String info) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(info, "info");
        this.title = title;
        this.info = info;
        this.itemType = AppsListItem.Type.Text;
    }

    public static /* synthetic */ AppsTextListItem copy$default(AppsTextListItem appsTextListItem, String str, String str2, int r3, Object obj) {
        if ((r3 & 1) != 0) {
            str = appsTextListItem.title;
        }
        if ((r3 & 2) != 0) {
            str2 = appsTextListItem.info;
        }
        return appsTextListItem.copy(str, str2);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.info;
    }

    public final AppsTextListItem copy(String title, String info) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(info, "info");
        return new AppsTextListItem(title, info);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppsTextListItem)) {
            return false;
        }
        AppsTextListItem appsTextListItem = (AppsTextListItem) obj;
        if (Intrinsics.areEqual(this.title, appsTextListItem.title) && Intrinsics.areEqual(this.info, appsTextListItem.info)) {
            return true;
        }
        return false;
    }

    public final String getInfo() {
        return this.info;
    }

    @Override // com.animaconnected.secondo.screens.apps.AppsListItem
    public AppsListItem.Type getItemType() {
        return this.itemType;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return this.info.hashCode() + (this.title.hashCode() * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AppsTextListItem(title=");
        sb.append(this.title);
        sb.append(", info=");
        return OpaqueKey$$ExternalSyntheticOutline0.m(sb, this.info, ')');
    }

    public /* synthetic */ AppsTextListItem(String str, String str2, int r3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (r3 & 2) != 0 ? "" : str2);
    }
}
