package app.cash.sqldelight.driver.jdbc;

import java.sql.ResultSet;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: JdbcDriver.kt */
/* loaded from: classes.dex */
public /* synthetic */ class JdbcCursor$getBoolean$1 extends FunctionReferenceImpl implements Function1<Integer, Boolean> {
    public JdbcCursor$getBoolean$1(ResultSet resultSet) {
        super(1, resultSet, ResultSet.class, "getBoolean", "getBoolean(I)Z", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(Integer num) {
        return Boolean.valueOf(((ResultSet) this.receiver).getBoolean(num.intValue()));
    }
}
