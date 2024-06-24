package androidx.compose.animation.core;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.IntOffset;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsKt;

/* compiled from: VisibilityThresholds.kt */
/* loaded from: classes.dex */
public final class VisibilityThresholdsKt {
    public static final Map<TwoWayConverter<?, ?>, Float> visibilityThresholdMap;

    static {
        Float valueOf = Float.valueOf(0.5f);
        TwoWayConverterImpl twoWayConverterImpl = VectorConvertersKt.IntToVector;
        Float valueOf2 = Float.valueOf(1.0f);
        Pair pair = new Pair(twoWayConverterImpl, valueOf2);
        Pair pair2 = new Pair(VectorConvertersKt.IntSizeToVector, valueOf2);
        int r1 = IntOffset.$r8$clinit;
        Pair pair3 = new Pair(VectorConvertersKt.IntOffsetToVector, valueOf2);
        Pair pair4 = new Pair(VectorConvertersKt.FloatToVector, Float.valueOf(0.01f));
        Pair pair5 = new Pair(VectorConvertersKt.RectToVector, valueOf);
        int r12 = Size.$r8$clinit;
        Pair pair6 = new Pair(VectorConvertersKt.SizeToVector, valueOf);
        int r13 = Offset.$r8$clinit;
        Pair pair7 = new Pair(VectorConvertersKt.OffsetToVector, valueOf);
        TwoWayConverterImpl twoWayConverterImpl2 = VectorConvertersKt.DpToVector;
        Float valueOf3 = Float.valueOf(0.1f);
        Pair pair8 = new Pair(twoWayConverterImpl2, valueOf3);
        int r0 = DpOffset.$r8$clinit;
        visibilityThresholdMap = MapsKt__MapsKt.mapOf(pair, pair2, pair3, pair4, pair5, pair6, pair7, pair8, new Pair(VectorConvertersKt.DpOffsetToVector, valueOf3));
    }
}
