package androidx.compose.ui.modifier;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.BackwardsCompatNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.Owner;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ModifierLocalManager.kt */
/* loaded from: classes.dex */
public final class ModifierLocalManager {
    public final MutableVector<BackwardsCompatNode> inserted;
    public final MutableVector<ModifierLocal<?>> insertedLocal;
    public boolean invalidated;
    public final Owner owner;
    public final MutableVector<LayoutNode> removed;
    public final MutableVector<ModifierLocal<?>> removedLocal;

    public ModifierLocalManager(Owner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.owner = owner;
        this.inserted = new MutableVector<>(new BackwardsCompatNode[16]);
        this.insertedLocal = new MutableVector<>(new ModifierLocal[16]);
        this.removed = new MutableVector<>(new LayoutNode[16]);
        this.removedLocal = new MutableVector<>(new ModifierLocal[16]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    public static void invalidateConsumersOfNodeForKey(Modifier.Node node, ModifierLocal modifierLocal, HashSet hashSet) {
        boolean z;
        boolean z2;
        boolean z3;
        Modifier.Node node2 = node.node;
        if (node2.isAttached) {
            MutableVector mutableVector = new MutableVector(new Modifier.Node[16]);
            Modifier.Node node3 = node2.child;
            if (node3 == null) {
                DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector, node2);
            } else {
                mutableVector.add(node3);
            }
            while (mutableVector.isNotEmpty()) {
                Modifier.Node node4 = (Modifier.Node) mutableVector.removeAt(mutableVector.size - 1);
                if ((node4.aggregateChildKindSet & 32) != 0) {
                    for (Modifier.Node node5 = node4; node5 != null; node5 = node5.child) {
                        if ((node5.kindSet & 32) != 0) {
                            DelegatingNode delegatingNode = node5;
                            ?? r6 = 0;
                            while (true) {
                                if (delegatingNode != 0) {
                                    z = false;
                                    if (delegatingNode instanceof ModifierLocalModifierNode) {
                                        ModifierLocalModifierNode modifierLocalModifierNode = (ModifierLocalModifierNode) delegatingNode;
                                        if (modifierLocalModifierNode instanceof BackwardsCompatNode) {
                                            BackwardsCompatNode backwardsCompatNode = (BackwardsCompatNode) modifierLocalModifierNode;
                                            if ((backwardsCompatNode.element instanceof ModifierLocalConsumer) && backwardsCompatNode.readValues.contains(modifierLocal)) {
                                                hashSet.add(modifierLocalModifierNode);
                                            }
                                        }
                                        if (!(!modifierLocalModifierNode.getProvidedValues().contains$ui_release(modifierLocal))) {
                                            break;
                                        }
                                    } else {
                                        if ((delegatingNode.kindSet & 32) != 0) {
                                            z2 = true;
                                        } else {
                                            z2 = false;
                                        }
                                        if (z2 && (delegatingNode instanceof DelegatingNode)) {
                                            Modifier.Node node6 = delegatingNode.delegate;
                                            int r9 = 0;
                                            delegatingNode = delegatingNode;
                                            r6 = r6;
                                            while (node6 != null) {
                                                if ((node6.kindSet & 32) != 0) {
                                                    z3 = true;
                                                } else {
                                                    z3 = false;
                                                }
                                                if (z3) {
                                                    r9++;
                                                    r6 = r6;
                                                    if (r9 == 1) {
                                                        delegatingNode = node6;
                                                    } else {
                                                        if (r6 == 0) {
                                                            r6 = new MutableVector(new Modifier.Node[16]);
                                                        }
                                                        if (delegatingNode != 0) {
                                                            r6.add(delegatingNode);
                                                            delegatingNode = 0;
                                                        }
                                                        r6.add(node6);
                                                    }
                                                }
                                                node6 = node6.child;
                                                delegatingNode = delegatingNode;
                                                r6 = r6;
                                            }
                                            if (r9 == 1) {
                                            }
                                        }
                                    }
                                    delegatingNode = DelegatableNodeKt.access$pop(r6);
                                } else {
                                    z = true;
                                    break;
                                }
                            }
                            if (z) {
                            }
                        }
                    }
                }
                DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector, node4);
            }
            return;
        }
        throw new IllegalStateException("visitSubtreeIf called on an unattached node".toString());
    }

    public final void invalidate() {
        if (!this.invalidated) {
            this.invalidated = true;
            this.owner.registerOnEndApplyChangesListener(new Function0<Unit>() { // from class: androidx.compose.ui.modifier.ModifierLocalManager$invalidate$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    ModifierLocalManager modifierLocalManager = ModifierLocalManager.this;
                    int r1 = 0;
                    modifierLocalManager.invalidated = false;
                    HashSet hashSet = new HashSet();
                    MutableVector<LayoutNode> mutableVector = modifierLocalManager.removed;
                    int r4 = mutableVector.size;
                    MutableVector<ModifierLocal<?>> mutableVector2 = modifierLocalManager.removedLocal;
                    if (r4 > 0) {
                        LayoutNode[] layoutNodeArr = mutableVector.content;
                        int r7 = 0;
                        do {
                            LayoutNode layoutNode = layoutNodeArr[r7];
                            ModifierLocal<?> modifierLocal = mutableVector2.content[r7];
                            Modifier.Node node = layoutNode.nodes.head;
                            if (node.isAttached) {
                                ModifierLocalManager.invalidateConsumersOfNodeForKey(node, modifierLocal, hashSet);
                            }
                            r7++;
                        } while (r7 < r4);
                    }
                    mutableVector.clear();
                    mutableVector2.clear();
                    MutableVector<BackwardsCompatNode> mutableVector3 = modifierLocalManager.inserted;
                    int r42 = mutableVector3.size;
                    MutableVector<ModifierLocal<?>> mutableVector4 = modifierLocalManager.insertedLocal;
                    if (r42 > 0) {
                        BackwardsCompatNode[] backwardsCompatNodeArr = mutableVector3.content;
                        do {
                            BackwardsCompatNode backwardsCompatNode = backwardsCompatNodeArr[r1];
                            ModifierLocal<?> modifierLocal2 = mutableVector4.content[r1];
                            if (backwardsCompatNode.isAttached) {
                                ModifierLocalManager.invalidateConsumersOfNodeForKey(backwardsCompatNode, modifierLocal2, hashSet);
                            }
                            r1++;
                        } while (r1 < r42);
                    }
                    mutableVector3.clear();
                    mutableVector4.clear();
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        ((BackwardsCompatNode) it.next()).updateModifierLocalConsumer();
                    }
                    return Unit.INSTANCE;
                }
            });
        }
    }
}
