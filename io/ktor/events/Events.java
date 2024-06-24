package io.ktor.events;

import io.ktor.util.collections.CopyOnWriteHashMap;
import kotlin.ExceptionsKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;

/* compiled from: Events.kt */
/* loaded from: classes3.dex */
public final class Events {
    public final CopyOnWriteHashMap<EventDefinition<?>, LockFreeLinkedListHead> handlers = new CopyOnWriteHashMap<>();

    /* compiled from: Events.kt */
    /* loaded from: classes3.dex */
    public static final class HandlerRegistration extends LockFreeLinkedListNode implements DisposableHandle {
    }

    public final void raise(EventDefinition definition) {
        Unit unit;
        Intrinsics.checkNotNullParameter(definition, "definition");
        LockFreeLinkedListHead lockFreeLinkedListHead = this.handlers.get(definition);
        Throwable th = null;
        if (lockFreeLinkedListHead != null) {
            Throwable th2 = null;
            for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) lockFreeLinkedListHead.getNext(); !Intrinsics.areEqual(lockFreeLinkedListNode, lockFreeLinkedListHead); lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode()) {
                if (lockFreeLinkedListNode instanceof HandlerRegistration) {
                    try {
                        ((HandlerRegistration) lockFreeLinkedListNode).getClass();
                        Intrinsics.checkNotNull(null, "null cannot be cast to non-null type kotlin.Function1<T of io.ktor.events.Events.raise$lambda$2, kotlin.Unit>{ io.ktor.events.EventsKt.EventHandler<T of io.ktor.events.Events.raise$lambda$2> }");
                        throw null;
                    } catch (Throwable th3) {
                        if (th2 != null) {
                            ExceptionsKt.addSuppressed(th2, th3);
                            unit = Unit.INSTANCE;
                        } else {
                            unit = null;
                        }
                        if (unit == null) {
                            th2 = th3;
                        }
                    }
                }
            }
            th = th2;
        }
        if (th != null) {
            throw th;
        }
    }
}
