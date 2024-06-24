package com.animaconnected.secondo.screens.demo;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.widget.compose.ComponentsKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: DisableDemoModeBottomDialog.kt */
/* renamed from: com.animaconnected.secondo.screens.demo.ComposableSingletons$DisableDemoModeBottomDialogKt$lambda-1$1, reason: invalid class name */
/* loaded from: classes3.dex */
public final class ComposableSingletons$DisableDemoModeBottomDialogKt$lambda1$1 extends Lambda implements Function3<Function0<? extends Unit>, Composer, Integer, Unit> {
    public static final ComposableSingletons$DisableDemoModeBottomDialogKt$lambda1$1 INSTANCE = new ComposableSingletons$DisableDemoModeBottomDialogKt$lambda1$1();

    public ComposableSingletons$DisableDemoModeBottomDialogKt$lambda1$1() {
        super(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$onExitDemoMode() {
        ProviderFactory.getWatch().getWatchManager().getDemoModeProvider().setIsEnabled(false);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Function0<? extends Unit> function0, Composer composer, Integer num) {
        invoke((Function0<Unit>) function0, composer, num.intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r4v4, types: [com.animaconnected.secondo.screens.demo.ComposableSingletons$DisableDemoModeBottomDialogKt$lambda-1$1$1, kotlin.jvm.internal.Lambda] */
    public final void invoke(final Function0<Unit> dismissDialog, Composer composer, int r4) {
        Intrinsics.checkNotNullParameter(dismissDialog, "dismissDialog");
        if ((r4 & 14) == 0) {
            r4 |= composer.changedInstance(dismissDialog) ? 4 : 2;
        }
        if ((r4 & 91) == 18 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            ComponentsKt.BrandTheme(ComposableLambdaKt.composableLambda(composer, 2073069414, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.demo.ComposableSingletons$DisableDemoModeBottomDialogKt$lambda-1$1.1

                /* compiled from: DisableDemoModeBottomDialog.kt */
                /* renamed from: com.animaconnected.secondo.screens.demo.ComposableSingletons$DisableDemoModeBottomDialogKt$lambda-1$1$1$1, reason: invalid class name and collision with other inner class name */
                /* loaded from: classes3.dex */
                public /* synthetic */ class C00551 extends FunctionReferenceImpl implements Function0<Unit> {
                    public static final C00551 INSTANCE = new C00551();

                    public C00551() {
                        super(0, Intrinsics.Kotlin.class, "onExitDemoMode", "invoke$onExitDemoMode()V", 0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        ComposableSingletons$DisableDemoModeBottomDialogKt$lambda1$1.invoke$onExitDemoMode();
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r42) {
                    if ((r42 & 11) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                    } else {
                        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                        DisableDemoModeBottomDialogKt.DialogContent(dismissDialog, C00551.INSTANCE, composer2, 0);
                    }
                }
            }), composer, 6);
        }
    }
}
