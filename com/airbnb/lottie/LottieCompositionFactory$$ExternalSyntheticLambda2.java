package com.airbnb.lottie;

import com.animaconnected.secondo.notification.model.ImportantApp;
import com.animaconnected.secondo.provider.notification.NotificationProvider;
import java.io.InputStream;
import java.util.concurrent.Callable;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class LottieCompositionFactory$$ExternalSyntheticLambda2 implements Callable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ LottieCompositionFactory$$ExternalSyntheticLambda2(Object obj, int r2, Object obj2) {
        this.$r8$classId = r2;
        this.f$0 = obj;
        this.f$1 = obj2;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        Void lambda$deleteImportantApp$11;
        int r0 = this.$r8$classId;
        Object obj = this.f$1;
        Object obj2 = this.f$0;
        switch (r0) {
            case 0:
                return LottieCompositionFactory.fromJsonInputStreamSync((String) obj, (InputStream) obj2);
            default:
                lambda$deleteImportantApp$11 = ((NotificationProvider) obj2).lambda$deleteImportantApp$11((ImportantApp) obj);
                return lambda$deleteImportantApp$11;
        }
    }
}
