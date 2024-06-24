package org.slf4j;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.ServiceLoader;
import java.util.concurrent.LinkedBlockingQueue;
import org.slf4j.event.SubstituteLoggingEvent;
import org.slf4j.helpers.NOPLogger;
import org.slf4j.helpers.NOP_FallbackServiceProvider;
import org.slf4j.helpers.SubstituteLogger;
import org.slf4j.helpers.SubstituteLoggerFactory;
import org.slf4j.helpers.SubstituteServiceProvider;
import org.slf4j.helpers.Util;
import org.slf4j.spi.SLF4JServiceProvider;

/* loaded from: classes4.dex */
public final class LoggerFactory {
    public static final String[] API_COMPATIBILITY_LIST;
    public static final boolean DETECT_LOGGER_NAME_MISMATCH;
    public static volatile int INITIALIZATION_STATE;
    public static volatile SLF4JServiceProvider PROVIDER;
    public static final SubstituteServiceProvider SUBST_PROVIDER = new SubstituteServiceProvider();
    public static final NOP_FallbackServiceProvider NOP_FALLBACK_SERVICE_PROVIDER = new NOP_FallbackServiceProvider();

    static {
        String str;
        boolean equalsIgnoreCase;
        try {
            str = System.getProperty("slf4j.detectLoggerNameMismatch");
        } catch (SecurityException unused) {
            str = null;
        }
        if (str == null) {
            equalsIgnoreCase = false;
        } else {
            equalsIgnoreCase = str.equalsIgnoreCase("true");
        }
        DETECT_LOGGER_NAME_MISMATCH = equalsIgnoreCase;
        API_COMPATIBILITY_LIST = new String[]{"2.0"};
    }

    public static Logger getLogger(Class<?> cls) {
        int r4;
        Logger logger = getLogger(cls.getName());
        if (DETECT_LOGGER_NAME_MISMATCH) {
            Util.ClassContextSecurityManager classContextSecurityManager = Util.SECURITY_MANAGER;
            Class<?> cls2 = null;
            if (classContextSecurityManager == null) {
                if (Util.SECURITY_MANAGER_CREATION_ALREADY_ATTEMPTED) {
                    classContextSecurityManager = null;
                } else {
                    try {
                        classContextSecurityManager = new Util.ClassContextSecurityManager();
                    } catch (SecurityException unused) {
                        classContextSecurityManager = null;
                    }
                    Util.SECURITY_MANAGER = classContextSecurityManager;
                    Util.SECURITY_MANAGER_CREATION_ALREADY_ATTEMPTED = true;
                }
            }
            if (classContextSecurityManager != null) {
                Class<?>[] classContext = classContextSecurityManager.getClassContext();
                String name = Util.class.getName();
                int r42 = 0;
                while (r42 < classContext.length && !name.equals(classContext[r42].getName())) {
                    r42++;
                }
                if (r42 < classContext.length && (r4 = r42 + 2) < classContext.length) {
                    cls2 = classContext[r4];
                } else {
                    throw new IllegalStateException("Failed to find org.slf4j.helpers.Util or its caller in the stack; this should not happen");
                }
            }
            if (cls2 != null && (!cls2.isAssignableFrom(cls))) {
                Util.report(String.format("Detected logger name mismatch. Given name: \"%s\"; computed name: \"%s\".", logger.getName(), cls2.getName()));
                Util.report("See https://www.slf4j.org/codes.html#loggerNameMismatch for an explanation");
            }
        }
        return logger;
    }

    public static SLF4JServiceProvider getProvider() {
        if (INITIALIZATION_STATE == 0) {
            synchronized (LoggerFactory.class) {
                if (INITIALIZATION_STATE == 0) {
                    INITIALIZATION_STATE = 1;
                    performInitialization();
                }
            }
        }
        int r0 = INITIALIZATION_STATE;
        if (r0 != 1) {
            if (r0 != 2) {
                if (r0 != 3) {
                    if (r0 == 4) {
                        return NOP_FALLBACK_SERVICE_PROVIDER;
                    }
                    throw new IllegalStateException("Unreachable code");
                }
                return PROVIDER;
            }
            throw new IllegalStateException("org.slf4j.LoggerFactory in failed state. Original exception was thrown EARLIER. See also https://www.slf4j.org/codes.html#unsuccessfulInit");
        }
        return SUBST_PROVIDER;
    }

    public static final void performInitialization() {
        Enumeration<URL> resources;
        boolean z;
        try {
            ServiceLoader load = ServiceLoader.load(SLF4JServiceProvider.class);
            ArrayList arrayList = new ArrayList();
            Iterator it = load.iterator();
            while (it.hasNext()) {
                arrayList.add((SLF4JServiceProvider) it.next());
            }
            reportMultipleBindingAmbiguity(arrayList);
            if (!arrayList.isEmpty()) {
                PROVIDER = (SLF4JServiceProvider) arrayList.get(0);
                PROVIDER.initialize();
                INITIALIZATION_STATE = 3;
                if (!arrayList.isEmpty()) {
                    if (arrayList.size() > 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        Util.report("Actual provider is of type [" + arrayList.get(0) + "]");
                    }
                }
            } else {
                INITIALIZATION_STATE = 4;
                Util.report("No SLF4J providers were found.");
                Util.report("Defaulting to no-operation (NOP) logger implementation");
                Util.report("See https://www.slf4j.org/codes.html#noProviders for further details.");
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                try {
                    ClassLoader classLoader = LoggerFactory.class.getClassLoader();
                    if (classLoader == null) {
                        resources = ClassLoader.getSystemResources("org/slf4j/impl/StaticLoggerBinder.class");
                    } else {
                        resources = classLoader.getResources("org/slf4j/impl/StaticLoggerBinder.class");
                    }
                    while (resources.hasMoreElements()) {
                        linkedHashSet.add(resources.nextElement());
                    }
                } catch (IOException e) {
                    System.err.println("Error getting resources from path");
                    System.err.println("Reported exception:");
                    e.printStackTrace();
                }
                reportIgnoredStaticLoggerBinders(linkedHashSet);
            }
            postBindCleanUp();
            if (INITIALIZATION_STATE == 3) {
                try {
                    String requestedApiVersion = PROVIDER.getRequestedApiVersion();
                    boolean z2 = false;
                    for (String str : API_COMPATIBILITY_LIST) {
                        if (requestedApiVersion.startsWith(str)) {
                            z2 = true;
                        }
                    }
                    if (!z2) {
                        Util.report("The requested version " + requestedApiVersion + " by your slf4j binding is not compatible with " + Arrays.asList(API_COMPATIBILITY_LIST).toString());
                        Util.report("See https://www.slf4j.org/codes.html#version_mismatch for further details.");
                    }
                } catch (NoSuchFieldError unused) {
                } catch (Throwable th) {
                    System.err.println("Unexpected problem occured during version sanity check");
                    System.err.println("Reported exception:");
                    th.printStackTrace();
                }
            }
        } catch (Exception e2) {
            INITIALIZATION_STATE = 2;
            System.err.println("Failed to instantiate SLF4J LoggerFactory");
            System.err.println("Reported exception:");
            e2.printStackTrace();
            throw new IllegalStateException("Unexpected initialization failure", e2);
        }
    }

    public static void postBindCleanUp() {
        boolean z;
        SubstituteServiceProvider substituteServiceProvider = SUBST_PROVIDER;
        synchronized (substituteServiceProvider) {
            substituteServiceProvider.loggerFactory.postInitialization = true;
            SubstituteLoggerFactory substituteLoggerFactory = substituteServiceProvider.loggerFactory;
            substituteLoggerFactory.getClass();
            Iterator it = new ArrayList(substituteLoggerFactory.loggers.values()).iterator();
            while (it.hasNext()) {
                SubstituteLogger substituteLogger = (SubstituteLogger) it.next();
                substituteLogger._delegate = getLogger(substituteLogger.name);
            }
        }
        LinkedBlockingQueue<SubstituteLoggingEvent> linkedBlockingQueue = SUBST_PROVIDER.loggerFactory.eventQueue;
        int size = linkedBlockingQueue.size();
        ArrayList arrayList = new ArrayList(128);
        int r0 = 0;
        while (linkedBlockingQueue.drainTo(arrayList, 128) != 0) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                SubstituteLoggingEvent substituteLoggingEvent = (SubstituteLoggingEvent) it2.next();
                if (substituteLoggingEvent != null) {
                    SubstituteLogger substituteLogger2 = substituteLoggingEvent.logger;
                    String str = substituteLogger2.name;
                    if (substituteLogger2._delegate == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        if (!(substituteLogger2._delegate instanceof NOPLogger)) {
                            if (substituteLogger2.isDelegateEventAware()) {
                                if (substituteLogger2.isDelegateEventAware()) {
                                    try {
                                        substituteLogger2.logMethodCache.invoke(substituteLogger2._delegate, substituteLoggingEvent);
                                    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
                                    }
                                }
                            } else {
                                Util.report(str);
                            }
                        }
                    } else {
                        throw new IllegalStateException("Delegate logger cannot be null at this state.");
                    }
                }
                int r9 = r0 + 1;
                if (r0 == 0) {
                    if (substituteLoggingEvent.logger.isDelegateEventAware()) {
                        Util.report("A number (" + size + ") of logging calls during the initialization phase have been intercepted and are");
                        Util.report("now being replayed. These are subject to the filtering rules of the underlying logging system.");
                        Util.report("See also https://www.slf4j.org/codes.html#replay");
                    } else if (!(substituteLoggingEvent.logger._delegate instanceof NOPLogger)) {
                        Util.report("The following set of substitute loggers may have been accessed");
                        Util.report("during the initialization phase. Logging calls during this");
                        Util.report("phase were not honored. However, subsequent logging calls to these");
                        Util.report("loggers will work as normally expected.");
                        Util.report("See also https://www.slf4j.org/codes.html#substituteLogger");
                    }
                }
                r0 = r9;
            }
            arrayList.clear();
        }
        SubstituteLoggerFactory substituteLoggerFactory2 = SUBST_PROVIDER.loggerFactory;
        substituteLoggerFactory2.loggers.clear();
        substituteLoggerFactory2.eventQueue.clear();
    }

    public static void reportIgnoredStaticLoggerBinders(LinkedHashSet linkedHashSet) {
        if (linkedHashSet.isEmpty()) {
            return;
        }
        Util.report("Class path contains SLF4J bindings targeting slf4j-api versions 1.7.x or earlier.");
        Iterator it = linkedHashSet.iterator();
        while (it.hasNext()) {
            Util.report("Ignoring binding found at [" + ((URL) it.next()) + "]");
        }
        Util.report("See https://www.slf4j.org/codes.html#ignoredBindings for an explanation.");
    }

    public static void reportMultipleBindingAmbiguity(ArrayList arrayList) {
        boolean z = true;
        if (arrayList.size() <= 1) {
            z = false;
        }
        if (z) {
            Util.report("Class path contains multiple SLF4J providers.");
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Util.report("Found provider [" + ((SLF4JServiceProvider) it.next()) + "]");
            }
            Util.report("See https://www.slf4j.org/codes.html#multiple_bindings for an explanation.");
        }
    }

    public static Logger getLogger(String str) {
        return getProvider().getLoggerFactory().getLogger(str);
    }
}
