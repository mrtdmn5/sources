package com.animaconnected.secondo.screens.settings.health;

import android.content.SharedPreferences;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.utils.Internet;
import com.animaconnected.watch.account.strava.StravaClient;
import com.animaconnected.watch.provider.demo.DemoModeProvider;
import com.google.common.collect.Platform;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: StravaUIState.kt */
/* loaded from: classes3.dex */
public final class StravaUIState {
    public static final int $stable = 8;
    private final StravaClient client;
    private final DemoModeProvider demoModeProvider;
    private final SharedPreferences sharedPreferences;
    private final Function1<BottomSheetType, Unit> showSheet;

    /* compiled from: StravaUIState.kt */
    @DebugMetadata(c = "com.animaconnected.secondo.screens.settings.health.StravaUIState$1", f = "StravaUIState.kt", l = {36}, m = "invokeSuspend")
    /* renamed from: com.animaconnected.secondo.screens.settings.health.StravaUIState$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            int r1 = this.label;
            if (r1 != 0) {
                if (r1 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                StravaClient stravaClient = StravaUIState.this.client;
                this.label = 1;
                if (stravaClient.checkConnection(this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StravaUIState(Function1<? super BottomSheetType, Unit> showSheet, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(showSheet, "showSheet");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.showSheet = showSheet;
        this.sharedPreferences = KronabyApplication.Companion.getContext().getSharedPreferences("STRAVA_UI_STORAGE", 0);
        this.client = ProviderFactory.getWatch().getWatchManager().getStravaClient();
        this.demoModeProvider = ProviderFactory.getWatch().getWatchManager().getDemoModeProvider();
        BuildersKt.launch$default(scope, null, null, new AnonymousClass1(null), 3);
    }

    private final void hideBadge() {
        SharedPreferences sharedPreferences = this.sharedPreferences;
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "sharedPreferences");
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putBoolean("KEY_STRAVA_BADGE", false);
        edit.apply();
    }

    public final void authorize() {
        this.client.startAuthentication();
    }

    public final boolean getShowBadge() {
        return this.sharedPreferences.getBoolean("KEY_STRAVA_BADGE", true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isConnected(Composer composer, int r5) {
        composer.startReplaceableGroup(-1015022258);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        boolean booleanValue = ((Boolean) Platform.collectAsState(this.client.isConnectedFlow(), Boolean.FALSE, null, composer, 2).getValue()).booleanValue();
        composer.endReplaceableGroup();
        return booleanValue;
    }

    public final void onClick() {
        hideBadge();
        if (this.demoModeProvider.isCurrentlyEnabled()) {
            this.showSheet.invoke(BottomSheetType.StravaDisabledInDemo);
            return;
        }
        if (!Internet.INSTANCE.isAvailable()) {
            this.showSheet.invoke(BottomSheetType.NoInternet);
        } else if (this.client.isConnected()) {
            this.showSheet.invoke(BottomSheetType.StravaDisconnect);
        } else {
            this.showSheet.invoke(BottomSheetType.StravaConnect);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object onDisconnect(kotlin.coroutines.Continuation<? super java.lang.Boolean> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.animaconnected.secondo.screens.settings.health.StravaUIState$onDisconnect$1
            if (r0 == 0) goto L13
            r0 = r5
            com.animaconnected.secondo.screens.settings.health.StravaUIState$onDisconnect$1 r0 = (com.animaconnected.secondo.screens.settings.health.StravaUIState$onDisconnect$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.secondo.screens.settings.health.StravaUIState$onDisconnect$1 r0 = new com.animaconnected.secondo.screens.settings.health.StravaUIState$onDisconnect$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.ResultKt.throwOnFailure(r5)
            goto L3d
        L27:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L2f:
            kotlin.ResultKt.throwOnFailure(r5)
            com.animaconnected.watch.account.strava.StravaClient r5 = r4.client
            r0.label = r3
            java.lang.Object r5 = r5.revokeAccess(r0)
            if (r5 != r1) goto L3d
            return r1
        L3d:
            com.animaconnected.watch.utils.WatchLibResult r5 = (com.animaconnected.watch.utils.WatchLibResult) r5
            boolean r0 = r5 instanceof com.animaconnected.watch.utils.WatchLibResult.Success
            if (r0 == 0) goto L44
            goto L49
        L44:
            boolean r5 = r5 instanceof com.animaconnected.watch.utils.WatchLibResult.Failure
            if (r5 == 0) goto L4e
            r3 = 0
        L49:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r3)
            return r5
        L4e:
            kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.settings.health.StravaUIState.onDisconnect(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
