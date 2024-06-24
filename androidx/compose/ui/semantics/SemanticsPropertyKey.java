package androidx.compose.ui.semantics;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty;

/* compiled from: SemanticsProperties.kt */
/* loaded from: classes.dex */
public final class SemanticsPropertyKey<T> {
    public final Function2<T, T, T> mergePolicy;
    public final String name;

    /* compiled from: SemanticsProperties.kt */
    /* renamed from: androidx.compose.ui.semantics.SemanticsPropertyKey$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public final class AnonymousClass1 extends Lambda implements Function2<Object, Object, Object> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            if (obj == null) {
                return obj2;
            }
            return obj;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SemanticsPropertyKey(String str, Function2<? super T, ? super T, ? extends T> mergePolicy) {
        Intrinsics.checkNotNullParameter(mergePolicy, "mergePolicy");
        this.name = str;
        this.mergePolicy = mergePolicy;
    }

    public final void setValue(SemanticsPropertyReceiver thisRef, KProperty<?> property, T t) {
        Intrinsics.checkNotNullParameter(thisRef, "thisRef");
        Intrinsics.checkNotNullParameter(property, "property");
        thisRef.set(this, t);
    }

    public final String toString() {
        return "SemanticsPropertyKey: " + this.name;
    }
}
