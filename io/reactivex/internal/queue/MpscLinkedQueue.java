package io.reactivex.internal.queue;

import io.reactivex.internal.fuseable.SimplePlainQueue;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class MpscLinkedQueue<T> implements SimplePlainQueue<T> {
    public final AtomicReference<LinkedQueueNode<T>> consumerNode;
    public final AtomicReference<LinkedQueueNode<T>> producerNode;

    /* loaded from: classes.dex */
    public static final class LinkedQueueNode<E> extends AtomicReference<LinkedQueueNode<E>> {
        public E value;

        public LinkedQueueNode() {
        }

        public LinkedQueueNode(E e) {
            this.value = e;
        }
    }

    public MpscLinkedQueue() {
        AtomicReference<LinkedQueueNode<T>> atomicReference = new AtomicReference<>();
        this.producerNode = atomicReference;
        AtomicReference<LinkedQueueNode<T>> atomicReference2 = new AtomicReference<>();
        this.consumerNode = atomicReference2;
        LinkedQueueNode<T> linkedQueueNode = new LinkedQueueNode<>();
        atomicReference2.lazySet(linkedQueueNode);
        atomicReference.getAndSet(linkedQueueNode);
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final void clear() {
        while (poll() != null && !isEmpty()) {
        }
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final boolean isEmpty() {
        if (this.consumerNode.get() == this.producerNode.get()) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final boolean offer(T t) {
        if (t != null) {
            LinkedQueueNode<T> linkedQueueNode = new LinkedQueueNode<>(t);
            this.producerNode.getAndSet(linkedQueueNode).lazySet(linkedQueueNode);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final T poll() {
        LinkedQueueNode<T> linkedQueueNode;
        AtomicReference<LinkedQueueNode<T>> atomicReference = this.consumerNode;
        LinkedQueueNode<T> linkedQueueNode2 = atomicReference.get();
        LinkedQueueNode<T> linkedQueueNode3 = (LinkedQueueNode) linkedQueueNode2.get();
        if (linkedQueueNode3 != null) {
            T t = linkedQueueNode3.value;
            linkedQueueNode3.value = null;
            atomicReference.lazySet(linkedQueueNode3);
            return t;
        }
        if (linkedQueueNode2 == this.producerNode.get()) {
            return null;
        }
        do {
            linkedQueueNode = (LinkedQueueNode) linkedQueueNode2.get();
        } while (linkedQueueNode == null);
        T t2 = linkedQueueNode.value;
        linkedQueueNode.value = null;
        atomicReference.lazySet(linkedQueueNode);
        return t2;
    }
}
