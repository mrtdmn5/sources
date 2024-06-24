package com.animaconnected.secondo.screens.settings.health;

import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.googlefit.GoogleFitProvider;
import com.animaconnected.secondo.provider.googlefit.GoogleFitUiState;
import com.animaconnected.secondo.utils.CustomActivityResult;
import com.animaconnected.secondo.utils.Internet;
import com.animaconnected.watch.provider.demo.DemoModeProvider;
import com.google.common.collect.Platform;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GoogleFitUIState.kt */
/* loaded from: classes3.dex */
public final class GoogleFitUIState {
    public static final int $stable = 8;
    private final CustomActivityResult<Intent, ActivityResult> activityLauncher;
    private final DemoModeProvider demoModeProvider;
    private final GoogleFitProvider provider;
    private final Function1<BottomSheetType, Unit> showSheet;

    /* JADX WARN: Multi-variable type inference failed */
    public GoogleFitUIState(Function1<? super BottomSheetType, Unit> showSheet, CustomActivityResult<Intent, ActivityResult> activityLauncher) {
        Intrinsics.checkNotNullParameter(showSheet, "showSheet");
        Intrinsics.checkNotNullParameter(activityLauncher, "activityLauncher");
        this.showSheet = showSheet;
        this.activityLauncher = activityLauncher;
        GoogleFitProvider googleFitProvider = ProviderFactory.INSTANCE.getGoogleFitProvider();
        this.provider = googleFitProvider;
        this.demoModeProvider = ProviderFactory.getWatch().getWatchManager().getDemoModeProvider();
        googleFitProvider.updateUiState();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final GoogleFitUiState getState(Composer composer, int r2) {
        composer.startReplaceableGroup(1302558977);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        GoogleFitUiState googleFitUiState = (GoogleFitUiState) Platform.collectAsState(this.provider.getUiState(), composer).getValue();
        composer.endReplaceableGroup();
        return googleFitUiState;
    }

    public final void onClick() {
        this.provider.setBadgeVisible(false);
        if (this.demoModeProvider.isCurrentlyEnabled()) {
            this.showSheet.invoke(BottomSheetType.GoogleFitDisabledInDemo);
            return;
        }
        if (!Internet.INSTANCE.isAvailable()) {
            this.showSheet.invoke(BottomSheetType.NoInternet);
        } else if (this.provider.getUiState().getValue().getRequiresAttention()) {
            this.provider.enableGoogleFit(this.activityLauncher, new Function1<ActivityResult, Unit>() { // from class: com.animaconnected.secondo.screens.settings.health.GoogleFitUIState$onClick$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ActivityResult activityResult) {
                    invoke2(activityResult);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ActivityResult it) {
                    GoogleFitProvider googleFitProvider;
                    Intrinsics.checkNotNullParameter(it, "it");
                    googleFitProvider = GoogleFitUIState.this.provider;
                    googleFitProvider.updateUiState();
                }
            });
        } else {
            this.showSheet.invoke(BottomSheetType.GoogleFitDisconnect);
        }
    }

    public final Object onDisconnect(Continuation<? super Boolean> continuation) {
        return this.provider.disableGoogleFit(continuation);
    }
}
