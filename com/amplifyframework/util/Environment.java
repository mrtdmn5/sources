package com.amplifyframework.util;

import java.util.Arrays;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class Environment {
    private Environment() {
    }

    public static boolean isJUnitTest() {
        Iterator it = Arrays.asList(Thread.currentThread().getStackTrace()).iterator();
        while (it.hasNext()) {
            if (((StackTraceElement) it.next()).getClassName().startsWith("org.junit.")) {
                return true;
            }
        }
        return false;
    }
}
