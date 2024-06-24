package com.animaconnected.watch.device;

import com.animaconnected.watch.display.Font;
import com.animaconnected.watch.display.FontType;

/* compiled from: WatchStyle.kt */
/* loaded from: classes3.dex */
public interface WatchStyle {
    WatchDisplayColors getColors();

    Font getFont(FontType fontType);

    void setBackgroundColor(String str);

    void setForegroundColor(String str);

    void setHighlightColor(String str);
}
