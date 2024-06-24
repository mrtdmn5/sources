package kotlinx.serialization.modules;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;

/* compiled from: SerializersModule.kt */
/* loaded from: classes4.dex */
public abstract class ContextualProvider {

    /* compiled from: SerializersModule.kt */
    /* loaded from: classes4.dex */
    public static final class Argless extends ContextualProvider {
        public final boolean equals(Object obj) {
            if (obj instanceof Argless) {
                ((Argless) obj).getClass();
                if (Intrinsics.areEqual((Object) null, (Object) null)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            throw null;
        }

        @Override // kotlinx.serialization.modules.ContextualProvider
        public final KSerializer<?> invoke(List<? extends KSerializer<?>> typeArgumentsSerializers) {
            Intrinsics.checkNotNullParameter(typeArgumentsSerializers, "typeArgumentsSerializers");
            return null;
        }
    }

    /* compiled from: SerializersModule.kt */
    /* loaded from: classes4.dex */
    public static final class WithTypeArguments extends ContextualProvider {
        @Override // kotlinx.serialization.modules.ContextualProvider
        public final KSerializer<?> invoke(List<? extends KSerializer<?>> typeArgumentsSerializers) {
            Intrinsics.checkNotNullParameter(typeArgumentsSerializers, "typeArgumentsSerializers");
            throw null;
        }
    }

    public abstract KSerializer<?> invoke(List<? extends KSerializer<?>> list);
}
