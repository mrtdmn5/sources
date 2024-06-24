package app.cash.sqldelight;

import app.cash.sqldelight.Transacter;
import app.cash.sqldelight.db.SqlDriver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Transacter.kt */
/* loaded from: classes.dex */
public abstract class BaseTransacterImpl {
    private final SqlDriver driver;

    public BaseTransacterImpl(SqlDriver driver) {
        Intrinsics.checkNotNullParameter(driver, "driver");
        this.driver = driver;
    }

    public final String createArguments(int r4) {
        if (r4 == 0) {
            return "()";
        }
        StringBuilder sb = new StringBuilder(r4 + 2);
        sb.append("(?");
        int r42 = r4 - 1;
        for (int r0 = 0; r0 < r42; r0++) {
            sb.append(",?");
        }
        sb.append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    public final SqlDriver getDriver() {
        return this.driver;
    }

    public final void notifyQueries(int r3, Function1<? super Function1<? super String, Unit>, Unit> tableProvider) {
        Intrinsics.checkNotNullParameter(tableProvider, "tableProvider");
        final Transacter.Transaction currentTransaction = this.driver.currentTransaction();
        if (currentTransaction != null) {
            if (currentTransaction.registeredQueries.add(Integer.valueOf(r3))) {
                tableProvider.invoke(new Function1<String, Unit>() { // from class: app.cash.sqldelight.BaseTransacterImpl$notifyQueries$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(String str) {
                        String it = str;
                        Intrinsics.checkNotNullParameter(it, "it");
                        Transacter.Transaction.this.pendingTables.add(it);
                        return Unit.INSTANCE;
                    }
                });
            }
        } else {
            final LinkedHashSet linkedHashSet = new LinkedHashSet();
            tableProvider.invoke(new Function1<String, Unit>() { // from class: app.cash.sqldelight.BaseTransacterImpl$notifyQueries$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(String str) {
                    String it = str;
                    Intrinsics.checkNotNullParameter(it, "it");
                    linkedHashSet.add(it);
                    return Unit.INSTANCE;
                }
            });
            SqlDriver sqlDriver = this.driver;
            String[] strArr = (String[]) linkedHashSet.toArray(new String[0]);
            sqlDriver.notifyListeners((String[]) Arrays.copyOf(strArr, strArr.length));
        }
    }

    public final <R> R postTransactionCleanup(Transacter.Transaction transaction, Transacter.Transaction transaction2, Throwable th, R r) {
        Intrinsics.checkNotNullParameter(transaction, "transaction");
        LinkedHashSet linkedHashSet = transaction.registeredQueries;
        ArrayList arrayList = transaction.postCommitHooks;
        ArrayList arrayList2 = transaction.postRollbackHooks;
        LinkedHashSet linkedHashSet2 = transaction.pendingTables;
        boolean z = true;
        if (transaction2 == null) {
            if (transaction.successful && transaction.childrenSuccessful) {
                if (!linkedHashSet2.isEmpty()) {
                    SqlDriver sqlDriver = this.driver;
                    String[] strArr = (String[]) linkedHashSet2.toArray(new String[0]);
                    sqlDriver.notifyListeners((String[]) Arrays.copyOf(strArr, strArr.length));
                }
                linkedHashSet2.clear();
                linkedHashSet.clear();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((Function0) it.next()).invoke();
                }
                arrayList.clear();
            } else {
                try {
                    Iterator it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        ((Function0) it2.next()).invoke();
                    }
                    arrayList2.clear();
                } catch (Throwable th2) {
                    if (th != null) {
                        throw new Throwable("Exception while rolling back from an exception.\nOriginal exception: " + th + "\nwith cause " + th.getCause() + "\n\nRollback exception: " + th2, th2);
                    }
                    throw th2;
                }
            }
        } else {
            if (!transaction.successful || !transaction.childrenSuccessful) {
                z = false;
            }
            transaction2.childrenSuccessful = z;
            transaction2.postCommitHooks.addAll(arrayList);
            transaction2.postRollbackHooks.addAll(arrayList2);
            transaction2.registeredQueries.addAll(linkedHashSet);
            transaction2.pendingTables.addAll(linkedHashSet2);
        }
        if (transaction2 == null && (th instanceof RollbackException)) {
            return (R) ((RollbackException) th).value;
        }
        if (th == null) {
            return r;
        }
        throw th;
    }
}
