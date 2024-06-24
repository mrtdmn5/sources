package androidx.compose.ui;

import androidx.compose.ui.draw.PainterNode;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.ObserverNodeOwnerScope;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobImpl;
import kotlinx.coroutines.internal.ContextScope;

/* compiled from: Modifier.kt */
/* loaded from: classes.dex */
public interface Modifier {
    public static final /* synthetic */ int $r8$clinit = 0;

    /* compiled from: Modifier.kt */
    /* loaded from: classes.dex */
    public static final class Companion implements Modifier {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @Override // androidx.compose.ui.Modifier
        public final boolean all(Function1<? super Element, Boolean> predicate) {
            Intrinsics.checkNotNullParameter(predicate, "predicate");
            return true;
        }

        @Override // androidx.compose.ui.Modifier
        public final <R> R foldIn(R r, Function2<? super R, ? super Element, ? extends R> operation) {
            Intrinsics.checkNotNullParameter(operation, "operation");
            return r;
        }

        @Override // androidx.compose.ui.Modifier
        public final Modifier then(Modifier other) {
            Intrinsics.checkNotNullParameter(other, "other");
            return other;
        }

        public final String toString() {
            return "Modifier";
        }
    }

    /* compiled from: Modifier.kt */
    /* loaded from: classes.dex */
    public interface Element extends Modifier {
        @Override // androidx.compose.ui.Modifier
        default boolean all(Function1<? super Element, Boolean> predicate) {
            Intrinsics.checkNotNullParameter(predicate, "predicate");
            return predicate.invoke(this).booleanValue();
        }

        @Override // androidx.compose.ui.Modifier
        default <R> R foldIn(R r, Function2<? super R, ? super Element, ? extends R> operation) {
            Intrinsics.checkNotNullParameter(operation, "operation");
            return operation.invoke(r, this);
        }
    }

    boolean all(Function1<? super Element, Boolean> function1);

    <R> R foldIn(R r, Function2<? super R, ? super Element, ? extends R> function2);

    default Modifier then(Modifier other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (other == Companion.$$INSTANCE) {
            return this;
        }
        return new CombinedModifier(this, other);
    }

    /* compiled from: Modifier.kt */
    /* loaded from: classes.dex */
    public static abstract class Node implements DelegatableNode {
        public Node child;
        public NodeCoordinator coordinator;
        public boolean insertedNodeAwaitingAttachForInvalidation;
        public boolean isAttached;
        public int kindSet;
        public boolean onAttachRunExpected;
        public boolean onDetachRunExpected;
        public ObserverNodeOwnerScope ownerScope;
        public Node parent;
        public ContextScope scope;
        public boolean updatedNodeAwaitingAttachForInvalidation;
        public Node node = this;
        public int aggregateChildKindSet = -1;

        public final CoroutineScope getCoroutineScope() {
            ContextScope contextScope = this.scope;
            if (contextScope == null) {
                ContextScope CoroutineScope = CoroutineScopeKt.CoroutineScope(DelegatableNodeKt.requireOwner(this).getCoroutineContext().plus(new JobImpl((Job) DelegatableNodeKt.requireOwner(this).getCoroutineContext().get(Job.Key.$$INSTANCE))));
                this.scope = CoroutineScope;
                return CoroutineScope;
            }
            return contextScope;
        }

        @Override // androidx.compose.ui.node.DelegatableNode
        public final Node getNode() {
            return this.node;
        }

        public boolean getShouldAutoInvalidate() {
            return !(this instanceof PainterNode);
        }

        public void markAsAttached$ui_release() {
            boolean z;
            if (!this.isAttached) {
                if (this.coordinator != null) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    this.isAttached = true;
                    this.onAttachRunExpected = true;
                    return;
                }
                throw new IllegalStateException("attach invoked on a node without a coordinator".toString());
            }
            throw new IllegalStateException("node attached multiple times".toString());
        }

        public void markAsDetached$ui_release() {
            if (this.isAttached) {
                if (!this.onAttachRunExpected) {
                    if (!this.onDetachRunExpected) {
                        this.isAttached = false;
                        ContextScope contextScope = this.scope;
                        if (contextScope != null) {
                            CoroutineScopeKt.cancel(contextScope, new ModifierNodeDetachedCancellationException());
                            this.scope = null;
                            return;
                        }
                        return;
                    }
                    throw new IllegalStateException("Must run runDetachLifecycle() before markAsDetached()".toString());
                }
                throw new IllegalStateException("Must run runAttachLifecycle() before markAsDetached()".toString());
            }
            throw new IllegalStateException("Cannot detach a node that is not attached".toString());
        }

        public void reset$ui_release() {
            if (this.isAttached) {
                onReset();
                return;
            }
            throw new IllegalStateException("Check failed.".toString());
        }

        public void runAttachLifecycle$ui_release() {
            if (this.isAttached) {
                if (this.onAttachRunExpected) {
                    this.onAttachRunExpected = false;
                    onAttach();
                    this.onDetachRunExpected = true;
                    return;
                }
                throw new IllegalStateException("Must run runAttachLifecycle() only once after markAsAttached()".toString());
            }
            throw new IllegalStateException("Must run markAsAttached() prior to runAttachLifecycle".toString());
        }

        public void runDetachLifecycle$ui_release() {
            boolean z;
            if (this.isAttached) {
                if (this.coordinator != null) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    if (this.onDetachRunExpected) {
                        this.onDetachRunExpected = false;
                        onDetach();
                        return;
                    }
                    throw new IllegalStateException("Must run runDetachLifecycle() once after runAttachLifecycle() and before markAsDetached()".toString());
                }
                throw new IllegalStateException("detach invoked on a node without a coordinator".toString());
            }
            throw new IllegalStateException("node detached multiple times".toString());
        }

        public void updateCoordinator$ui_release(NodeCoordinator nodeCoordinator) {
            this.coordinator = nodeCoordinator;
        }

        public void onAttach() {
        }

        public void onDetach() {
        }

        public void onReset() {
        }
    }
}
