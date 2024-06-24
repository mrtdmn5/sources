package com.google.firebase.components;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes3.dex */
public class DependencyCycleException extends DependencyException {
    public final List<Component<?>> componentsInCycle;

    public DependencyCycleException(ArrayList arrayList) {
        super("Dependency cycle detected: " + Arrays.toString(arrayList.toArray()));
        this.componentsInCycle = arrayList;
    }
}
