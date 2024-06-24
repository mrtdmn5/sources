package com.animaconnected.secondo.app;

import android.app.Notification;
import android.app.Person;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.KronabyApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NotificationTextExtractor.kt */
/* loaded from: classes.dex */
public final class NotificationTextExtractor {
    private static final String KEY_DATA_MIME_TYPE = "type";
    private static final String KEY_DATA_URI = "uri";
    private static final String KEY_SENDER = "sender";
    private static final String KEY_TEXT = "text";
    private static final String KEY_TIMESTAMP = "time";
    private static final String tag = "MessageNotificationHandler";
    public static final NotificationTextExtractor INSTANCE = new NotificationTextExtractor();
    private static final String[] emailProjection = {TransferTable.COLUMN_ID, "data1"};
    public static final int $stable = 8;

    private NotificationTextExtractor() {
    }

    private final Notification.MessagingStyle.Message asMessage(Bundle bundle) {
        try {
            if (!bundle.containsKey(KEY_TEXT) || !bundle.containsKey("time")) {
                return null;
            }
            Notification.MessagingStyle.Message message = new Notification.MessagingStyle.Message(bundle.getCharSequence(KEY_TEXT), bundle.getLong("time"), bundle.getCharSequence(KEY_SENDER));
            if (bundle.containsKey("type") && bundle.containsKey("uri")) {
                message.setData(bundle.getString("type"), (Uri) bundle.getParcelable("uri"));
            }
            return message;
        } catch (ClassCastException unused) {
            return null;
        }
    }

    private final String getEmail(Uri uri) {
        try {
            Cursor query = KronabyApplication.Companion.getContext().getContentResolver().query(uri, emailProjection, null, null, null);
            if (query == null) {
                return null;
            }
            try {
                query.moveToFirst();
                final String string = query.getString(query.getColumnIndex("data1"));
                LogKt.verbose$default((Object) INSTANCE, tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.app.NotificationTextExtractor$getEmail$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Got email address: " + string;
                    }
                }, 6, (Object) null);
                CloseableKt.closeFinally(query, null);
                return string;
            } finally {
            }
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x017a, code lost:            r10 = r10.getName();     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v12, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r6v13, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.util.ArrayList<java.lang.String> getTexts(android.service.notification.StatusBarNotification r10) {
        /*
            Method dump skipped, instructions count: 482
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.app.NotificationTextExtractor.getTexts(android.service.notification.StatusBarNotification):java.util.ArrayList");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String print(Person person) {
        String person2;
        CharSequence name;
        String uri;
        String key;
        boolean isBot;
        boolean isImportant;
        if (Build.VERSION.SDK_INT < 28) {
            person2 = person.toString();
            return person2;
        }
        StringBuilder sb = new StringBuilder("Name: ");
        name = person.getName();
        sb.append((Object) name);
        sb.append(", uri ");
        uri = person.getUri();
        sb.append(uri);
        sb.append(", key: ");
        key = person.getKey();
        sb.append(key);
        sb.append(", isBot: ");
        isBot = person.isBot();
        sb.append(isBot);
        sb.append(", isImportant: ");
        isImportant = person.isImportant();
        sb.append(isImportant);
        return sb.toString();
    }

    public final List<String> getEmailAddresses(StatusBarNotification sbn) {
        String email;
        Uri uri;
        Intrinsics.checkNotNullParameter(sbn, "sbn");
        List<String> people = getPeople(sbn);
        final ArrayList<Uri> arrayList = new ArrayList();
        Iterator<T> it = people.iterator();
        while (it.hasNext()) {
            try {
                uri = Uri.parse((String) it.next());
            } catch (Exception unused) {
                uri = null;
            }
            if (uri != null) {
                arrayList.add(uri);
            }
        }
        LogKt.verbose$default((Object) this, tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.app.NotificationTextExtractor$getEmailAddresses$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return CollectionsKt___CollectionsKt.joinToString$default(arrayList, null, null, null, new Function1<Uri, CharSequence>() { // from class: com.animaconnected.secondo.app.NotificationTextExtractor$getEmailAddresses$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final CharSequence invoke(Uri it2) {
                        Intrinsics.checkNotNullParameter(it2, "it");
                        return "uri: " + it2 + " scheme: " + it2.getScheme() + " encodedpath: " + it2.getPath() + ' ' + it2.getSchemeSpecificPart();
                    }
                }, 31);
            }
        }, 6, (Object) null);
        ArrayList arrayList2 = new ArrayList();
        for (Uri uri2 : arrayList) {
            if (Intrinsics.areEqual(uri2.getScheme(), "mailto")) {
                email = uri2.getSchemeSpecificPart();
            } else {
                email = INSTANCE.getEmail(uri2);
            }
            if (email != null) {
                arrayList2.add(email);
            }
        }
        return arrayList2;
    }

    public final List<String> getPeople(StatusBarNotification sbn) {
        Bundle bundle;
        final ArrayList arrayList;
        String uri;
        Intrinsics.checkNotNullParameter(sbn, "sbn");
        Notification notification = sbn.getNotification();
        if (notification != null) {
            bundle = notification.extras;
        } else {
            bundle = null;
        }
        final List list = EmptyList.INSTANCE;
        if (bundle == null) {
            return list;
        }
        String[] stringArray = bundle.getStringArray("android.people");
        if (stringArray != null) {
            arrayList = ArraysKt___ArraysKt.toMutableList(stringArray);
        } else {
            arrayList = new ArrayList();
        }
        LogKt.verbose$default((Object) this, tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.app.NotificationTextExtractor$getPeople$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Got Notification.EXTRA_PEOPLE ".concat(CollectionsKt___CollectionsKt.joinToString$default(arrayList, null, null, null, null, 63));
            }
        }, 6, (Object) null);
        if (Build.VERSION.SDK_INT >= 28) {
            List parcelableArrayList = bundle.getParcelableArrayList("android.people.list");
            if (parcelableArrayList != null) {
                list = parcelableArrayList;
            }
            LogKt.verbose$default((Object) this, tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.app.NotificationTextExtractor$getPeople$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Got Notification.EXTRA_PEOPLE_LIST ".concat(CollectionsKt___CollectionsKt.joinToString$default(list, null, null, null, new Function1<Person, CharSequence>() { // from class: com.animaconnected.secondo.app.NotificationTextExtractor$getPeople$2.1
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final CharSequence invoke2(Person it) {
                            String print;
                            Intrinsics.checkNotNullParameter(it, "it");
                            print = NotificationTextExtractor.INSTANCE.print(it);
                            return print;
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ CharSequence invoke(Person person) {
                            return invoke2(NotificationTextExtractor$$ExternalSyntheticApiModelOutline0.m(person));
                        }
                    }, 31));
                }
            }, 6, (Object) null);
            List list2 = list;
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list2, 10));
            Iterator<E> it = list2.iterator();
            while (it.hasNext()) {
                uri = NotificationTextExtractor$$ExternalSyntheticApiModelOutline0.m(it.next()).getUri();
                arrayList2.add(uri);
            }
            arrayList.addAll(arrayList2);
        }
        return CollectionsKt___CollectionsKt.toList(CollectionsKt___CollectionsKt.filterNotNull(arrayList));
    }

    public final String getText(StatusBarNotification sbn) {
        Bundle bundle;
        CharSequence charSequence;
        String obj;
        Intrinsics.checkNotNullParameter(sbn, "sbn");
        Notification notification = sbn.getNotification();
        if (notification != null) {
            bundle = notification.extras;
        } else {
            bundle = null;
        }
        if (bundle == null || (charSequence = bundle.getCharSequence("android.text")) == null || (obj = charSequence.toString()) == null) {
            return "";
        }
        return obj;
    }

    public final String getTitle(StatusBarNotification sbn) {
        Bundle bundle;
        CharSequence charSequence;
        String obj;
        Intrinsics.checkNotNullParameter(sbn, "sbn");
        Notification notification = sbn.getNotification();
        if (notification != null) {
            bundle = notification.extras;
        } else {
            bundle = null;
        }
        if (bundle == null || (charSequence = bundle.getCharSequence("android.title")) == null || (obj = charSequence.toString()) == null) {
            return "";
        }
        return obj;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001e, code lost:            r1 = r1.getName();     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.util.List<java.lang.String> getTexts(android.app.Notification.MessagingStyle.Message r4) {
        /*
            r3 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.CharSequence r1 = r4.getSender()
            if (r1 == 0) goto L12
            java.lang.String r1 = r1.toString()
            r0.add(r1)
        L12:
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 28
            if (r1 < r2) goto L2f
            android.app.Person r1 = com.animaconnected.secondo.app.NotificationTextExtractor$$ExternalSyntheticApiModelOutline8.m(r4)
            if (r1 == 0) goto L29
            java.lang.CharSequence r1 = com.animaconnected.secondo.app.NotificationTextExtractor$$ExternalSyntheticApiModelOutline1.m(r1)
            if (r1 == 0) goto L29
            java.lang.String r1 = r1.toString()
            goto L2a
        L29:
            r1 = 0
        L2a:
            if (r1 == 0) goto L2f
            r0.add(r1)
        L2f:
            java.lang.CharSequence r4 = r4.getText()
            if (r4 == 0) goto L3c
            java.lang.String r4 = r4.toString()
            r0.add(r4)
        L3c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.app.NotificationTextExtractor.getTexts(android.app.Notification$MessagingStyle$Message):java.util.List");
    }
}
