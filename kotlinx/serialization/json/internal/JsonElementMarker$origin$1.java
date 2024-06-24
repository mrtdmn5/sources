package kotlinx.serialization.json.internal;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* compiled from: JsonElementMarker.kt */
/* loaded from: classes4.dex */
public /* synthetic */ class JsonElementMarker$origin$1 extends FunctionReferenceImpl implements Function2<SerialDescriptor, Integer, Boolean> {
    public JsonElementMarker$origin$1(Object obj) {
        super(2, obj, JsonElementMarker.class, "readIfAbsent", "readIfAbsent(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Z", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Boolean invoke(SerialDescriptor serialDescriptor, Integer num) {
        boolean z;
        SerialDescriptor p0 = serialDescriptor;
        int intValue = num.intValue();
        Intrinsics.checkNotNullParameter(p0, "p0");
        JsonElementMarker jsonElementMarker = (JsonElementMarker) this.receiver;
        jsonElementMarker.getClass();
        if (!p0.isElementOptional(intValue) && p0.getElementDescriptor(intValue).isNullable()) {
            z = true;
        } else {
            z = false;
        }
        jsonElementMarker.isUnmarkedNull = z;
        return Boolean.valueOf(z);
    }
}
