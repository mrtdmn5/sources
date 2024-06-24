package app.cash.sqldelight;

import app.cash.sqldelight.db.QueryResult;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: Transacter.kt */
/* loaded from: classes.dex */
public interface Transacter {

    /* compiled from: Transacter.kt */
    /* loaded from: classes.dex */
    public static abstract class Transaction {
        public boolean successful;
        public final long ownerThreadId = Thread.currentThread().getId();
        public final ArrayList postCommitHooks = new ArrayList();
        public final ArrayList postRollbackHooks = new ArrayList();
        public final LinkedHashSet registeredQueries = new LinkedHashSet();
        public final LinkedHashSet pendingTables = new LinkedHashSet();
        public boolean childrenSuccessful = true;

        public abstract QueryResult.Value endTransaction(boolean z);

        public final void endTransaction$runtime() {
            boolean z;
            boolean z2 = true;
            if (this.ownerThreadId == Thread.currentThread().getId()) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                if (!this.successful || !this.childrenSuccessful) {
                    z2 = false;
                }
                endTransaction(z2);
                return;
            }
            throw new IllegalStateException("Transaction objects (`TransactionWithReturn` and `TransactionWithoutReturn`) must be used\nonly within the transaction lambda scope.".toString());
        }

        public abstract Transaction getEnclosingTransaction();
    }

    void transaction(boolean z, Function1<? super TransactionWithoutReturn, Unit> function1);
}
