package aws.smithy.kotlin.runtime.net;

import java.util.List;
import kotlin.coroutines.Continuation;

/* compiled from: HostResolver.kt */
/* loaded from: classes.dex */
public interface HostResolver {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: HostResolver.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
    }

    void reportFailure(HostAddress hostAddress);

    Object resolve(String str, Continuation<? super List<HostAddress>> continuation);
}
