package org.slf4j.helpers;

/* loaded from: classes4.dex */
public final class Util {
    public static ClassContextSecurityManager SECURITY_MANAGER = null;
    public static boolean SECURITY_MANAGER_CREATION_ALREADY_ATTEMPTED = false;

    /* loaded from: classes4.dex */
    public static final class ClassContextSecurityManager extends SecurityManager {
        @Override // java.lang.SecurityManager
        public final Class<?>[] getClassContext() {
            return super.getClassContext();
        }
    }

    public static final void report(String str) {
        System.err.println("SLF4J: " + str);
    }
}
