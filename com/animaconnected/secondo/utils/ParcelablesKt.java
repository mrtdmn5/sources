package com.animaconnected.secondo.utils;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Parcelables.kt */
/* loaded from: classes3.dex */
public final class ParcelablesKt {
    public static final /* synthetic */ <T extends Parcelable> T parcelable(Intent intent, String key) {
        Intrinsics.checkNotNullParameter(intent, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (Build.VERSION.SDK_INT >= 33) {
            Intrinsics.reifiedOperationMarker();
            throw null;
        }
        intent.getParcelableExtra(key);
        Intrinsics.reifiedOperationMarker();
        throw null;
    }

    public static final /* synthetic */ <T extends Serializable> Serializable serializableExtra(Intent intent, String name) {
        Intrinsics.checkNotNullParameter(intent, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        if (Build.VERSION.SDK_INT < 33) {
            return intent.getSerializableExtra(name);
        }
        Intrinsics.reifiedOperationMarker();
        throw null;
    }

    public static final /* synthetic */ <T extends Parcelable> T parcelable(Bundle bundle, String key) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (Build.VERSION.SDK_INT >= 33) {
            Intrinsics.reifiedOperationMarker();
            throw null;
        }
        bundle.getParcelable(key);
        Intrinsics.reifiedOperationMarker();
        throw null;
    }
}
