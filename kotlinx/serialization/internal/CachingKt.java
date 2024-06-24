package kotlinx.serialization.internal;

import kotlin.Result;
import kotlin.ResultKt;

/* compiled from: Caching.kt */
/* loaded from: classes4.dex */
public final class CachingKt {
    public static final boolean useClassValue;

    static {
        Object createFailure;
        try {
            createFailure = Class.forName("java.lang.ClassValue");
        } catch (Throwable th) {
            createFailure = ResultKt.createFailure(th);
        }
        if (!(createFailure instanceof Result.Failure)) {
            createFailure = Boolean.TRUE;
        }
        Object obj = Boolean.FALSE;
        if (createFailure instanceof Result.Failure) {
            createFailure = obj;
        }
        useClassValue = ((Boolean) createFailure).booleanValue();
    }
}
