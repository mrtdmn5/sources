package androidx.compose.foundation;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Indication.kt */
/* loaded from: classes.dex */
public final class NoIndication implements Indication {
    public static final NoIndication INSTANCE = new NoIndication();

    /* compiled from: Indication.kt */
    /* loaded from: classes.dex */
    public static final class NoIndicationInstance implements IndicationInstance {
        public static final NoIndicationInstance INSTANCE = new NoIndicationInstance();

        @Override // androidx.compose.foundation.IndicationInstance
        public final void drawIndication(ContentDrawScope contentDrawScope) {
            Intrinsics.checkNotNullParameter(contentDrawScope, "<this>");
            contentDrawScope.drawContent();
        }
    }

    @Override // androidx.compose.foundation.Indication
    public final IndicationInstance rememberUpdatedInstance(InteractionSource interactionSource, Composer composer) {
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        composer.startReplaceableGroup(285654452);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        NoIndicationInstance noIndicationInstance = NoIndicationInstance.INSTANCE;
        composer.endReplaceableGroup();
        return noIndicationInstance;
    }
}
