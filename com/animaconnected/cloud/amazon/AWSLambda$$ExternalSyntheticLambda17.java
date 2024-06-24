package com.animaconnected.cloud.amazon;

import com.animaconnected.cloud.amazon.lambda.RemoteDebugReturn;
import com.animaconnected.future.MapCallback;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class AWSLambda$$ExternalSyntheticLambda17 implements MapCallback {
    @Override // com.animaconnected.future.MapCallback
    public final Object onResult(Object obj) {
        return ((RemoteDebugReturn) obj).getForceCrash();
    }
}
