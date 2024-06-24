package com.animaconnected.secondo.behaviour.distress.permission;

import androidx.activity.result.ActivityResultCallback;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PermissionCompat.kt */
/* loaded from: classes3.dex */
public final class PermissionCompatKt$registerPermission$3<O> implements ActivityResultCallback {
    final /* synthetic */ Function0<Unit> $denied;
    final /* synthetic */ Function0<Unit> $granted;

    public PermissionCompatKt$registerPermission$3(Function0<Unit> function0, Function0<Unit> function02) {
        this.$granted = function0;
        this.$denied = function02;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public final void onActivityResult(Boolean bool) {
        Intrinsics.checkNotNull(bool);
        (bool.booleanValue() ? this.$granted : this.$denied).invoke();
    }
}
