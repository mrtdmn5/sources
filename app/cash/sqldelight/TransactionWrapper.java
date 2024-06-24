package app.cash.sqldelight;

import app.cash.sqldelight.Transacter;

/* compiled from: Transacter.kt */
/* loaded from: classes.dex */
public final class TransactionWrapper<R> implements TransactionWithoutReturn {
    public final Transacter.Transaction transaction;

    public TransactionWrapper(Transacter.Transaction transaction) {
        this.transaction = transaction;
    }

    @Override // app.cash.sqldelight.TransactionWithoutReturn
    public final Void rollback() {
        boolean z;
        Transacter.Transaction transaction = this.transaction;
        transaction.getClass();
        if (transaction.ownerThreadId == Thread.currentThread().getId()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            throw new RollbackException(0);
        }
        throw new IllegalStateException("Transaction objects (`TransactionWithReturn` and `TransactionWithoutReturn`) must be used\nonly within the transaction lambda scope.".toString());
    }
}
