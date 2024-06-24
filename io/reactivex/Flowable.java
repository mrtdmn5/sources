package io.reactivex;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.subscribers.StrictSubscriber;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* loaded from: classes3.dex */
public abstract class Flowable<T> implements Publisher<T> {
    public static final int BUFFER_SIZE = Math.max(1, Integer.getInteger("rx2.buffer-size", 128).intValue());

    @Override // org.reactivestreams.Publisher
    public final void subscribe(Subscriber<? super T> subscriber) {
        if (subscriber instanceof FlowableSubscriber) {
            subscribe((FlowableSubscriber) subscriber);
        } else {
            subscribe((FlowableSubscriber) new StrictSubscriber(subscriber));
        }
    }

    public abstract void subscribeActual(Subscriber<? super T> subscriber);

    public final void subscribe(FlowableSubscriber<? super T> flowableSubscriber) {
        try {
            subscribeActual(flowableSubscriber);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            RxJavaPlugins.onError(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }
}
