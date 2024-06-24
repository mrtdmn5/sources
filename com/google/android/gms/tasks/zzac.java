package com.google.android.gms.tasks;

import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.VectorConvertersKt;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.MissingFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* compiled from: com.google.android.gms:play-services-tasks@@18.0.2 */
/* loaded from: classes3.dex */
public final /* synthetic */ class zzac {
    public static final float calculateTargetValue(DecayAnimationSpec decayAnimationSpec, float f) {
        Intrinsics.checkNotNullParameter(decayAnimationSpec, "<this>");
        return ((AnimationVector1D) decayAnimationSpec.vectorize(VectorConvertersKt.FloatToVector).getTargetValue(new AnimationVector1D(0.0f), new AnimationVector1D(f))).value;
    }

    public static final void throwMissingFieldException(int r3, int r4, SerialDescriptor descriptor) {
        String str;
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        ArrayList arrayList = new ArrayList();
        int r32 = (~r3) & r4;
        for (int r1 = 0; r1 < 32; r1++) {
            if ((r32 & 1) != 0) {
                arrayList.add(descriptor.getElementName(r1));
            }
            r32 >>>= 1;
        }
        String serialName = descriptor.getSerialName();
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        if (arrayList.size() == 1) {
            str = "Field '" + ((String) arrayList.get(0)) + "' is required for type with serial name '" + serialName + "', but it was missing";
        } else {
            str = "Fields " + arrayList + " are required for type with serial name '" + serialName + "', but they were missing";
        }
        throw new MissingFieldException(arrayList, str, null);
    }
}
