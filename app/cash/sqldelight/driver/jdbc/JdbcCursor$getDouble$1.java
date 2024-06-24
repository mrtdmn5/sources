package app.cash.sqldelight.driver.jdbc;

import java.sql.ResultSet;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: JdbcDriver.kt */
/* loaded from: classes.dex */
public /* synthetic */ class JdbcCursor$getDouble$1 extends FunctionReferenceImpl implements Function1<Integer, Double> {
    public JdbcCursor$getDouble$1(ResultSet resultSet) {
        super(1, resultSet, ResultSet.class, "getDouble", "getDouble(I)D", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Double invoke(Integer num) {
        return Double.valueOf(((ResultSet) this.receiver).getDouble(num.intValue()));
    }
}
