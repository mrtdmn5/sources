package androidx.core.util;

import kotlinx.serialization.KSerializer;

/* loaded from: classes.dex */
public final class Preconditions {
    public static final KSerializer[] EMPTY_SERIALIZER_ARRAY = new KSerializer[0];

    public static void checkArgument(String str, boolean z) {
        if (z) {
        } else {
            throw new IllegalArgumentException(str);
        }
    }

    public static void checkArgumentNonnegative(int r0) {
        if (r0 >= 0) {
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static void checkNotNull(Object obj, String str) {
        if (obj != null) {
        } else {
            throw new NullPointerException(str);
        }
    }
}
