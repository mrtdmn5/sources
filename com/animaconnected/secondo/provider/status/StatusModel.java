package com.animaconnected.secondo.provider.status;

import com.animaconnected.secondo.screens.status.BaseStatusFragment;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StatusModel.kt */
/* loaded from: classes3.dex */
public abstract class StatusModel {
    public static final int $stable = 8;
    private final Class<? extends BaseStatusFragment> fragment;
    private final int priority;

    public /* synthetic */ StatusModel(int r1, Class cls, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, cls);
    }

    public final BaseStatusFragment createFragment() {
        BaseStatusFragment newInstance = this.fragment.newInstance();
        Intrinsics.checkNotNullExpressionValue(newInstance, "newInstance(...)");
        return newInstance;
    }

    public final Class<? extends BaseStatusFragment> getFragment() {
        return this.fragment;
    }

    public final int getPriority() {
        return this.priority;
    }

    public String toString() {
        return "StatusModel(priority=" + this.priority + ", class=" + getClass().getSimpleName() + ')';
    }

    private StatusModel(int r1, Class<? extends BaseStatusFragment> cls) {
        this.priority = r1;
        this.fragment = cls;
    }
}
