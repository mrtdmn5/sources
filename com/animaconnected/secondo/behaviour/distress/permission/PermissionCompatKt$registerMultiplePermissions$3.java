package com.animaconnected.secondo.behaviour.distress.permission;

import androidx.activity.result.ActivityResultCallback;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PermissionCompat.kt */
/* loaded from: classes3.dex */
public final class PermissionCompatKt$registerMultiplePermissions$3<O> implements ActivityResultCallback {
    final /* synthetic */ Function0<Unit> $allGranted;
    final /* synthetic */ Function0<Unit> $denied;

    public PermissionCompatKt$registerMultiplePermissions$3(Function0<Unit> function0, Function0<Unit> function02) {
        this.$allGranted = function0;
        this.$denied = function02;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public final void onActivityResult(Map<String, Boolean> result) {
        Intrinsics.checkNotNullParameter(result, "result");
        Set<Map.Entry<String, Boolean>> entrySet = result.entrySet();
        boolean z = true;
        if (!(entrySet instanceof Collection) || !entrySet.isEmpty()) {
            Iterator<T> it = entrySet.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (!((Boolean) ((Map.Entry) it.next()).getValue()).booleanValue()) {
                    z = false;
                    break;
                }
            }
        }
        (z ? this.$allGranted : this.$denied).invoke();
    }
}
