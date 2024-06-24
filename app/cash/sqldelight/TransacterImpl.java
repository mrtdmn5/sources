package app.cash.sqldelight;

import app.cash.sqldelight.Transacter;
import app.cash.sqldelight.db.SqlDriver;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Transacter.kt */
/* loaded from: classes.dex */
public abstract class TransacterImpl extends BaseTransacterImpl implements Transacter {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TransacterImpl(SqlDriver driver) {
        super(driver);
        Intrinsics.checkNotNullParameter(driver, "driver");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <R> R transactionWithWrapper(boolean z, Function1<? super TransactionWrapper<R>, ? extends R> function1) {
        boolean z2;
        R r;
        Transacter.Transaction transaction = (Transacter.Transaction) getDriver().newTransaction().value;
        Transacter.Transaction enclosingTransaction = transaction.getEnclosingTransaction();
        if (enclosingTransaction != null && z) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            Throwable th = null;
            try {
                r = function1.invoke(new TransactionWrapper(transaction));
                try {
                    transaction.successful = true;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                r = null;
                th = th3;
            }
            transaction.endTransaction$runtime();
            return (R) postTransactionCleanup(transaction, enclosingTransaction, th, r);
        }
        throw new IllegalStateException("Already in a transaction".toString());
    }

    @Override // app.cash.sqldelight.Transacter
    public void transaction(boolean z, Function1<? super TransactionWithoutReturn, Unit> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        transactionWithWrapper(z, body);
    }

    public <R> R transactionWithResult(boolean z, Function1<Object, ? extends R> bodyWithReturn) {
        Intrinsics.checkNotNullParameter(bodyWithReturn, "bodyWithReturn");
        return (R) transactionWithWrapper(z, bodyWithReturn);
    }
}
