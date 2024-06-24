package kotlinx.serialization.internal;

import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;

/* compiled from: CollectionSerializers.kt */
/* loaded from: classes4.dex */
public abstract class CollectionSerializer<E, C extends Collection<? extends E>, B> extends CollectionLikeSerializer<E, C, B> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CollectionSerializer(KSerializer<E> element) {
        super(element);
        Intrinsics.checkNotNullParameter(element, "element");
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final Iterator collectionIterator(Object obj) {
        Collection collection = (Collection) obj;
        Intrinsics.checkNotNullParameter(collection, "<this>");
        return collection.iterator();
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final int collectionSize(Object obj) {
        Collection collection = (Collection) obj;
        Intrinsics.checkNotNullParameter(collection, "<this>");
        return collection.size();
    }
}
