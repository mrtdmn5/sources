package com.animaconnected.secondo.app;

import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.watch.filter.FilterSettings;
import com.animaconnected.watch.filter.ImportantContact;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImportantContact.kt */
/* loaded from: classes.dex */
public final class ImportantContactKt {
    private static final FilterSettings filterSettings = ProviderFactory.getWatch().getWatchManager().getFilterSettings();
    private static final String tag = "ImportantContact";

    /* compiled from: ImportantContact.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[FilterSettings.Allowed.values().length];
            try {
                r0[FilterSettings.Allowed.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[FilterSettings.Allowed.All.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[FilterSettings.Allowed.Known.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r0[FilterSettings.Allowed.Favourites.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                r0[FilterSettings.Allowed.Important.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    public static final Object allowNotifyForCalls(List<ImportantContact> list, Continuation<? super Boolean> continuation) {
        return shouldNotifyUserNow(list, filterSettings.getCallsFilter(), continuation);
    }

    public static final Object allowNotifyForTexts(List<ImportantContact> list, Continuation<? super Boolean> continuation) {
        return shouldNotifyUserNow(list, filterSettings.getTextsFilter(), continuation);
    }

    private static final boolean anyFavorite(List<ImportantContact> list) {
        List<ImportantContact> list2 = list;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            return false;
        }
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            if (((ImportantContact) it.next()).isFavourite()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x005f -> B:10:0x0062). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object anyImportant(java.util.List<com.animaconnected.watch.filter.ImportantContact> r5, kotlin.coroutines.Continuation<? super java.lang.Boolean> r6) {
        /*
            boolean r0 = r6 instanceof com.animaconnected.secondo.app.ImportantContactKt$anyImportant$1
            if (r0 == 0) goto L13
            r0 = r6
            com.animaconnected.secondo.app.ImportantContactKt$anyImportant$1 r0 = (com.animaconnected.secondo.app.ImportantContactKt$anyImportant$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.secondo.app.ImportantContactKt$anyImportant$1 r0 = new com.animaconnected.secondo.app.ImportantContactKt$anyImportant$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L34
            if (r2 != r4) goto L2c
            java.lang.Object r5 = r0.L$0
            java.util.Iterator r5 = (java.util.Iterator) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L62
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            kotlin.ResultKt.throwOnFailure(r6)
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            boolean r6 = r5 instanceof java.util.Collection
            if (r6 == 0) goto L47
            r6 = r5
            java.util.Collection r6 = (java.util.Collection) r6
            boolean r6 = r6.isEmpty()
            if (r6 == 0) goto L47
            goto L6b
        L47:
            java.util.Iterator r5 = r5.iterator()
        L4b:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L6b
            java.lang.Object r6 = r5.next()
            com.animaconnected.watch.filter.ImportantContact r6 = (com.animaconnected.watch.filter.ImportantContact) r6
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r6 = isImportant(r6, r0)
            if (r6 != r1) goto L62
            return r1
        L62:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L4b
            r3 = r4
        L6b:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r3)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.app.ImportantContactKt.anyImportant(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final Uri createLookupUri(String str) {
        Uri withAppendedPath = Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(str));
        Intrinsics.checkNotNullExpressionValue(withAppendedPath, "withAppendedPath(...)");
        return withAppendedPath;
    }

    public static final ImportantContact fromLookupUri(ImportantContact.Companion companion, Uri lookupUri) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(lookupUri, "lookupUri");
        return getImportantContact(lookupUri);
    }

    public static final ImportantContact fromPhoneNumber(ImportantContact.Companion companion, String phoneNumber) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        return getImportantContact(createLookupUri(phoneNumber));
    }

    public static final FilterSettings getFilterSettings() {
        return filterSettings;
    }

    private static final ImportantContact getImportantContact(Uri uri) {
        int columnIndex;
        int r0;
        int r2;
        ImportantContact importantContact;
        try {
            final Cursor query = KronabyApplication.Companion.getContext().getContentResolver().query(uri, new String[]{TransferTable.COLUMN_ID, "display_name", "starred"}, null, null, null);
            if (query != null) {
                try {
                    columnIndex = query.getColumnIndex("display_name");
                } finally {
                }
            } else {
                columnIndex = -1;
            }
            if (query != null) {
                r0 = query.getColumnIndex("starred");
            } else {
                r0 = -1;
            }
            if (query != null) {
                r2 = query.getColumnIndex(TransferTable.COLUMN_ID);
            } else {
                r2 = -1;
            }
            if (query != null && query.moveToFirst() && columnIndex != -1 && r2 != -1) {
                String string = query.getString(columnIndex);
                String string2 = query.getString(r2);
                final String string3 = query.getString(r0);
                boolean areEqual = Intrinsics.areEqual(string3, "1");
                LogKt.verbose$default((Object) uri, tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.app.ImportantContactKt$getImportantContact$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Got favourite : " + string3;
                    }
                }, 6, (Object) null);
                Intrinsics.checkNotNull(string2);
                Intrinsics.checkNotNull(string);
                importantContact = new ImportantContact(string2, string, areEqual);
            } else {
                LogKt.verbose$default((Object) uri, tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.app.ImportantContactKt$getImportantContact$1$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        StringBuilder sb = new StringBuilder("cursor moveToFirst: ");
                        Cursor cursor = query;
                        sb.append(cursor != null ? Boolean.valueOf(cursor.moveToFirst()) : null);
                        return sb.toString();
                    }
                }, 6, (Object) null);
                importantContact = null;
            }
            CloseableKt.closeFinally(query, null);
            return importantContact;
        } catch (Exception e) {
            LogKt.warn$default((Object) uri, tag, (Throwable) e, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.app.ImportantContactKt$getImportantContact$2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Failed to get contact name";
                }
            }, 4, (Object) null);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x006c A[LOOP:0: B:11:0x0066->B:13:0x006c, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object isImportant(com.animaconnected.watch.filter.ImportantContact r11, kotlin.coroutines.Continuation<? super java.lang.Boolean> r12) {
        /*
            boolean r0 = r12 instanceof com.animaconnected.secondo.app.ImportantContactKt$isImportant$1
            if (r0 == 0) goto L13
            r0 = r12
            com.animaconnected.secondo.app.ImportantContactKt$isImportant$1 r0 = (com.animaconnected.secondo.app.ImportantContactKt$isImportant$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.secondo.app.ImportantContactKt$isImportant$1 r0 = new com.animaconnected.secondo.app.ImportantContactKt$isImportant$1
            r0.<init>(r12)
        L18:
            java.lang.Object r12 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r11 = r0.L$1
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r0 = r0.L$0
            com.animaconnected.watch.filter.ImportantContact r0 = (com.animaconnected.watch.filter.ImportantContact) r0
            kotlin.ResultKt.throwOnFailure(r12)
            r4 = r0
            goto L55
        L30:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L38:
            kotlin.ResultKt.throwOnFailure(r12)
            java.lang.String r12 = r11.getPlatformSpecificIdentifier()
            com.animaconnected.watch.filter.FilterSettings r2 = com.animaconnected.secondo.app.ImportantContactKt.filterSettings
            com.animaconnected.watch.CommonFlow r2 = r2.getImportantContactsFlow()
            r0.L$0 = r11
            r0.L$1 = r12
            r0.label = r3
            java.lang.Object r0 = kotlinx.coroutines.flow.FlowKt.first(r2, r0)
            if (r0 != r1) goto L52
            return r1
        L52:
            r4 = r11
            r11 = r12
            r12 = r0
        L55:
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 10
            int r1 = kotlin.collections.CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(r12, r1)
            r0.<init>(r1)
            java.util.Iterator r12 = r12.iterator()
        L66:
            boolean r1 = r12.hasNext()
            if (r1 == 0) goto L7a
            java.lang.Object r1 = r12.next()
            com.animaconnected.watch.filter.ImportantContact r1 = (com.animaconnected.watch.filter.ImportantContact) r1
            java.lang.String r1 = r1.getPlatformSpecificIdentifier()
            r0.add(r1)
            goto L66
        L7a:
            boolean r12 = r0.isEmpty()
            r1 = 0
            if (r12 == 0) goto L83
        L81:
            r3 = r1
            goto L99
        L83:
            java.util.Iterator r12 = r0.iterator()
        L87:
            boolean r0 = r12.hasNext()
            if (r0 == 0) goto L81
            java.lang.Object r0 = r12.next()
            java.lang.String r0 = (java.lang.String) r0
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r11)
            if (r0 == 0) goto L87
        L99:
            java.lang.String r5 = "ImportantContact"
            r6 = 0
            r7 = 0
            com.animaconnected.secondo.app.ImportantContactKt$isImportant$2 r8 = new com.animaconnected.secondo.app.ImportantContactKt$isImportant$2
            r8.<init>()
            r9 = 6
            r10 = 0
            com.animaconnected.logger.LogKt.warn$default(r4, r5, r6, r7, r8, r9, r10)
            java.lang.Boolean r11 = java.lang.Boolean.valueOf(r3)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.app.ImportantContactKt.isImportant(com.animaconnected.watch.filter.ImportantContact, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00ea, code lost:            if (((java.lang.Boolean) r3).booleanValue() == false) goto L58;     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x010e, code lost:            if (((java.lang.Boolean) r3).booleanValue() == false) goto L58;     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0128, code lost:            if (((java.lang.Boolean) r3).booleanValue() == false) goto L58;     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object shouldNotifyUserNow(java.util.List<com.animaconnected.watch.filter.ImportantContact> r19, com.animaconnected.watch.filter.FilterSettings.Allowed r20, kotlin.coroutines.Continuation<? super java.lang.Boolean> r21) {
        /*
            Method dump skipped, instructions count: 328
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.app.ImportantContactKt.shouldNotifyUserNow(java.util.List, com.animaconnected.watch.filter.FilterSettings$Allowed, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
