package com.animaconnected.watch.display;

import com.animaconnected.watch.behaviour.Behaviour;
import com.animaconnected.watch.device.AppAction;
import com.animaconnected.watch.image.Mitmap;
import com.animaconnected.watch.strings.KeyString;

/* compiled from: WatchAppInterfaces.kt */
/* loaded from: classes3.dex */
public interface WatchApp extends Behaviour {
    Mitmap getIcon();

    AppId getId();

    default QuickActionType getQuickActionType() {
        return QuickActionType.None;
    }

    KeyString getTitle();

    default boolean isHidden() {
        return false;
    }

    void onAppAction(int r1, AppAction appAction);

    void onStateChanged(VisibilityState visibilityState);
}
