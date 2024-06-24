package com.animaconnected.watch.display;

import com.animaconnected.watch.DisplayWatch;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.device.AppAction;
import com.animaconnected.watch.device.files.WatchFile;
import com.animaconnected.watch.image.Mitmap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WatchAppInterfaces.kt */
/* loaded from: classes3.dex */
public interface FirmwareApp extends WatchApp {
    static /* synthetic */ Object getFiles$suspendImpl(FirmwareApp firmwareApp, Continuation<? super List<WatchFile>> continuation) {
        return null;
    }

    static /* synthetic */ Object onWatchFileChange$suspendImpl(FirmwareApp firmwareApp, WatchFile watchFile, DisplayWatch displayWatch, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    default Slot[] compatibleSlots() {
        return new Slot[]{Slot.Display};
    }

    default Object getFiles(Continuation<? super List<WatchFile>> continuation) {
        return getFiles$suspendImpl(this, continuation);
    }

    default Map<String, Mitmap> getImages() {
        return EmptyMap.INSTANCE;
    }

    default Map<String, WatchString> getStrings() {
        return EmptyMap.INSTANCE;
    }

    @Override // com.animaconnected.watch.display.WatchApp
    default void onAppAction(int r1, AppAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
    }

    @Override // com.animaconnected.watch.display.WatchApp
    default void onStateChanged(VisibilityState state) {
        Intrinsics.checkNotNullParameter(state, "state");
    }

    default Object onWatchFileChange(WatchFile watchFile, DisplayWatch displayWatch, Continuation<? super Unit> continuation) {
        return onWatchFileChange$suspendImpl(this, watchFile, displayWatch, continuation);
    }
}
