package androidx.compose.ui.input.pointer;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.node.HitTestResult;
import androidx.compose.ui.node.LayoutNode;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PointerInputEventProcessor.kt */
/* loaded from: classes.dex */
public final class PointerInputEventProcessor {
    public final HitPathTracker hitPathTracker;
    public final HitTestResult hitResult;
    public boolean isProcessing;
    public final PointerInputChangeEventProducer pointerInputChangeEventProducer;
    public final LayoutNode root;

    public PointerInputEventProcessor(LayoutNode root) {
        Intrinsics.checkNotNullParameter(root, "root");
        this.root = root;
        this.hitPathTracker = new HitPathTracker(root.nodes.innerCoordinator);
        this.pointerInputChangeEventProducer = new PointerInputChangeEventProducer();
        this.hitResult = new HitTestResult();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0050 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:? A[LOOP:2: B:72:0x0036->B:84:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* renamed from: process-BIzXfog */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int m415processBIzXfog(androidx.compose.ui.input.pointer.PointerInputEvent r18, androidx.compose.ui.input.pointer.PositionCalculator r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 252
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.PointerInputEventProcessor.m415processBIzXfog(androidx.compose.ui.input.pointer.PointerInputEvent, androidx.compose.ui.input.pointer.PositionCalculator, boolean):int");
    }

    public final void processCancel() {
        if (!this.isProcessing) {
            this.pointerInputChangeEventProducer.previousPointerInputData.clear();
            NodeParent nodeParent = this.hitPathTracker.root;
            MutableVector<Node> mutableVector = nodeParent.children;
            int r2 = mutableVector.size;
            if (r2 > 0) {
                Node[] nodeArr = mutableVector.content;
                int r3 = 0;
                do {
                    nodeArr[r3].dispatchCancel();
                    r3++;
                } while (r3 < r2);
            }
            nodeParent.children.clear();
        }
    }
}
