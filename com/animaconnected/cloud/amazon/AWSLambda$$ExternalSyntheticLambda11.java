package com.animaconnected.cloud.amazon;

import com.animaconnected.cloud.amazon.lambda.IftttReturn;
import com.animaconnected.cloud.util.CloudIftttStatus;
import com.animaconnected.future.MapCallback;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class AWSLambda$$ExternalSyntheticLambda11 implements MapCallback {
    @Override // com.animaconnected.future.MapCallback
    public final Object onResult(Object obj) {
        CloudIftttStatus lambda$getIftttStatus$16;
        lambda$getIftttStatus$16 = AWSLambda.lambda$getIftttStatus$16((IftttReturn) obj);
        return lambda$getIftttStatus$16;
    }
}
