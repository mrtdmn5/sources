package kotlinx.coroutines.selects;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.channels.BufferedChannel$onUndeliveredElementReceiveCancellationConstructor$1$1;
import kotlinx.coroutines.channels.ReceiveChannel;

/* compiled from: Select.kt */
/* loaded from: classes4.dex */
public final class SelectClause1Impl<Q> implements SelectClause1<Q> {
    public final Object clauseObject;
    public final Function3<SelectInstance<?>, Object, Object, Function1<Throwable, Unit>> onCancellationConstructor;
    public final Function3<Object, Object, Object, Object> processResFunc;
    public final Function3<Object, SelectInstance<?>, Object, Unit> regFunc;

    public SelectClause1Impl(ReceiveChannel receiveChannel, Function3 function3, Function3 function32, BufferedChannel$onUndeliveredElementReceiveCancellationConstructor$1$1 bufferedChannel$onUndeliveredElementReceiveCancellationConstructor$1$1) {
        this.clauseObject = receiveChannel;
        this.regFunc = function3;
        this.processResFunc = function32;
        this.onCancellationConstructor = bufferedChannel$onUndeliveredElementReceiveCancellationConstructor$1$1;
    }

    @Override // kotlinx.coroutines.selects.SelectClause
    public final Object getClauseObject() {
        return this.clauseObject;
    }

    @Override // kotlinx.coroutines.selects.SelectClause
    public final Function3<SelectInstance<?>, Object, Object, Function1<Throwable, Unit>> getOnCancellationConstructor() {
        return this.onCancellationConstructor;
    }

    @Override // kotlinx.coroutines.selects.SelectClause
    public final Function3<Object, Object, Object, Object> getProcessResFunc() {
        return this.processResFunc;
    }

    @Override // kotlinx.coroutines.selects.SelectClause
    public final Function3<Object, SelectInstance<?>, Object, Unit> getRegFunc() {
        return this.regFunc;
    }
}
