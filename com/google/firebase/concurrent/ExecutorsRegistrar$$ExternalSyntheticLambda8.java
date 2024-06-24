package com.google.firebase.concurrent;

import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.Lazy;
import com.google.firebase.components.RestrictedComponentContainer;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes3.dex */
public final /* synthetic */ class ExecutorsRegistrar$$ExternalSyntheticLambda8 implements ComponentFactory {
    public static String m(String str, int r2, String str2, int r4, String str3) {
        return str + r2 + str2 + r4 + str3;
    }

    @Override // com.google.firebase.components.ComponentFactory
    public Object create(RestrictedComponentContainer restrictedComponentContainer) {
        Lazy<ScheduledExecutorService> lazy = ExecutorsRegistrar.BG_EXECUTOR;
        return UiExecutor.INSTANCE;
    }
}
