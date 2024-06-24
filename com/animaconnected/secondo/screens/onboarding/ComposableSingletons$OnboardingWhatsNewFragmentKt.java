package com.animaconnected.secondo.screens.onboarding;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.animaconnected.widget.TextKt;
import com.kronaby.watch.app.R;
import io.ktor.http.URLProtocolKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OnboardingWhatsNewFragment.kt */
/* loaded from: classes3.dex */
public final class ComposableSingletons$OnboardingWhatsNewFragmentKt {
    public static final ComposableSingletons$OnboardingWhatsNewFragmentKt INSTANCE = new ComposableSingletons$OnboardingWhatsNewFragmentKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f77lambda1 = ComposableLambdaKt.composableLambdaInstance(2042109839, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.ComposableSingletons$OnboardingWhatsNewFragmentKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope ButtonOutlined, Composer composer, int r28) {
            Intrinsics.checkNotNullParameter(ButtonOutlined, "$this$ButtonOutlined");
            if ((r28 & 81) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
            } else {
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
                TextKt.m1633CapsTextfLXpl1I(URLProtocolKt.stringResource(R.string.onboarding_continue, composer), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, null, composer, 0, 0, 65534);
            }
        }
    }, false);

    /* renamed from: lambda-2, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f78lambda2 = ComposableLambdaKt.composableLambdaInstance(1757577864, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.ComposableSingletons$OnboardingWhatsNewFragmentKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int r5) {
            if ((r5 & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
            } else {
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
                OnboardingWhatsNewFragmentKt.access$WhatsNewScreen(CollectionsKt__CollectionsKt.listOf((Object[]) new WhatsNewUiItem[]{new WhatsNewUiItem(R.string.whats_new_3_5_more_watches_title, R.string.whats_new_3_5_more_watches_description), new WhatsNewUiItem(R.string.whats_new_3_5_more_alarms_title, R.string.whats_new_3_5_more_arams_description)}), new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.ComposableSingletons$OnboardingWhatsNewFragmentKt$lambda-2$1.1
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }
                }, composer, 48);
            }
        }
    }, false);

    /* renamed from: getLambda-1$secondo_kronabyRelease, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m943getLambda1$secondo_kronabyRelease() {
        return f77lambda1;
    }

    /* renamed from: getLambda-2$secondo_kronabyRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m944getLambda2$secondo_kronabyRelease() {
        return f78lambda2;
    }
}
