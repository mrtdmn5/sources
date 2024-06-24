package org.sqlite.jdbc3;

import com.animaconnected.cloud.amazon.lambda.GetProductInfoReturn;
import com.animaconnected.cloud.util.CloudProductInfoResponse;
import com.animaconnected.future.MapCallback;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes4.dex */
public final /* synthetic */ class JDBC3PreparedStatement$$ExternalSyntheticLambda4 implements MapCallback {
    @Override // com.animaconnected.future.MapCallback
    public final Object onResult(Object obj) {
        return new CloudProductInfoResponse((GetProductInfoReturn) obj);
    }
}
