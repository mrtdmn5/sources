package com.animaconnected.watch.behaviour.worldtime;

import com.animaconnected.watch.strings.Key;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: WorldTime.kt */
/* loaded from: classes3.dex */
public final class WorldTimeKt {
    public static final Key toStringKey(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Key.valueOf(StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(str, "/", "_"), "-", "_"));
    }
}
