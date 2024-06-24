package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.Internal;
import com.google.crypto.tink.shaded.protobuf.Utf8;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
public final class LazyStringArrayList extends AbstractProtobufList<String> implements LazyStringList, RandomAccess {
    public final ArrayList list;

    static {
        new LazyStringArrayList(10).isMutable = false;
    }

    public LazyStringArrayList(int r2) {
        this((ArrayList<Object>) new ArrayList(r2));
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int r2, Object obj) {
        ensureIsMutable();
        this.list.add(r2, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        ensureIsMutable();
        this.list.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int r7) {
        String str;
        ArrayList arrayList = this.list;
        Object obj = arrayList.get(r7);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            byteString.getClass();
            Charset charset = Internal.UTF_8;
            if (byteString.size() == 0) {
                str = "";
            } else {
                str = byteString.toStringInternal(charset);
            }
            if (byteString.isValidUtf8()) {
                arrayList.set(r7, str);
            }
        } else {
            byte[] bArr = (byte[]) obj;
            str = new String(bArr, Internal.UTF_8);
            Utf8.Processor processor = Utf8.processor;
            boolean z = false;
            if (Utf8.processor.partialIsValidUtf8(0, bArr.length, bArr) == 0) {
                z = true;
            }
            if (z) {
                arrayList.set(r7, str);
            }
        }
        return str;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.LazyStringList
    public final Object getRaw(int r2) {
        return this.list.get(r2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.LazyStringList
    public final List<?> getUnderlyingElements() {
        return Collections.unmodifiableList(this.list);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.LazyStringList
    public final LazyStringList getUnmodifiableView() {
        if (this.isMutable) {
            return new UnmodifiableLazyStringList(this);
        }
        return this;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.ProtobufList
    public final Internal.ProtobufList mutableCopyWithCapacity(int r2) {
        if (r2 >= size()) {
            ArrayList arrayList = new ArrayList(r2);
            arrayList.addAll(this.list);
            return new LazyStringArrayList((ArrayList<Object>) arrayList);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object remove(int r3) {
        ensureIsMutable();
        Object remove = this.list.remove(r3);
        ((AbstractList) this).modCount++;
        if (remove instanceof String) {
            return (String) remove;
        }
        if (remove instanceof ByteString) {
            ByteString byteString = (ByteString) remove;
            byteString.getClass();
            Charset charset = Internal.UTF_8;
            if (byteString.size() == 0) {
                return "";
            }
            return byteString.toStringInternal(charset);
        }
        return new String((byte[]) remove, Internal.UTF_8);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int r2, Object obj) {
        ensureIsMutable();
        Object obj2 = this.list.set(r2, (String) obj);
        if (obj2 instanceof String) {
            return (String) obj2;
        }
        if (obj2 instanceof ByteString) {
            ByteString byteString = (ByteString) obj2;
            byteString.getClass();
            Charset charset = Internal.UTF_8;
            if (byteString.size() == 0) {
                return "";
            }
            return byteString.toStringInternal(charset);
        }
        return new String((byte[]) obj2, Internal.UTF_8);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.list.size();
    }

    public LazyStringArrayList(ArrayList<Object> arrayList) {
        this.list = arrayList;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public final boolean addAll(int r2, Collection<? extends String> collection) {
        ensureIsMutable();
        if (collection instanceof LazyStringList) {
            collection = ((LazyStringList) collection).getUnderlyingElements();
        }
        boolean addAll = this.list.addAll(r2, collection);
        ((AbstractList) this).modCount++;
        return addAll;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.LazyStringList
    public final void add(ByteString byteString) {
        ensureIsMutable();
        this.list.add(byteString);
        ((AbstractList) this).modCount++;
    }
}
