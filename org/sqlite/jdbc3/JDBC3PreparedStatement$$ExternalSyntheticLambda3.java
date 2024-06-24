package org.sqlite.jdbc3;

import com.animaconnected.cloud.amazon.AWSLambda;
import com.animaconnected.cloud.amazon.lambda.IftttReturn;
import com.animaconnected.future.MapCallback;
import java.net.URL;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes4.dex */
public final /* synthetic */ class JDBC3PreparedStatement$$ExternalSyntheticLambda3 implements MapCallback {
    public static int m(double d, int r2, int r3) {
        return (Double.hashCode(d) + r2) * r3;
    }

    @Override // com.animaconnected.future.MapCallback
    public Object onResult(Object obj) {
        URL lambda$getIftttSetupUrl$14;
        lambda$getIftttSetupUrl$14 = AWSLambda.lambda$getIftttSetupUrl$14((IftttReturn) obj);
        return lambda$getIftttSetupUrl$14;
    }

    public static int m(boolean z, int r1, int r2) {
        return (Boolean.hashCode(z) + r1) * r2;
    }
}
