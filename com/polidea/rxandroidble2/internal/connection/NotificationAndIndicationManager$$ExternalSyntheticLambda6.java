package com.polidea.rxandroidble2.internal.connection;

import com.polidea.rxandroidble2.internal.util.CharacteristicChangedEvent;
import io.reactivex.functions.Function;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes3.dex */
public final /* synthetic */ class NotificationAndIndicationManager$$ExternalSyntheticLambda6 implements Function {
    @Override // io.reactivex.functions.Function
    public final Object apply(Object obj) {
        return ((CharacteristicChangedEvent) obj).data;
    }
}
