package com.animaconnected.secondo.screens.debugsettings;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DebugMediaNotificationsFragment.kt */
/* loaded from: classes3.dex */
public final class ComposableSingletons$DebugMediaNotificationsFragmentKt {
    public static final ComposableSingletons$DebugMediaNotificationsFragmentKt INSTANCE = new ComposableSingletons$DebugMediaNotificationsFragmentKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f30lambda1 = ComposableLambdaKt.composableLambdaInstance(1576909324, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.ComposableSingletons$DebugMediaNotificationsFragmentKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int r28) {
            if ((r28 & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
            } else {
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
                TextKt.m216Text4IGK_g("Album", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 131070);
            }
        }
    }, false);

    /* renamed from: lambda-2, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f31lambda2 = ComposableLambdaKt.composableLambdaInstance(-592129085, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.ComposableSingletons$DebugMediaNotificationsFragmentKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int r28) {
            if ((r28 & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
            } else {
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
                TextKt.m216Text4IGK_g("Song title", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 131070);
            }
        }
    }, false);

    /* renamed from: lambda-3, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f32lambda3 = ComposableLambdaKt.composableLambdaInstance(-534146812, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.ComposableSingletons$DebugMediaNotificationsFragmentKt$lambda-3$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int r28) {
            if ((r28 & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
            } else {
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
                TextKt.m216Text4IGK_g("Artist", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 131070);
            }
        }
    }, false);

    /* renamed from: lambda-4, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f33lambda4 = ComposableLambdaKt.composableLambdaInstance(-476164539, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.ComposableSingletons$DebugMediaNotificationsFragmentKt$lambda-4$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int r28) {
            if ((r28 & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
            } else {
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
                TextKt.m216Text4IGK_g("Duration seconds", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 131070);
            }
        }
    }, false);

    /* renamed from: lambda-5, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f34lambda5 = ComposableLambdaKt.composableLambdaInstance(-891409694, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.ComposableSingletons$DebugMediaNotificationsFragmentKt$lambda-5$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope Button, Composer composer, int r30) {
            Intrinsics.checkNotNullParameter(Button, "$this$Button");
            if ((r30 & 81) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
            } else {
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
                TextKt.m216Text4IGK_g("Send!", SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 54, 0, 131068);
            }
        }
    }, false);

    /* renamed from: getLambda-1$secondo_kronabyRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m846getLambda1$secondo_kronabyRelease() {
        return f30lambda1;
    }

    /* renamed from: getLambda-2$secondo_kronabyRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m847getLambda2$secondo_kronabyRelease() {
        return f31lambda2;
    }

    /* renamed from: getLambda-3$secondo_kronabyRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m848getLambda3$secondo_kronabyRelease() {
        return f32lambda3;
    }

    /* renamed from: getLambda-4$secondo_kronabyRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m849getLambda4$secondo_kronabyRelease() {
        return f33lambda4;
    }

    /* renamed from: getLambda-5$secondo_kronabyRelease, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m850getLambda5$secondo_kronabyRelease() {
        return f34lambda5;
    }
}
