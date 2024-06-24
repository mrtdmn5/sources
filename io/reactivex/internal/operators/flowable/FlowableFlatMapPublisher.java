package io.reactivex.internal.operators.flowable;

import android.Manifest;
import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.single.SingleInternalHelper$ToFlowable;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.ScalarSubscription;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* loaded from: classes.dex */
public final class FlowableFlatMapPublisher<T, U> extends Flowable<U> {
    public final int bufferSize;
    public final Function<? super T, ? extends Publisher<? extends U>> mapper;
    public final Publisher<T> source;
    public final boolean delayErrors = false;
    public final int maxConcurrency = Integer.MAX_VALUE;

    public FlowableFlatMapPublisher(FlowableFromArray flowableFromArray, SingleInternalHelper$ToFlowable singleInternalHelper$ToFlowable, int r3) {
        this.source = flowableFromArray;
        this.mapper = singleInternalHelper$ToFlowable;
        this.bufferSize = r3;
    }

    @Override // io.reactivex.Flowable
    public final void subscribeActual(Subscriber<? super U> subscriber) {
        boolean z;
        Function<? super T, ? extends Publisher<? extends U>> function = this.mapper;
        Publisher<T> publisher = this.source;
        if (publisher instanceof Callable) {
            try {
                Manifest manifest = (Object) ((Callable) publisher).call();
                if (manifest == null) {
                    EmptySubscription.complete(subscriber);
                } else {
                    try {
                        Publisher<? extends U> apply = function.apply(manifest);
                        ObjectHelper.requireNonNull(apply, "The mapper returned a null Publisher");
                        Publisher<? extends U> publisher2 = apply;
                        if (publisher2 instanceof Callable) {
                            try {
                                Object call = ((Callable) publisher2).call();
                                if (call == null) {
                                    EmptySubscription.complete(subscriber);
                                } else {
                                    subscriber.onSubscribe(new ScalarSubscription(call, subscriber));
                                }
                            } catch (Throwable th) {
                                Exceptions.throwIfFatal(th);
                                EmptySubscription.error(th, subscriber);
                            }
                        } else {
                            publisher2.subscribe(subscriber);
                        }
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        EmptySubscription.error(th2, subscriber);
                    }
                }
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                EmptySubscription.error(th3, subscriber);
            }
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return;
        }
        publisher.subscribe(new FlowableFlatMap$MergeSubscriber(subscriber, this.mapper, this.delayErrors, this.maxConcurrency, this.bufferSize));
    }
}
