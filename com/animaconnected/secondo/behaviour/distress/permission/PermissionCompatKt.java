package com.animaconnected.secondo.behaviour.distress.permission;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts$RequestMultiplePermissions;
import androidx.activity.result.contract.ActivityResultContracts$RequestPermission;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PermissionCompat.kt */
/* loaded from: classes3.dex */
public final class PermissionCompatKt {
    public static final ActivityResultLauncher<String[]> registerMultiplePermissions(AppCompatActivity appCompatActivity, Function0<Unit> allGranted, Function0<Unit> denied) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "<this>");
        Intrinsics.checkNotNullParameter(allGranted, "allGranted");
        Intrinsics.checkNotNullParameter(denied, "denied");
        ActivityResultLauncher<String[]> registerForActivityResult = appCompatActivity.registerForActivityResult(new ActivityResultContracts$RequestMultiplePermissions(), new PermissionCompatKt$registerMultiplePermissions$3(allGranted, denied));
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResult(...)");
        return registerForActivityResult;
    }

    public static /* synthetic */ ActivityResultLauncher registerMultiplePermissions$default(AppCompatActivity appCompatActivity, Function0 allGranted, Function0 denied, int r3, Object obj) {
        if ((r3 & 1) != 0) {
            allGranted = new Function0<Unit>() { // from class: com.animaconnected.secondo.behaviour.distress.permission.PermissionCompatKt$registerMultiplePermissions$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        if ((r3 & 2) != 0) {
            denied = new Function0<Unit>() { // from class: com.animaconnected.secondo.behaviour.distress.permission.PermissionCompatKt$registerMultiplePermissions$2
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        Intrinsics.checkNotNullParameter(appCompatActivity, "<this>");
        Intrinsics.checkNotNullParameter(allGranted, "allGranted");
        Intrinsics.checkNotNullParameter(denied, "denied");
        ActivityResultLauncher registerForActivityResult = appCompatActivity.registerForActivityResult(new ActivityResultContracts$RequestMultiplePermissions(), new PermissionCompatKt$registerMultiplePermissions$3(allGranted, denied));
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResult(...)");
        return registerForActivityResult;
    }

    public static final ActivityResultLauncher<String> registerPermission(Fragment fragment, Function0<Unit> granted, Function0<Unit> denied) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(granted, "granted");
        Intrinsics.checkNotNullParameter(denied, "denied");
        ActivityResultLauncher<String> registerForActivityResult = fragment.registerForActivityResult(new ActivityResultContracts$RequestPermission(), new PermissionCompatKt$registerPermission$3(granted, denied));
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResult(...)");
        return registerForActivityResult;
    }

    public static /* synthetic */ ActivityResultLauncher registerPermission$default(Fragment fragment, Function0 granted, Function0 denied, int r3, Object obj) {
        if ((r3 & 1) != 0) {
            granted = new Function0<Unit>() { // from class: com.animaconnected.secondo.behaviour.distress.permission.PermissionCompatKt$registerPermission$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        if ((r3 & 2) != 0) {
            denied = new Function0<Unit>() { // from class: com.animaconnected.secondo.behaviour.distress.permission.PermissionCompatKt$registerPermission$2
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(granted, "granted");
        Intrinsics.checkNotNullParameter(denied, "denied");
        ActivityResultLauncher registerForActivityResult = fragment.registerForActivityResult(new ActivityResultContracts$RequestPermission(), new PermissionCompatKt$registerPermission$3(granted, denied));
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResult(...)");
        return registerForActivityResult;
    }

    public static final ActivityResultLauncher<String[]> registerMultiplePermissions(Fragment fragment, Function0<Unit> allGranted, Function0<Unit> denied) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(allGranted, "allGranted");
        Intrinsics.checkNotNullParameter(denied, "denied");
        ActivityResultLauncher<String[]> registerForActivityResult = fragment.registerForActivityResult(new ActivityResultContracts$RequestMultiplePermissions(), new PermissionCompatKt$registerMultiplePermissions$6(allGranted, denied));
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResult(...)");
        return registerForActivityResult;
    }

    public static /* synthetic */ ActivityResultLauncher registerMultiplePermissions$default(Fragment fragment, Function0 allGranted, Function0 denied, int r3, Object obj) {
        if ((r3 & 1) != 0) {
            allGranted = new Function0<Unit>() { // from class: com.animaconnected.secondo.behaviour.distress.permission.PermissionCompatKt$registerMultiplePermissions$4
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        if ((r3 & 2) != 0) {
            denied = new Function0<Unit>() { // from class: com.animaconnected.secondo.behaviour.distress.permission.PermissionCompatKt$registerMultiplePermissions$5
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(allGranted, "allGranted");
        Intrinsics.checkNotNullParameter(denied, "denied");
        ActivityResultLauncher registerForActivityResult = fragment.registerForActivityResult(new ActivityResultContracts$RequestMultiplePermissions(), new PermissionCompatKt$registerMultiplePermissions$6(allGranted, denied));
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResult(...)");
        return registerForActivityResult;
    }
}
