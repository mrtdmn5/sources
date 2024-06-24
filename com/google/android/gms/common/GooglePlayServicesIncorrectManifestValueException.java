package com.google.android.gms.common;

import com.google.android.gms.common.annotation.KeepName;
import com.google.firebase.concurrent.ExecutorsRegistrar$$ExternalSyntheticLambda8;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
@KeepName
/* loaded from: classes3.dex */
public final class GooglePlayServicesIncorrectManifestValueException extends GooglePlayServicesManifestException {
    public GooglePlayServicesIncorrectManifestValueException(int r5) {
        super(ExecutorsRegistrar$$ExternalSyntheticLambda8.m("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected ", GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE, " but found ", r5, ".  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />"));
    }
}
