package kotlin.collections;

import com.google.firebase.concurrent.ExecutorsRegistrar$$ExternalSyntheticLambda8;

/* compiled from: Arrays.kt */
/* loaded from: classes.dex */
public class ArraysKt__ArraysKt {
    public static final void copyOfRangeToIndexCheck(int r4, int r5) {
        if (r4 <= r5) {
        } else {
            throw new IndexOutOfBoundsException(ExecutorsRegistrar$$ExternalSyntheticLambda8.m("toIndex (", r4, ") is greater than size (", r5, ")."));
        }
    }
}
