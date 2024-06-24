package com.animaconnected.watch.device;

import com.animaconnected.msgpack.MsgPack;
import com.animaconnected.watch.display.AppId;
import com.animaconnected.watch.fitness.FitnessMetric;
import com.animaconnected.watch.fitness.HeartrateValue;
import java.util.Map;
import kotlin.UInt;

/* compiled from: WatchEventListener.kt */
/* loaded from: classes3.dex */
public interface InternalEvents extends WatchEventListener {
    /* renamed from: onFileWriteResult-miZAcA0$default, reason: not valid java name */
    static /* synthetic */ void m1068onFileWriteResultmiZAcA0$default(InternalEvents internalEvents, FileResult fileResult, int r3, Integer num, UInt uInt, int r6, Object obj) {
        if (obj == null) {
            if ((r6 & 4) != 0) {
                num = null;
            }
            if ((r6 & 8) != 0) {
                uInt = null;
            }
            internalEvents.mo1050onFileWriteResultmiZAcA0(fileResult, r3, num, uInt);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onFileWriteResult-miZAcA0");
    }

    void onAppAction(AppId appId, int r2, AppAction appAction);

    void onCSEMLog(MsgPack msgPack);

    /* renamed from: onFileChanged-kosIJfI */
    void mo1048onFileChangedkosIJfI(int r1, Integer num, UInt uInt);

    /* renamed from: onFileDeleteResult-Qn1smSk */
    void mo1049onFileDeleteResultQn1smSk(FileResult fileResult, int r2);

    /* renamed from: onFileWriteResult-miZAcA0 */
    void mo1050onFileWriteResultmiZAcA0(FileResult fileResult, int r2, Integer num, UInt uInt);

    void onHeartrateLiveData(HeartrateValue heartrateValue);

    void onNewFitnessData();

    void onSessionData(Map<FitnessMetric, Integer> map);

    void onSpeedCalibrationFailed();
}
