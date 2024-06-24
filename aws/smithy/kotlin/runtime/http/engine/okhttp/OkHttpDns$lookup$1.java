package aws.smithy.kotlin.runtime.http.engine.okhttp;

import aws.smithy.kotlin.runtime.net.HostAddress;
import aws.smithy.kotlin.runtime.net.HostResolver;
import com.animaconnected.secondo.R;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: OkHttpUtils.kt */
@DebugMetadata(c = "aws.smithy.kotlin.runtime.http.engine.okhttp.OkHttpDns$lookup$1", f = "OkHttpUtils.kt", l = {R.styleable.AppTheme_stepsHistoryBackgroundDetail}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class OkHttpDns$lookup$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends InetAddress>>, Object> {
    public final /* synthetic */ String $hostname;
    public int label;
    public final /* synthetic */ OkHttpDns this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OkHttpDns$lookup$1(OkHttpDns okHttpDns, String str, Continuation<? super OkHttpDns$lookup$1> continuation) {
        super(2, continuation);
        this.this$0 = okHttpDns;
        this.$hostname = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OkHttpDns$lookup$1(this.this$0, this.$hostname, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends InetAddress>> continuation) {
        return ((OkHttpDns$lookup$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            HostResolver hostResolver = this.this$0.hr;
            this.label = 1;
            obj = hostResolver.resolve(this.$hostname, this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        List<HostAddress> list = (List) obj;
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list, 10));
        for (HostAddress hostAddress : list) {
            Intrinsics.checkNotNullParameter(hostAddress, "<this>");
            InetAddress byAddress = InetAddress.getByAddress(hostAddress.hostname, hostAddress.address.getOctets());
            Intrinsics.checkNotNullExpressionValue(byAddress, "getByAddress(hostname, address.octets)");
            arrayList.add(byAddress);
        }
        return arrayList;
    }
}
