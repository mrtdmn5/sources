package com.animaconnected.secondo.screens.workout.dashboard;

import android.graphics.ColorFilter;
import android.graphics.PorterDuffColorFilter;
import android.os.Build;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.Colors;
import androidx.compose.material.ColorsKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidBlendMode_androidKt;
import androidx.compose.ui.graphics.BlendModeColorFilterHelper;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.ContentScale$Companion$Inside$1;
import androidx.compose.ui.res.PainterResources_androidKt;
import com.animaconnected.watch.fitness.FitnessDataKt;
import com.animaconnected.watch.fitness.HealthGoals;
import com.animaconnected.watch.graphs.BarEntry;
import com.animaconnected.watch.workout.HealthOnboardingState;
import com.animaconnected.watch.workout.StringMetricListItem;
import com.animaconnected.widget.SessionCardData;
import com.kronaby.watch.app.R;
import io.ktor.http.URLProtocolKt;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HealthDashboardScreen.kt */
/* loaded from: classes3.dex */
public final class ComposableSingletons$HealthDashboardScreenKt {
    public static final ComposableSingletons$HealthDashboardScreenKt INSTANCE = new ComposableSingletons$HealthDashboardScreenKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f100lambda1 = ComposableLambdaKt.composableLambdaInstance(-738125229, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.workout.dashboard.ComposableSingletons$HealthDashboardScreenKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int r13) {
            ColorFilter porterDuffColorFilter;
            if ((r13 & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            Modifier m91size3ABfNKs = SizeKt.m91size3ABfNKs(Modifier.Companion.$$INSTANCE, 32);
            Painter painterResource = PainterResources_androidKt.painterResource(R.drawable.ic_settings, composer);
            String stringResource = URLProtocolKt.stringResource(R.string.health_top_title, composer);
            ContentScale$Companion$Inside$1 contentScale$Companion$Inside$1 = ContentScale.Companion.Inside;
            long m166getOnBackground0d7_KjU = ((Colors) composer.consume(ColorsKt.LocalColors)).m166getOnBackground0d7_KjU();
            if (Build.VERSION.SDK_INT >= 29) {
                porterDuffColorFilter = BlendModeColorFilterHelper.INSTANCE.m309BlendModeColorFilterxETnrds(m166getOnBackground0d7_KjU, 5);
            } else {
                porterDuffColorFilter = new PorterDuffColorFilter(ColorKt.m327toArgb8_81llA(m166getOnBackground0d7_KjU), AndroidBlendMode_androidKt.m281toPorterDuffModes9anfk8(5));
            }
            ImageKt.Image(painterResource, stringResource, m91size3ABfNKs, null, contentScale$Companion$Inside$1, 0.0f, new androidx.compose.ui.graphics.ColorFilter(porterDuffColorFilter), composer, 24968, 40);
        }
    }, false);

    /* renamed from: lambda-2, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f101lambda2 = ComposableLambdaKt.composableLambdaInstance(855150067, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.workout.dashboard.ComposableSingletons$HealthDashboardScreenKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int r13) {
            if ((r13 & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            HealthDashboardPreviewData healthDashboardPreviewData = HealthDashboardPreviewData.INSTANCE;
            GoalData goalData = healthDashboardPreviewData.getGoalData();
            List<StringMetricListItem> metrics = healthDashboardPreviewData.getMetrics();
            HealthDashboardScreenKt.HealthDashboardScreen(goalData, healthDashboardPreviewData.getSession(), metrics, new HealthOnboardingUIState(ScrollKt.rememberScrollState(composer), 100, healthDashboardPreviewData.getSession(), healthDashboardPreviewData.getMetrics()), HealthOnboardingState.Inactive, false, null, healthDashboardPreviewData.getChartTheme(), new Function1<ClickEvent, Unit>() { // from class: com.animaconnected.secondo.screens.workout.dashboard.ComposableSingletons$HealthDashboardScreenKt$lambda-2$1.1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ClickEvent it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ClickEvent clickEvent) {
                    invoke2(clickEvent);
                    return Unit.INSTANCE;
                }
            }, composer, (SessionCardData.$stable << 3) | 119239176);
        }
    }, false);

    /* renamed from: lambda-3, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f102lambda3 = ComposableLambdaKt.composableLambdaInstance(800363856, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.workout.dashboard.ComposableSingletons$HealthDashboardScreenKt$lambda-3$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int r12) {
            if ((r12 & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
            } else {
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
                HealthDashboardScreenKt.DailyGoalsCard(null, new Function0<BarEntry>() { // from class: com.animaconnected.secondo.screens.workout.dashboard.ComposableSingletons$HealthDashboardScreenKt$lambda-3$1.1
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final BarEntry invoke() {
                        return new BarEntry(1000, (String) null, 0L, (String) null, (String) null, false, 62, (DefaultConstructorMarker) null);
                    }
                }, new Function0<BarEntry>() { // from class: com.animaconnected.secondo.screens.workout.dashboard.ComposableSingletons$HealthDashboardScreenKt$lambda-3$1.2
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final BarEntry invoke() {
                        return new BarEntry(8, (String) null, 0L, (String) null, (String) null, false, 62, (DefaultConstructorMarker) null);
                    }
                }, new Function0<BarEntry>() { // from class: com.animaconnected.secondo.screens.workout.dashboard.ComposableSingletons$HealthDashboardScreenKt$lambda-3$1.3
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final BarEntry invoke() {
                        return new BarEntry(120, (String) null, 0L, (String) null, (String) null, false, 62, (DefaultConstructorMarker) null);
                    }
                }, FitnessDataKt.m1223default(HealthGoals.Companion), HealthDashboardPreviewData.INSTANCE.getChartTheme(), new Function1<Rect, Unit>() { // from class: com.animaconnected.secondo.screens.workout.dashboard.ComposableSingletons$HealthDashboardScreenKt$lambda-3$1.4
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Rect it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Rect rect) {
                        invoke2(rect);
                        return Unit.INSTANCE;
                    }
                }, composer, 1871280, 1);
            }
        }
    }, false);

    /* renamed from: getLambda-1$secondo_kronabyRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1014getLambda1$secondo_kronabyRelease() {
        return f100lambda1;
    }

    /* renamed from: getLambda-2$secondo_kronabyRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1015getLambda2$secondo_kronabyRelease() {
        return f101lambda2;
    }

    /* renamed from: getLambda-3$secondo_kronabyRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1016getLambda3$secondo_kronabyRelease() {
        return f102lambda3;
    }
}
