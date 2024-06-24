package com.animaconnected.secondo.screens.details;

import android.os.Bundle;
import com.animaconnected.watch.Slot;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseDetailsFragment.kt */
/* loaded from: classes3.dex */
public final class BaseDetailsFragmentKt {
    public static final void putSlot(Bundle bundle, String key, Slot slot) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNull(slot, "null cannot be cast to non-null type java.io.Serializable");
        bundle.putSerializable(key, slot);
    }
}
