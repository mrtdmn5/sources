package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* compiled from: Tagged.kt */
/* loaded from: classes4.dex */
public abstract class NamedValueDecoder extends TaggedDecoder<String> {
    public abstract String elementName(SerialDescriptor serialDescriptor, int r2);

    @Override // kotlinx.serialization.internal.TaggedDecoder
    public final String getTag$1(SerialDescriptor serialDescriptor, int r3) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        String nestedName = elementName(serialDescriptor, r3);
        Intrinsics.checkNotNullParameter(nestedName, "nestedName");
        return nestedName;
    }
}
