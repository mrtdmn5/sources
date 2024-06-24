package com.animaconnected.watch.device;

import com.animaconnected.watch.utils.WatchLibException;
import com.animaconnected.watch.utils.WatchLibResult;
import kotlin.coroutines.Continuation;

/* compiled from: AccountBackend.kt */
/* loaded from: classes3.dex */
public interface AccountBackend {
    boolean isSandbox();

    Object token(Continuation<? super WatchLibResult<String, WatchLibException>> continuation);
}
