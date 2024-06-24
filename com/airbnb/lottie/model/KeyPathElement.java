package com.airbnb.lottie.model;

import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;

/* loaded from: classes.dex */
public interface KeyPathElement {
    void addValueCallback(LottieValueCallback lottieValueCallback, Object obj);

    void resolveKeyPath(KeyPath keyPath, int r2, ArrayList arrayList, KeyPath keyPath2);
}
