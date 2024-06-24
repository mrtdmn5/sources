package com.animaconnected.secondo.screens.activity;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.animaconnected.widget.TextKt;
import com.kronaby.watch.app.R;
import io.ktor.http.URLProtocolKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActivitySetupFragment.kt */
/* loaded from: classes3.dex */
public final class ComposableSingletons$ActivitySetupFragmentKt {
    public static final ComposableSingletons$ActivitySetupFragmentKt INSTANCE = new ComposableSingletons$ActivitySetupFragmentKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f27lambda1 = ComposableLambdaKt.composableLambdaInstance(24341543, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.activity.ComposableSingletons$ActivitySetupFragmentKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope ButtonOutlined, Composer composer, int r28) {
            Intrinsics.checkNotNullParameter(ButtonOutlined, "$this$ButtonOutlined");
            if ((r28 & 81) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
            } else {
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
                TextKt.m1633CapsTextfLXpl1I(URLProtocolKt.stringResource(R.string.activity_activate_label, composer), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, null, composer, 0, 0, 65534);
            }
        }
    }, false);

    /* renamed from: getLambda-1$secondo_kronabyRelease, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m831getLambda1$secondo_kronabyRelease() {
        return f27lambda1;
    }
}
