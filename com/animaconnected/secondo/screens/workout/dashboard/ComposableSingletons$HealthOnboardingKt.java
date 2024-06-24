package com.animaconnected.secondo.screens.workout.dashboard;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import com.animaconnected.watch.workout.MetricListItem;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HealthOnboarding.kt */
/* loaded from: classes3.dex */
public final class ComposableSingletons$HealthOnboardingKt {
    public static final ComposableSingletons$HealthOnboardingKt INSTANCE = new ComposableSingletons$HealthOnboardingKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function3<MetricListItem<?>, Composer, Integer, Unit> f103lambda1 = ComposableLambdaKt.composableLambdaInstance(-1582288724, new Function3<MetricListItem<?>, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.workout.dashboard.ComposableSingletons$HealthOnboardingKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(MetricListItem<?> metricListItem, Composer composer, Integer num) {
            invoke(metricListItem, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(MetricListItem<?> metric, Composer composer, int r10) {
            Intrinsics.checkNotNullParameter(metric, "metric");
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            HealthDashboardScreenKt.MetricCard(SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f), metric, new Function1<Rect, Unit>() { // from class: com.animaconnected.secondo.screens.workout.dashboard.ComposableSingletons$HealthOnboardingKt$lambda-1$1.1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Rect it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Rect rect) {
                    invoke2(rect);
                    return Unit.INSTANCE;
                }
            }, composer, 454, 0);
        }
    }, false);

    /* renamed from: getLambda-1$secondo_kronabyRelease, reason: not valid java name */
    public final Function3<MetricListItem<?>, Composer, Integer, Unit> m1017getLambda1$secondo_kronabyRelease() {
        return f103lambda1;
    }
}
