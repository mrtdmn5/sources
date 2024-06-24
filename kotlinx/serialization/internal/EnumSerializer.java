package kotlinx.serialization.internal;

import java.lang.Enum;
import java.util.Arrays;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.SynchronizedLazyImpl;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* compiled from: Enums.kt */
/* loaded from: classes4.dex */
public final class EnumSerializer<T extends Enum<T>> implements KSerializer<T> {
    public final SynchronizedLazyImpl descriptor$delegate;
    public final T[] values;

    public EnumSerializer(final String str, T[] values) {
        Intrinsics.checkNotNullParameter(values, "values");
        this.values = values;
        this.descriptor$delegate = LazyKt__LazyJVMKt.lazy(new Function0<SerialDescriptor>(this) { // from class: kotlinx.serialization.internal.EnumSerializer$descriptor$2
            public final /* synthetic */ EnumSerializer<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final SerialDescriptor invoke() {
                EnumSerializer<T> enumSerializer = this.this$0;
                enumSerializer.getClass();
                Enum[] enumArr = enumSerializer.values;
                EnumDescriptor enumDescriptor = new EnumDescriptor(str, enumArr.length);
                for (Enum r0 : enumArr) {
                    enumDescriptor.addElement(r0.name(), false);
                }
                return enumDescriptor;
            }
        });
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        boolean z;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        int decodeEnum = decoder.decodeEnum(getDescriptor());
        T[] tArr = this.values;
        if (decodeEnum >= 0 && decodeEnum < tArr.length) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return tArr[decodeEnum];
        }
        throw new SerializationException(decodeEnum + " is not among valid " + getDescriptor().getSerialName() + " enum values, values size is " + tArr.length);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return (SerialDescriptor) this.descriptor$delegate.getValue();
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, Object obj) {
        Enum value = (Enum) obj;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        T[] tArr = this.values;
        int indexOf = ArraysKt___ArraysKt.indexOf(tArr, value);
        if (indexOf != -1) {
            encoder.encodeEnum(getDescriptor(), indexOf);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(value);
        sb.append(" is not a valid enum ");
        sb.append(getDescriptor().getSerialName());
        sb.append(", must be one of ");
        String arrays = Arrays.toString(tArr);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
        sb.append(arrays);
        throw new SerializationException(sb.toString());
    }

    public final String toString() {
        return "kotlinx.serialization.internal.EnumSerializer<" + getDescriptor().getSerialName() + '>';
    }
}
