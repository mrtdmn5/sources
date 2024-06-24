package io.reactivex.internal.functions;

import io.reactivex.functions.BiPredicate;

/* loaded from: classes.dex */
public final class ObjectHelper {
    public static final BiObjectPredicate EQUALS = new BiObjectPredicate();

    /* loaded from: classes.dex */
    public static final class BiObjectPredicate implements BiPredicate<Object, Object> {
    }

    public static boolean equals(Object obj, Object obj2) {
        if (obj != obj2 && (obj == null || !obj.equals(obj2))) {
            return false;
        }
        return true;
    }

    public static void requireNonNull(Object obj, String str) {
        if (obj != null) {
        } else {
            throw new NullPointerException(str);
        }
    }

    public static void verifyPositive(int r2, String str) {
        if (r2 > 0) {
            return;
        }
        throw new IllegalArgumentException(str + " > 0 required but it was " + r2);
    }
}
