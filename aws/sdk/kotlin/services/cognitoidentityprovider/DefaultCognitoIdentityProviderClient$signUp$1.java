package aws.sdk.kotlin.services.cognitoidentityprovider;

import aws.sdk.kotlin.services.cognitoidentityprovider.model.SignUpRequest;
import aws.smithy.kotlin.runtime.http.operation.SdkHttpOperation;
import java.io.Closeable;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: DefaultCognitoIdentityProviderClient.kt */
@DebugMetadata(c = "aws.sdk.kotlin.services.cognitoidentityprovider.DefaultCognitoIdentityProviderClient", f = "DefaultCognitoIdentityProviderClient.kt", l = {3202, 3802}, m = "signUp")
/* loaded from: classes.dex */
public final class DefaultCognitoIdentityProviderClient$signUp$1 extends ContinuationImpl {
    public Closeable L$0;
    public SignUpRequest L$1;
    public SdkHttpOperation L$2;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ DefaultCognitoIdentityProviderClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultCognitoIdentityProviderClient$signUp$1(DefaultCognitoIdentityProviderClient defaultCognitoIdentityProviderClient, Continuation<? super DefaultCognitoIdentityProviderClient$signUp$1> continuation) {
        super(continuation);
        this.this$0 = defaultCognitoIdentityProviderClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.signUp(null, this);
    }
}
