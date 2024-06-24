package kotlinx.coroutines.internal;

import java.util.Arrays;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import kotlinx.coroutines.android.AndroidDispatcherFactory;
import kotlinx.coroutines.test.internal.TestMainDispatcherFactory;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes4.dex */
public final /* synthetic */ class MainDispatcherLoader$$ExternalSyntheticServiceLoad0 {
    public static /* synthetic */ Iterator m() {
        try {
            return Arrays.asList(new AndroidDispatcherFactory(), new TestMainDispatcherFactory()).iterator();
        } catch (Throwable th) {
            throw new ServiceConfigurationError(th.getMessage(), th);
        }
    }
}
