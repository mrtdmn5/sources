package com.animaconnected.watch.display;

import com.animaconnected.watch.display.view.Display;
import java.util.List;

/* compiled from: WatchAppInterfaces.kt */
/* loaded from: classes3.dex */
public interface RemoteApp extends WatchApp {
    List<Display> getDisplays();

    VisibilityState getOnStartState();

    void requestState(VisibilityState visibilityState);
}
