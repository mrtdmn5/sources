package com.animaconnected.secondo.provider.remotecrash;

import com.animaconnected.future.SuccessCallback;
import com.animaconnected.secondo.screens.notification.picker.ImportantAppsPresenter;
import java.util.List;
import java.util.Map;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes3.dex */
public final /* synthetic */ class RemoteCrashProvider$$ExternalSyntheticLambda5 implements SuccessCallback {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ RemoteCrashProvider$$ExternalSyntheticLambda5(int r1, Object obj) {
        this.$r8$classId = r1;
        this.f$0 = obj;
    }

    @Override // com.animaconnected.future.SuccessCallback
    public final void onSuccess(Object obj) {
        int r0 = this.$r8$classId;
        Object obj2 = this.f$0;
        switch (r0) {
            case 0:
                RemoteCrashProvider.$r8$lambda$ZNhuJu9FYtIiv1EHL0Qjao5lQyo((RemoteCrashProvider) obj2, (Map) obj);
                return;
            default:
                ((ImportantAppsPresenter.PickerView) obj2).setData((List) obj);
                return;
        }
    }
}
