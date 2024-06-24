package com.google.firebase.tracing;

import android.os.Trace;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.ComponentRegistrarProcessor;
import com.google.firebase.components.RestrictedComponentContainer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public final class ComponentMonitor implements ComponentRegistrarProcessor {
    @Override // com.google.firebase.components.ComponentRegistrarProcessor
    public final List<Component<?>> processRegistrar(ComponentRegistrar componentRegistrar) {
        ArrayList arrayList = new ArrayList();
        for (final Component<?> component : componentRegistrar.getComponents()) {
            final String str = component.name;
            if (str != null) {
                component = new Component<>(str, component.providedInterfaces, component.dependencies, component.instantiation, component.type, new ComponentFactory() { // from class: com.google.firebase.tracing.ComponentMonitor$$ExternalSyntheticLambda0
                    @Override // com.google.firebase.components.ComponentFactory
                    public final Object create(RestrictedComponentContainer restrictedComponentContainer) {
                        String str2 = str;
                        Component component2 = component;
                        try {
                            Trace.beginSection(str2);
                            return component2.factory.create(restrictedComponentContainer);
                        } finally {
                            Trace.endSection();
                        }
                    }
                }, component.publishedEvents);
            }
            arrayList.add(component);
        }
        return arrayList;
    }
}
