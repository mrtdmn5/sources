package com.animaconnected.secondo.behaviour.music;

import com.animaconnected.logger.LogKt;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: MusicWatchAppAndroid.kt */
@DebugMetadata(c = "com.animaconnected.secondo.behaviour.music.MusicWatchAppAndroid$onPlaybackChange$2", f = "MusicWatchAppAndroid.kt", l = {100}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class MusicWatchAppAndroid$onPlaybackChange$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MusicPlayback $playback;
    final /* synthetic */ DisplayWatch $watch;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MusicWatchAppAndroid this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MusicWatchAppAndroid$onPlaybackChange$2(DisplayWatch displayWatch, MusicWatchAppAndroid musicWatchAppAndroid, MusicPlayback musicPlayback, Continuation<? super MusicWatchAppAndroid$onPlaybackChange$2> continuation) {
        super(2, continuation);
        this.$watch = displayWatch;
        this.this$0 = musicWatchAppAndroid;
        this.$playback = musicPlayback;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MusicWatchAppAndroid$onPlaybackChange$2 musicWatchAppAndroid$onPlaybackChange$2 = new MusicWatchAppAndroid$onPlaybackChange$2(this.$watch, this.this$0, this.$playback, continuation);
        musicWatchAppAndroid$onPlaybackChange$2.L$0 = obj;
        return musicWatchAppAndroid$onPlaybackChange$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        Exception exc;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 == 1) {
                CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Exception e) {
                    exc = e;
                    coroutineScope = coroutineScope2;
                    LogKt.warn$default((Object) coroutineScope, "MusicWatchApp", (Throwable) exc, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.behaviour.music.MusicWatchAppAndroid$onPlaybackChange$2.1
                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "Couldn't update music";
                        }
                    }, 4, (Object) null);
                    return Unit.INSTANCE;
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope3 = (CoroutineScope) this.L$0;
            try {
                DisplayWatch displayWatch = this.$watch;
                MusicInfo info = this.this$0.getInfo();
                MusicPlayback musicPlayback = this.$playback;
                this.L$0 = coroutineScope3;
                this.label = 1;
                if (DisplayWatchJvm.sendMediaNotification(displayWatch, info, musicPlayback, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } catch (Exception e2) {
                coroutineScope = coroutineScope3;
                exc = e2;
                LogKt.warn$default((Object) coroutineScope, "MusicWatchApp", (Throwable) exc, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.behaviour.music.MusicWatchAppAndroid$onPlaybackChange$2.1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Couldn't update music";
                    }
                }, 4, (Object) null);
                return Unit.INSTANCE;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MusicWatchAppAndroid$onPlaybackChange$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
