package com.animaconnected.secondo.behaviour.findphone;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import androidx.core.app.NotificationCompat$Builder;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferService;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.behaviour.BehaviourPlugin;
import com.animaconnected.secondo.utils.AppUtils;
import com.animaconnected.secondo.utils.NotificationUtils;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.behaviour.interfaces.FindPhoneListener;
import com.animaconnected.watch.behaviour.interfaces.FindPhoneMusicPlayer;
import com.animaconnected.watch.behaviour.interfaces.Music;
import com.animaconnected.watch.behaviour.interfaces.PlayResult;
import com.animaconnected.watch.behaviour.types.FindPhone;
import com.kronaby.watch.app.R;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* compiled from: FindPhonePlugin.kt */
/* loaded from: classes3.dex */
public final class FindPhonePlugin implements BehaviourPlugin<FindPhone> {
    public static final int $stable = 8;
    private MediaPlayer currentMediaPlayer;
    private FindPhone findPhone;
    private boolean hasAudioFocus;
    private final AudioManagerWrapper audioWrapper = AudioManagerKt.getAudioManagerWrapper(new Function0<Unit>() { // from class: com.animaconnected.secondo.behaviour.findphone.FindPhonePlugin$audioWrapper$1
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
            FindPhone findPhone;
            findPhone = FindPhonePlugin.this.findPhone;
            if (findPhone != null) {
                findPhone.stopMusic();
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("findPhone");
                throw null;
            }
        }
    });
    private FindPhonePlugin$stopPlayingBroadcastReceiver$1 stopPlayingBroadcastReceiver = new BroadcastReceiver() { // from class: com.animaconnected.secondo.behaviour.findphone.FindPhonePlugin$stopPlayingBroadcastReceiver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String str;
            FindPhone findPhone;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            str = FindPhonePlugin.this.actionStopPlaying;
            if (Intrinsics.areEqual(str, intent.getAction())) {
                findPhone = FindPhonePlugin.this.findPhone;
                if (findPhone != null) {
                    findPhone.stopMusic();
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("findPhone");
                    throw null;
                }
            }
        }
    };
    private final String actionStopPlaying = "FIND_PHONE_STOP_PLAYING_SOUND";
    private final int findPhoneNotificationID = 17070599;
    private final Lazy behaviour$delegate = LazyKt__LazyJVMKt.lazy(new Function0<FindPhone>() { // from class: com.animaconnected.secondo.behaviour.findphone.FindPhonePlugin$behaviour$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final FindPhone invoke() {
            FindPhone findPhone;
            findPhone = FindPhonePlugin.this.findPhone;
            if (findPhone != null) {
                return findPhone;
            }
            Intrinsics.throwUninitializedPropertyAccessException("findPhone");
            throw null;
        }
    });
    private final String type = FindPhone.TYPE;
    private final int nameId = R.string.behaviour_name_find_phone;
    private final int iconResourceId = R.drawable.ic_find_phone;
    private final String iconWatchAsset = "watch/ic_find_phone.png";

    /* compiled from: FindPhonePlugin.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[Music.values().length];
            try {
                r0[Music.Normal.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[Music.NotSet.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[Music.Loud.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r0[Music.Discrete.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                r0[Music.Upbeat.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                r0[Music.Christmas.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    private final void dismissNotification(Context context) {
        getNotificationManager(context).cancel(this.findPhoneNotificationID);
    }

    private final NotificationManager getNotificationManager(Context context) {
        Object systemService = context.getSystemService(TransferService.INTENT_KEY_NOTIFICATION);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        return (NotificationManager) systemService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int resource(Music music) {
        switch (WhenMappings.$EnumSwitchMapping$0[music.ordinal()]) {
            case 1:
            case 2:
                return R.raw.kronabyriseandshine;
            case 3:
                return R.raw.kronabyrollingwaves;
            case 4:
                return R.raw.kronabycuriouspeek;
            case 5:
                return R.raw.kronaby_findphone_finding_the_beat;
            case 6:
                return R.raw.jingle_bells_kronaby_master;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showNotification() {
        Context context = KronabyApplication.Companion.getContext();
        NotificationManager notificationManager = getNotificationManager(context);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, new Intent(this.actionStopPlaying), AppUtils.getPendingIntentFlag());
        NotificationCompat$Builder createNotificationBuilder = NotificationUtils.createNotificationBuilder(context, NotificationUtils.DEFAULT_NOTIFICATION_CHANNEL_ID);
        createNotificationBuilder.setContentTitle(context.getString(R.string.notification_find_phone_title));
        createNotificationBuilder.setContentText(context.getString(R.string.notification_find_phone_description));
        createNotificationBuilder.mPriority = 0;
        createNotificationBuilder.setFlag(16, true);
        createNotificationBuilder.mContentIntent = broadcast;
        createNotificationBuilder.mNotification.deleteIntent = broadcast;
        notificationManager.notify(this.findPhoneNotificationID, createNotificationBuilder.build());
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public Fragment createFragment(Slot slot) {
        Intrinsics.checkNotNullParameter(slot, "slot");
        return FindPhoneFragment.Companion.newInstance(slot);
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public int getIconResourceId() {
        return this.iconResourceId;
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public String getIconWatchAsset() {
        return this.iconWatchAsset;
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public int getNameId() {
        return this.nameId;
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public String getType() {
        return this.type;
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public void initBehaviour(final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.findPhone = new FindPhone(new FindPhoneMusicPlayer() { // from class: com.animaconnected.secondo.behaviour.findphone.FindPhonePlugin$initBehaviour$findPhoneMusicPlayer$1
            @Override // com.animaconnected.watch.behaviour.interfaces.FindPhoneMusicPlayer
            public Object play(Music music, float f, Continuation<? super PlayResult> continuation) {
                AudioManagerWrapper audioManagerWrapper;
                boolean z;
                AudioManagerWrapper audioManagerWrapper2;
                AudioManagerWrapper audioManagerWrapper3;
                AudioManagerWrapper audioManagerWrapper4;
                audioManagerWrapper = FindPhonePlugin.this.audioWrapper;
                if (!audioManagerWrapper.currentlyInCall()) {
                    z = FindPhonePlugin.this.hasAudioFocus;
                    if (!z) {
                        audioManagerWrapper4 = FindPhonePlugin.this.audioWrapper;
                        if (audioManagerWrapper4.requestFocus()) {
                            FindPhonePlugin.this.hasAudioFocus = true;
                        } else {
                            LogKt.debug$default((Object) this, "Failed to grant audio focus", (String) null, (Throwable) null, false, 14, (Object) null);
                            return PlayResult.Failed;
                        }
                    }
                    audioManagerWrapper2 = FindPhonePlugin.this.audioWrapper;
                    audioManagerWrapper2.prepareForBlast();
                    audioManagerWrapper3 = FindPhonePlugin.this.audioWrapper;
                    audioManagerWrapper3.adjustVolume(f);
                    DefaultScheduler defaultScheduler = Dispatchers.Default;
                    return BuildersKt.withContext(MainDispatcherLoader.dispatcher, new FindPhonePlugin$initBehaviour$findPhoneMusicPlayer$1$play$2(FindPhonePlugin.this, context, music, null), continuation);
                }
                LogKt.debug$default((Object) this, "Currently in call, abort.", (String) null, (Throwable) null, false, 14, (Object) null);
                return PlayResult.Failed;
            }

            @Override // com.animaconnected.watch.behaviour.interfaces.FindPhoneMusicPlayer
            public void stop() {
                FindPhonePlugin.this.stopPlaying();
            }
        }, SetsKt__SetsKt.mutableSetOf(new FindPhoneListener() { // from class: com.animaconnected.secondo.behaviour.findphone.FindPhonePlugin$initBehaviour$findPhoneListener$1
            @Override // com.animaconnected.watch.behaviour.interfaces.FindPhoneListener
            public void onFindPhoneStarted() {
                FindPhonePlugin$stopPlayingBroadcastReceiver$1 findPhonePlugin$stopPlayingBroadcastReceiver$1;
                String str;
                Context applicationContext = context.getApplicationContext();
                findPhonePlugin$stopPlayingBroadcastReceiver$1 = this.stopPlayingBroadcastReceiver;
                IntentFilter intentFilter = new IntentFilter();
                str = this.actionStopPlaying;
                intentFilter.addAction(str);
                Unit unit = Unit.INSTANCE;
                ContextCompat.registerReceiver(applicationContext, findPhonePlugin$stopPlayingBroadcastReceiver$1, intentFilter, 4);
                this.showNotification();
            }

            @Override // com.animaconnected.watch.behaviour.interfaces.FindPhoneListener
            public void onFindPhoneStopped() {
            }
        }), null, 4, null);
    }

    public final void stopPlaying() {
        MediaPlayer mediaPlayer = this.currentMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            this.audioWrapper.abandonFocus();
            this.hasAudioFocus = false;
            this.audioWrapper.returnToUserSettings();
            KronabyApplication.Companion companion = KronabyApplication.Companion;
            dismissNotification(companion.getContext());
            try {
                companion.getContext().getApplicationContext().unregisterReceiver(this.stopPlayingBroadcastReceiver);
            } catch (IllegalArgumentException unused) {
                LogKt.debug$default((Object) this, "Most likely the broadcast receiver was not registered successfully so it is unable to find it.", (String) null, (Throwable) null, true, 6, (Object) null);
            }
        }
        this.currentMediaPlayer = null;
    }

    @Override // com.animaconnected.secondo.behaviour.BehaviourPlugin
    public FindPhone getBehaviour() {
        return (FindPhone) this.behaviour$delegate.getValue();
    }
}
