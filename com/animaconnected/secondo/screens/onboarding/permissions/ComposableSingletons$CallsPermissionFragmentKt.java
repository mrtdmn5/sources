package com.animaconnected.secondo.screens.onboarding.permissions;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: CallsPermissionFragment.kt */
/* loaded from: classes3.dex */
public final class ComposableSingletons$CallsPermissionFragmentKt {
    public static final ComposableSingletons$CallsPermissionFragmentKt INSTANCE = new ComposableSingletons$CallsPermissionFragmentKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f81lambda1 = ComposableLambdaKt.composableLambdaInstance(441389727, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.permissions.ComposableSingletons$CallsPermissionFragmentKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int r3) {
            if ((r3 & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
            } else {
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
                CallsPermissionFragmentKt.access$PreviewScreen(composer, 0);
            }
        }
    }, false);

    /* renamed from: lambda-2, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f82lambda2 = ComposableLambdaKt.composableLambdaInstance(2077442729, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.permissions.ComposableSingletons$CallsPermissionFragmentKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int r3) {
            if ((r3 & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
            } else {
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
                CallsPermissionFragmentKt.access$PreviewScreen(composer, 0);
            }
        }
    }, false);

    /* renamed from: getLambda-1$secondo_kronabyRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m954getLambda1$secondo_kronabyRelease() {
        return f81lambda1;
    }

    /* renamed from: getLambda-2$secondo_kronabyRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m955getLambda2$secondo_kronabyRelease() {
        return f82lambda2;
    }
}
