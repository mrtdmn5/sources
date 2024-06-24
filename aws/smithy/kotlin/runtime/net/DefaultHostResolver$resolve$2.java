package aws.smithy.kotlin.runtime.net;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.CookieJar$Companion$NoCookies;

/* compiled from: DefaultHostResolverJVM.kt */
@DebugMetadata(c = "aws.smithy.kotlin.runtime.net.DefaultHostResolver$resolve$2", f = "DefaultHostResolverJVM.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class DefaultHostResolver$resolve$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends HostAddress>>, Object> {
    public final /* synthetic */ String $hostname;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultHostResolver$resolve$2(String str, Continuation<? super DefaultHostResolver$resolve$2> continuation) {
        super(2, continuation);
        this.$hostname = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DefaultHostResolver$resolve$2(this.$hostname, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends HostAddress>> continuation) {
        return ((DefaultHostResolver$resolve$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        ResultKt.throwOnFailure(obj);
        InetAddress[] allByName = InetAddress.getAllByName(this.$hostname);
        Intrinsics.checkNotNullExpressionValue(allByName, "getAllByName(hostname)");
        ArrayList arrayList = new ArrayList(allByName.length);
        for (InetAddress it : allByName) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            arrayList.add(CookieJar$Companion$NoCookies.toHostAddress(it));
        }
        return arrayList;
    }
}
