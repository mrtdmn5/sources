package com.animaconnected.cloud.amazon;

import com.animaconnected.cloud.amazon.lambda.LambdaFunctions;
import com.animaconnected.future.MapCallback;
import com.google.android.gms.maps.GoogleMap;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class AWSLambda$$ExternalSyntheticLambda2 implements MapCallback, GoogleMap.OnMapLoadedCallback {
    public final /* synthetic */ Object f$0;

    public /* synthetic */ AWSLambda$$ExternalSyntheticLambda2(Object obj) {
        this.f$0 = obj;
    }

    @Override // com.animaconnected.future.MapCallback
    public final Object onResult(Object obj) {
        LambdaFunctions lambda$getLambdaFunctions$0;
        lambda$getLambdaFunctions$0 = ((AWSLambda) this.f$0).lambda$getLambdaFunctions$0((AWSAmplifyCredentials) obj);
        return lambda$getLambdaFunctions$0;
    }
}
