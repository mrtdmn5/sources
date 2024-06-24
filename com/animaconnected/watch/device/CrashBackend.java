package com.animaconnected.watch.device;

import com.animaconnected.watch.device.diagnostics.DiagnosticsBinaryData;
import com.animaconnected.watch.utils.WatchLibException;
import com.animaconnected.watch.utils.WatchLibResult;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: CrashBackend.kt */
/* loaded from: classes3.dex */
public interface CrashBackend {
    String calculateSha1(String str);

    Object storeCrashFiles(List<DiagnosticsBinaryData> list, CrashFile crashFile, Continuation<? super WatchLibResult<Unit, WatchLibException>> continuation);

    Object uploadStoredCrashes(Continuation<? super WatchLibResult<Unit, WatchLibException>> continuation);
}
