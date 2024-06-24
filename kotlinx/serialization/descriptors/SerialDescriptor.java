package kotlinx.serialization.descriptors;

import java.lang.annotation.Annotation;
import java.util.List;

/* compiled from: SerialDescriptor.kt */
/* loaded from: classes4.dex */
public interface SerialDescriptor {
    List<Annotation> getAnnotations();

    List<Annotation> getElementAnnotations(int r1);

    SerialDescriptor getElementDescriptor(int r1);

    int getElementIndex(String str);

    String getElementName(int r1);

    int getElementsCount();

    SerialKind getKind();

    String getSerialName();

    boolean isElementOptional(int r1);

    boolean isInline();

    boolean isNullable();
}
