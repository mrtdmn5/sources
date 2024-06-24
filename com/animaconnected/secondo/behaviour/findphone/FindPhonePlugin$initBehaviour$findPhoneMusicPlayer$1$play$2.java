package com.animaconnected.secondo.behaviour.findphone;

import android.content.Context;
import android.media.MediaPlayer;
import com.animaconnected.watch.behaviour.interfaces.Music;
import com.animaconnected.watch.behaviour.interfaces.PlayResult;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: FindPhonePlugin.kt */
@DebugMetadata(c = "com.animaconnected.secondo.behaviour.findphone.FindPhonePlugin$initBehaviour$findPhoneMusicPlayer$1$play$2", f = "FindPhonePlugin.kt", l = {71}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class FindPhonePlugin$initBehaviour$findPhoneMusicPlayer$1$play$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super PlayResult>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Music $music;
    Object L$0;
    int label;
    final /* synthetic */ FindPhonePlugin this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FindPhonePlugin$initBehaviour$findPhoneMusicPlayer$1$play$2(FindPhonePlugin findPhonePlugin, Context context, Music music, Continuation<? super FindPhonePlugin$initBehaviour$findPhoneMusicPlayer$1$play$2> continuation) {
        super(2, continuation);
        this.this$0 = findPhonePlugin;
        this.$context = context;
        this.$music = music;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FindPhonePlugin$initBehaviour$findPhoneMusicPlayer$1$play$2(this.this$0, this.$context, this.$music, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        int resource;
        MediaPlayer mediaPlayer;
        MediaPlayer mediaPlayer2;
        Unit unit;
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
            FindPhonePlugin findPhonePlugin = this.this$0;
            Context context = this.$context;
            resource = findPhonePlugin.resource(this.$music);
            findPhonePlugin.currentMediaPlayer = MediaPlayer.create(context, resource);
            mediaPlayer = this.this$0.currentMediaPlayer;
            if (mediaPlayer != null) {
                mediaPlayer.start();
            }
            FindPhonePlugin findPhonePlugin2 = this.this$0;
            this.L$0 = findPhonePlugin2;
            this.label = 1;
            final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(this));
            mediaPlayer2 = findPhonePlugin2.currentMediaPlayer;
            if (mediaPlayer2 != null) {
                mediaPlayer2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.animaconnected.secondo.behaviour.findphone.FindPhonePlugin$initBehaviour$findPhoneMusicPlayer$1$play$2$1$1
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public final void onCompletion(MediaPlayer mediaPlayer3) {
                        safeContinuation.resumeWith(PlayResult.Finished);
                    }
                });
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                safeContinuation.resumeWith(PlayResult.Failed);
            }
            obj = safeContinuation.getOrThrow();
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return obj;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super PlayResult> continuation) {
        return ((FindPhonePlugin$initBehaviour$findPhoneMusicPlayer$1$play$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
