package aws.smithy.kotlin.runtime.net;

import java.util.List;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: DefaultHostResolverJVM.kt */
/* loaded from: classes.dex */
public final class DefaultHostResolver implements HostResolver {
    public static final DefaultHostResolver INSTANCE = new DefaultHostResolver();

    @Override // aws.smithy.kotlin.runtime.net.HostResolver
    public final Object resolve(String str, Continuation<? super List<HostAddress>> continuation) {
        return BuildersKt.withContext(Dispatchers.IO, new DefaultHostResolver$resolve$2(str, null), continuation);
    }

    @Override // aws.smithy.kotlin.runtime.net.HostResolver
    public final void reportFailure(HostAddress hostAddress) {
    }
}
