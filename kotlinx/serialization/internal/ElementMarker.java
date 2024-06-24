package kotlinx.serialization.internal;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.internal.JsonElementMarker$origin$1;

/* compiled from: ElementMarker.kt */
/* loaded from: classes4.dex */
public final class ElementMarker {

    @Deprecated
    public static final long[] EMPTY_HIGH_MARKS = new long[0];
    public final SerialDescriptor descriptor;
    public final long[] highMarksArray;
    public long lowerMarks;
    public final Function2<SerialDescriptor, Integer, Boolean> readIfAbsent;

    public ElementMarker(SerialDescriptor descriptor, JsonElementMarker$origin$1 jsonElementMarker$origin$1) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        this.descriptor = descriptor;
        this.readIfAbsent = jsonElementMarker$origin$1;
        int elementsCount = descriptor.getElementsCount();
        if (elementsCount <= 64) {
            this.lowerMarks = elementsCount != 64 ? (-1) << elementsCount : 0L;
            this.highMarksArray = EMPTY_HIGH_MARKS;
            return;
        }
        this.lowerMarks = 0L;
        int r6 = (elementsCount - 1) >>> 6;
        long[] jArr = new long[r6];
        if ((elementsCount & 63) != 0) {
            jArr[r6 - 1] = (-1) << elementsCount;
        }
        this.highMarksArray = jArr;
    }
}
