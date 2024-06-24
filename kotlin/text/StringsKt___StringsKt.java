package kotlin.text;

import androidx.compose.runtime.ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import kotlin.collections.SlidingWindowKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: _Strings.kt */
/* loaded from: classes.dex */
public class StringsKt___StringsKt extends StringsKt___StringsJvmKt {
    public static final String drop(int r1, String str) {
        boolean z;
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (r1 >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            int length = str.length();
            if (r1 > length) {
                r1 = length;
            }
            String substring = str.substring(r1);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            return substring;
        }
        throw new IllegalArgumentException(ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0.m("Requested character count ", r1, " is less than zero.").toString());
    }

    public static final char first(CharSequence charSequence) {
        boolean z;
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (charSequence.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return charSequence.charAt(0);
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    public static final char last(CharSequence charSequence) {
        boolean z;
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (charSequence.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return charSequence.charAt(StringsKt__StringsKt.getLastIndex(charSequence));
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    public static final String take(int r2, String str) {
        boolean z;
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (r2 >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            int length = str.length();
            if (r2 > length) {
                r2 = length;
            }
            String substring = str.substring(0, r2);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            return substring;
        }
        throw new IllegalArgumentException(ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0.m("Requested character count ", r2, " is less than zero.").toString());
    }

    public static final String takeLast(int r1, String str) {
        boolean z;
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (r1 >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            int length = str.length();
            if (r1 > length) {
                r1 = length;
            }
            String substring = str.substring(length - r1);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            return substring;
        }
        throw new IllegalArgumentException(ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0.m("Requested character count ", r1, " is less than zero.").toString());
    }

    public static final ArrayList windowed(String str, int r7, int r8, boolean z, Function1 transform) {
        int r2;
        boolean z2;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        SlidingWindowKt.checkWindowSizeStep(r7, r8);
        int length = str.length();
        int r1 = length / r8;
        if (length % r8 == 0) {
            r2 = 0;
        } else {
            r2 = 1;
        }
        ArrayList arrayList = new ArrayList(r1 + r2);
        int r12 = 0;
        while (true) {
            if (r12 >= 0 && r12 < length) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                break;
            }
            int r5 = r12 + r7;
            if (r5 < 0 || r5 > length) {
                if (!z) {
                    break;
                }
                r5 = length;
            }
            arrayList.add(transform.invoke(str.subSequence(r12, r5)));
            r12 += r8;
        }
        return arrayList;
    }
}
