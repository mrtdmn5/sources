package org.sqlite.jdbc3;

import com.animaconnected.cloud.amazon.AWSCloud;
import com.animaconnected.cloud.amazon.lambda.TokenStorageReturn;
import com.animaconnected.future.MapCallback;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes4.dex */
public final /* synthetic */ class JDBC3PreparedStatement$$ExternalSyntheticLambda0 implements MapCallback {
    @Override // com.animaconnected.future.MapCallback
    public final Object onResult(Object obj) {
        Void lambda$updateTokens$0;
        lambda$updateTokens$0 = AWSCloud.lambda$updateTokens$0((TokenStorageReturn) obj);
        return lambda$updateTokens$0;
    }
}
