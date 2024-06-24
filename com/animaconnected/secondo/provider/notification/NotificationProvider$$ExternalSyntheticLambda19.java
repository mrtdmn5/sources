package com.animaconnected.secondo.provider.notification;

import com.animaconnected.future.SuccessCallback;
import com.animaconnected.secondo.provider.notification.NotificationProvider;
import com.animaconnected.secondo.screens.notification.NotificationDragAndDropProvider;
import java.util.List;
import java.util.Map;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes3.dex */
public final /* synthetic */ class NotificationProvider$$ExternalSyntheticLambda19 implements SuccessCallback {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ NotificationProvider$$ExternalSyntheticLambda19(int r1, Object obj) {
        this.$r8$classId = r1;
        this.f$0 = obj;
    }

    @Override // com.animaconnected.future.SuccessCallback
    public final void onSuccess(Object obj) {
        int r0 = this.$r8$classId;
        Object obj2 = this.f$0;
        switch (r0) {
            case 0:
                NotificationProvider.$r8$lambda$uYn8XOHz1oaZSYDQfEPxaox0mhI((NotificationProvider.Callback) obj2, (List) obj);
                return;
            default:
                NotificationDragAndDropProvider.m935$r8$lambda$k0BAuaB3XqIPWjN_LpkQfytceU((NotificationDragAndDropProvider) obj2, (Map) obj);
                return;
        }
    }
}
