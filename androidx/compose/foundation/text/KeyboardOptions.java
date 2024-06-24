package androidx.compose.foundation.text;

import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardType;
import com.google.android.gms.measurement.internal.zzdn;
import org.sqlite.jdbc3.JDBC3PreparedStatement$$ExternalSyntheticLambda3;

/* compiled from: KeyboardOptions.kt */
/* loaded from: classes.dex */
public final class KeyboardOptions {
    public static final KeyboardOptions Default = new KeyboardOptions(0, 0, 0, 15);
    public final boolean autoCorrect;
    public final int capitalization;
    public final int imeAction;
    public final int keyboardType;

    public KeyboardOptions(int r4, int r5, int r6, int r7) {
        r4 = (r7 & 1) != 0 ? 0 : r4;
        boolean z = (r7 & 2) != 0;
        r5 = (r7 & 4) != 0 ? 1 : r5;
        r6 = (r7 & 8) != 0 ? 1 : r6;
        this.capitalization = r4;
        this.autoCorrect = z;
        this.keyboardType = r5;
        this.imeAction = r6;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        boolean z3;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KeyboardOptions)) {
            return false;
        }
        KeyboardOptions keyboardOptions = (KeyboardOptions) obj;
        if (this.capitalization == keyboardOptions.capitalization) {
            z = true;
        } else {
            z = false;
        }
        if (!z || this.autoCorrect != keyboardOptions.autoCorrect) {
            return false;
        }
        if (this.keyboardType == keyboardOptions.keyboardType) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            return false;
        }
        if (this.imeAction == keyboardOptions.imeAction) {
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
        return Integer.hashCode(this.imeAction) + HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.keyboardType, JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.autoCorrect, Integer.hashCode(this.capitalization) * 31, 31), 31);
    }

    public final String toString() {
        return "KeyboardOptions(capitalization=" + ((Object) zzdn.m1645toStringimpl(this.capitalization)) + ", autoCorrect=" + this.autoCorrect + ", keyboardType=" + ((Object) KeyboardType.m544toStringimpl(this.keyboardType)) + ", imeAction=" + ((Object) ImeAction.m542toStringimpl(this.imeAction)) + ')';
    }
}
