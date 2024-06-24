package com.animaconnected.info;

import j$.time.Clock;
import j$.time.Instant;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class DateTimeUtilsKt$$ExternalSyntheticOutline0 {
    public static Instant m(String str) {
        Instant instant = Clock.systemUTC().instant();
        Intrinsics.checkNotNullExpressionValue(instant, str);
        return instant;
    }
}
