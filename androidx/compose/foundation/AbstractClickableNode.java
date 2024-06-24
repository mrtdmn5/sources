package androidx.compose.foundation;

import android.view.KeyEvent;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction$Cancel;
import androidx.compose.foundation.interaction.PressInteraction$Press;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.key.KeyInputModifierNode;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.PointerInputModifierNode;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Clickable.kt */
/* loaded from: classes.dex */
public abstract class AbstractClickableNode extends DelegatingNode implements PointerInputModifierNode, KeyInputModifierNode {
    public boolean enabled;
    public final InteractionData interactionData;
    public MutableInteractionSource interactionSource;
    public Function0<Unit> onClick;

    /* compiled from: Clickable.kt */
    /* loaded from: classes.dex */
    public static final class InteractionData {
        public PressInteraction$Press pressInteraction;
        public final LinkedHashMap currentKeyPressInteractions = new LinkedHashMap();
        public long centreOffset = Offset.Zero;
    }

    public AbstractClickableNode(MutableInteractionSource interactionSource, boolean z, Function0 onClick) {
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        this.interactionSource = interactionSource;
        this.enabled = z;
        this.onClick = onClick;
        this.interactionData = new InteractionData();
    }

    public final void disposeInteractionSource() {
        InteractionData interactionData = this.interactionData;
        PressInteraction$Press pressInteraction$Press = interactionData.pressInteraction;
        if (pressInteraction$Press != null) {
            this.interactionSource.tryEmit(new PressInteraction$Cancel(pressInteraction$Press));
        }
        LinkedHashMap linkedHashMap = interactionData.currentKeyPressInteractions;
        Iterator it = linkedHashMap.values().iterator();
        while (it.hasNext()) {
            this.interactionSource.tryEmit(new PressInteraction$Cancel((PressInteraction$Press) it.next()));
        }
        interactionData.pressInteraction = null;
        linkedHashMap.clear();
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public final void onCancelPointerInput() {
        ((ClickableNode) this).clickablePointerInputNode.onCancelPointerInput();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onDetach() {
        disposeInteractionSource();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    @Override // androidx.compose.ui.input.key.KeyInputModifierNode
    /* renamed from: onKeyEvent-ZmokQxo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean mo12onKeyEventZmokQxo(android.view.KeyEvent r13) {
        /*
            r12 = this;
            java.lang.String r0 = "event"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            boolean r0 = r12.enabled
            r1 = 3
            r2 = 160(0xa0, float:2.24E-43)
            r3 = 66
            r4 = 23
            r5 = 32
            r6 = 0
            androidx.compose.foundation.AbstractClickableNode$InteractionData r7 = r12.interactionData
            r8 = 0
            r9 = 1
            if (r0 == 0) goto L6e
            int r0 = androidx.compose.foundation.Clickable_androidKt.$r8$clinit
            int r0 = androidx.compose.ui.input.key.KeyEvent_androidKt.m400getTypeZmokQxo(r13)
            r10 = 2
            if (r0 != r10) goto L22
            r0 = r9
            goto L23
        L22:
            r0 = r8
        L23:
            if (r0 == 0) goto L38
            long r10 = androidx.compose.ui.input.key.KeyEvent_androidKt.m399getKeyZmokQxo(r13)
            long r10 = r10 >> r5
            int r0 = (int) r10
            if (r0 == r4) goto L33
            if (r0 == r3) goto L33
            if (r0 == r2) goto L33
            r0 = r8
            goto L34
        L33:
            r0 = r9
        L34:
            if (r0 == 0) goto L38
            r0 = r9
            goto L39
        L38:
            r0 = r8
        L39:
            if (r0 == 0) goto L6e
            java.util.LinkedHashMap r0 = r7.currentKeyPressInteractions
            long r2 = androidx.compose.ui.input.key.KeyEvent_androidKt.m399getKeyZmokQxo(r13)
            androidx.compose.ui.input.key.Key r4 = new androidx.compose.ui.input.key.Key
            r4.<init>(r2)
            boolean r0 = r0.containsKey(r4)
            if (r0 != 0) goto Lba
            androidx.compose.foundation.interaction.PressInteraction$Press r0 = new androidx.compose.foundation.interaction.PressInteraction$Press
            long r2 = r7.centreOffset
            r0.<init>(r2)
            java.util.LinkedHashMap r2 = r7.currentKeyPressInteractions
            long r3 = androidx.compose.ui.input.key.KeyEvent_androidKt.m399getKeyZmokQxo(r13)
            androidx.compose.ui.input.key.Key r13 = new androidx.compose.ui.input.key.Key
            r13.<init>(r3)
            r2.put(r13, r0)
            kotlinx.coroutines.CoroutineScope r13 = r12.getCoroutineScope()
            androidx.compose.foundation.AbstractClickableNode$onKeyEvent$1 r2 = new androidx.compose.foundation.AbstractClickableNode$onKeyEvent$1
            r2.<init>(r12, r0, r6)
            kotlinx.coroutines.BuildersKt.launch$default(r13, r6, r6, r2, r1)
            goto Lb9
        L6e:
            boolean r0 = r12.enabled
            if (r0 == 0) goto Lba
            int r0 = androidx.compose.foundation.Clickable_androidKt.$r8$clinit
            int r0 = androidx.compose.ui.input.key.KeyEvent_androidKt.m400getTypeZmokQxo(r13)
            if (r0 != r9) goto L7c
            r0 = r9
            goto L7d
        L7c:
            r0 = r8
        L7d:
            if (r0 == 0) goto L92
            long r10 = androidx.compose.ui.input.key.KeyEvent_androidKt.m399getKeyZmokQxo(r13)
            long r10 = r10 >> r5
            int r0 = (int) r10
            if (r0 == r4) goto L8d
            if (r0 == r3) goto L8d
            if (r0 == r2) goto L8d
            r0 = r8
            goto L8e
        L8d:
            r0 = r9
        L8e:
            if (r0 == 0) goto L92
            r0 = r9
            goto L93
        L92:
            r0 = r8
        L93:
            if (r0 == 0) goto Lba
            java.util.LinkedHashMap r0 = r7.currentKeyPressInteractions
            long r2 = androidx.compose.ui.input.key.KeyEvent_androidKt.m399getKeyZmokQxo(r13)
            androidx.compose.ui.input.key.Key r13 = new androidx.compose.ui.input.key.Key
            r13.<init>(r2)
            java.lang.Object r13 = r0.remove(r13)
            androidx.compose.foundation.interaction.PressInteraction$Press r13 = (androidx.compose.foundation.interaction.PressInteraction$Press) r13
            if (r13 == 0) goto Lb4
            kotlinx.coroutines.CoroutineScope r0 = r12.getCoroutineScope()
            androidx.compose.foundation.AbstractClickableNode$onKeyEvent$2$1 r2 = new androidx.compose.foundation.AbstractClickableNode$onKeyEvent$2$1
            r2.<init>(r12, r13, r6)
            kotlinx.coroutines.BuildersKt.launch$default(r0, r6, r6, r2, r1)
        Lb4:
            kotlin.jvm.functions.Function0<kotlin.Unit> r13 = r12.onClick
            r13.invoke()
        Lb9:
            r8 = r9
        Lba:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.AbstractClickableNode.mo12onKeyEventZmokQxo(android.view.KeyEvent):boolean");
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    /* renamed from: onPointerEvent-H0pRuoY, reason: not valid java name */
    public final void mo13onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pass, long j) {
        Intrinsics.checkNotNullParameter(pass, "pass");
        ((ClickableNode) this).clickablePointerInputNode.mo13onPointerEventH0pRuoY(pointerEvent, pass, j);
    }

    @Override // androidx.compose.ui.input.key.KeyInputModifierNode
    /* renamed from: onPreKeyEvent-ZmokQxo, reason: not valid java name */
    public final boolean mo14onPreKeyEventZmokQxo(KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return false;
    }
}
