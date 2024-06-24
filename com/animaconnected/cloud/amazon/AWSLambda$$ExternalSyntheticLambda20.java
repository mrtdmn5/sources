package com.animaconnected.cloud.amazon;

import com.animaconnected.cloud.amazon.lambda.SendStatusDestinationReturn;
import com.animaconnected.cloud.util.CloudStatusResponse;
import com.animaconnected.future.MapCallback;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class AWSLambda$$ExternalSyntheticLambda20 implements MapCallback {
    @Override // com.animaconnected.future.MapCallback
    public final Object onResult(Object obj) {
        CloudStatusResponse lambda$sendStatus$3;
        lambda$sendStatus$3 = AWSLambda.lambda$sendStatus$3((SendStatusDestinationReturn) obj);
        return lambda$sendStatus$3;
    }
}
