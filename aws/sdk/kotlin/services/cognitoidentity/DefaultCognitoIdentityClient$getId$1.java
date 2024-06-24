package aws.sdk.kotlin.services.cognitoidentity;

import aws.sdk.kotlin.services.cognitoidentity.model.GetIdRequest;
import aws.smithy.kotlin.runtime.http.operation.SdkHttpOperation;
import java.io.Closeable;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: DefaultCognitoIdentityClient.kt */
@DebugMetadata(c = "aws.sdk.kotlin.services.cognitoidentity.DefaultCognitoIdentityClient", f = "DefaultCognitoIdentityClient.kt", l = {309, 951}, m = "getId")
/* loaded from: classes.dex */
public final class DefaultCognitoIdentityClient$getId$1 extends ContinuationImpl {
    public Closeable L$0;
    public GetIdRequest L$1;
    public SdkHttpOperation L$2;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ DefaultCognitoIdentityClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultCognitoIdentityClient$getId$1(DefaultCognitoIdentityClient defaultCognitoIdentityClient, Continuation<? super DefaultCognitoIdentityClient$getId$1> continuation) {
        super(continuation);
        this.this$0 = defaultCognitoIdentityClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getId(null, this);
    }
}
