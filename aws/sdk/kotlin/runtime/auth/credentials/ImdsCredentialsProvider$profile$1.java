package aws.sdk.kotlin.runtime.auth.credentials;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* compiled from: ImdsCredentialsProvider.kt */
@DebugMetadata(c = "aws.sdk.kotlin.runtime.auth.credentials.ImdsCredentialsProvider$profile$1", f = "ImdsCredentialsProvider.kt", l = {69}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ImdsCredentialsProvider$profile$1 extends SuspendLambda implements Function1<Continuation<? super String>, Object> {
    public int label;
    public final /* synthetic */ ImdsCredentialsProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImdsCredentialsProvider$profile$1(ImdsCredentialsProvider imdsCredentialsProvider, Continuation<? super ImdsCredentialsProvider$profile$1> continuation) {
        super(1, continuation);
        this.this$0 = imdsCredentialsProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new ImdsCredentialsProvider$profile$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super String> continuation) {
        return ((ImdsCredentialsProvider$profile$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
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
            ImdsCredentialsProvider imdsCredentialsProvider = this.this$0;
            String str = imdsCredentialsProvider.profileOverride;
            if (str != null) {
                return str;
            }
            this.label = 1;
            obj = ImdsCredentialsProvider.access$loadProfile(imdsCredentialsProvider, this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return obj;
    }
}
