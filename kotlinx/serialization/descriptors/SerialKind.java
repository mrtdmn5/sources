package kotlinx.serialization.descriptors;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: SerialKinds.kt */
/* loaded from: classes4.dex */
public abstract class SerialKind {

    /* compiled from: SerialKinds.kt */
    /* loaded from: classes4.dex */
    public static final class CONTEXTUAL extends SerialKind {
        public static final CONTEXTUAL INSTANCE = new CONTEXTUAL();
    }

    /* compiled from: SerialKinds.kt */
    /* loaded from: classes4.dex */
    public static final class ENUM extends SerialKind {
        public static final ENUM INSTANCE = new ENUM();
    }

    public final int hashCode() {
        return toString().hashCode();
    }

    public final String toString() {
        String simpleName = Reflection.getOrCreateKotlinClass(getClass()).getSimpleName();
        Intrinsics.checkNotNull(simpleName);
        return simpleName;
    }
}
