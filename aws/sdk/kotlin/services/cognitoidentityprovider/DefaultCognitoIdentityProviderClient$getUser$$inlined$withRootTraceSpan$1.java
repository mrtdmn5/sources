package aws.sdk.kotlin.services.cognitoidentityprovider;

import aws.sdk.kotlin.services.cognitoidentityprovider.model.GetUserRequest;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.GetUserResponse;
import aws.smithy.kotlin.runtime.http.SdkHttpClient;
import aws.smithy.kotlin.runtime.http.operation.SdkHttpOperation;
import aws.smithy.kotlin.runtime.http.operation.SdkHttpOperationKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: CoroutineContextUtils.kt */
@DebugMetadata(c = "aws.sdk.kotlin.services.cognitoidentityprovider.DefaultCognitoIdentityProviderClient$getUser$$inlined$withRootTraceSpan$1", f = "DefaultCognitoIdentityProviderClient.kt", l = {228}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class DefaultCognitoIdentityProviderClient$getUser$$inlined$withRootTraceSpan$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super GetUserResponse>, Object> {
    public final /* synthetic */ GetUserRequest $input$inlined;
    public final /* synthetic */ SdkHttpOperation $op$inlined;
    public /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ DefaultCognitoIdentityProviderClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultCognitoIdentityProviderClient$getUser$$inlined$withRootTraceSpan$1(Continuation continuation, SdkHttpOperation sdkHttpOperation, DefaultCognitoIdentityProviderClient defaultCognitoIdentityProviderClient, GetUserRequest getUserRequest) {
        super(2, continuation);
        this.$op$inlined = sdkHttpOperation;
        this.this$0 = defaultCognitoIdentityProviderClient;
        this.$input$inlined = getUserRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DefaultCognitoIdentityProviderClient$getUser$$inlined$withRootTraceSpan$1 defaultCognitoIdentityProviderClient$getUser$$inlined$withRootTraceSpan$1 = new DefaultCognitoIdentityProviderClient$getUser$$inlined$withRootTraceSpan$1(continuation, this.$op$inlined, this.this$0, this.$input$inlined);
        defaultCognitoIdentityProviderClient$getUser$$inlined$withRootTraceSpan$1.L$0 = obj;
        return defaultCognitoIdentityProviderClient$getUser$$inlined$withRootTraceSpan$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super GetUserResponse> continuation) {
        return ((DefaultCognitoIdentityProviderClient$getUser$$inlined$withRootTraceSpan$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            SdkHttpClient sdkHttpClient = this.this$0.client;
            this.label = 1;
            obj = SdkHttpOperationKt.roundTrip(this.$op$inlined, sdkHttpClient, this.$input$inlined, this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return obj;
    }
}
