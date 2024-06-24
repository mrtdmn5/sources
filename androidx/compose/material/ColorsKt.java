package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import no.nordicsemi.android.dfu.DfuBaseService;

/* compiled from: Colors.kt */
/* loaded from: classes.dex */
public final class ColorsKt {
    public static final StaticProvidableCompositionLocal LocalColors = CompositionLocalKt.staticCompositionLocalOf(new Function0<Colors>() { // from class: androidx.compose.material.ColorsKt$LocalColors$1
        @Override // kotlin.jvm.functions.Function0
        public final Colors invoke() {
            return ColorsKt.m178lightColors2qZNXz8$default(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 4095);
        }
    });

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: contentColorFor-4WTKRHQ */
    public static final long m175contentColorFor4WTKRHQ(Colors contentColorFor, long j) {
        Intrinsics.checkNotNullParameter(contentColorFor, "$this$contentColorFor");
        if (Color.m317equalsimpl0(j, contentColorFor.m170getPrimary0d7_KjU())) {
            return contentColorFor.m167getOnPrimary0d7_KjU();
        }
        if (Color.m317equalsimpl0(j, contentColorFor.m171getPrimaryVariant0d7_KjU())) {
            return contentColorFor.m167getOnPrimary0d7_KjU();
        }
        if (Color.m317equalsimpl0(j, contentColorFor.m172getSecondary0d7_KjU())) {
            return contentColorFor.m168getOnSecondary0d7_KjU();
        }
        if (Color.m317equalsimpl0(j, contentColorFor.m173getSecondaryVariant0d7_KjU())) {
            return contentColorFor.m168getOnSecondary0d7_KjU();
        }
        if (Color.m317equalsimpl0(j, contentColorFor.m164getBackground0d7_KjU())) {
            return contentColorFor.m166getOnBackground0d7_KjU();
        }
        if (Color.m317equalsimpl0(j, contentColorFor.m174getSurface0d7_KjU())) {
            return contentColorFor.m169getOnSurface0d7_KjU();
        }
        if (Color.m317equalsimpl0(j, contentColorFor.m165getError0d7_KjU())) {
            return ((Color) contentColorFor.onError$delegate.getValue()).value;
        }
        return Color.Unspecified;
    }

    /* renamed from: contentColorFor-ek8zF_U */
    public static final long m176contentColorForek8zF_U(long j, Composer composer) {
        boolean z;
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        long m175contentColorFor4WTKRHQ = m175contentColorFor4WTKRHQ((Colors) composer.consume(LocalColors), j);
        if (m175contentColorFor4WTKRHQ != Color.Unspecified) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return ((Color) composer.consume(ContentColorKt.LocalContentColor)).value;
        }
        return m175contentColorFor4WTKRHQ;
    }

    /* renamed from: darkColors-2qZNXz8$default */
    public static Colors m177darkColors2qZNXz8$default(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, int r49) {
        long j11;
        long j12;
        long j13;
        long j14;
        long j15;
        long j16;
        long j17;
        long j18;
        long j19;
        long j20;
        long j21;
        long j22;
        if ((r49 & 1) != 0) {
            j11 = ColorKt.Color(4290479868L);
        } else {
            j11 = j;
        }
        if ((r49 & 2) != 0) {
            j12 = ColorKt.Color(4281794739L);
        } else {
            j12 = 0;
        }
        if ((r49 & 4) != 0) {
            j13 = ColorKt.Color(4278442694L);
        } else {
            j13 = j2;
        }
        if ((r49 & 8) != 0) {
            j14 = j13;
        } else {
            j14 = 0;
        }
        if ((r49 & 16) != 0) {
            j15 = ColorKt.Color(4279374354L);
        } else {
            j15 = j3;
        }
        if ((r49 & 32) != 0) {
            j16 = ColorKt.Color(4279374354L);
        } else {
            j16 = j4;
        }
        if ((r49 & 64) != 0) {
            j17 = ColorKt.Color(4291782265L);
        } else {
            j17 = j5;
        }
        if ((r49 & 128) != 0) {
            j18 = Color.Black;
        } else {
            j18 = j6;
        }
        if ((r49 & 256) != 0) {
            j19 = Color.Black;
        } else {
            j19 = j7;
        }
        if ((r49 & DfuBaseService.ERROR_REMOTE_TYPE_SECURE) != 0) {
            j20 = Color.White;
        } else {
            j20 = j8;
        }
        if ((r49 & 1024) != 0) {
            j21 = Color.White;
        } else {
            j21 = j9;
        }
        if ((r49 & 2048) != 0) {
            j22 = Color.Black;
        } else {
            j22 = j10;
        }
        return new Colors(j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, false);
    }

    /* renamed from: lightColors-2qZNXz8$default */
    public static Colors m178lightColors2qZNXz8$default(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, int r49) {
        long j11;
        long j12;
        long j13;
        long j14;
        long j15;
        long j16;
        long j17;
        long j18;
        long j19;
        long j20;
        long j21;
        long j22;
        if ((r49 & 1) != 0) {
            j11 = ColorKt.Color(4284612846L);
        } else {
            j11 = j;
        }
        if ((r49 & 2) != 0) {
            j12 = ColorKt.Color(4281794739L);
        } else {
            j12 = 0;
        }
        if ((r49 & 4) != 0) {
            j13 = ColorKt.Color(4278442694L);
        } else {
            j13 = j2;
        }
        if ((r49 & 8) != 0) {
            j14 = ColorKt.Color(4278290310L);
        } else {
            j14 = 0;
        }
        if ((r49 & 16) != 0) {
            j15 = Color.White;
        } else {
            j15 = j3;
        }
        if ((r49 & 32) != 0) {
            j16 = Color.White;
        } else {
            j16 = j4;
        }
        if ((r49 & 64) != 0) {
            j17 = ColorKt.Color(4289724448L);
        } else {
            j17 = j5;
        }
        if ((r49 & 128) != 0) {
            j18 = Color.White;
        } else {
            j18 = j6;
        }
        if ((r49 & 256) != 0) {
            j19 = Color.Black;
        } else {
            j19 = j7;
        }
        if ((r49 & DfuBaseService.ERROR_REMOTE_TYPE_SECURE) != 0) {
            j20 = Color.Black;
        } else {
            j20 = j8;
        }
        if ((r49 & 1024) != 0) {
            j21 = Color.Black;
        } else {
            j21 = j9;
        }
        if ((r49 & 2048) != 0) {
            j22 = Color.White;
        } else {
            j22 = j10;
        }
        return new Colors(j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, true);
    }
}
