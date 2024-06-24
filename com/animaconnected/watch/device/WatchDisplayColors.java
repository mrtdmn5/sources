package com.animaconnected.watch.device;

import androidx.compose.animation.AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0;
import com.animaconnected.watch.image.Kolor;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WatchStyle.kt */
/* loaded from: classes3.dex */
public final class WatchDisplayColors {
    private final int background;
    private final int foreground;
    private final int highlight;
    private final boolean sync;

    public /* synthetic */ WatchDisplayColors(int r1, int r2, int r3, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, r2, r3, z);
    }

    /* renamed from: copy-6kCbuTE$default, reason: not valid java name */
    public static /* synthetic */ WatchDisplayColors m1086copy6kCbuTE$default(WatchDisplayColors watchDisplayColors, int r1, int r2, int r3, boolean z, int r5, Object obj) {
        if ((r5 & 1) != 0) {
            r1 = watchDisplayColors.background;
        }
        if ((r5 & 2) != 0) {
            r2 = watchDisplayColors.foreground;
        }
        if ((r5 & 4) != 0) {
            r3 = watchDisplayColors.highlight;
        }
        if ((r5 & 8) != 0) {
            z = watchDisplayColors.sync;
        }
        return watchDisplayColors.m1090copy6kCbuTE(r1, r2, r3, z);
    }

    /* renamed from: component1-IpmnaRI, reason: not valid java name */
    public final int m1087component1IpmnaRI() {
        return this.background;
    }

    /* renamed from: component2-IpmnaRI, reason: not valid java name */
    public final int m1088component2IpmnaRI() {
        return this.foreground;
    }

    /* renamed from: component3-IpmnaRI, reason: not valid java name */
    public final int m1089component3IpmnaRI() {
        return this.highlight;
    }

    public final boolean component4() {
        return this.sync;
    }

    /* renamed from: copy-6kCbuTE, reason: not valid java name */
    public final WatchDisplayColors m1090copy6kCbuTE(int r8, int r9, int r10, boolean z) {
        return new WatchDisplayColors(r8, r9, r10, z, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WatchDisplayColors)) {
            return false;
        }
        WatchDisplayColors watchDisplayColors = (WatchDisplayColors) obj;
        if (Kolor.m1539equalsimpl0(this.background, watchDisplayColors.background) && Kolor.m1539equalsimpl0(this.foreground, watchDisplayColors.foreground) && Kolor.m1539equalsimpl0(this.highlight, watchDisplayColors.highlight) && this.sync == watchDisplayColors.sync) {
            return true;
        }
        return false;
    }

    /* renamed from: getBackground-IpmnaRI, reason: not valid java name */
    public final int m1091getBackgroundIpmnaRI() {
        return this.background;
    }

    /* renamed from: getForeground-IpmnaRI, reason: not valid java name */
    public final int m1092getForegroundIpmnaRI() {
        return this.foreground;
    }

    /* renamed from: getHighlight-IpmnaRI, reason: not valid java name */
    public final int m1093getHighlightIpmnaRI() {
        return this.highlight;
    }

    public final boolean getSync() {
        return this.sync;
    }

    public int hashCode() {
        return Boolean.hashCode(this.sync) + ((Kolor.m1544hashCodeimpl(this.highlight) + ((Kolor.m1544hashCodeimpl(this.foreground) + (Kolor.m1544hashCodeimpl(this.background) * 31)) * 31)) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("WatchDisplayColors(background=");
        sb.append((Object) Kolor.m1545toStringimpl(this.background));
        sb.append(", foreground=");
        sb.append((Object) Kolor.m1545toStringimpl(this.foreground));
        sb.append(", highlight=");
        sb.append((Object) Kolor.m1545toStringimpl(this.highlight));
        sb.append(", sync=");
        return AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0.m(sb, this.sync, ')');
    }

    private WatchDisplayColors(int r1, int r2, int r3, boolean z) {
        this.background = r1;
        this.foreground = r2;
        this.highlight = r3;
        this.sync = z;
    }
}
