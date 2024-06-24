package com.animaconnected.secondo.screens.debugsettings;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticOutline0;
import androidx.compose.material.CardKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer$Companion$Empty$1;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.behaviour.music.MusicDataListener;
import com.animaconnected.secondo.behaviour.music.MusicDataProvider;
import com.animaconnected.secondo.notification.receiver.NotificationUtil;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.ComposeFragment;
import com.animaconnected.secondo.screens.tipsandtricks.TipsAndTricksConstants;
import com.animaconnected.watch.DisplayWatch;
import com.animaconnected.watch.MusicInfo;
import com.animaconnected.watch.MusicPlayback;
import com.animaconnected.watch.Watch;
import com.google.common.base.Strings;
import com.google.common.collect.Hashing;
import com.google.common.collect.Platform;
import com.kronaby.watch.app.R;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* compiled from: DebugMediaNotificationsFragment.kt */
/* loaded from: classes3.dex */
public final class DebugMediaNotificationsFragment extends ComposeFragment implements MusicDataListener {
    public static final int $stable = 8;
    private final MutableState<Integer> currentVolume;
    private MusicDataProvider musicProvider;
    private final MutableState<MusicInfo> musicState;
    private final String name = "DebugMediaNotifications";
    private final MutableState<MusicPlayback> playBackMutableState;
    private final MutableState<Boolean> useMediaManager;
    private final DisplayWatch watch;

    public DebugMediaNotificationsFragment() {
        DisplayWatch displayWatch;
        Watch watch = ProviderFactory.getWatch().getWatch();
        if (watch instanceof DisplayWatch) {
            displayWatch = (DisplayWatch) watch;
        } else {
            displayWatch = null;
        }
        this.watch = displayWatch;
        this.musicProvider = ProviderFactory.getMusicDataProvider();
        this.musicState = Platform.mutableStateOf$default(new MusicInfo("Artist", "Song Title", "Album Name here", TipsAndTricksConstants.MUTE_PHONE_CALL_PRIORITY));
        this.playBackMutableState = Platform.mutableStateOf$default(new MusicPlayback(0L, 3));
        this.currentVolume = Platform.mutableStateOf$default(0);
        this.useMediaManager = Platform.mutableStateOf$default(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MusicInfo ComposeContent$lambda$1(MutableState<MusicInfo> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MusicPlayback ComposeContent$lambda$4(MutableState<MusicPlayback> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendMediaNotification(MusicInfo musicInfo, MusicPlayback musicPlayback) {
        BuildersKt.launch$default(Hashing.getLifecycleScope(this), null, null, new DebugMediaNotificationsFragment$sendMediaNotification$1(this, musicInfo, musicPlayback, null), 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendVolume() {
        BuildersKt.launch$default(Hashing.getLifecycleScope(this), null, null, new DebugMediaNotificationsFragment$sendVolume$1(this, null), 3);
    }

    @Override // com.animaconnected.secondo.screens.ComposeFragment
    public void ComposeContent(Composer composer, final int r10) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(1988877529);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        List listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{new Pair("Playing", 3), new Pair("Pause", 2), new Pair("Stop", 1)});
        startRestartGroup.startReplaceableGroup(-633467466);
        Object nextSlot = startRestartGroup.nextSlot();
        Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
        if (nextSlot == composer$Companion$Empty$1) {
            nextSlot = this.musicState;
            startRestartGroup.updateValue(nextSlot);
        }
        MutableState mutableState = (MutableState) nextSlot;
        Object m = CoreTextFieldKt$$ExternalSyntheticOutline0.m(startRestartGroup, false, -633467413);
        if (m == composer$Companion$Empty$1) {
            m = this.playBackMutableState;
            startRestartGroup.updateValue(m);
        }
        startRestartGroup.end(false);
        CardKt.m162CardFjzlyU(null, null, 0.0f, ComposableLambdaKt.composableLambda(startRestartGroup, -1033027716, new DebugMediaNotificationsFragment$ComposeContent$1(mutableState, (MutableState) m, listOf, this)), startRestartGroup, 1572864, 63);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugMediaNotificationsFragment$ComposeContent$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r3) {
                    DebugMediaNotificationsFragment.this.ComposeContent(composer2, Strings.updateChangedFlags(r10 | 1));
                }
            };
        }
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public boolean accessEvenIfDisconnected() {
        return true;
    }

    @Override // com.animaconnected.secondo.screens.ComposeFragment, com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getFeaturePathName() {
        String string = getString(R.string.feature_path_settings);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return this.name;
    }

    @Override // com.animaconnected.secondo.screens.ComposeFragment, com.animaconnected.secondo.screens.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        if (!NotificationUtil.isEnabled(requireContext)) {
            Context requireContext2 = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext(...)");
            NotificationUtil.showNeedsReadNotificationsPermissionDialog(requireContext2, new NotificationUtil.DialogListener() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugMediaNotificationsFragment$onCreate$1
                @Override // com.animaconnected.secondo.notification.receiver.NotificationUtil.DialogListener
                public void onNeedsReadNotificationsPermissionCancel() {
                }

                @Override // com.animaconnected.secondo.notification.receiver.NotificationUtil.DialogListener
                public void onNotificationSettingsLaunched() {
                }
            });
        }
        this.musicProvider.addListener(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.musicProvider.removeListener(this);
    }

    @Override // com.animaconnected.secondo.behaviour.music.MusicDataListener
    public void onInfo(MusicInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        if (this.useMediaManager.getValue().booleanValue()) {
            this.musicState.setValue(info);
        }
    }

    @Override // com.animaconnected.secondo.behaviour.music.MusicDataListener
    @SuppressLint({"SetTextI18n"})
    public void onPlaybackChange(MusicPlayback playback) {
        Intrinsics.checkNotNullParameter(playback, "playback");
        if (this.useMediaManager.getValue().booleanValue()) {
            this.playBackMutableState.setValue(playback);
        }
    }

    @Override // com.animaconnected.secondo.behaviour.music.MusicDataListener
    public void onVolumeChange(int r2) {
        this.currentVolume.setValue(Integer.valueOf(r2));
    }

    @Override // com.animaconnected.secondo.behaviour.music.MusicDataListener
    public void onSessionFinished() {
    }
}
