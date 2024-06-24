package androidx.compose.material;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;

/* compiled from: Menu.kt */
/* loaded from: classes.dex */
public final class DropdownMenuPositionProvider implements PopupPositionProvider {
    public final long contentOffset;
    public final Density density;
    public final Function2<IntRect, IntRect, Unit> onPositionCalculated;

    public DropdownMenuPositionProvider() {
        throw null;
    }

    public DropdownMenuPositionProvider(long j, Density density, Function2 onPositionCalculated) {
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(onPositionCalculated, "onPositionCalculated");
        this.contentOffset = j;
        this.density = density;
        this.onPositionCalculated = onPositionCalculated;
    }

    @Override // androidx.compose.ui.window.PopupPositionProvider
    /* renamed from: calculatePosition-llwVHH4 */
    public final long mo133calculatePositionllwVHH4(IntRect intRect, long j, LayoutDirection layoutDirection, long j2) {
        Sequence sequenceOf;
        Object obj;
        Object obj2;
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        float f = MenuKt.MenuVerticalMargin;
        Density density = this.density;
        int mo44roundToPx0680j_4 = density.mo44roundToPx0680j_4(f);
        long j3 = this.contentOffset;
        int mo44roundToPx0680j_42 = density.mo44roundToPx0680j_4(DpOffset.m583getXD9Ej5fM(j3));
        int mo44roundToPx0680j_43 = density.mo44roundToPx0680j_4(DpOffset.m584getYD9Ej5fM(j3));
        int r5 = intRect.left;
        int r6 = r5 + mo44roundToPx0680j_42;
        int r8 = intRect.right;
        int r10 = (int) (j2 >> 32);
        int r7 = (r8 - mo44roundToPx0680j_42) - r10;
        int r9 = (int) (j >> 32);
        int r11 = r9 - r10;
        if (layoutDirection == LayoutDirection.Ltr) {
            Integer[] numArr = new Integer[3];
            numArr[0] = Integer.valueOf(r6);
            numArr[1] = Integer.valueOf(r7);
            if (r5 < 0) {
                r11 = 0;
            }
            numArr[2] = Integer.valueOf(r11);
            sequenceOf = SequencesKt__SequencesKt.sequenceOf(numArr);
        } else {
            Integer[] numArr2 = new Integer[3];
            numArr2[0] = Integer.valueOf(r7);
            numArr2[1] = Integer.valueOf(r6);
            if (r8 <= r9) {
                r11 = 0;
            }
            numArr2[2] = Integer.valueOf(r11);
            sequenceOf = SequencesKt__SequencesKt.sequenceOf(numArr2);
        }
        Iterator it = sequenceOf.iterator();
        while (true) {
            obj = null;
            if (it.hasNext()) {
                obj2 = it.next();
                int intValue = ((Number) obj2).intValue();
                if (intValue >= 0 && intValue + r10 <= r9) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    break;
                }
            } else {
                obj2 = null;
                break;
            }
        }
        Integer num = (Integer) obj2;
        if (num != null) {
            r7 = num.intValue();
        }
        int max = Math.max(intRect.bottom + mo44roundToPx0680j_43, mo44roundToPx0680j_4);
        int r52 = intRect.top;
        int m593getHeightimpl = (r52 - mo44roundToPx0680j_43) - IntSize.m593getHeightimpl(j2);
        Iterator it2 = SequencesKt__SequencesKt.sequenceOf(Integer.valueOf(max), Integer.valueOf(m593getHeightimpl), Integer.valueOf(r52 - (IntSize.m593getHeightimpl(j2) / 2)), Integer.valueOf((IntSize.m593getHeightimpl(j) - IntSize.m593getHeightimpl(j2)) - mo44roundToPx0680j_4)).iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            int intValue2 = ((Number) next).intValue();
            if (intValue2 >= mo44roundToPx0680j_4 && IntSize.m593getHeightimpl(j2) + intValue2 <= IntSize.m593getHeightimpl(j) - mo44roundToPx0680j_4) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                obj = next;
                break;
            }
        }
        Integer num2 = (Integer) obj;
        if (num2 != null) {
            m593getHeightimpl = num2.intValue();
        }
        this.onPositionCalculated.invoke(intRect, new IntRect(r7, m593getHeightimpl, r10 + r7, IntSize.m593getHeightimpl(j2) + m593getHeightimpl));
        return IntOffsetKt.IntOffset(r7, m593getHeightimpl);
    }

    public final boolean equals(Object obj) {
        boolean z;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DropdownMenuPositionProvider)) {
            return false;
        }
        DropdownMenuPositionProvider dropdownMenuPositionProvider = (DropdownMenuPositionProvider) obj;
        long j = dropdownMenuPositionProvider.contentOffset;
        int r1 = DpOffset.$r8$clinit;
        if (this.contentOffset == j) {
            z = true;
        } else {
            z = false;
        }
        if (z && Intrinsics.areEqual(this.density, dropdownMenuPositionProvider.density) && Intrinsics.areEqual(this.onPositionCalculated, dropdownMenuPositionProvider.onPositionCalculated)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int r0 = DpOffset.$r8$clinit;
        return this.onPositionCalculated.hashCode() + ((this.density.hashCode() + (Long.hashCode(this.contentOffset) * 31)) * 31);
    }

    public final String toString() {
        return "DropdownMenuPositionProvider(contentOffset=" + ((Object) DpOffset.m585toStringimpl(this.contentOffset)) + ", density=" + this.density + ", onPositionCalculated=" + this.onPositionCalculated + ')';
    }
}
