package androidx.compose.ui.text.input;

import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;
import com.google.android.gms.measurement.internal.zzdn;
import org.sqlite.jdbc3.JDBC3PreparedStatement$$ExternalSyntheticLambda3;

/* compiled from: ImeOptions.kt */
/* loaded from: classes.dex */
public final class ImeOptions {
    public static final ImeOptions Default = new ImeOptions(false, 0, true, 1, 1);
    public final boolean autoCorrect;
    public final int capitalization;
    public final int imeAction;
    public final int keyboardType;
    public final boolean singleLine;

    public ImeOptions(boolean z, int r2, boolean z2, int r4, int r5) {
        this.singleLine = z;
        this.capitalization = r2;
        this.autoCorrect = z2;
        this.keyboardType = r4;
        this.imeAction = r5;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        boolean z3;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImeOptions)) {
            return false;
        }
        ImeOptions imeOptions = (ImeOptions) obj;
        if (this.singleLine != imeOptions.singleLine) {
            return false;
        }
        if (this.capitalization == imeOptions.capitalization) {
            z = true;
        } else {
            z = false;
        }
        if (!z || this.autoCorrect != imeOptions.autoCorrect) {
            return false;
        }
        if (this.keyboardType == imeOptions.keyboardType) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            return false;
        }
        if (this.imeAction == imeOptions.imeAction) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Integer.hashCode(this.imeAction) + HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.keyboardType, JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.autoCorrect, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.capitalization, Boolean.hashCode(this.singleLine) * 31, 31), 31), 31);
    }

    public final String toString() {
        return "ImeOptions(singleLine=" + this.singleLine + ", capitalization=" + ((Object) zzdn.m1645toStringimpl(this.capitalization)) + ", autoCorrect=" + this.autoCorrect + ", keyboardType=" + ((Object) KeyboardType.m544toStringimpl(this.keyboardType)) + ", imeAction=" + ((Object) ImeAction.m542toStringimpl(this.imeAction)) + ')';
    }
}
