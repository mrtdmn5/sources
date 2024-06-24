package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequesterModifierNode;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* compiled from: Focusable.kt */
/* loaded from: classes.dex */
public final class FocusableSemanticsNode extends Modifier.Node implements SemanticsModifierNode, FocusRequesterModifierNode {
    public boolean isFocused;

    public FocusableSemanticsNode() {
        new SemanticsConfiguration();
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final void applySemantics(SemanticsConfiguration semanticsConfiguration) {
        Intrinsics.checkNotNullParameter(semanticsConfiguration, "<this>");
        boolean z = this.isFocused;
        KProperty<Object>[] kPropertyArr = SemanticsPropertiesKt.$$delegatedProperties;
        SemanticsProperties.Focused.setValue(semanticsConfiguration, SemanticsPropertiesKt.$$delegatedProperties[4], Boolean.valueOf(z));
        semanticsConfiguration.set(SemanticsActions.RequestFocus, new AccessibilityAction(null, new Function0<Boolean>() { // from class: androidx.compose.foundation.FocusableSemanticsNode$applySemantics$1
            {
                super(0);
            }

            /* JADX WARN: Code restructure failed: missing block: B:108:0x00bb, code lost:            if (r0.fetchFocusProperties$ui_release().canFocus != false) goto L9;     */
            /* JADX WARN: Code restructure failed: missing block: B:111:0x008b, code lost:            continue;     */
            /* JADX WARN: Code restructure failed: missing block: B:43:0x0020, code lost:            if (r0.fetchFocusProperties$ui_release().canFocus != false) goto L9;     */
            /* JADX WARN: Code restructure failed: missing block: B:44:0x0022, code lost:            r0 = androidx.compose.ui.focus.FocusTransactionsKt.requestFocus(r0);     */
            @Override // kotlin.jvm.functions.Function0
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Boolean invoke() {
                /*
                    Method dump skipped, instructions count: 281
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.FocusableSemanticsNode$applySemantics$1.invoke():java.lang.Object");
            }
        }));
    }
}
