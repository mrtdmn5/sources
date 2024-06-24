package okhttp3.internal;

import java.util.concurrent.ThreadFactory;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes4.dex */
public final /* synthetic */ class _UtilJvmKt$$ExternalSyntheticLambda0 implements ThreadFactory {
    public final /* synthetic */ String f$0;
    public final /* synthetic */ boolean f$1;

    public /* synthetic */ _UtilJvmKt$$ExternalSyntheticLambda0(String str, boolean z) {
        this.f$0 = str;
        this.f$1 = z;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        String name = this.f$0;
        Intrinsics.checkNotNullParameter(name, "$name");
        Thread thread = new Thread(runnable, name);
        thread.setDaemon(this.f$1);
        return thread;
    }
}
