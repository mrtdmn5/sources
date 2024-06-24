package com.animaconnected.secondo.behaviour.music;

import android.content.ContentResolver;
import android.media.session.MediaController;
import android.net.Uri;
import android.provider.Settings;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: MusicDataProvider.kt */
@DebugMetadata(c = "com.animaconnected.secondo.behaviour.music.MusicDataProvider$connectController$1", f = "MusicDataProvider.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class MusicDataProvider$connectController$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MediaController $newController;
    int label;
    final /* synthetic */ MusicDataProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MusicDataProvider$connectController$1(MusicDataProvider musicDataProvider, MediaController mediaController, Continuation<? super MusicDataProvider$connectController$1> continuation) {
        super(2, continuation);
        this.this$0 = musicDataProvider;
        this.$newController = mediaController;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MusicDataProvider$connectController$1(this.this$0, this.$newController, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MediaController mediaController;
        ContentResolver contentResolver;
        MusicDataProvider$volumeObserver$1 musicDataProvider$volumeObserver$1;
        MusicDataProvider$mediaObserver$1 musicDataProvider$mediaObserver$1;
        ContentResolver contentResolver2;
        MusicDataProvider$volumeObserver$1 musicDataProvider$volumeObserver$12;
        MusicDataProvider$mediaObserver$1 musicDataProvider$mediaObserver$12;
        MusicDataProvider$mediaObserver$1 musicDataProvider$mediaObserver$13;
        MusicDataProvider$volumeObserver$1 musicDataProvider$volumeObserver$13;
        MusicDataProvider$mediaObserver$1 musicDataProvider$mediaObserver$14;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.musicInfo = null;
            this.this$0.playback = null;
            mediaController = this.this$0.controller;
            if (mediaController != null) {
                musicDataProvider$mediaObserver$14 = this.this$0.mediaObserver;
                mediaController.unregisterCallback(musicDataProvider$mediaObserver$14);
            }
            this.this$0.controller = null;
            contentResolver = this.this$0.cr;
            musicDataProvider$volumeObserver$1 = this.this$0.volumeObserver;
            contentResolver.unregisterContentObserver(musicDataProvider$volumeObserver$1);
            MediaController mediaController2 = this.$newController;
            musicDataProvider$mediaObserver$1 = this.this$0.mediaObserver;
            mediaController2.registerCallback(musicDataProvider$mediaObserver$1);
            contentResolver2 = this.this$0.cr;
            Uri uri = Settings.System.CONTENT_URI;
            musicDataProvider$volumeObserver$12 = this.this$0.volumeObserver;
            contentResolver2.registerContentObserver(uri, true, musicDataProvider$volumeObserver$12);
            this.this$0.controller = this.$newController;
            musicDataProvider$mediaObserver$12 = this.this$0.mediaObserver;
            musicDataProvider$mediaObserver$12.onMetadataChanged(this.$newController.getMetadata());
            musicDataProvider$mediaObserver$13 = this.this$0.mediaObserver;
            musicDataProvider$mediaObserver$13.onPlaybackStateChanged(this.$newController.getPlaybackState());
            musicDataProvider$volumeObserver$13 = this.this$0.volumeObserver;
            musicDataProvider$volumeObserver$13.onChange(true);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MusicDataProvider$connectController$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
