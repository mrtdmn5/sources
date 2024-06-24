package org.sqlite.jdbc3;

import com.animaconnected.cloud.amazon.AWSLambda;
import com.animaconnected.cloud.amazon.lambda.IftttReturn;
import com.animaconnected.future.MapCallback;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes4.dex */
public final /* synthetic */ class JDBC3Statement$$ExternalSyntheticLambda1 implements MapCallback {
    @Override // com.animaconnected.future.MapCallback
    public final Object onResult(Object obj) {
        Void lambda$sendIftttTrigger$18;
        lambda$sendIftttTrigger$18 = AWSLambda.lambda$sendIftttTrigger$18((IftttReturn) obj);
        return lambda$sendIftttTrigger$18;
    }
}
