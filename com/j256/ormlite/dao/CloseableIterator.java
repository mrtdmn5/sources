package com.j256.ormlite.dao;

import java.io.Closeable;
import java.util.Iterator;

/* loaded from: classes3.dex */
public interface CloseableIterator<T> extends Iterator<T>, Closeable {
    void moveToNext();
}
