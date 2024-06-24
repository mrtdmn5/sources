package androidx.compose.material;

import android.content.Context;
import android.content.res.Resources;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.kronaby.watch.app.R;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Strings.android.kt */
/* loaded from: classes.dex */
public final class Strings_androidKt {
    /* renamed from: getString-4foXLRw, reason: not valid java name */
    public static final String m204getString4foXLRw(int r4, Composer composer) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        String str;
        composer.startReplaceableGroup(-726638443);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        composer.consume(AndroidCompositionLocals_androidKt.LocalConfiguration);
        Resources resources = ((Context) composer.consume(AndroidCompositionLocals_androidKt.LocalContext)).getResources();
        boolean z7 = false;
        if (r4 == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            str = resources.getString(R.string.navigation_menu);
            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(R.string.navigation_menu)");
        } else {
            if (r4 == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                str = resources.getString(R.string.close_drawer);
                Intrinsics.checkNotNullExpressionValue(str, "resources.getString(R.string.close_drawer)");
            } else {
                if (r4 == 2) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    str = resources.getString(R.string.close_sheet);
                    Intrinsics.checkNotNullExpressionValue(str, "resources.getString(R.string.close_sheet)");
                } else {
                    if (r4 == 3) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (z4) {
                        str = resources.getString(R.string.default_error_message);
                        Intrinsics.checkNotNullExpressionValue(str, "resources.getString(R.st…ng.default_error_message)");
                    } else {
                        if (r4 == 4) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        if (z5) {
                            str = resources.getString(R.string.dropdown_menu);
                            Intrinsics.checkNotNullExpressionValue(str, "resources.getString(R.string.dropdown_menu)");
                        } else {
                            if (r4 == 5) {
                                z6 = true;
                            } else {
                                z6 = false;
                            }
                            if (z6) {
                                str = resources.getString(R.string.range_start);
                                Intrinsics.checkNotNullExpressionValue(str, "resources.getString(R.string.range_start)");
                            } else {
                                if (r4 == 6) {
                                    z7 = true;
                                }
                                if (z7) {
                                    str = resources.getString(R.string.range_end);
                                    Intrinsics.checkNotNullExpressionValue(str, "resources.getString(R.string.range_end)");
                                } else {
                                    str = "";
                                }
                            }
                        }
                    }
                }
            }
        }
        composer.endReplaceableGroup();
        return str;
    }
}
