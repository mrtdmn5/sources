package androidx.compose.foundation;

import android.os.Build;
import androidx.compose.animation.AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0;
import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticOutline1;
import androidx.compose.animation.Scale$$ExternalSyntheticOutline0;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpSize;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.sqlite.jdbc3.JDBC3PreparedStatement$$ExternalSyntheticLambda3;

/* compiled from: Magnifier.kt */
/* loaded from: classes.dex */
public final class MagnifierStyle {
    public static final MagnifierStyle Default;
    public static final MagnifierStyle TextDefault;
    public final boolean clippingEnabled;
    public final float cornerRadius;
    public final float elevation;
    public final boolean fishEyeEnabled;
    public final long size;
    public final boolean useTextDefault;

    static {
        long j = DpSize.Unspecified;
        Default = new MagnifierStyle(false, j, Float.NaN, Float.NaN, true, false);
        TextDefault = new MagnifierStyle(true, j, Float.NaN, Float.NaN, true, false);
    }

    public MagnifierStyle(boolean z, long j, float f, float f2, boolean z2, boolean z3) {
        this.useTextDefault = z;
        this.size = j;
        this.cornerRadius = f;
        this.elevation = f2;
        this.clippingEnabled = z2;
        this.fishEyeEnabled = z3;
    }

    public final boolean equals(Object obj) {
        boolean z;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MagnifierStyle)) {
            return false;
        }
        MagnifierStyle magnifierStyle = (MagnifierStyle) obj;
        if (this.useTextDefault != magnifierStyle.useTextDefault) {
            return false;
        }
        if (this.size == magnifierStyle.size) {
            z = true;
        } else {
            z = false;
        }
        if (z && Dp.m579equalsimpl0(this.cornerRadius, magnifierStyle.cornerRadius) && Dp.m579equalsimpl0(this.elevation, magnifierStyle.elevation) && this.clippingEnabled == magnifierStyle.clippingEnabled && this.fishEyeEnabled == magnifierStyle.fishEyeEnabled) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = Boolean.hashCode(this.useTextDefault) * 31;
        int r1 = DpSize.$r8$clinit;
        return Boolean.hashCode(this.fishEyeEnabled) + JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.clippingEnabled, FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.elevation, FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.cornerRadius, Scale$$ExternalSyntheticOutline0.m(this.size, hashCode, 31), 31), 31), 31);
    }

    public final boolean isSupported() {
        boolean z;
        int r0 = Build.VERSION.SDK_INT;
        SemanticsPropertyKey<Function0<Offset>> semanticsPropertyKey = MagnifierKt.MagnifierPositionInRoot;
        if (r0 >= 28) {
            z = true;
        } else {
            z = false;
        }
        if (z && !this.fishEyeEnabled && (this.useTextDefault || Intrinsics.areEqual(this, Default) || r0 >= 29)) {
            return true;
        }
        return false;
    }

    public final String toString() {
        if (this.useTextDefault) {
            return "MagnifierStyle.TextDefault";
        }
        StringBuilder sb = new StringBuilder("MagnifierStyle(size=");
        sb.append((Object) DpSize.m588toStringimpl(this.size));
        sb.append(", cornerRadius=");
        sb.append((Object) Dp.m580toStringimpl(this.cornerRadius));
        sb.append(", elevation=");
        sb.append((Object) Dp.m580toStringimpl(this.elevation));
        sb.append(", clippingEnabled=");
        sb.append(this.clippingEnabled);
        sb.append(", fishEyeEnabled=");
        return AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0.m(sb, this.fishEyeEnabled, ')');
    }
}
