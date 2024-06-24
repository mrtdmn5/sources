package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import java.util.List;

/* compiled from: PagerLayoutInfo.kt */
/* loaded from: classes.dex */
public interface PagerLayoutInfo {
    int getAfterContentPadding();

    int getBeforeContentPadding();

    PageInfo getClosestPageToSnapPosition();

    Orientation getOrientation();

    int getPageSize();

    int getPageSpacing();

    int getPagesCount();

    /* renamed from: getViewportSize-YbymL2g, reason: not valid java name */
    long mo106getViewportSizeYbymL2g();

    List<PageInfo> getVisiblePagesInfo();
}
