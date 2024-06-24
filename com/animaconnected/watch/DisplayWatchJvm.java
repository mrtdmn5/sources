package com.animaconnected.watch;

import com.animaconnected.logger.LogKt;
import com.animaconnected.watch.MusicPlayback;
import com.animaconnected.watch.device.CallState;
import com.animaconnected.watch.device.WatchIO;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function0;

/* compiled from: DisplayWatch.kt */
/* loaded from: classes3.dex */
public final class DisplayWatchJvm {
    public static final MusicPlayback.State getPlaybackState(int r0) {
        switch (r0) {
            case 0:
                return MusicPlayback.State.NONE;
            case 1:
                return MusicPlayback.State.STOPPED;
            case 2:
                return MusicPlayback.State.PAUSED;
            case 3:
                return MusicPlayback.State.PLAYING;
            case 4:
                return MusicPlayback.State.FAST_FORWARDING;
            case 5:
                return MusicPlayback.State.REWINDING;
            case 6:
                return MusicPlayback.State.BUFFERING;
            case 7:
                return MusicPlayback.State.ERROR;
            case 8:
                return MusicPlayback.State.CONNECTING;
            case 9:
                return MusicPlayback.State.SKIPPING_TO_PREVIOUS;
            case 10:
                return MusicPlayback.State.SKIPPING_TO_NEXT;
            case 11:
                return MusicPlayback.State.SKIPPING_TO_QUEUE_ITEM;
            default:
                return MusicPlayback.State.NONE;
        }
    }

    public static final Object removeNotification(DisplayWatch displayWatch, final int r8, Continuation<? super Unit> continuation) throws Exception {
        LogKt.verbose$default((Object) displayWatch, displayWatch.getTag$watch_release(), (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.DisplayWatchJvm$removeNotification$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "removeNotification: " + r8;
            }
        }, 6, (Object) null);
        WatchIO io2 = displayWatch.getIo();
        if (io2 != null) {
            Object writeRemoveNotification = io2.writeRemoveNotification(r8, continuation);
            if (writeRemoveNotification == CoroutineSingletons.COROUTINE_SUSPENDED) {
                return writeRemoveNotification;
            }
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0213 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x01f1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object sendMediaNotification(com.animaconnected.watch.DisplayWatch r31, com.animaconnected.watch.MusicInfo r32, com.animaconnected.watch.MusicPlayback r33, kotlin.coroutines.Continuation<? super kotlin.Unit> r34) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 588
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.DisplayWatchJvm.sendMediaNotification(com.animaconnected.watch.DisplayWatch, com.animaconnected.watch.MusicInfo, com.animaconnected.watch.MusicPlayback, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Object setCallStatus(DisplayWatch displayWatch, final int r13, final CallState callState, String str, boolean z, boolean z2, Continuation<? super Unit> continuation) throws Exception {
        String str2;
        LogKt.debug$default((Object) displayWatch, displayWatch.getTag$watch_release(), (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.DisplayWatchJvm$setCallStatus$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Call status updated. Call id: " + r13 + " with state: " + callState;
            }
        }, 6, (Object) null);
        WatchIO io2 = displayWatch.getIo();
        if (io2 != null) {
            if (str == null) {
                str2 = "";
            } else {
                str2 = str;
            }
            Object writeIncomingCall = io2.writeIncomingCall(r13, callState, str2, z, z2, continuation);
            if (writeIncomingCall == CoroutineSingletons.COROUTINE_SUSPENDED) {
                return writeIncomingCall;
            }
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }
}
