package com.animaconnected.secondo.screens.onboarding;

import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WhatsNewStorage.kt */
/* loaded from: classes3.dex */
final class WhatsNewInfo {
    private final Function0<Boolean> canShowUpdate;
    private final int description;
    private final int title;

    public WhatsNewInfo(Function0<Boolean> canShowUpdate, int r3, int r4) {
        Intrinsics.checkNotNullParameter(canShowUpdate, "canShowUpdate");
        this.canShowUpdate = canShowUpdate;
        this.title = r3;
        this.description = r4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WhatsNewInfo copy$default(WhatsNewInfo whatsNewInfo, Function0 function0, int r2, int r3, int r4, Object obj) {
        if ((r4 & 1) != 0) {
            function0 = whatsNewInfo.canShowUpdate;
        }
        if ((r4 & 2) != 0) {
            r2 = whatsNewInfo.title;
        }
        if ((r4 & 4) != 0) {
            r3 = whatsNewInfo.description;
        }
        return whatsNewInfo.copy(function0, r2, r3);
    }

    public final Function0<Boolean> component1() {
        return this.canShowUpdate;
    }

    public final int component2() {
        return this.title;
    }

    public final int component3() {
        return this.description;
    }

    public final WhatsNewInfo copy(Function0<Boolean> canShowUpdate, int r3, int r4) {
        Intrinsics.checkNotNullParameter(canShowUpdate, "canShowUpdate");
        return new WhatsNewInfo(canShowUpdate, r3, r4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WhatsNewInfo)) {
            return false;
        }
        WhatsNewInfo whatsNewInfo = (WhatsNewInfo) obj;
        if (Intrinsics.areEqual(this.canShowUpdate, whatsNewInfo.canShowUpdate) && this.title == whatsNewInfo.title && this.description == whatsNewInfo.description) {
            return true;
        }
        return false;
    }

    public final Function0<Boolean> getCanShowUpdate() {
        return this.canShowUpdate;
    }

    public final int getDescription() {
        return this.description;
    }

    public final int getTitle() {
        return this.title;
    }

    public int hashCode() {
        return Integer.hashCode(this.description) + HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.title, this.canShowUpdate.hashCode() * 31, 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("WhatsNewInfo(canShowUpdate=");
        sb.append(this.canShowUpdate);
        sb.append(", title=");
        sb.append(this.title);
        sb.append(", description=");
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.description, ')');
    }
}
