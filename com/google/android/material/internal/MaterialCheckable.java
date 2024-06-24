package com.google.android.material.internal;

import android.widget.Checkable;
import com.google.android.material.internal.MaterialCheckable;

/* loaded from: classes3.dex */
public interface MaterialCheckable<T extends MaterialCheckable<T>> extends Checkable {

    /* loaded from: classes3.dex */
    public interface OnCheckedChangeListener<C> {
    }

    int getId();

    void setInternalOnCheckedChangeListener(OnCheckedChangeListener<T> onCheckedChangeListener);
}
