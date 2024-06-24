package com.jakewharton.rxrelay2;

/* loaded from: classes3.dex */
public final class AppendOnlyLinkedArrayList<T> {
    public final Object[] head;
    public int offset;
    public Object[] tail;

    public AppendOnlyLinkedArrayList() {
        Object[] objArr = new Object[5];
        this.head = objArr;
        this.tail = objArr;
    }
}
