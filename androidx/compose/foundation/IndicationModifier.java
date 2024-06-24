package androidx.compose.foundation;

import androidx.compose.ui.draw.DrawModifier;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Indication.kt */
/* loaded from: classes.dex */
public final class IndicationModifier implements DrawModifier {
    public final IndicationInstance indicationInstance;

    public IndicationModifier(IndicationInstance indicationInstance) {
        Intrinsics.checkNotNullParameter(indicationInstance, "indicationInstance");
        this.indicationInstance = indicationInstance;
    }

    @Override // androidx.compose.ui.draw.DrawModifier
    public final void draw(ContentDrawScope contentDrawScope) {
        Intrinsics.checkNotNullParameter(contentDrawScope, "<this>");
        this.indicationInstance.drawIndication(contentDrawScope);
    }
}
