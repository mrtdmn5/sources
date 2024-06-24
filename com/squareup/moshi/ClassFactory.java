package com.squareup.moshi;

import java.lang.reflect.InvocationTargetException;

/* loaded from: classes3.dex */
public abstract class ClassFactory<T> {
    public abstract T newInstance() throws InvocationTargetException, IllegalAccessException, InstantiationException;
}
