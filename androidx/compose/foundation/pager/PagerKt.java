package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.ui.geometry.Offset;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Pager.kt */
/* loaded from: classes.dex */
public final class PagerKt {
    public static final ConsumeAllFlingOnDirection ConsumeHorizontalFlingNestedScrollConnection = new ConsumeAllFlingOnDirection(Orientation.Horizontal);

    static {
        Orientation orientation = Orientation.Vertical;
        Intrinsics.checkNotNullParameter(orientation, "orientation");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0377  */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0225  */
    /* renamed from: HorizontalPager-xYaah8o, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m105HorizontalPagerxYaah8o(final androidx.compose.foundation.pager.PagerState r38, androidx.compose.ui.Modifier r39, androidx.compose.foundation.layout.PaddingValues r40, androidx.compose.foundation.pager.PageSize r41, int r42, float r43, androidx.compose.ui.Alignment.Vertical r44, androidx.compose.foundation.gestures.snapping.SnapFlingBehavior r45, boolean r46, boolean r47, kotlin.jvm.functions.Function1<? super java.lang.Integer, ? extends java.lang.Object> r48, androidx.compose.ui.input.nestedscroll.NestedScrollConnection r49, final kotlin.jvm.functions.Function4<? super androidx.compose.foundation.pager.PagerScope, ? super java.lang.Integer, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r50, androidx.compose.runtime.Composer r51, final int r52, final int r53, final int r54) {
        /*
            Method dump skipped, instructions count: 914
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.PagerKt.m105HorizontalPagerxYaah8o(androidx.compose.foundation.pager.PagerState, androidx.compose.ui.Modifier, androidx.compose.foundation.layout.PaddingValues, androidx.compose.foundation.pager.PageSize, int, float, androidx.compose.ui.Alignment$Vertical, androidx.compose.foundation.gestures.snapping.SnapFlingBehavior, boolean, boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.input.nestedscroll.NestedScrollConnection, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final float dragGestureDelta(PagerState pagerState) {
        Orientation orientation = pagerState.getLayoutInfo$foundation_release().getOrientation();
        Orientation orientation2 = Orientation.Horizontal;
        ParcelableSnapshotMutableState parcelableSnapshotMutableState = pagerState.upDownDifference$delegate;
        if (orientation == orientation2) {
            return Offset.m259getXimpl(((Offset) parcelableSnapshotMutableState.getValue()).packedValue);
        }
        return Offset.m260getYimpl(((Offset) parcelableSnapshotMutableState.getValue()).packedValue);
    }
}
