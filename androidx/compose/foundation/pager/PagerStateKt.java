package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.SaverKt$Saver$1;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;

/* compiled from: PagerState.kt */
/* loaded from: classes.dex */
public final class PagerStateKt {
    public static final float DefaultPositionThreshold = 56;
    public static final PagerStateKt$EmptyLayoutInfo$1 EmptyLayoutInfo = new PagerLayoutInfo() { // from class: androidx.compose.foundation.pager.PagerStateKt$EmptyLayoutInfo$1
        public final Orientation orientation = Orientation.Horizontal;

        @Override // androidx.compose.foundation.pager.PagerLayoutInfo
        public final int getAfterContentPadding() {
            return 0;
        }

        @Override // androidx.compose.foundation.pager.PagerLayoutInfo
        public final int getBeforeContentPadding() {
            return 0;
        }

        @Override // androidx.compose.foundation.pager.PagerLayoutInfo
        public final PageInfo getClosestPageToSnapPosition() {
            return null;
        }

        @Override // androidx.compose.foundation.pager.PagerLayoutInfo
        public final Orientation getOrientation() {
            return this.orientation;
        }

        @Override // androidx.compose.foundation.pager.PagerLayoutInfo
        public final int getPageSize() {
            return 0;
        }

        @Override // androidx.compose.foundation.pager.PagerLayoutInfo
        public final int getPageSpacing() {
            return 0;
        }

        @Override // androidx.compose.foundation.pager.PagerLayoutInfo
        public final int getPagesCount() {
            return 0;
        }

        @Override // androidx.compose.foundation.pager.PagerLayoutInfo
        /* renamed from: getViewportSize-YbymL2g */
        public final long mo106getViewportSizeYbymL2g() {
            return 0L;
        }

        @Override // androidx.compose.foundation.pager.PagerLayoutInfo
        public final List<PageInfo> getVisiblePagesInfo() {
            return EmptyList.INSTANCE;
        }
    };
    public static final PagerStateKt$UnitDensity$1 UnitDensity = new PagerStateKt$UnitDensity$1();
    public static final PagerStateKt$SnapAlignmentStartToStart$1 SnapAlignmentStartToStart = PagerStateKt$SnapAlignmentStartToStart$1.INSTANCE;

    public static final PagerStateImpl rememberPagerState(final Function0 function0, Composer composer) {
        composer.startReplaceableGroup(-1210768637);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        final int r0 = 0;
        Object[] objArr = new Object[0];
        SaverKt$Saver$1 saverKt$Saver$1 = PagerStateImpl.Saver;
        final float f = 0.0f;
        Float valueOf = Float.valueOf(0.0f);
        composer.startReplaceableGroup(1618982084);
        boolean changed = composer.changed((Object) 0) | composer.changed(valueOf) | composer.changed(function0);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.Empty) {
            rememberedValue = new Function0<PagerStateImpl>() { // from class: androidx.compose.foundation.pager.PagerStateKt$rememberPagerState$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final PagerStateImpl invoke() {
                    return new PagerStateImpl(r0, f, function0);
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        PagerStateImpl pagerStateImpl = (PagerStateImpl) RememberSaveableKt.rememberSaveable(objArr, saverKt$Saver$1, (Function0) rememberedValue, composer, 4);
        pagerStateImpl.pageCountState.setValue(function0);
        composer.endReplaceableGroup();
        return pagerStateImpl;
    }
}
