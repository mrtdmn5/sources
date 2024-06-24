package com.google.firebase.platforminfo;

import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.Qualified;
import com.google.firebase.components.RestrictedComponentContainer;
import java.util.Set;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes3.dex */
public final /* synthetic */ class DefaultUserAgentPublisher$$ExternalSyntheticLambda0 implements ComponentFactory {
    @Override // com.google.firebase.components.ComponentFactory
    public final Object create(RestrictedComponentContainer restrictedComponentContainer) {
        Set of = restrictedComponentContainer.setOf(Qualified.unqualified(LibraryVersion.class));
        GlobalLibraryVersionRegistrar globalLibraryVersionRegistrar = GlobalLibraryVersionRegistrar.INSTANCE;
        if (globalLibraryVersionRegistrar == null) {
            synchronized (GlobalLibraryVersionRegistrar.class) {
                globalLibraryVersionRegistrar = GlobalLibraryVersionRegistrar.INSTANCE;
                if (globalLibraryVersionRegistrar == null) {
                    globalLibraryVersionRegistrar = new GlobalLibraryVersionRegistrar();
                    GlobalLibraryVersionRegistrar.INSTANCE = globalLibraryVersionRegistrar;
                }
            }
        }
        return new DefaultUserAgentPublisher(of, globalLibraryVersionRegistrar);
    }
}
