package aws.smithy.kotlin.runtime.serde;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SdkSerializable.kt */
/* loaded from: classes.dex */
public final class SdkSerializableLambda<T> {
    public final T input;
    public final Function2<Serializer, T, Unit> serializeFn;

    /* JADX WARN: Multi-variable type inference failed */
    public SdkSerializableLambda(T t, Function2<? super Serializer, ? super T, Unit> serializeFn) {
        Intrinsics.checkNotNullParameter(serializeFn, "serializeFn");
        this.input = t;
        this.serializeFn = serializeFn;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SdkSerializableLambda)) {
            return false;
        }
        SdkSerializableLambda sdkSerializableLambda = (SdkSerializableLambda) obj;
        if (Intrinsics.areEqual(this.input, sdkSerializableLambda.input) && Intrinsics.areEqual(this.serializeFn, sdkSerializableLambda.serializeFn)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        T t = this.input;
        if (t == null) {
            hashCode = 0;
        } else {
            hashCode = t.hashCode();
        }
        return this.serializeFn.hashCode() + (hashCode * 31);
    }

    public final void serialize(Serializer serializer) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        this.serializeFn.invoke(serializer, this.input);
    }

    public final String toString() {
        return "SdkSerializableLambda(input=" + this.input + ", serializeFn=" + this.serializeFn + ')';
    }
}
