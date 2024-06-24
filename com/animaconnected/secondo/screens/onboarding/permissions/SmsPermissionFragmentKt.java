package com.animaconnected.secondo.screens.onboarding.permissions;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.compose.animation.CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0;
import androidx.compose.animation.CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline1;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.pager.LazyLayoutPagerKt$$ExternalSyntheticOutline0;
import androidx.compose.material.BottomSheetScaffoldKt;
import androidx.compose.material.BottomSheetScaffoldState;
import androidx.compose.material.BottomSheetState;
import androidx.compose.material.BottomSheetValue;
import androidx.compose.material.Colors;
import androidx.compose.material.ColorsKt;
import androidx.compose.material.DrawerKt$ModalDrawer$1$$ExternalSyntheticOutline0;
import androidx.compose.material.TextKt;
import androidx.compose.material.Typography;
import androidx.compose.material.TypographyKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetCompositeKeyHash$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.databinding.DialogNeedsReadNotificationsPermissionBinding;
import com.animaconnected.secondo.notification.receiver.NotificationUtil;
import com.animaconnected.secondo.screens.onboarding.OnboardingPermissionInfo;
import com.animaconnected.secondo.screens.onboarding.OnboardingPermissionKt;
import com.animaconnected.secondo.screens.onboarding.PermissionState;
import com.animaconnected.secondo.screens.onboarding.permissions.SmsPermissionFragmentKt$SmsPermissionContent$1;
import com.animaconnected.secondo.utils.CompanionDeviceUtils;
import com.animaconnected.widget.theme.FestinaComposeThemeProvider;
import com.animaconnected.widget.theme.KronabyComposeLightThemeProvider;
import com.animaconnected.widget.theme.ThemeKt;
import com.google.common.base.Strings;
import com.kronaby.watch.app.R;
import io.ktor.http.URLProtocolKt;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: SmsPermissionFragment.kt */
/* loaded from: classes3.dex */
public final class SmsPermissionFragmentKt {
    private static final List<String> smsPermissions = CollectionsKt__CollectionsKt.listOf("android.permission.ACCESS_NOTIFICATION_POLICY");

    public static final void FestinaSmsPermissionScreen(Composer composer, final int r4) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(-1164598609);
        if (r4 == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            ThemeKt.BrandTheme(FestinaComposeThemeProvider.INSTANCE, ComposableSingletons$SmsPermissionFragmentKt.INSTANCE.m958getLambda1$secondo_kronabyRelease(), startRestartGroup, FestinaComposeThemeProvider.$stable | 48);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.permissions.SmsPermissionFragmentKt$FestinaSmsPermissionScreen$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r2) {
                    SmsPermissionFragmentKt.FestinaSmsPermissionScreen(composer2, Strings.updateChangedFlags(r4 | 1));
                }
            };
        }
    }

    public static final void KronabySmsPermissionScreen(Composer composer, final int r4) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(-604543047);
        if (r4 == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            ThemeKt.BrandTheme(KronabyComposeLightThemeProvider.INSTANCE, ComposableSingletons$SmsPermissionFragmentKt.INSTANCE.m959getLambda2$secondo_kronabyRelease(), startRestartGroup, KronabyComposeLightThemeProvider.$stable | 48);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.permissions.SmsPermissionFragmentKt$KronabySmsPermissionScreen$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r2) {
                    SmsPermissionFragmentKt.KronabySmsPermissionScreen(composer2, Strings.updateChangedFlags(r4 | 1));
                }
            };
        }
    }

    public static final void PreviewScreen(Composer composer, final int r5) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(-1491553425);
        if (r5 == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            SmsPermissionContent(new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.permissions.SmsPermissionFragmentKt$PreviewScreen$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.permissions.SmsPermissionFragmentKt$PreviewScreen$2
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, PermissionState.Idle.INSTANCE, startRestartGroup, 438);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.permissions.SmsPermissionFragmentKt$PreviewScreen$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r2) {
                    SmsPermissionFragmentKt.PreviewScreen(composer2, Strings.updateChangedFlags(r5 | 1));
                }
            };
        }
    }

    /* JADX WARN: Type inference failed for: r0v16, types: [com.animaconnected.secondo.screens.onboarding.permissions.SmsPermissionFragmentKt$SmsPermissionContent$1, kotlin.jvm.internal.Lambda] */
    /* JADX WARN: Type inference failed for: r12v0, types: [com.animaconnected.secondo.screens.onboarding.permissions.SmsPermissionFragmentKt$SmsPermissionContent$2, kotlin.jvm.internal.Lambda] */
    public static final void SmsPermissionContent(final Function0<Unit> function0, final Function0<Unit> function02, final PermissionState permissionState, Composer composer, final int r50) {
        int r0;
        ComposerImpl composerImpl;
        int r1;
        int r12;
        int r02;
        ComposerImpl startRestartGroup = composer.startRestartGroup(772078976);
        if ((r50 & 14) == 0) {
            if (startRestartGroup.changedInstance(function0)) {
                r02 = 4;
            } else {
                r02 = 2;
            }
            r0 = r02 | r50;
        } else {
            r0 = r50;
        }
        if ((r50 & 112) == 0) {
            if (startRestartGroup.changedInstance(function02)) {
                r12 = 32;
            } else {
                r12 = 16;
            }
            r0 |= r12;
        }
        if ((r50 & 896) == 0) {
            if (startRestartGroup.changed(permissionState)) {
                r1 = 256;
            } else {
                r1 = 128;
            }
            r0 |= r1;
        }
        if ((r0 & 731) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composerImpl = startRestartGroup;
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            final Context context = (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.LocalContext);
            final BottomSheetScaffoldState rememberBottomSheetScaffoldState = BottomSheetScaffoldKt.rememberBottomSheetScaffoldState(startRestartGroup);
            startRestartGroup.startReplaceableGroup(773894976);
            startRestartGroup.startReplaceableGroup(-492369756);
            Object nextSlot = startRestartGroup.nextSlot();
            if (nextSlot == Composer.Companion.Empty) {
                nextSlot = LazyLayoutPagerKt$$ExternalSyntheticOutline0.m(EffectsKt.createCompositionCoroutineScope(startRestartGroup), startRestartGroup);
            }
            startRestartGroup.end(false);
            final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) nextSlot).coroutineScope;
            startRestartGroup.end(false);
            composerImpl = startRestartGroup;
            BottomSheetScaffoldKt.m156BottomSheetScaffoldbGncdBI(ComposableLambdaKt.composableLambda(startRestartGroup, 2099001487, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.permissions.SmsPermissionFragmentKt$SmsPermissionContent$1

                /* compiled from: SmsPermissionFragment.kt */
                /* renamed from: com.animaconnected.secondo.screens.onboarding.permissions.SmsPermissionFragmentKt$SmsPermissionContent$1$1, reason: invalid class name */
                /* loaded from: classes3.dex */
                public static final class AnonymousClass1 extends Lambda implements Function1<Context, LinearLayout> {
                    final /* synthetic */ CoroutineScope $scope;
                    final /* synthetic */ BottomSheetScaffoldState $sheetState;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public AnonymousClass1(CoroutineScope coroutineScope, BottomSheetScaffoldState bottomSheetScaffoldState) {
                        super(1);
                        this.$scope = coroutineScope;
                        this.$sheetState = bottomSheetScaffoldState;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final void invoke$lambda$2$lambda$0(Context context, View view) {
                        Intrinsics.checkNotNullParameter(context, "$context");
                        NotificationUtil.INSTANCE.openNotificationAccess(context);
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final void invoke$lambda$2$lambda$1(CoroutineScope scope, BottomSheetScaffoldState sheetState, View view) {
                        Intrinsics.checkNotNullParameter(scope, "$scope");
                        Intrinsics.checkNotNullParameter(sheetState, "$sheetState");
                        BuildersKt.launch$default(scope, null, null, new SmsPermissionFragmentKt$SmsPermissionContent$1$1$1$2$1(sheetState, null), 3);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final LinearLayout invoke(final Context context) {
                        Intrinsics.checkNotNullParameter(context, "context");
                        DialogNeedsReadNotificationsPermissionBinding inflate = DialogNeedsReadNotificationsPermissionBinding.inflate(LayoutInflater.from(context), null, false);
                        final CoroutineScope coroutineScope = this.$scope;
                        final BottomSheetScaffoldState bottomSheetScaffoldState = this.$sheetState;
                        TextView textView = inflate.tvTitle;
                        KronabyApplication.Companion companion = KronabyApplication.Companion;
                        textView.setText(companion.getContext().getString(R.string.bottom_dialog_notification_title));
                        inflate.tvDescription.setText(companion.getContext().getString(R.string.onboarding_sms_permission_notification_dialog_description));
                        inflate.btnApprove.setText(companion.getContext().getString(R.string.onboarding_sms_permission_notification_dialog_primary_btn));
                        inflate.btnApprove.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.onboarding.permissions.SmsPermissionFragmentKt$SmsPermissionContent$1$1$$ExternalSyntheticLambda0
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                SmsPermissionFragmentKt$SmsPermissionContent$1.AnonymousClass1.invoke$lambda$2$lambda$0(context, view);
                            }
                        });
                        inflate.btnCancel.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.onboarding.permissions.SmsPermissionFragmentKt$SmsPermissionContent$1$1$$ExternalSyntheticLambda1
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                SmsPermissionFragmentKt$SmsPermissionContent$1.AnonymousClass1.invoke$lambda$2$lambda$1(CoroutineScope.this, bottomSheetScaffoldState, view);
                            }
                        });
                        return inflate.getRoot();
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer2, Integer num) {
                    invoke(columnScope, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ColumnScope BottomSheetScaffold, Composer composer2, int r9) {
                    Intrinsics.checkNotNullParameter(BottomSheetScaffold, "$this$BottomSheetScaffold");
                    if ((r9 & 14) == 0) {
                        r9 |= composer2.changed(BottomSheetScaffold) ? 4 : 2;
                    }
                    if ((r9 & 91) == 18 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                    } else {
                        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                        AndroidView_androidKt.AndroidView(new AnonymousClass1(CoroutineScope.this, rememberBottomSheetScaffoldState), BottomSheetScaffold.align(SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f)), null, composer2, 0, 4);
                    }
                }
            }), null, rememberBottomSheetScaffoldState, null, null, null, 0, false, null, 0.0f, Color.White, 0L, 0, null, false, null, 0.0f, 0L, 0L, 0L, 0L, 0L, ComposableLambdaKt.composableLambda(startRestartGroup, 1130652266, new Function3<PaddingValues, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.permissions.SmsPermissionFragmentKt$SmsPermissionContent$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(PaddingValues paddingValues, Composer composer2, Integer num) {
                    invoke(paddingValues, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Type inference failed for: r8v9, types: [kotlin.jvm.internal.Lambda, com.animaconnected.secondo.screens.onboarding.permissions.SmsPermissionFragmentKt$SmsPermissionContent$2$3] */
                public final void invoke(PaddingValues it, Composer composer2, int r10) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    if ((r10 & 81) == 16 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                    OnboardingPermissionInfo onboardingPermissionInfo = new OnboardingPermissionInfo(URLProtocolKt.stringResource(R.string.onboarding_sms_permission_title, composer2), R.drawable.ic_all_texts, URLProtocolKt.stringResource(R.string.onboarding_sms_permission_primary_button, composer2), URLProtocolKt.stringResource(R.string.button_label_not_now, composer2));
                    final Context context2 = context;
                    final CoroutineScope coroutineScope2 = coroutineScope;
                    final BottomSheetScaffoldState bottomSheetScaffoldState = rememberBottomSheetScaffoldState;
                    Function0<Unit> function03 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.permissions.SmsPermissionFragmentKt$SmsPermissionContent$2.1

                        /* compiled from: SmsPermissionFragment.kt */
                        @DebugMetadata(c = "com.animaconnected.secondo.screens.onboarding.permissions.SmsPermissionFragmentKt$SmsPermissionContent$2$1$1", f = "SmsPermissionFragment.kt", l = {105, 107}, m = "invokeSuspend")
                        /* renamed from: com.animaconnected.secondo.screens.onboarding.permissions.SmsPermissionFragmentKt$SmsPermissionContent$2$1$1, reason: invalid class name and collision with other inner class name */
                        /* loaded from: classes3.dex */
                        public static final class C00621 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            final /* synthetic */ BottomSheetScaffoldState $sheetState;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            public C00621(BottomSheetScaffoldState bottomSheetScaffoldState, Continuation<? super C00621> continuation) {
                                super(2, continuation);
                                this.$sheetState = bottomSheetScaffoldState;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                return new C00621(this.$sheetState, continuation);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                boolean z;
                                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                                int r1 = this.label;
                                if (r1 != 0) {
                                    if (r1 != 1 && r1 != 2) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    ResultKt.throwOnFailure(obj);
                                } else {
                                    ResultKt.throwOnFailure(obj);
                                    if (this.$sheetState.bottomSheetState.anchoredDraggableState.getCurrentValue() == BottomSheetValue.Collapsed) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    if (z) {
                                        BottomSheetState bottomSheetState = this.$sheetState.bottomSheetState;
                                        this.label = 1;
                                        if (bottomSheetState.expand(this) == coroutineSingletons) {
                                            return coroutineSingletons;
                                        }
                                    } else {
                                        BottomSheetState bottomSheetState2 = this.$sheetState.bottomSheetState;
                                        this.label = 2;
                                        if (bottomSheetState2.collapse(this) == coroutineSingletons) {
                                            return coroutineSingletons;
                                        }
                                    }
                                }
                                return Unit.INSTANCE;
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                return ((C00621) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                            }
                        }

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            if (CompanionDeviceUtils.INSTANCE.hasAssociatedDevice(context2)) {
                                NotificationUtil.INSTANCE.openNotificationAccess(context2);
                            } else {
                                BuildersKt.launch$default(coroutineScope2, null, null, new C00621(bottomSheetScaffoldState, null), 3);
                            }
                        }
                    };
                    composer2.startReplaceableGroup(-31982692);
                    boolean changedInstance = composer2.changedInstance(function02);
                    final Function0<Unit> function04 = function02;
                    Object rememberedValue = composer2.rememberedValue();
                    if (changedInstance || rememberedValue == Composer.Companion.Empty) {
                        rememberedValue = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.permissions.SmsPermissionFragmentKt$SmsPermissionContent$2$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                function04.invoke();
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue);
                    }
                    Function0 function05 = (Function0) rememberedValue;
                    composer2.endReplaceableGroup();
                    final PermissionState permissionState2 = permissionState;
                    final Function0<Unit> function06 = function0;
                    OnboardingPermissionKt.OnboardingPermissionScreen(onboardingPermissionInfo, function03, function05, ComposableLambdaKt.composableLambda(composer2, 707790660, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.permissions.SmsPermissionFragmentKt$SmsPermissionContent$2.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int r30) {
                            if ((r30 & 11) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$13 = ComposerKt.removeCurrentGroupInstance;
                            PermissionState permissionState3 = PermissionState.this;
                            if (Intrinsics.areEqual(permissionState3, PermissionState.Idle.INSTANCE)) {
                                composer3.startReplaceableGroup(-483455358);
                                Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, composer3);
                                composer3.startReplaceableGroup(-1323940314);
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3);
                                PersistentCompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                ComposeUiNode.Companion.getClass();
                                LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                                ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion);
                                if (composer3.getApplier() instanceof Applier) {
                                    composer3.startReusableNode();
                                    if (composer3.getInserting()) {
                                        composer3.createNode(layoutNode$Companion$Constructor$1);
                                    } else {
                                        composer3.useNode();
                                    }
                                    Updater.m228setimpl(composer3, columnMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                                    Updater.m228setimpl(composer3, currentCompositionLocalMap, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                                    ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$1 = ComposeUiNode.Companion.SetCompositeKeyHash;
                                    if (composer3.getInserting() || !Intrinsics.areEqual(composer3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                        CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0.m(currentCompositeKeyHash, composer3, currentCompositeKeyHash, composeUiNode$Companion$SetCompositeKeyHash$1);
                                    }
                                    CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline1.m(0, modifierMaterializerOf, new SkippableUpdater(composer3), composer3, 2058660585);
                                    TextKt.m216Text4IGK_g(URLProtocolKt.stringResource(R.string.onboarding_sms_permission_description, composer3), null, ((Colors) composer3.consume(ColorsKt.LocalColors)).m166getOnBackground0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) composer3.consume(TypographyKt.LocalTypography)).body1, composer3, 0, 0, 65530);
                                    DrawerKt$ModalDrawer$1$$ExternalSyntheticOutline0.m(composer3);
                                    return;
                                }
                                ComposablesKt.invalidApplier();
                                throw null;
                            }
                            if (Intrinsics.areEqual(permissionState3, PermissionState.Granted.INSTANCE) ? true : Intrinsics.areEqual(permissionState3, PermissionState.Denied.INSTANCE)) {
                                function06.invoke();
                            }
                        }
                    }), composer2, 3072);
                }
            }), composerImpl, 6, 390, 384, 4189178);
        }
        RecomposeScopeImpl endRestartGroup = composerImpl.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.permissions.SmsPermissionFragmentKt$SmsPermissionContent$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r5) {
                    SmsPermissionFragmentKt.SmsPermissionContent(function0, function02, permissionState, composer2, Strings.updateChangedFlags(r50 | 1));
                }
            };
        }
    }

    public static final /* synthetic */ void access$PreviewScreen(Composer composer, int r1) {
        PreviewScreen(composer, r1);
    }

    public static final List<String> getSmsPermissions() {
        return smsPermissions;
    }
}
