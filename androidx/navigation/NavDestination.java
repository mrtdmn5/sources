package androidx.navigation;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import androidx.collection.SparseArrayCompat;
import androidx.navigation.NavDeepLink;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class NavDestination {
    public SparseArrayCompat<NavAction> mActions;
    public HashMap<String, NavArgument> mArguments;
    public ArrayList<NavDeepLink> mDeepLinks;
    public int mId;
    public String mIdName;
    public CharSequence mLabel;
    public final String mNavigatorName;
    public NavGraph mParent;

    /* loaded from: classes.dex */
    public static class DeepLinkMatch implements Comparable<DeepLinkMatch> {
        public final NavDestination mDestination;
        public final boolean mHasMatchingAction;
        public final boolean mIsExactDeepLink;
        public final Bundle mMatchingArgs;
        public final int mMimeTypeMatchLevel;

        public DeepLinkMatch(NavDestination navDestination, Bundle bundle, boolean z, boolean z2, int r5) {
            this.mDestination = navDestination;
            this.mMatchingArgs = bundle;
            this.mIsExactDeepLink = z;
            this.mHasMatchingAction = z2;
            this.mMimeTypeMatchLevel = r5;
        }

        @Override // java.lang.Comparable
        public final int compareTo(DeepLinkMatch deepLinkMatch) {
            boolean z = this.mIsExactDeepLink;
            if (z && !deepLinkMatch.mIsExactDeepLink) {
                return 1;
            }
            if (!z && deepLinkMatch.mIsExactDeepLink) {
                return -1;
            }
            Bundle bundle = this.mMatchingArgs;
            if (bundle != null && deepLinkMatch.mMatchingArgs == null) {
                return 1;
            }
            if (bundle == null && deepLinkMatch.mMatchingArgs != null) {
                return -1;
            }
            if (bundle != null) {
                int size = bundle.size() - deepLinkMatch.mMatchingArgs.size();
                if (size > 0) {
                    return 1;
                }
                if (size < 0) {
                    return -1;
                }
            }
            boolean z2 = this.mHasMatchingAction;
            if (z2 && !deepLinkMatch.mHasMatchingAction) {
                return 1;
            }
            if (z2 || !deepLinkMatch.mHasMatchingAction) {
                return this.mMimeTypeMatchLevel - deepLinkMatch.mMimeTypeMatchLevel;
            }
            return -1;
        }
    }

    static {
        new HashMap();
    }

    public NavDestination(Navigator<? extends NavDestination> navigator) {
        this.mNavigatorName = NavigatorProvider.getNameForNavigator(navigator.getClass());
    }

    public static String getDisplayName(Context context, int r2) {
        if (r2 <= 16777215) {
            return Integer.toString(r2);
        }
        try {
            return context.getResources().getResourceName(r2);
        } catch (Resources.NotFoundException unused) {
            return Integer.toString(r2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0088 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[LOOP:1: B:26:0x0054->B:40:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.os.Bundle addInDefaultArgs(android.os.Bundle r7) {
        /*
            r6 = this;
            if (r7 != 0) goto Le
            java.util.HashMap<java.lang.String, androidx.navigation.NavArgument> r0 = r6.mArguments
            if (r0 == 0) goto Lc
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto Le
        Lc:
            r7 = 0
            return r7
        Le:
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            java.util.HashMap<java.lang.String, androidx.navigation.NavArgument> r1 = r6.mArguments
            if (r1 == 0) goto L43
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L1f:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L43
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getValue()
            androidx.navigation.NavArgument r3 = (androidx.navigation.NavArgument) r3
            java.lang.Object r2 = r2.getKey()
            java.lang.String r2 = (java.lang.String) r2
            boolean r4 = r3.mDefaultValuePresent
            if (r4 == 0) goto L1f
            androidx.navigation.NavType r4 = r3.mType
            java.lang.Object r3 = r3.mDefaultValue
            r4.put(r0, r2, r3)
            goto L1f
        L43:
            if (r7 == 0) goto Lbb
            r0.putAll(r7)
            java.util.HashMap<java.lang.String, androidx.navigation.NavArgument> r1 = r6.mArguments
            if (r1 == 0) goto Lbb
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L54:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto Lbb
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getValue()
            androidx.navigation.NavArgument r3 = (androidx.navigation.NavArgument) r3
            java.lang.Object r4 = r2.getKey()
            java.lang.String r4 = (java.lang.String) r4
            boolean r5 = r3.mIsNullable
            if (r5 != 0) goto L7d
            boolean r5 = r7.containsKey(r4)
            if (r5 == 0) goto L7d
            java.lang.Object r5 = r7.get(r4)
            if (r5 != 0) goto L7d
            goto L84
        L7d:
            androidx.navigation.NavType r3 = r3.mType     // Catch: java.lang.ClassCastException -> L84
            r3.get(r7, r4)     // Catch: java.lang.ClassCastException -> L84
            r3 = 1
            goto L85
        L84:
            r3 = 0
        L85:
            if (r3 == 0) goto L88
            goto L54
        L88:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Wrong argument type for '"
            r0.<init>(r1)
            java.lang.Object r1 = r2.getKey()
            java.lang.String r1 = (java.lang.String) r1
            r0.append(r1)
            java.lang.String r1 = "' in argument bundle. "
            r0.append(r1)
            java.lang.Object r1 = r2.getValue()
            androidx.navigation.NavArgument r1 = (androidx.navigation.NavArgument) r1
            androidx.navigation.NavType r1 = r1.mType
            java.lang.String r1 = r1.getName()
            r0.append(r1)
            java.lang.String r1 = " expected."
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r7.<init>(r0)
            throw r7
        Lbb:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavDestination.addInDefaultArgs(android.os.Bundle):android.os.Bundle");
    }

    public final int[] buildDeepLinkIds() {
        ArrayDeque arrayDeque = new ArrayDeque();
        NavDestination navDestination = this;
        while (true) {
            NavGraph navGraph = navDestination.mParent;
            if (navGraph == null || navGraph.mStartDestId != navDestination.mId) {
                arrayDeque.addFirst(navDestination);
            }
            if (navGraph == null) {
                break;
            }
            navDestination = navGraph;
        }
        int[] r1 = new int[arrayDeque.size()];
        Iterator it = arrayDeque.iterator();
        int r2 = 0;
        while (it.hasNext()) {
            r1[r2] = ((NavDestination) it.next()).mId;
            r2++;
        }
        return r1;
    }

    public final NavAction getAction(int r3) {
        NavAction navAction;
        SparseArrayCompat<NavAction> sparseArrayCompat = this.mActions;
        if (sparseArrayCompat == null) {
            navAction = null;
        } else {
            navAction = (NavAction) sparseArrayCompat.get(r3, null);
        }
        if (navAction != null) {
            return navAction;
        }
        NavGraph navGraph = this.mParent;
        if (navGraph == null) {
            return null;
        }
        return navGraph.getAction(r3);
    }

    public DeepLinkMatch matchDeepLink(NavDeepLinkRequest navDeepLinkRequest) {
        Bundle bundle;
        boolean z;
        int r5;
        String str;
        int r8;
        Map unmodifiableMap;
        Bundle bundle2;
        Matcher matcher;
        String str2;
        HashMap hashMap;
        Uri uri;
        boolean z2;
        boolean z3;
        ArrayList<NavDeepLink> arrayList = this.mDeepLinks;
        Bundle bundle3 = null;
        if (arrayList == null) {
            return null;
        }
        Iterator<NavDeepLink> it = arrayList.iterator();
        DeepLinkMatch deepLinkMatch = null;
        while (it.hasNext()) {
            NavDeepLink next = it.next();
            Uri uri2 = navDeepLinkRequest.mUri;
            if (uri2 != null) {
                HashMap<String, NavArgument> hashMap2 = this.mArguments;
                if (hashMap2 == null) {
                    unmodifiableMap = Collections.emptyMap();
                } else {
                    unmodifiableMap = Collections.unmodifiableMap(hashMap2);
                }
                next.getClass();
                Matcher matcher2 = next.mPattern.matcher(uri2.toString());
                if (!matcher2.matches()) {
                    bundle2 = bundle3;
                } else {
                    bundle2 = new Bundle();
                    ArrayList<String> arrayList2 = next.mArguments;
                    int size = arrayList2.size();
                    int r14 = 0;
                    while (true) {
                        if (r14 < size) {
                            String str3 = arrayList2.get(r14);
                            r14++;
                            String decode = Uri.decode(matcher2.group(r14));
                            NavArgument navArgument = (NavArgument) unmodifiableMap.get(str3);
                            if (navArgument != null) {
                                NavType navType = navArgument.mType;
                                try {
                                    navType.put(bundle2, str3, navType.parseValue(decode));
                                } catch (IllegalArgumentException unused) {
                                    z3 = true;
                                }
                            } else {
                                bundle2.putString(str3, decode);
                            }
                            z3 = false;
                            if (z3) {
                                break;
                            }
                        } else if (next.mIsParameterizedQuery) {
                            HashMap hashMap3 = next.mParamArgMap;
                            for (String str4 : hashMap3.keySet()) {
                                NavDeepLink.ParamQuery paramQuery = (NavDeepLink.ParamQuery) hashMap3.get(str4);
                                String queryParameter = uri2.getQueryParameter(str4);
                                if (queryParameter != null) {
                                    matcher = Pattern.compile(paramQuery.mParamRegex).matcher(queryParameter);
                                    if (!matcher.matches()) {
                                    }
                                } else {
                                    matcher = null;
                                }
                                int r13 = 0;
                                while (r13 < paramQuery.mArguments.size()) {
                                    if (matcher != null) {
                                        str2 = Uri.decode(matcher.group(r13 + 1));
                                    } else {
                                        str2 = null;
                                    }
                                    String str5 = paramQuery.mArguments.get(r13);
                                    NavArgument navArgument2 = (NavArgument) unmodifiableMap.get(str5);
                                    if (str2 != null) {
                                        hashMap = hashMap3;
                                        uri = uri2;
                                        if (str2.replaceAll("[{}]", "").equals(str5)) {
                                            continue;
                                        } else {
                                            if (navArgument2 != null) {
                                                NavType navType2 = navArgument2.mType;
                                                try {
                                                    navType2.put(bundle2, str5, navType2.parseValue(str2));
                                                } catch (IllegalArgumentException unused2) {
                                                    z2 = true;
                                                }
                                            } else {
                                                bundle2.putString(str5, str2);
                                            }
                                            z2 = false;
                                            if (z2) {
                                            }
                                        }
                                    } else {
                                        hashMap = hashMap3;
                                        uri = uri2;
                                    }
                                    r13++;
                                    hashMap3 = hashMap;
                                    uri2 = uri;
                                }
                            }
                        }
                    }
                    bundle2 = null;
                }
                bundle = bundle2;
            } else {
                bundle = null;
            }
            String str6 = navDeepLinkRequest.mAction;
            if (str6 != null && str6.equals(next.mAction)) {
                z = true;
            } else {
                z = false;
            }
            String str7 = navDeepLinkRequest.mMimeType;
            if (str7 != null && (str = next.mMimeType) != null && next.mMimeTypePattern.matcher(str7).matches()) {
                String[] split = str.split("/", -1);
                String str8 = split[0];
                String str9 = split[1];
                String[] split2 = str7.split("/", -1);
                String str10 = split2[0];
                String str11 = split2[1];
                if (str8.equals(str10)) {
                    r8 = 2;
                } else {
                    r8 = 0;
                }
                if (str9.equals(str11)) {
                    r8++;
                }
                r5 = r8;
            } else {
                r5 = -1;
            }
            if (bundle != null || z || r5 > -1) {
                DeepLinkMatch deepLinkMatch2 = new DeepLinkMatch(this, bundle, next.mExactDeepLink, z, r5);
                if (deepLinkMatch == null || deepLinkMatch2.compareTo(deepLinkMatch) > 0) {
                    deepLinkMatch = deepLinkMatch2;
                }
            }
            bundle3 = null;
        }
        return deepLinkMatch;
    }

    public void onInflate(Context context, AttributeSet attributeSet) {
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, androidx.navigation.common.R$styleable.Navigator);
        int resourceId = obtainAttributes.getResourceId(1, 0);
        this.mId = resourceId;
        this.mIdName = null;
        this.mIdName = getDisplayName(context, resourceId);
        this.mLabel = obtainAttributes.getText(0);
        obtainAttributes.recycle();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("(");
        String str = this.mIdName;
        if (str == null) {
            sb.append("0x");
            sb.append(Integer.toHexString(this.mId));
        } else {
            sb.append(str);
        }
        sb.append(")");
        if (this.mLabel != null) {
            sb.append(" label=");
            sb.append(this.mLabel);
        }
        return sb.toString();
    }
}
