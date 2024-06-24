package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.Internal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class ListFieldSchema {
    public static final ListFieldSchemaFull FULL_INSTANCE = new ListFieldSchemaFull();
    public static final ListFieldSchemaLite LITE_INSTANCE = new ListFieldSchemaLite();

    /* loaded from: classes3.dex */
    public static final class ListFieldSchemaFull extends ListFieldSchema {
        public static final Class<?> UNMODIFIABLE_LIST_CLASS = Collections.unmodifiableList(Collections.emptyList()).getClass();

        @Override // com.google.crypto.tink.shaded.protobuf.ListFieldSchema
        public final void makeImmutableListAt(long j, Object obj) {
            Object unmodifiableList;
            List list = (List) UnsafeUtil.getObject(j, obj);
            if (list instanceof LazyStringList) {
                unmodifiableList = ((LazyStringList) list).getUnmodifiableView();
            } else {
                if (UNMODIFIABLE_LIST_CLASS.isAssignableFrom(list.getClass())) {
                    return;
                }
                if ((list instanceof PrimitiveNonBoxingCollection) && (list instanceof Internal.ProtobufList)) {
                    Internal.ProtobufList protobufList = (Internal.ProtobufList) list;
                    if (protobufList.isModifiable()) {
                        protobufList.makeImmutable();
                        return;
                    }
                    return;
                }
                unmodifiableList = Collections.unmodifiableList(list);
            }
            UnsafeUtil.putObject(j, obj, unmodifiableList);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ListFieldSchema
        public final void mergeListsAt(long j, Object obj, Object obj2) {
            List list = (List) UnsafeUtil.getObject(j, obj2);
            List mutableListAt = mutableListAt(j, list.size(), obj);
            int size = mutableListAt.size();
            int size2 = list.size();
            if (size > 0 && size2 > 0) {
                mutableListAt.addAll(list);
            }
            if (size > 0) {
                list = mutableListAt;
            }
            UnsafeUtil.putObject(j, obj, list);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ListFieldSchema
        public final List mutableListAt(long j, Object obj) {
            return mutableListAt(j, 10, obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static List mutableListAt(long j, int r5, Object obj) {
            LazyStringArrayList lazyStringArrayList;
            List arrayList;
            List list = (List) UnsafeUtil.getObject(j, obj);
            if (list.isEmpty()) {
                if (list instanceof LazyStringList) {
                    arrayList = new LazyStringArrayList(r5);
                } else if ((list instanceof PrimitiveNonBoxingCollection) && (list instanceof Internal.ProtobufList)) {
                    arrayList = ((Internal.ProtobufList) list).mutableCopyWithCapacity(r5);
                } else {
                    arrayList = new ArrayList(r5);
                }
                UnsafeUtil.putObject(j, obj, arrayList);
                return arrayList;
            }
            if (UNMODIFIABLE_LIST_CLASS.isAssignableFrom(list.getClass())) {
                ArrayList arrayList2 = new ArrayList(list.size() + r5);
                arrayList2.addAll(list);
                UnsafeUtil.putObject(j, obj, arrayList2);
                lazyStringArrayList = arrayList2;
            } else if (list instanceof UnmodifiableLazyStringList) {
                LazyStringArrayList lazyStringArrayList2 = new LazyStringArrayList(list.size() + r5);
                lazyStringArrayList2.addAll((UnmodifiableLazyStringList) list);
                UnsafeUtil.putObject(j, obj, lazyStringArrayList2);
                lazyStringArrayList = lazyStringArrayList2;
            } else {
                if (!(list instanceof PrimitiveNonBoxingCollection) || !(list instanceof Internal.ProtobufList)) {
                    return list;
                }
                Internal.ProtobufList protobufList = (Internal.ProtobufList) list;
                if (protobufList.isModifiable()) {
                    return list;
                }
                Internal.ProtobufList mutableCopyWithCapacity = protobufList.mutableCopyWithCapacity(list.size() + r5);
                UnsafeUtil.putObject(j, obj, mutableCopyWithCapacity);
                return mutableCopyWithCapacity;
            }
            return lazyStringArrayList;
        }
    }

    /* loaded from: classes3.dex */
    public static final class ListFieldSchemaLite extends ListFieldSchema {
        @Override // com.google.crypto.tink.shaded.protobuf.ListFieldSchema
        public final void makeImmutableListAt(long j, Object obj) {
            ((Internal.ProtobufList) UnsafeUtil.getObject(j, obj)).makeImmutable();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ListFieldSchema
        public final void mergeListsAt(long j, Object obj, Object obj2) {
            Internal.ProtobufList protobufList = (Internal.ProtobufList) UnsafeUtil.getObject(j, obj);
            Internal.ProtobufList protobufList2 = (Internal.ProtobufList) UnsafeUtil.getObject(j, obj2);
            int size = protobufList.size();
            int size2 = protobufList2.size();
            if (size > 0 && size2 > 0) {
                if (!protobufList.isModifiable()) {
                    protobufList = protobufList.mutableCopyWithCapacity(size2 + size);
                }
                protobufList.addAll(protobufList2);
            }
            if (size > 0) {
                protobufList2 = protobufList;
            }
            UnsafeUtil.putObject(j, obj, protobufList2);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ListFieldSchema
        public final List mutableListAt(long j, Object obj) {
            int r1;
            Internal.ProtobufList protobufList = (Internal.ProtobufList) UnsafeUtil.getObject(j, obj);
            if (!protobufList.isModifiable()) {
                int size = protobufList.size();
                if (size == 0) {
                    r1 = 10;
                } else {
                    r1 = size * 2;
                }
                Internal.ProtobufList mutableCopyWithCapacity = protobufList.mutableCopyWithCapacity(r1);
                UnsafeUtil.putObject(j, obj, mutableCopyWithCapacity);
                return mutableCopyWithCapacity;
            }
            return protobufList;
        }
    }

    public abstract void makeImmutableListAt(long j, Object obj);

    public abstract void mergeListsAt(long j, Object obj, Object obj2);

    public abstract List mutableListAt(long j, Object obj);
}
