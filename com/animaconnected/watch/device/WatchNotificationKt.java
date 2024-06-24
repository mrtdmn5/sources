package com.animaconnected.watch.device;

import com.animaconnected.watch.image.Kolor;
import com.animaconnected.watch.image.Kolors;
import com.animaconnected.watch.image.Mitmap;
import com.animaconnected.watch.strings.Key;
import com.animaconnected.watch.strings.StringsExtensionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* compiled from: WatchNotification.kt */
/* loaded from: classes3.dex */
public final class WatchNotificationKt {
    private static final Mutex notificationMutex = MutexKt.Mutex$default();

    public static final Mutex getNotificationMutex() {
        return notificationMutex;
    }

    public static final PhoneNotification permissionNotification(Mitmap icon) {
        Intrinsics.checkNotNullParameter(icon, "icon");
        return new PhoneNotification(111, "permissionNotification", StringsExtensionsKt.getKeyString(Key.permission_required), StringsExtensionsKt.getKeyString(Key.permission_instruct), icon, Kolor.m1537constructorimpl(Kolors.deepSkyBlue), "permission.required.notification", Vibration.NONE, null);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x0027. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0276 A[Catch: all -> 0x02e4, TryCatch #0 {all -> 0x02e4, blocks: (B:24:0x0272, B:26:0x0276, B:27:0x027c, B:29:0x0280, B:33:0x02b4), top: B:23:0x0272 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0280 A[Catch: all -> 0x02e4, TryCatch #0 {all -> 0x02e4, blocks: (B:24:0x0272, B:26:0x0276, B:27:0x027c, B:29:0x0280, B:33:0x02b4), top: B:23:0x0272 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x02b4 A[Catch: all -> 0x02e4, TRY_LEAVE, TryCatch #0 {all -> 0x02e4, blocks: (B:24:0x0272, B:26:0x0276, B:27:0x027c, B:29:0x0280, B:33:0x02b4), top: B:23:0x0272 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0219 A[Catch: all -> 0x004c, TRY_LEAVE, TryCatch #6 {all -> 0x004c, blocks: (B:13:0x0037, B:14:0x003c, B:18:0x0046, B:47:0x0211, B:49:0x0219, B:52:0x021f), top: B:7:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x021f A[Catch: all -> 0x004c, TRY_ENTER, TRY_LEAVE, TryCatch #6 {all -> 0x004c, blocks: (B:13:0x0037, B:14:0x003c, B:18:0x0046, B:47:0x0211, B:49:0x0219, B:52:0x021f), top: B:7:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01bf A[Catch: all -> 0x02e7, TryCatch #2 {all -> 0x02e7, blocks: (B:60:0x01af, B:62:0x01bf, B:63:0x01cb), top: B:59:0x01af }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0201 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01a4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002a  */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r5v0, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object sendNotification(com.animaconnected.watch.DisplayWatch r24, final com.animaconnected.watch.device.PhoneNotification r25, kotlin.coroutines.Continuation<? super kotlin.Unit> r26) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 776
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.device.WatchNotificationKt.sendNotification(com.animaconnected.watch.DisplayWatch, com.animaconnected.watch.device.PhoneNotification, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final PhoneNotification setupNeededNotification(Mitmap icon) {
        Intrinsics.checkNotNullParameter(icon, "icon");
        return new PhoneNotification(222, "setupNotification", StringsExtensionsKt.getKeyString(Key.setup_needed_title), StringsExtensionsKt.getKeyString(Key.setup_needed_description), icon, Kolor.m1537constructorimpl(Kolors.deepSkyBlue), "setup.notification", Vibration.NONE, null);
    }
}
