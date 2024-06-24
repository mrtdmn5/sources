package com.animaconnected.watch;

import com.animaconnected.future.FlatMapCallback;
import com.animaconnected.future.Future;
import com.animaconnected.watch.DeviceInformation;
import java.util.Map;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes3.dex */
public final /* synthetic */ class DeviceInformation$Companion$$ExternalSyntheticLambda0 implements FlatMapCallback {
    @Override // com.animaconnected.future.FlatMapCallback
    public final Future onResult(Object obj) {
        Future readFromService$lambda$0;
        readFromService$lambda$0 = DeviceInformation.Companion.readFromService$lambda$0((Map) obj);
        return readFromService$lambda$0;
    }
}
