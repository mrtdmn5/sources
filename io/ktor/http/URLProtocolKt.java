package io.ktor.http;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.pager.PagerLayoutInfo;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.ui.res.Resources_androidKt;
import androidx.compose.ui.unit.IntSize;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: URLProtocol.kt */
/* loaded from: classes3.dex */
public final class URLProtocolKt {
    public static final int getMainAxisViewportSize(PagerLayoutInfo pagerLayoutInfo) {
        Intrinsics.checkNotNullParameter(pagerLayoutInfo, "<this>");
        if (pagerLayoutInfo.getOrientation() == Orientation.Vertical) {
            return IntSize.m593getHeightimpl(pagerLayoutInfo.mo106getViewportSizeYbymL2g());
        }
        return (int) (pagerLayoutInfo.mo106getViewportSizeYbymL2g() >> 32);
    }

    public static final String stringResource(int r1, Composer composer) {
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        String string = Resources_androidKt.resources(composer).getString(r1);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(id)");
        return string;
    }
}
