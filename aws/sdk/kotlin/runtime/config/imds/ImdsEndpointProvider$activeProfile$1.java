package aws.sdk.kotlin.runtime.config.imds;

import aws.sdk.kotlin.runtime.config.profile.AwsConfigLoaderKt;
import aws.sdk.kotlin.runtime.config.profile.AwsProfile;
import aws.smithy.kotlin.runtime.util.PlatformProvider;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* compiled from: ImdsEndpointProvider.kt */
@DebugMetadata(c = "aws.sdk.kotlin.runtime.config.imds.ImdsEndpointProvider$activeProfile$1", f = "ImdsEndpointProvider.kt", l = {25}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ImdsEndpointProvider$activeProfile$1 extends SuspendLambda implements Function1<Continuation<? super AwsProfile>, Object> {
    public int label;
    public final /* synthetic */ ImdsEndpointProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImdsEndpointProvider$activeProfile$1(ImdsEndpointProvider imdsEndpointProvider, Continuation<? super ImdsEndpointProvider$activeProfile$1> continuation) {
        super(1, continuation);
        this.this$0 = imdsEndpointProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new ImdsEndpointProvider$activeProfile$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super AwsProfile> continuation) {
        return ((ImdsEndpointProvider$activeProfile$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
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
            PlatformProvider platformProvider = this.this$0.platformProvider;
            this.label = 1;
            obj = AwsConfigLoaderKt.loadActiveAwsProfile(platformProvider, this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return obj;
    }
}
