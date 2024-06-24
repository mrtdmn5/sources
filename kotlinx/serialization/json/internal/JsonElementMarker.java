package kotlinx.serialization.json.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.internal.ElementMarker;

/* compiled from: JsonElementMarker.kt */
/* loaded from: classes4.dex */
public final class JsonElementMarker {
    public boolean isUnmarkedNull;
    public final ElementMarker origin;

    public JsonElementMarker(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        this.origin = new ElementMarker(descriptor, new JsonElementMarker$origin$1(this));
    }
}
