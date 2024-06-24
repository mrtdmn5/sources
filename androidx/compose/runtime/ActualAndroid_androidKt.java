package androidx.compose.runtime;

import android.os.Looper;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;

/* compiled from: ActualAndroid.android.kt */
/* loaded from: classes.dex */
public final class ActualAndroid_androidKt {
    public static final /* synthetic */ int $r8$clinit = 0;

    static {
        LazyKt__LazyJVMKt.lazy(new Function0<MonotonicFrameClock>() { // from class: androidx.compose.runtime.ActualAndroid_androidKt$DefaultMonotonicFrameClock$2
            @Override // kotlin.jvm.functions.Function0
            public final MonotonicFrameClock invoke() {
                if (Looper.getMainLooper() != null) {
                    return DefaultChoreographerFrameClock.INSTANCE;
                }
                return SdkStubsFallbackFrameClock.INSTANCE;
            }
        });
    }
}
