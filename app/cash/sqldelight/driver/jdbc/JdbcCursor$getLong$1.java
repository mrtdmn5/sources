package app.cash.sqldelight.driver.jdbc;

import java.sql.ResultSet;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: JdbcDriver.kt */
/* loaded from: classes.dex */
public /* synthetic */ class JdbcCursor$getLong$1 extends FunctionReferenceImpl implements Function1<Integer, Long> {
    public JdbcCursor$getLong$1(ResultSet resultSet) {
        super(1, resultSet, ResultSet.class, "getLong", "getLong(I)J", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Long invoke(Integer num) {
        return Long.valueOf(((ResultSet) this.receiver).getLong(num.intValue()));
    }
}
