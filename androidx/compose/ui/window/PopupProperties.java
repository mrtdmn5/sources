package androidx.compose.ui.window;

import kotlin.jvm.internal.Intrinsics;
import org.sqlite.jdbc3.JDBC3PreparedStatement$$ExternalSyntheticLambda3;

/* compiled from: AndroidPopup.android.kt */
/* loaded from: classes.dex */
public final class PopupProperties {
    public final boolean clippingEnabled;
    public final boolean dismissOnBackPress;
    public final boolean dismissOnClickOutside;
    public final boolean excludeFromSystemGesture;
    public final boolean focusable;
    public final SecureFlagPolicy securePolicy;
    public final boolean usePlatformDefaultWidth;

    public PopupProperties(boolean z, boolean z2, boolean z3, SecureFlagPolicy securePolicy, boolean z4, boolean z5, boolean z6) {
        Intrinsics.checkNotNullParameter(securePolicy, "securePolicy");
        this.focusable = z;
        this.dismissOnBackPress = z2;
        this.dismissOnClickOutside = z3;
        this.securePolicy = securePolicy;
        this.excludeFromSystemGesture = z4;
        this.clippingEnabled = z5;
        this.usePlatformDefaultWidth = z6;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PopupProperties)) {
            return false;
        }
        PopupProperties popupProperties = (PopupProperties) obj;
        if (this.focusable == popupProperties.focusable && this.dismissOnBackPress == popupProperties.dismissOnBackPress && this.dismissOnClickOutside == popupProperties.dismissOnClickOutside && this.securePolicy == popupProperties.securePolicy && this.excludeFromSystemGesture == popupProperties.excludeFromSystemGesture && this.clippingEnabled == popupProperties.clippingEnabled && this.usePlatformDefaultWidth == popupProperties.usePlatformDefaultWidth) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        boolean z = this.dismissOnBackPress;
        return Boolean.hashCode(this.usePlatformDefaultWidth) + JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.clippingEnabled, JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.excludeFromSystemGesture, (this.securePolicy.hashCode() + JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.dismissOnClickOutside, JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(z, JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.focusable, Boolean.hashCode(z) * 31, 31), 31), 31)) * 31, 31), 31);
    }

    public PopupProperties() {
        this(false, true, true, SecureFlagPolicy.Inherit, true, true, false);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public PopupProperties(boolean r11, boolean r12, int r13) {
        /*
            r10 = this;
            r0 = r13 & 1
            r1 = 0
            if (r0 == 0) goto L7
            r3 = r1
            goto L8
        L7:
            r3 = r11
        L8:
            r11 = r13 & 2
            r0 = 1
            if (r11 == 0) goto Lf
            r4 = r0
            goto L10
        Lf:
            r4 = r1
        L10:
            r11 = r13 & 4
            if (r11 == 0) goto L16
            r5 = r0
            goto L17
        L16:
            r5 = r1
        L17:
            r11 = r13 & 8
            if (r11 == 0) goto L1e
            androidx.compose.ui.window.SecureFlagPolicy r11 = androidx.compose.ui.window.SecureFlagPolicy.Inherit
            goto L1f
        L1e:
            r11 = 0
        L1f:
            r6 = r11
            r11 = r13 & 16
            if (r11 == 0) goto L26
            r7 = r0
            goto L27
        L26:
            r7 = r12
        L27:
            r11 = r13 & 32
            if (r11 == 0) goto L2d
            r8 = r0
            goto L2e
        L2d:
            r8 = r1
        L2e:
            java.lang.String r11 = "securePolicy"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r11)
            r9 = 0
            r2 = r10
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.window.PopupProperties.<init>(boolean, boolean, int):void");
    }
}
