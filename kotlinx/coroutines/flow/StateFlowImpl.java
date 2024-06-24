package kotlinx.coroutines.flow;

import com.google.android.gms.measurement.internal.zzgp;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import kotlinx.coroutines.flow.internal.ChannelFlowOperatorImpl;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import kotlinx.coroutines.internal.Symbol;

/* compiled from: StateFlow.kt */
/* loaded from: classes4.dex */
public final class StateFlowImpl<T> extends AbstractSharedFlow<StateFlowSlot> implements MutableStateFlow<T>, Flow, FusibleFlow<T> {
    public static final AtomicReferenceFieldUpdater _state$FU = AtomicReferenceFieldUpdater.newUpdater(StateFlowImpl.class, Object.class, "_state");
    private volatile Object _state;
    public int sequence;

    public StateFlowImpl(Object obj) {
        this._state = obj;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00ac, code lost:            if (kotlin.jvm.internal.Intrinsics.areEqual(r0, r2) != false) goto L137;     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0092, code lost:            if (kotlin.Unit.INSTANCE == r4) goto L155;     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0092, code lost:            if (0 == 0) goto L142;     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x009a A[Catch: all -> 0x005f, TryCatch #1 {all -> 0x005f, blocks: (B:13:0x003a, B:14:0x0092, B:16:0x009a, B:19:0x00a1, B:20:0x00a5, B:24:0x00a8, B:26:0x00c9, B:30:0x00e1, B:31:0x00f9, B:37:0x010b, B:38:0x0110, B:43:0x0119, B:33:0x0103, B:50:0x00ae, B:53:0x00b5, B:61:0x0050, B:63:0x005b, B:64:0x0083), top: B:7:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00c7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002a  */
    @Override // kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object collect(kotlinx.coroutines.flow.FlowCollector<? super T> r18, kotlin.coroutines.Continuation<?> r19) {
        /*
            Method dump skipped, instructions count: 294
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.StateFlowImpl.collect(kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlinx.coroutines.internal.Symbol] */
    @Override // kotlinx.coroutines.flow.MutableStateFlow
    public final boolean compareAndSet(T t, T t2) {
        ?? r0 = zzgp.NULL;
        if (t == null) {
            t = r0;
        }
        if (t2 == null) {
            t2 = r0;
        }
        return updateState(t, t2);
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    public final StateFlowSlot createSlot() {
        return new StateFlowSlot();
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    public final AbstractSharedFlowSlot[] createSlotArray() {
        return new StateFlowSlot[2];
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow, kotlinx.coroutines.flow.FlowCollector
    public final Object emit(T t, Continuation<? super Unit> continuation) {
        setValue(t);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    public final Flow<T> fuse(CoroutineContext coroutineContext, int r3, BufferOverflow bufferOverflow) {
        boolean z;
        if (r3 >= 0 && r3 < 2) {
            z = true;
        } else {
            z = false;
        }
        if (((z || r3 == -2) && bufferOverflow == BufferOverflow.DROP_OLDEST) || ((r3 == 0 || r3 == -3) && bufferOverflow == BufferOverflow.SUSPEND)) {
            return this;
        }
        return new ChannelFlowOperatorImpl(r3, coroutineContext, bufferOverflow, this);
    }

    @Override // kotlinx.coroutines.flow.MutableStateFlow, kotlinx.coroutines.flow.StateFlow
    public final T getValue() {
        Symbol symbol = zzgp.NULL;
        T t = (T) _state$FU.get(this);
        if (t == symbol) {
            return null;
        }
        return t;
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public final void resetReplayCache() {
        throw new UnsupportedOperationException("MutableStateFlow.resetReplayCache is not supported");
    }

    @Override // kotlinx.coroutines.flow.MutableStateFlow
    public final void setValue(T t) {
        if (t == null) {
            t = (T) zzgp.NULL;
        }
        updateState(null, t);
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public final boolean tryEmit(T t) {
        setValue(t);
        return true;
    }

    public final boolean updateState(Object obj, Object obj2) {
        int r12;
        Object obj3;
        Symbol symbol;
        boolean z;
        boolean z2;
        synchronized (this) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$FU;
            Object obj4 = atomicReferenceFieldUpdater.get(this);
            if (obj != null && !Intrinsics.areEqual(obj4, obj)) {
                return false;
            }
            if (Intrinsics.areEqual(obj4, obj2)) {
                return true;
            }
            atomicReferenceFieldUpdater.set(this, obj2);
            int r11 = this.sequence;
            if ((r11 & 1) == 0) {
                int r112 = r11 + 1;
                this.sequence = r112;
                Object obj5 = this.slots;
                Unit unit = Unit.INSTANCE;
                while (true) {
                    StateFlowSlot[] stateFlowSlotArr = (StateFlowSlot[]) obj5;
                    if (stateFlowSlotArr != null) {
                        for (StateFlowSlot stateFlowSlot : stateFlowSlotArr) {
                            if (stateFlowSlot != null) {
                                while (true) {
                                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = StateFlowSlot._state$FU;
                                    Object obj6 = atomicReferenceFieldUpdater2.get(stateFlowSlot);
                                    if (obj6 != null && obj6 != (symbol = StateFlowKt.PENDING)) {
                                        Symbol symbol2 = StateFlowKt.NONE;
                                        if (obj6 == symbol2) {
                                            while (true) {
                                                if (atomicReferenceFieldUpdater2.compareAndSet(stateFlowSlot, obj6, symbol)) {
                                                    z = true;
                                                    break;
                                                }
                                                if (atomicReferenceFieldUpdater2.get(stateFlowSlot) != obj6) {
                                                    z = false;
                                                    break;
                                                }
                                            }
                                            if (z) {
                                                break;
                                            }
                                        } else {
                                            while (true) {
                                                if (atomicReferenceFieldUpdater2.compareAndSet(stateFlowSlot, obj6, symbol2)) {
                                                    z2 = true;
                                                    break;
                                                }
                                                if (atomicReferenceFieldUpdater2.get(stateFlowSlot) != obj6) {
                                                    z2 = false;
                                                    break;
                                                }
                                            }
                                            if (z2) {
                                                ((CancellableContinuationImpl) obj6).resumeWith(Unit.INSTANCE);
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    synchronized (this) {
                        r12 = this.sequence;
                        if (r12 == r112) {
                            this.sequence = r112 + 1;
                            return true;
                        }
                        obj3 = this.slots;
                        Unit unit2 = Unit.INSTANCE;
                    }
                    obj5 = obj3;
                    r112 = r12;
                }
            } else {
                this.sequence = r11 + 2;
                return true;
            }
        }
    }
}
