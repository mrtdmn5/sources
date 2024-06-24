package io.reactivex.internal.subscriptions;

import androidx.profileinstaller.FileSectionType$$ExternalSyntheticOutline0;
import io.reactivex.exceptions.ProtocolViolationException;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* loaded from: classes.dex */
public enum SubscriptionHelper implements Subscription {
    CANCELLED;

    public static void deferredRequest(AtomicReference<Subscription> atomicReference, AtomicLong atomicLong, long j) {
        Subscription subscription = atomicReference.get();
        if (subscription != null) {
            subscription.request(j);
            return;
        }
        if (validate(j)) {
            BackpressureHelper.add(atomicLong, j);
            Subscription subscription2 = atomicReference.get();
            if (subscription2 != null) {
                long andSet = atomicLong.getAndSet(0L);
                if (andSet != 0) {
                    subscription2.request(andSet);
                }
            }
        }
    }

    public static boolean deferredSetOnce(AtomicReference<Subscription> atomicReference, AtomicLong atomicLong, Subscription subscription) {
        if (setOnce(atomicReference, subscription)) {
            long andSet = atomicLong.getAndSet(0L);
            if (andSet != 0) {
                subscription.request(andSet);
                return true;
            }
            return true;
        }
        return false;
    }

    public static boolean replace(AtomicReference<Subscription> atomicReference, Subscription subscription) {
        boolean z;
        do {
            Subscription subscription2 = atomicReference.get();
            z = false;
            if (subscription2 == CANCELLED) {
                if (subscription != null) {
                    subscription.cancel();
                }
                return false;
            }
            while (true) {
                if (atomicReference.compareAndSet(subscription2, subscription)) {
                    z = true;
                    break;
                }
                if (atomicReference.get() != subscription2) {
                    break;
                }
            }
        } while (!z);
        return true;
    }

    public static void reportMoreProduced(long j) {
        RxJavaPlugins.onError(new ProtocolViolationException(FileSectionType$$ExternalSyntheticOutline0.m("More produced than requested: ", j)));
    }

    public static void reportSubscriptionSet() {
        RxJavaPlugins.onError(new ProtocolViolationException("Subscription already set!"));
    }

    public static boolean set(AtomicReference<Subscription> atomicReference, Subscription subscription) {
        Subscription subscription2;
        boolean z;
        do {
            subscription2 = atomicReference.get();
            z = false;
            if (subscription2 == CANCELLED) {
                if (subscription != null) {
                    subscription.cancel();
                }
                return false;
            }
            while (true) {
                if (atomicReference.compareAndSet(subscription2, subscription)) {
                    z = true;
                    break;
                }
                if (atomicReference.get() != subscription2) {
                    break;
                }
            }
        } while (!z);
        if (subscription2 != null) {
            subscription2.cancel();
        }
        return true;
    }

    public static boolean setOnce(AtomicReference<Subscription> atomicReference, Subscription subscription) {
        boolean z;
        if (subscription == null) {
            throw new NullPointerException("s is null");
        }
        while (true) {
            if (atomicReference.compareAndSet(null, subscription)) {
                z = true;
                break;
            }
            if (atomicReference.get() != null) {
                z = false;
                break;
            }
        }
        if (z) {
            return true;
        }
        subscription.cancel();
        if (atomicReference.get() != CANCELLED) {
            reportSubscriptionSet();
        }
        return false;
    }

    public static boolean validate(Subscription subscription, Subscription subscription2) {
        if (subscription2 == null) {
            RxJavaPlugins.onError(new NullPointerException("next is null"));
            return false;
        }
        if (subscription == null) {
            return true;
        }
        subscription2.cancel();
        reportSubscriptionSet();
        return false;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
    }

    public static boolean cancel(AtomicReference<Subscription> atomicReference) {
        Subscription andSet;
        Subscription subscription = atomicReference.get();
        SubscriptionHelper subscriptionHelper = CANCELLED;
        if (subscription == subscriptionHelper || (andSet = atomicReference.getAndSet(subscriptionHelper)) == subscriptionHelper) {
            return false;
        }
        if (andSet == null) {
            return true;
        }
        andSet.cancel();
        return true;
    }

    public static boolean validate(long j) {
        if (j > 0) {
            return true;
        }
        RxJavaPlugins.onError(new IllegalArgumentException(FileSectionType$$ExternalSyntheticOutline0.m("n > 0 required but it was ", j)));
        return false;
    }

    public static boolean setOnce(AtomicReference<Subscription> atomicReference, Subscription subscription, long j) {
        if (!setOnce(atomicReference, subscription)) {
            return false;
        }
        subscription.request(j);
        return true;
    }

    @Override // org.reactivestreams.Subscription
    public void request(long j) {
    }
}
