package com.google.android.gms.common.internal;

import android.os.Looper;
import android.text.TextUtils;
import com.amazonaws.services.s3.model.InstructionFileId;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes3.dex */
public final class Preconditions {
    public static void checkArgument(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkHandlerThread(com.google.android.gms.internal.base.zau zauVar) {
        String str;
        Looper myLooper = Looper.myLooper();
        if (myLooper != zauVar.getLooper()) {
            if (myLooper != null) {
                str = myLooper.getThread().getName();
            } else {
                str = "null current looper";
            }
            throw new IllegalStateException("Must be called on " + zauVar.getLooper().getThread().getName() + " thread, but got " + str + InstructionFileId.DOT);
        }
    }

    public static void checkMainThread(String str) {
        boolean z;
        if (Looper.getMainLooper() == Looper.myLooper()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
        } else {
            throw new IllegalStateException(str);
        }
    }

    @EnsuresNonNull({"#1"})
    public static void checkNotEmpty(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Given String is empty or null");
        }
    }

    public static void checkNotMainThread(String str) {
        boolean z;
        if (Looper.getMainLooper() == Looper.myLooper()) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
        } else {
            throw new IllegalStateException(str);
        }
    }

    @EnsuresNonNull({"#1"})
    public static void checkNotNull(Object obj) {
        if (obj == null) {
            throw new NullPointerException("null reference");
        }
    }

    public static void checkState(String str, boolean z) {
        if (z) {
        } else {
            throw new IllegalStateException(String.valueOf(str));
        }
    }

    public static void checkArgument(String str, boolean z) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(str));
        }
    }

    @EnsuresNonNull({"#1"})
    public static void checkNotNull(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    public static void checkArgument(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    @EnsuresNonNull({"#1"})
    public static void checkNotEmpty(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException(str);
        }
    }
}
