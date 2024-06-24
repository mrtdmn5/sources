package androidx.compose.ui.window;

import kotlin.jvm.internal.Intrinsics;
import org.sqlite.jdbc3.JDBC3PreparedStatement$$ExternalSyntheticLambda3;

/* compiled from: AndroidDialog.android.kt */
/* loaded from: classes.dex */
public final class DialogProperties {
    public final boolean decorFitsSystemWindows;
    public final boolean dismissOnBackPress;
    public final boolean dismissOnClickOutside;
    public final SecureFlagPolicy securePolicy;
    public final boolean usePlatformDefaultWidth;

    public DialogProperties(boolean z, boolean z2, SecureFlagPolicy securePolicy, boolean z3, boolean z4) {
        Intrinsics.checkNotNullParameter(securePolicy, "securePolicy");
        this.dismissOnBackPress = z;
        this.dismissOnClickOutside = z2;
        this.securePolicy = securePolicy;
        this.usePlatformDefaultWidth = z3;
        this.decorFitsSystemWindows = z4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DialogProperties)) {
            return false;
        }
        DialogProperties dialogProperties = (DialogProperties) obj;
        if (this.dismissOnBackPress == dialogProperties.dismissOnBackPress && this.dismissOnClickOutside == dialogProperties.dismissOnClickOutside && this.securePolicy == dialogProperties.securePolicy && this.usePlatformDefaultWidth == dialogProperties.usePlatformDefaultWidth && this.decorFitsSystemWindows == dialogProperties.decorFitsSystemWindows) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.decorFitsSystemWindows) + JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.usePlatformDefaultWidth, (this.securePolicy.hashCode() + JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.dismissOnClickOutside, Boolean.hashCode(this.dismissOnBackPress) * 31, 31)) * 31, 31);
    }

    public DialogProperties() {
        this(true, true, SecureFlagPolicy.Inherit, true, true);
    }
}
