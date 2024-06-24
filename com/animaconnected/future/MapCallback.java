package com.animaconnected.future;

import java.io.IOException;

/* loaded from: classes.dex */
public interface MapCallback<T, D> {
    D onResult(T t) throws IOException;
}
