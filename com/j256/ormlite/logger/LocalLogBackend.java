package com.j256.ormlite.logger;

import com.google.android.gms.internal.measurement.zzav$$ExternalSyntheticOutline0;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public final class LocalLogBackend implements LogBackend {
    public static final ArrayList classLevels;
    public static PrintStream printStream;
    public final String className;
    public final Level level;
    public static final Level DEFAULT_LEVEL = Level.DEBUG;
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");

    /* loaded from: classes3.dex */
    public static class LocalLogBackendFactory implements LogBackendFactory {
        @Override // com.j256.ormlite.logger.LogBackendFactory
        public final LogBackend createLogBackend(String str) {
            return new LocalLogBackend(str);
        }
    }

    /* loaded from: classes3.dex */
    public static class PatternLevel {
        public final Level level;
        public final Pattern pattern;

        public PatternLevel(Pattern pattern, Level level) {
            this.pattern = pattern;
            this.level = level;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0048  */
    static {
        /*
            com.j256.ormlite.logger.Level r0 = com.j256.ormlite.logger.Level.DEBUG
            com.j256.ormlite.logger.LocalLogBackend.DEFAULT_LEVEL = r0
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            java.lang.String r1 = "yyyy-MM-dd HH:mm:ss,SSS"
            r0.<init>(r1)
            com.j256.ormlite.logger.LocalLogBackend.DATE_FORMAT = r0
            java.lang.Class<com.j256.ormlite.logger.LocalLogBackend> r0 = com.j256.ormlite.logger.LocalLogBackend.class
            java.lang.String r1 = "/ormliteLocalLog.properties"
            java.io.InputStream r0 = r0.getResourceAsStream(r1)
            java.lang.String r1 = "IO exception reading the log properties file '/ormliteLocalLog.properties': "
            if (r0 == 0) goto L3d
            java.util.ArrayList r1 = configureClassLevels(r0)     // Catch: java.lang.Throwable -> L21 java.io.IOException -> L23
            r0.close()     // Catch: java.io.IOException -> L3e
            goto L3e
        L21:
            r1 = move-exception
            goto L39
        L23:
            r2 = move-exception
            java.io.PrintStream r3 = java.lang.System.err     // Catch: java.lang.Throwable -> L21
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L21
            r4.<init>(r1)     // Catch: java.lang.Throwable -> L21
            r4.append(r2)     // Catch: java.lang.Throwable -> L21
            java.lang.String r1 = r4.toString()     // Catch: java.lang.Throwable -> L21
            r3.println(r1)     // Catch: java.lang.Throwable -> L21
            r0.close()     // Catch: java.io.IOException -> L3d
            goto L3d
        L39:
            r0.close()     // Catch: java.io.IOException -> L3c
        L3c:
            throw r1
        L3d:
            r1 = 0
        L3e:
            com.j256.ormlite.logger.LocalLogBackend.classLevels = r1
            java.lang.String r0 = "com.j256.simplelogging.file"
            java.lang.String r0 = java.lang.System.getProperty(r0)
            if (r0 != 0) goto L4d
            java.io.PrintStream r0 = java.lang.System.out
            com.j256.ormlite.logger.LocalLogBackend.printStream = r0
            goto L59
        L4d:
            java.io.PrintStream r1 = new java.io.PrintStream     // Catch: java.io.FileNotFoundException -> L5a
            java.io.File r2 = new java.io.File     // Catch: java.io.FileNotFoundException -> L5a
            r2.<init>(r0)     // Catch: java.io.FileNotFoundException -> L5a
            r1.<init>(r2)     // Catch: java.io.FileNotFoundException -> L5a
            com.j256.ormlite.logger.LocalLogBackend.printStream = r1     // Catch: java.io.FileNotFoundException -> L5a
        L59:
            return
        L5a:
            r1 = move-exception
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Log file "
            java.lang.String r4 = " was not found"
            java.lang.String r0 = com.google.android.gms.internal.measurement.zzav$$ExternalSyntheticOutline0.m(r3, r0, r4)
            r2.<init>(r0, r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.logger.LocalLogBackend.<clinit>():void");
    }

    public LocalLogBackend(String str) {
        String str2;
        Level valueOf;
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf >= 0 && lastIndexOf != str.length() - 1) {
            str2 = str.substring(lastIndexOf + 1);
        } else {
            str2 = str;
        }
        this.className = str2;
        ArrayList<PatternLevel> arrayList = classLevels;
        Level level = null;
        if (arrayList != null) {
            for (PatternLevel patternLevel : arrayList) {
                if (patternLevel.pattern.matcher(str).matches()) {
                    Level level2 = patternLevel.level;
                    if (level == null || level2.ordinal() < level.ordinal()) {
                        level = level2;
                    }
                }
            }
        }
        if (level == null) {
            String property = System.getProperty("com.j256.simplelogging.level");
            if (property == null) {
                level = DEFAULT_LEVEL;
            } else {
                try {
                    try {
                        valueOf = Level.valueOf(property.toUpperCase());
                    } catch (IllegalArgumentException unused) {
                        valueOf = Level.valueOf(property.toUpperCase(Locale.ENGLISH));
                    }
                    level = valueOf;
                } catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException(zzav$$ExternalSyntheticOutline0.m("Level '", property, "' was not found"), e);
                }
            }
        }
        this.level = level;
    }

    public static ArrayList configureClassLevels(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        ArrayList arrayList = new ArrayList();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return arrayList;
            }
            if (readLine.length() != 0 && readLine.charAt(0) != '#') {
                String[] split = readLine.split("=");
                if (split.length != 2) {
                    System.err.println("Line is not in the format of 'pattern = level': ".concat(readLine));
                } else {
                    try {
                        arrayList.add(new PatternLevel(Pattern.compile(split[0].trim()), Level.valueOf(split[1].trim())));
                    } catch (IllegalArgumentException unused) {
                        System.err.println("Level '" + split[1] + "' was not found");
                    }
                }
            }
        }
    }

    @Override // com.j256.ormlite.logger.LogBackend
    public final boolean isLevelEnabled(Level level) {
        return this.level.isEnabled(level);
    }

    @Override // com.j256.ormlite.logger.LogBackend
    public final void log(Level level, String str) {
        printMessage(level, str, null);
    }

    public final void printMessage(Level level, String str, Exception exc) {
        if (!isLevelEnabled(level)) {
            return;
        }
        StringBuilder sb = new StringBuilder(128);
        sb.append(((DateFormat) DATE_FORMAT.clone()).format(new Date()));
        sb.append(" [");
        sb.append(level.name());
        sb.append("] ");
        sb.append(this.className);
        sb.append(' ');
        sb.append(str);
        printStream.println(sb.toString());
        if (exc != null) {
            exc.printStackTrace(printStream);
        }
    }

    @Override // com.j256.ormlite.logger.LogBackend
    public final void log(Level level, String str, Exception exc) {
        printMessage(level, str, exc);
    }
}
