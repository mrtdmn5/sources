package com.animaconnected.secondo.screens.settings.displaynotifications;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0;
import androidx.compose.animation.CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline1;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material.Colors;
import androidx.compose.material.ColorsKt;
import androidx.compose.material.DrawerKt$ModalDrawer$1$$ExternalSyntheticOutline0;
import androidx.compose.material.IconKt;
import androidx.compose.material.TextKt;
import androidx.compose.material.Typography;
import androidx.compose.material.TypographyKt;
import androidx.compose.material.icons.filled.SearchKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetCompositeKeyHash$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.res.PainterResources_androidKt;
import com.animaconnected.widget.ScreenTitleKt;
import com.kronaby.watch.app.R;
import io.ktor.http.URLProtocolKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AppsNotificationsFragment.kt */
/* loaded from: classes3.dex */
public final class ComposableSingletons$AppsNotificationsFragmentKt {
    public static final ComposableSingletons$AppsNotificationsFragmentKt INSTANCE = new ComposableSingletons$AppsNotificationsFragmentKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f96lambda1 = ComposableLambdaKt.composableLambdaInstance(1798683121, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.ComposableSingletons$AppsNotificationsFragmentKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int r10) {
            if ((r10 & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
            } else {
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
                IconKt.m187Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.ic_back_arrow_white, composer), "exit search", null, 0L, composer, 56, 12);
            }
        }
    }, false);

    /* renamed from: lambda-2, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f97lambda2 = ComposableLambdaKt.composableLambdaInstance(-1511432845, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.ComposableSingletons$AppsNotificationsFragmentKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int r8) {
            if ((r8 & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
            } else {
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
                IconKt.m188Iconww6aTOc(SearchKt.getSearch(), URLProtocolKt.stringResource(R.string.general_search, composer), null, composer, 0, 12);
            }
        }
    }, false);

    /* renamed from: lambda-3, reason: not valid java name */
    public static Function3<AnimatedVisibilityScope, Composer, Integer, Unit> f98lambda3 = ComposableLambdaKt.composableLambdaInstance(-825329222, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.ComposableSingletons$AppsNotificationsFragmentKt$lambda-3$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
            invoke(animatedVisibilityScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer composer, int r30) {
            Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            composer.startReplaceableGroup(-483455358);
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, composer);
            composer.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer);
            PersistentCompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion);
            if (composer.getApplier() instanceof Applier) {
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(layoutNode$Companion$Constructor$1);
                } else {
                    composer.useNode();
                }
                Updater.m228setimpl(composer, columnMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                Updater.m228setimpl(composer, currentCompositionLocalMap, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$1 = ComposeUiNode.Companion.SetCompositeKeyHash;
                if (composer.getInserting() || !Intrinsics.areEqual(composer.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0.m(currentCompositeKeyHash, composer, currentCompositeKeyHash, composeUiNode$Companion$SetCompositeKeyHash$1);
                }
                CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline1.m(0, modifierMaterializerOf, new SkippableUpdater(composer), composer, 2058660585);
                ScreenTitleKt.ScreenImageTitle(PaddingKt.m75paddingqDBjuR0$default(companion, 0.0f, 0.0f, 0.0f, 32, 7), URLProtocolKt.stringResource(R.string.display_app_details_title, composer), R.drawable.ic_important_apps, composer, 390, 0);
                TextKt.m216Text4IGK_g(URLProtocolKt.stringResource(R.string.filtered_notifications_apps_description, composer), null, ((Colors) composer.consume(ColorsKt.LocalColors)).m166getOnBackground0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) composer.consume(TypographyKt.LocalTypography)).body1, composer, 0, 0, 65530);
                DrawerKt$ModalDrawer$1$$ExternalSyntheticOutline0.m(composer);
                return;
            }
            ComposablesKt.invalidApplier();
            throw null;
        }
    }, false);

    /* renamed from: getLambda-1$secondo_kronabyRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m990getLambda1$secondo_kronabyRelease() {
        return f96lambda1;
    }

    /* renamed from: getLambda-2$secondo_kronabyRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m991getLambda2$secondo_kronabyRelease() {
        return f97lambda2;
    }

    /* renamed from: getLambda-3$secondo_kronabyRelease, reason: not valid java name */
    public final Function3<AnimatedVisibilityScope, Composer, Integer, Unit> m992getLambda3$secondo_kronabyRelease() {
        return f98lambda3;
    }
}
