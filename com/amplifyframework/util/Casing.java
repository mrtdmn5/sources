package com.amplifyframework.util;

import java.util.Locale;
import java.util.Objects;

/* loaded from: classes.dex */
public final class Casing {

    /* renamed from: com.amplifyframework.util.Casing$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$amplifyframework$util$Casing$CaseType;

        static {
            int[] r0 = new int[CaseType.values().length];
            $SwitchMap$com$amplifyframework$util$Casing$CaseType = r0;
            try {
                r0[CaseType.SCREAMING_SNAKE_CASE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$amplifyframework$util$Casing$CaseType[CaseType.CAMEL_CASE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$amplifyframework$util$Casing$CaseType[CaseType.PASCAL_CASE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes.dex */
    public enum CaseType {
        SCREAMING_SNAKE_CASE,
        CAMEL_CASE,
        PASCAL_CASE
    }

    /* loaded from: classes.dex */
    public static final class CasingSource {
        private final CaseType sourceCasing;

        public /* synthetic */ CasingSource(CaseType caseType, AnonymousClass1 anonymousClass1) {
            this(caseType);
        }

        public CasingTarget to(CaseType caseType) {
            return new CasingTarget(this.sourceCasing, caseType, null);
        }

        private CasingSource(CaseType caseType) {
            this.sourceCasing = caseType;
        }
    }

    /* loaded from: classes.dex */
    public static final class CasingTarget {
        private CaseType sourceCasing;
        private CaseType targetCasing;

        public /* synthetic */ CasingTarget(CaseType caseType, CaseType caseType2, AnonymousClass1 anonymousClass1) {
            this(caseType, caseType2);
        }

        public String convert(String str) {
            if (str != null && str.length() != 0) {
                int r0 = AnonymousClass1.$SwitchMap$com$amplifyframework$util$Casing$CaseType[this.sourceCasing.ordinal()];
                if (r0 == 1) {
                    return Casing.fromScreamingSnakeCase(str, this.targetCasing);
                }
                if (r0 == 2) {
                    return Casing.fromCamelCase(str, this.targetCasing);
                }
                if (r0 == 3) {
                    return Casing.fromPascalCase(str, this.targetCasing);
                }
                throw new IllegalStateException("Unknown source casing = " + this.sourceCasing);
            }
            return str;
        }

        private CasingTarget(CaseType caseType, CaseType caseType2) {
            this.sourceCasing = caseType;
            this.targetCasing = caseType2;
        }
    }

    private Casing() {
    }

    private static String camelToPascal(String str) {
        if (str != null && str.length() != 0) {
            return str.substring(0, 1).toUpperCase(Locale.getDefault()) + str.substring(1);
        }
        return str;
    }

    public static String capitalize(String str) {
        if (str != null && str.length() != 0) {
            return str.substring(0, 1).toUpperCase(Locale.getDefault()) + str.substring(1).toLowerCase(Locale.getDefault());
        }
        return str;
    }

    public static String capitalizeFirst(String str) {
        if (str != null && str.length() != 0) {
            return str.substring(0, 1).toUpperCase(Locale.getDefault()) + str.substring(1);
        }
        return str;
    }

    public static CasingSource from(CaseType caseType) {
        Objects.requireNonNull(caseType);
        return new CasingSource(caseType, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String fromCamelCase(String str, CaseType caseType) {
        Objects.requireNonNull(caseType);
        if (str == null) {
            return null;
        }
        int r0 = AnonymousClass1.$SwitchMap$com$amplifyframework$util$Casing$CaseType[caseType.ordinal()];
        if (r0 != 1) {
            if (r0 != 2) {
                if (r0 == 3) {
                    return camelToPascal(str);
                }
                throw new IllegalStateException("No such casing = " + caseType);
            }
            return str;
        }
        return toScreamingSnake(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String fromPascalCase(String str, CaseType caseType) {
        Objects.requireNonNull(caseType);
        if (str == null) {
            return null;
        }
        int r0 = AnonymousClass1.$SwitchMap$com$amplifyframework$util$Casing$CaseType[caseType.ordinal()];
        if (r0 != 1) {
            if (r0 != 2) {
                if (r0 == 3) {
                    return str;
                }
                throw new IllegalStateException("No such casing = " + caseType);
            }
            return pascalToCamel(str);
        }
        return toScreamingSnake(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String fromScreamingSnakeCase(String str, CaseType caseType) {
        int r0;
        Objects.requireNonNull(caseType);
        if (str != null && str.length() != 0 && (r0 = AnonymousClass1.$SwitchMap$com$amplifyframework$util$Casing$CaseType[caseType.ordinal()]) != 1) {
            if (r0 != 2) {
                if (r0 == 3) {
                    return screamingSnakeToPascal(str);
                }
                throw new IllegalStateException("Unknown target casing = " + caseType);
            }
            return screamingSnakeToCamel(str);
        }
        return str;
    }

    private static String pascalToCamel(String str) {
        if (str != null && str.length() != 0) {
            return str.substring(0, 1).toLowerCase(Locale.getDefault()) + str.substring(1);
        }
        return str;
    }

    private static String screamingSnakeToCamel(String str) {
        if (str != null && str.length() != 0) {
            return pascalToCamel(screamingSnakeToPascal(str));
        }
        return str;
    }

    private static String screamingSnakeToPascal(String str) {
        if (str != null && str.length() != 0) {
            String[] split = str.split("_");
            StringBuilder sb = new StringBuilder();
            for (String str2 : split) {
                sb.append(capitalize(str2));
            }
            return sb.toString();
        }
        return str;
    }

    private static String toScreamingSnake(String str) {
        if (str != null && str.length() != 0) {
            StringBuilder sb = new StringBuilder();
            char[] charArray = str.toCharArray();
            for (int r1 = 0; r1 < charArray.length; r1++) {
                char c = charArray[r1];
                if (Character.isLetterOrDigit(c)) {
                    if (Character.isLowerCase(c)) {
                        sb.append(Character.toUpperCase(c));
                    } else if (r1 != 0) {
                        sb.append("_");
                        sb.append(c);
                    } else {
                        sb.append(c);
                    }
                } else {
                    sb.append("_");
                }
            }
            return sb.toString();
        }
        return str;
    }
}
