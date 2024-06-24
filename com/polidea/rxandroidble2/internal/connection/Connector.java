package com.polidea.rxandroidble2.internal.connection;

import com.polidea.rxandroidble2.ConnectionSetup;
import io.reactivex.internal.operators.observable.ObservableDefer;

/* loaded from: classes3.dex */
public interface Connector {
    ObservableDefer prepareConnection(ConnectionSetup connectionSetup);
}
