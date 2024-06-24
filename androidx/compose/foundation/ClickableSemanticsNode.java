package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Clickable.kt */
/* loaded from: classes.dex */
public final class ClickableSemanticsNode extends Modifier.Node implements SemanticsModifierNode {
    public boolean enabled;
    public Function0<Unit> onClick;
    public String onClickLabel;
    public Function0<Unit> onLongClick;
    public String onLongClickLabel;
    public Role role;

    public ClickableSemanticsNode(boolean z, String str, Role role, Function0 onClick) {
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        this.enabled = z;
        this.onClickLabel = str;
        this.role = role;
        this.onClick = onClick;
        this.onLongClickLabel = null;
        this.onLongClick = null;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final void applySemantics(SemanticsConfiguration semanticsConfiguration) {
        Intrinsics.checkNotNullParameter(semanticsConfiguration, "<this>");
        Role role = this.role;
        if (role != null) {
            SemanticsPropertiesKt.m506setRolekuIjeqM(semanticsConfiguration, role.value);
        }
        SemanticsPropertiesKt.onClick(semanticsConfiguration, this.onClickLabel, new Function0<Boolean>() { // from class: androidx.compose.foundation.ClickableSemanticsNode$applySemantics$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                ClickableSemanticsNode.this.onClick.invoke();
                return Boolean.TRUE;
            }
        });
        if (this.onLongClick != null) {
            semanticsConfiguration.set(SemanticsActions.OnLongClick, new AccessibilityAction(this.onLongClickLabel, new Function0<Boolean>() { // from class: androidx.compose.foundation.ClickableSemanticsNode$applySemantics$2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    Function0<Unit> function0 = ClickableSemanticsNode.this.onLongClick;
                    if (function0 != null) {
                        function0.invoke();
                    }
                    return Boolean.TRUE;
                }
            }));
        }
        if (!this.enabled) {
            semanticsConfiguration.set(SemanticsProperties.Disabled, Unit.INSTANCE);
        }
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final boolean getShouldMergeDescendantSemantics() {
        return true;
    }
}
