package com.google.firebase.concurrent;

import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.RestrictedComponentContainer;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes3.dex */
public final /* synthetic */ class ExecutorsRegistrar$$ExternalSyntheticLambda5 implements ComponentFactory {
    @Override // com.google.firebase.components.ComponentFactory
    public final Object create(RestrictedComponentContainer restrictedComponentContainer) {
        return ExecutorsRegistrar.BG_EXECUTOR.get();
    }
}
