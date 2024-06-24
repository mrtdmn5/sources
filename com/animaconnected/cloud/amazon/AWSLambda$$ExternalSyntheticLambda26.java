package com.animaconnected.cloud.amazon;

import com.animaconnected.future.FailCallback;
import com.animaconnected.future.Promise;
import com.animaconnected.secondo.provider.notification.NotificationProvider;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class AWSLambda$$ExternalSyntheticLambda26 implements FailCallback {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ AWSLambda$$ExternalSyntheticLambda26(int r1, Object obj) {
        this.$r8$classId = r1;
        this.f$0 = obj;
    }

    @Override // com.animaconnected.future.FailCallback
    public final void onFail(Throwable th) {
        int r0 = this.$r8$classId;
        Object obj = this.f$0;
        switch (r0) {
            case 0:
                ((AWSLambda) obj).lambda$sendFeedback$28(th);
                return;
            default:
                NotificationProvider.lambda$deleteImportantAppAndConfigurationItem$27((Promise) obj, th);
                return;
        }
    }
}
