package com.animaconnected.secondo.screens.debugsettings;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import com.animaconnected.secondo.screens.debugsettings.DebugBleStatus;
import com.animaconnected.watch.Watch;
import com.kronaby.watch.app.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DebugSettingsScreen.kt */
/* loaded from: classes3.dex */
public final class ComposableSingletons$DebugSettingsScreenKt {
    public static final ComposableSingletons$DebugSettingsScreenKt INSTANCE = new ComposableSingletons$DebugSettingsScreenKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f42lambda1 = ComposableLambdaKt.composableLambdaInstance(-1503750450, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.ComposableSingletons$DebugSettingsScreenKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope ButtonOutlined, Composer composer, int r13) {
            Intrinsics.checkNotNullParameter(ButtonOutlined, "$this$ButtonOutlined");
            if ((r13 & 81) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
            } else {
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
                ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.battery_green_75_95, composer), null, null, null, null, 0.0f, null, composer, 56, 124);
            }
        }
    }, false);

    /* renamed from: lambda-2, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f43lambda2 = ComposableLambdaKt.composableLambdaInstance(-1516774537, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.ComposableSingletons$DebugSettingsScreenKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope ButtonOutlined, Composer composer, int r13) {
            Intrinsics.checkNotNullParameter(ButtonOutlined, "$this$ButtonOutlined");
            if ((r13 & 81) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
            } else {
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
                ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.battery_yellow_15_30, composer), null, null, null, null, 0.0f, null, composer, 56, 124);
            }
        }
    }, false);

    /* renamed from: lambda-3, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f44lambda3 = ComposableLambdaKt.composableLambdaInstance(1741182358, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.ComposableSingletons$DebugSettingsScreenKt$lambda-3$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope ButtonOutlined, Composer composer, int r13) {
            Intrinsics.checkNotNullParameter(ButtonOutlined, "$this$ButtonOutlined");
            if ((r13 & 81) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
            } else {
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
                ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.battery_red_0_15, composer), null, null, null, null, 0.0f, null, composer, 56, 124);
            }
        }
    }, false);

    /* renamed from: lambda-4, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f45lambda4 = ComposableLambdaKt.composableLambdaInstance(-115674455, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.ComposableSingletons$DebugSettingsScreenKt$lambda-4$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int r22) {
            if ((r22 & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
            } else {
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
                DebugSettingsScreenKt.DebugSettingsScreen(new DebugUiState(new DebugBleStatus(DebugBleStatus.ConnectionState.CONNECTED, true), Watch.WatchState.Ready, null, null, new DebugSwitchStatus(false, true, false, false, false, false, false, false, false, false, 1021, null), new DebugTokens("e35c81a5f5fb03d7ebd4666bdaf22ec9", "MQBa3rY1E6qjCYO4QOD7FWaUae2C4higMuzYNA", "bb216556632ab2880f46adbb335fc6eadff65601", "kaKbgTNKkhtjfrQVsvo-FhzdOCJKuxcz5fBIr7-NdcA"), null, null, false, 460, null), new Function1<DebugClick, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.ComposableSingletons$DebugSettingsScreenKt$lambda-4$1.1
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(DebugClick it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DebugClick debugClick) {
                        invoke2(debugClick);
                        return Unit.INSTANCE;
                    }
                }, composer, 48);
            }
        }
    }, false);

    /* renamed from: getLambda-1$secondo_kronabyRelease, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m858getLambda1$secondo_kronabyRelease() {
        return f42lambda1;
    }

    /* renamed from: getLambda-2$secondo_kronabyRelease, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m859getLambda2$secondo_kronabyRelease() {
        return f43lambda2;
    }

    /* renamed from: getLambda-3$secondo_kronabyRelease, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m860getLambda3$secondo_kronabyRelease() {
        return f44lambda3;
    }

    /* renamed from: getLambda-4$secondo_kronabyRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m861getLambda4$secondo_kronabyRelease() {
        return f45lambda4;
    }
}
