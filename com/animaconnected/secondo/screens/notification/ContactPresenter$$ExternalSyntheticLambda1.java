package com.animaconnected.secondo.screens.notification;

import com.animaconnected.future.FailCallback;
import com.animaconnected.secondo.provider.notification.NotificationProvider;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes3.dex */
public final /* synthetic */ class ContactPresenter$$ExternalSyntheticLambda1 implements FailCallback {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ ContactPresenter$$ExternalSyntheticLambda1(int r1) {
        this.$r8$classId = r1;
    }

    @Override // com.animaconnected.future.FailCallback
    public final void onFail(Throwable th) {
        switch (this.$r8$classId) {
            case 0:
                ContactPresenter.m929$r8$lambda$4f8hDbxjjYIfIIu4VOJWSQDz5s(th);
                return;
            default:
                NotificationProvider.lambda$getImportantAppFromConfigurationItemId$35(th);
                return;
        }
    }
}
