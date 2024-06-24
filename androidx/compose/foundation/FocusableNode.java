package androidx.compose.foundation;

import androidx.compose.foundation.interaction.FocusInteraction$Focus;
import androidx.compose.foundation.interaction.FocusInteraction$Unfocus;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.lazy.layout.LazyLayoutPinnableItem;
import androidx.compose.foundation.relocation.BringIntoViewRequesterImpl;
import androidx.compose.foundation.relocation.BringIntoViewRequesterNode;
import androidx.compose.ui.focus.FocusEventModifierNode;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.focus.FocusStateImpl;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.PinnableContainer;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.node.LayoutAwareModifierNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.BuildersKt;

/* compiled from: Focusable.kt */
/* loaded from: classes.dex */
public final class FocusableNode extends DelegatingNode implements FocusEventModifierNode, LayoutAwareModifierNode, SemanticsModifierNode, GlobalPositionAwareModifierNode {
    public final BringIntoViewRequesterImpl bringIntoViewRequester;
    public final BringIntoViewRequesterNode bringIntoViewRequesterNode;
    public FocusState focusState;
    public final FocusableInteractionNode focusableInteractionNode;
    public final FocusablePinnableContainerNode focusablePinnableContainer;
    public final FocusableSemanticsNode focusableSemanticsNode;
    public final FocusedBoundsNode focusedBoundsNode;

    public FocusableNode(MutableInteractionSource mutableInteractionSource) {
        FocusableSemanticsNode focusableSemanticsNode = new FocusableSemanticsNode();
        delegate(focusableSemanticsNode);
        this.focusableSemanticsNode = focusableSemanticsNode;
        FocusableInteractionNode focusableInteractionNode = new FocusableInteractionNode(mutableInteractionSource);
        delegate(focusableInteractionNode);
        this.focusableInteractionNode = focusableInteractionNode;
        FocusablePinnableContainerNode focusablePinnableContainerNode = new FocusablePinnableContainerNode();
        delegate(focusablePinnableContainerNode);
        this.focusablePinnableContainer = focusablePinnableContainerNode;
        FocusedBoundsNode focusedBoundsNode = new FocusedBoundsNode();
        delegate(focusedBoundsNode);
        this.focusedBoundsNode = focusedBoundsNode;
        BringIntoViewRequesterImpl bringIntoViewRequesterImpl = new BringIntoViewRequesterImpl();
        this.bringIntoViewRequester = bringIntoViewRequesterImpl;
        BringIntoViewRequesterNode bringIntoViewRequesterNode = new BringIntoViewRequesterNode(bringIntoViewRequesterImpl);
        delegate(bringIntoViewRequesterNode);
        this.bringIntoViewRequesterNode = bringIntoViewRequesterNode;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final void applySemantics(SemanticsConfiguration semanticsConfiguration) {
        Intrinsics.checkNotNullParameter(semanticsConfiguration, "<this>");
        this.focusableSemanticsNode.applySemantics(semanticsConfiguration);
    }

    @Override // androidx.compose.ui.focus.FocusEventModifierNode
    public final void onFocusEvent(FocusStateImpl focusState) {
        Function1 function1;
        Function1 function12;
        Intrinsics.checkNotNullParameter(focusState, "focusState");
        if (!Intrinsics.areEqual(this.focusState, focusState)) {
            boolean isFocused = focusState.isFocused();
            LazyLayoutPinnableItem lazyLayoutPinnableItem = null;
            if (isFocused) {
                BuildersKt.launch$default(getCoroutineScope(), null, null, new FocusableNode$onFocusEvent$1(this, null), 3);
            }
            if (this.isAttached) {
                SemanticsModifierNodeKt.invalidateSemantics(this);
            }
            FocusableInteractionNode focusableInteractionNode = this.focusableInteractionNode;
            MutableInteractionSource mutableInteractionSource = focusableInteractionNode.interactionSource;
            if (mutableInteractionSource != null) {
                if (isFocused) {
                    FocusInteraction$Focus focusInteraction$Focus = focusableInteractionNode.focusedInteraction;
                    if (focusInteraction$Focus != null) {
                        focusableInteractionNode.emitWithFallback(mutableInteractionSource, new FocusInteraction$Unfocus(focusInteraction$Focus));
                        focusableInteractionNode.focusedInteraction = null;
                    }
                    FocusInteraction$Focus focusInteraction$Focus2 = new FocusInteraction$Focus();
                    focusableInteractionNode.emitWithFallback(mutableInteractionSource, focusInteraction$Focus2);
                    focusableInteractionNode.focusedInteraction = focusInteraction$Focus2;
                } else {
                    FocusInteraction$Focus focusInteraction$Focus3 = focusableInteractionNode.focusedInteraction;
                    if (focusInteraction$Focus3 != null) {
                        focusableInteractionNode.emitWithFallback(mutableInteractionSource, new FocusInteraction$Unfocus(focusInteraction$Focus3));
                        focusableInteractionNode.focusedInteraction = null;
                    }
                }
            }
            FocusedBoundsNode focusedBoundsNode = this.focusedBoundsNode;
            if (isFocused != focusedBoundsNode.isFocused) {
                if (!isFocused) {
                    if (focusedBoundsNode.isAttached) {
                        function12 = (Function1) focusedBoundsNode.getCurrent(FocusedBoundsKt.ModifierLocalFocusedBoundsObserver);
                    } else {
                        function12 = null;
                    }
                    if (function12 != null) {
                        function12.invoke(null);
                    }
                } else {
                    LayoutCoordinates layoutCoordinates = focusedBoundsNode.layoutCoordinates;
                    if (layoutCoordinates != null && layoutCoordinates.isAttached()) {
                        if (focusedBoundsNode.isAttached) {
                            function1 = (Function1) focusedBoundsNode.getCurrent(FocusedBoundsKt.ModifierLocalFocusedBoundsObserver);
                        } else {
                            function1 = null;
                        }
                        if (function1 != null) {
                            function1.invoke(focusedBoundsNode.layoutCoordinates);
                        }
                    }
                }
                focusedBoundsNode.isFocused = isFocused;
            }
            FocusablePinnableContainerNode focusablePinnableContainerNode = this.focusablePinnableContainer;
            if (isFocused) {
                focusablePinnableContainerNode.getClass();
                Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                ObserverModifierNodeKt.observeReads(focusablePinnableContainerNode, new FocusablePinnableContainerNode$retrievePinnableContainer$1(ref$ObjectRef, focusablePinnableContainerNode));
                PinnableContainer pinnableContainer = (PinnableContainer) ref$ObjectRef.element;
                if (pinnableContainer != null) {
                    lazyLayoutPinnableItem = pinnableContainer.pin();
                }
                focusablePinnableContainerNode.pinnedHandle = lazyLayoutPinnableItem;
            } else {
                PinnableContainer.PinnedHandle pinnedHandle = focusablePinnableContainerNode.pinnedHandle;
                if (pinnedHandle != null) {
                    pinnedHandle.release();
                }
                focusablePinnableContainerNode.pinnedHandle = null;
            }
            focusablePinnableContainerNode.isFocused = isFocused;
            this.focusableSemanticsNode.isFocused = isFocused;
            this.focusState = focusState;
        }
    }

    @Override // androidx.compose.ui.node.GlobalPositionAwareModifierNode
    public final void onGloballyPositioned(NodeCoordinator nodeCoordinator) {
        this.focusedBoundsNode.onGloballyPositioned(nodeCoordinator);
    }

    @Override // androidx.compose.ui.node.LayoutAwareModifierNode
    public final void onPlaced(NodeCoordinator coordinates) {
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        BringIntoViewRequesterNode bringIntoViewRequesterNode = this.bringIntoViewRequesterNode;
        bringIntoViewRequesterNode.getClass();
        bringIntoViewRequesterNode.layoutCoordinates = coordinates;
    }
}
