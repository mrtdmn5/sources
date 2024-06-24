package com.animaconnected.secondo.screens.debugsettings;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HeartRateRefDeviceFragment.kt */
/* loaded from: classes3.dex */
public final class ComposableSingletons$HeartRateRefDeviceFragmentKt {
    public static final ComposableSingletons$HeartRateRefDeviceFragmentKt INSTANCE = new ComposableSingletons$HeartRateRefDeviceFragmentKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f58lambda1 = ComposableLambdaKt.composableLambdaInstance(-1301359172, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.ComposableSingletons$HeartRateRefDeviceFragmentKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope Button, Composer composer, int r29) {
            Intrinsics.checkNotNullParameter(Button, "$this$Button");
            if ((r29 & 81) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
            } else {
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
                TextKt.m216Text4IGK_g("Export CSV", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 131070);
            }
        }
    }, false);

    /* renamed from: lambda-2, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f59lambda2 = ComposableLambdaKt.composableLambdaInstance(2089542451, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.ComposableSingletons$HeartRateRefDeviceFragmentKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope Button, Composer composer, int r29) {
            Intrinsics.checkNotNullParameter(Button, "$this$Button");
            if ((r29 & 81) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
            } else {
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
                TextKt.m216Text4IGK_g("Clear", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 131070);
            }
        }
    }, false);

    /* renamed from: lambda-3, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f60lambda3 = ComposableLambdaKt.composableLambdaInstance(593226757, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.ComposableSingletons$HeartRateRefDeviceFragmentKt$lambda-3$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope Button, Composer composer, int r29) {
            Intrinsics.checkNotNullParameter(Button, "$this$Button");
            if ((r29 & 81) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
            } else {
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
                TextKt.m216Text4IGK_g("Inactivate", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 131070);
            }
        }
    }, false);

    /* renamed from: getLambda-1$secondo_kronabyRelease, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m874getLambda1$secondo_kronabyRelease() {
        return f58lambda1;
    }

    /* renamed from: getLambda-2$secondo_kronabyRelease, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m875getLambda2$secondo_kronabyRelease() {
        return f59lambda2;
    }

    /* renamed from: getLambda-3$secondo_kronabyRelease, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m876getLambda3$secondo_kronabyRelease() {
        return f60lambda3;
    }
}
