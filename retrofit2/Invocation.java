package retrofit2;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public final class Invocation {
    public final List<?> arguments;
    public final Method method;

    public Invocation(Method method, ArrayList arrayList) {
        this.method = method;
        this.arguments = Collections.unmodifiableList(arrayList);
    }

    public final String toString() {
        Method method = this.method;
        return String.format("%s.%s() %s", method.getDeclaringClass().getName(), method.getName(), this.arguments);
    }
}
