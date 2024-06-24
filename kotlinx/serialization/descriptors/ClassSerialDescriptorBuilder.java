package kotlinx.serialization.descriptors;

import androidx.activity.result.ActivityResultRegistry$$ExternalSyntheticOutline0;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SerialDescriptors.kt */
/* loaded from: classes4.dex */
public final class ClassSerialDescriptorBuilder {
    public List<? extends Annotation> annotations;
    public final ArrayList elementAnnotations;
    public final ArrayList elementDescriptors;
    public final ArrayList elementNames;
    public final ArrayList elementOptionality;
    public final String serialName;
    public final HashSet uniqueNames;

    public ClassSerialDescriptorBuilder(String serialName) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        this.serialName = serialName;
        this.annotations = EmptyList.INSTANCE;
        this.elementNames = new ArrayList();
        this.uniqueNames = new HashSet();
        this.elementDescriptors = new ArrayList();
        this.elementAnnotations = new ArrayList();
        this.elementOptionality = new ArrayList();
    }

    public final void element(String elementName, SerialDescriptor descriptor, List<? extends Annotation> annotations, boolean z) {
        Intrinsics.checkNotNullParameter(elementName, "elementName");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        if (this.uniqueNames.add(elementName)) {
            this.elementNames.add(elementName);
            this.elementDescriptors.add(descriptor);
            this.elementAnnotations.add(annotations);
            this.elementOptionality.add(Boolean.valueOf(z));
            return;
        }
        StringBuilder m = ActivityResultRegistry$$ExternalSyntheticOutline0.m("Element with name '", elementName, "' is already registered in ");
        m.append(this.serialName);
        throw new IllegalArgumentException(m.toString().toString());
    }
}
