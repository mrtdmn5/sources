package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Add missing generic type declarations: [E] */
/* compiled from: AbstractPersistentList.kt */
/* loaded from: classes.dex */
public final class AbstractPersistentList$removeAll$1<E> extends Lambda implements Function1<E, Boolean> {
    public final /* synthetic */ Collection<E> $elements;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AbstractPersistentList$removeAll$1(Collection<? extends E> collection) {
        super(1);
        this.$elements = collection;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(Object obj) {
        return Boolean.valueOf(this.$elements.contains(obj));
    }
}
