package com.animaconnected.secondo.screens.debugsettings;

import androidx.fragment.app.Fragment;
import com.amplifyframework.core.model.Model$$ExternalSyntheticOutline0;
import com.animaconnected.secondo.utils.ViewKt;
import com.animaconnected.watch.DisplayWatch;
import com.animaconnected.watch.DisplayWatchJvm;
import com.animaconnected.watch.MusicInfo;
import com.animaconnected.watch.MusicPlayback;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: DebugMediaNotificationsFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.DebugMediaNotificationsFragment$sendMediaNotification$1", f = "DebugMediaNotificationsFragment.kt", l = {206}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DebugMediaNotificationsFragment$sendMediaNotification$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MusicInfo $musicInfo;
    final /* synthetic */ MusicPlayback $playbackState;
    int label;
    final /* synthetic */ DebugMediaNotificationsFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugMediaNotificationsFragment$sendMediaNotification$1(DebugMediaNotificationsFragment debugMediaNotificationsFragment, MusicInfo musicInfo, MusicPlayback musicPlayback, Continuation<? super DebugMediaNotificationsFragment$sendMediaNotification$1> continuation) {
        super(2, continuation);
        this.this$0 = debugMediaNotificationsFragment;
        this.$musicInfo = musicInfo;
        this.$playbackState = musicPlayback;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DebugMediaNotificationsFragment$sendMediaNotification$1(this.this$0, this.$musicInfo, this.$playbackState, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        DisplayWatch displayWatch;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r2 = this.label;
        try {
            if (r2 != 0) {
                if (r2 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                displayWatch = this.this$0.watch;
                if (displayWatch != null) {
                    MusicInfo musicInfo = this.$musicInfo;
                    MusicPlayback musicPlayback = this.$playbackState;
                    this.label = 1;
                    if (DisplayWatchJvm.sendMediaNotification(displayWatch, musicInfo, musicPlayback, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
            }
            ViewKt.toast$default((Fragment) this.this$0, "Sending notification with musicInfo " + this.$musicInfo + " and android playback state " + this.$playbackState, false, 2, (Object) null);
        } catch (Exception e) {
            ViewKt.toast$default((Fragment) this.this$0, Model$$ExternalSyntheticOutline0.m("Error: ", e), false, 2, (Object) null);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DebugMediaNotificationsFragment$sendMediaNotification$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
