package com.animaconnected.watch.behaviour.alarms;

import com.animaconnected.watch.device.files.WatchFile;
import com.animaconnected.watch.provider.WatchAlarm;
import java.util.List;

/* compiled from: AlarmsApp.kt */
/* loaded from: classes3.dex */
public final class AlarmsAppKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final WatchFile makeWatchFile(List<WatchAlarm> list, String str) {
        return new WatchFile(str, AlarmsApp.AlarmAppFile, AlarmParserKt.encode(WatchAlarm.Companion, list), true);
    }
}
