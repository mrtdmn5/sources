package kotlinx.coroutines.internal;

import java.util.Arrays;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import kotlinx.coroutines.android.AndroidExceptionPreHandler;
import kotlinx.coroutines.test.internal.ExceptionCollectorAsService;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes4.dex */
public final /* synthetic */ class CoroutineExceptionHandlerImplKt$$ExternalSyntheticServiceLoad0 {
    public static /* synthetic */ Iterator m() {
        try {
            return Arrays.asList(new AndroidExceptionPreHandler(), new ExceptionCollectorAsService()).iterator();
        } catch (Throwable th) {
            throw new ServiceConfigurationError(th.getMessage(), th);
        }
    }
}
