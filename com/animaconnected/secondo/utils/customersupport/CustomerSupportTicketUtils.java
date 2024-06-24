package com.animaconnected.secondo.utils.customersupport;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import androidx.room.util.TableInfo$ForeignKey$$ExternalSyntheticOutline0;
import com.amplifyframework.auth.cognito.asf.SignatureGenerator$Companion$$ExternalSyntheticOutline0;
import com.animaconnected.firebase.AppEvents;
import com.animaconnected.secondo.app.RemoteConfigController;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.squareup.moshi.Moshi;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/* compiled from: CustomerSupportTicketUtils.kt */
/* loaded from: classes3.dex */
public final class CustomerSupportTicketUtils {
    public static final int $stable = 8;
    private final CustomerSupportTicketApi api;
    private final AppEvents appAnalytics;
    private final String tag;
    private final String webCode;

    /* compiled from: CustomerSupportTicketUtils.kt */
    /* loaded from: classes3.dex */
    public static final class Content {
        public static final int $stable = 0;
        private final String creationDate;
        private final String idIncidence;
        private final String incidenceCode;

        public Content(String str, String str2, String str3) {
            SignatureGenerator$Companion$$ExternalSyntheticOutline0.m(str, "creationDate", str2, "idIncidence", str3, "incidenceCode");
            this.creationDate = str;
            this.idIncidence = str2;
            this.incidenceCode = str3;
        }

        public static /* synthetic */ Content copy$default(Content content, String str, String str2, String str3, int r4, Object obj) {
            if ((r4 & 1) != 0) {
                str = content.creationDate;
            }
            if ((r4 & 2) != 0) {
                str2 = content.idIncidence;
            }
            if ((r4 & 4) != 0) {
                str3 = content.incidenceCode;
            }
            return content.copy(str, str2, str3);
        }

        public final String component1() {
            return this.creationDate;
        }

        public final String component2() {
            return this.idIncidence;
        }

        public final String component3() {
            return this.incidenceCode;
        }

        public final Content copy(String creationDate, String idIncidence, String incidenceCode) {
            Intrinsics.checkNotNullParameter(creationDate, "creationDate");
            Intrinsics.checkNotNullParameter(idIncidence, "idIncidence");
            Intrinsics.checkNotNullParameter(incidenceCode, "incidenceCode");
            return new Content(creationDate, idIncidence, incidenceCode);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Content)) {
                return false;
            }
            Content content = (Content) obj;
            if (Intrinsics.areEqual(this.creationDate, content.creationDate) && Intrinsics.areEqual(this.idIncidence, content.idIncidence) && Intrinsics.areEqual(this.incidenceCode, content.incidenceCode)) {
                return true;
            }
            return false;
        }

        public final String getCreationDate() {
            return this.creationDate;
        }

        public final String getIdIncidence() {
            return this.idIncidence;
        }

        public final String getIncidenceCode() {
            return this.incidenceCode;
        }

        public int hashCode() {
            return this.incidenceCode.hashCode() + TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.idIncidence, this.creationDate.hashCode() * 31, 31);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Content(creationDate=");
            sb.append(this.creationDate);
            sb.append(", idIncidence=");
            sb.append(this.idIncidence);
            sb.append(", incidenceCode=");
            return OpaqueKey$$ExternalSyntheticOutline0.m(sb, this.incidenceCode, ')');
        }
    }

    /* compiled from: CustomerSupportTicketUtils.kt */
    /* loaded from: classes3.dex */
    public static final class CreateTicketResponse {
        public static final int $stable = 0;
        private final String code;
        private final Content content;

        public CreateTicketResponse(String code, Content content) {
            Intrinsics.checkNotNullParameter(code, "code");
            Intrinsics.checkNotNullParameter(content, "content");
            this.code = code;
            this.content = content;
        }

        public static /* synthetic */ CreateTicketResponse copy$default(CreateTicketResponse createTicketResponse, String str, Content content, int r3, Object obj) {
            if ((r3 & 1) != 0) {
                str = createTicketResponse.code;
            }
            if ((r3 & 2) != 0) {
                content = createTicketResponse.content;
            }
            return createTicketResponse.copy(str, content);
        }

        public final String component1() {
            return this.code;
        }

        public final Content component2() {
            return this.content;
        }

        public final CreateTicketResponse copy(String code, Content content) {
            Intrinsics.checkNotNullParameter(code, "code");
            Intrinsics.checkNotNullParameter(content, "content");
            return new CreateTicketResponse(code, content);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CreateTicketResponse)) {
                return false;
            }
            CreateTicketResponse createTicketResponse = (CreateTicketResponse) obj;
            if (Intrinsics.areEqual(this.code, createTicketResponse.code) && Intrinsics.areEqual(this.content, createTicketResponse.content)) {
                return true;
            }
            return false;
        }

        public final String getCode() {
            return this.code;
        }

        public final Content getContent() {
            return this.content;
        }

        public int hashCode() {
            return this.content.hashCode() + (this.code.hashCode() * 31);
        }

        public String toString() {
            return "CreateTicketResponse(code=" + this.code + ", content=" + this.content + ')';
        }
    }

    /* compiled from: CustomerSupportTicketUtils.kt */
    /* loaded from: classes3.dex */
    public interface CustomerSupportTicketApi {
        @Headers({"Content-type:application/json"})
        @POST("customer-services/technical-services")
        Object createTicket(@Body Ticket ticket, Continuation<? super CreateTicketResponse> continuation);
    }

    /* compiled from: CustomerSupportTicketUtils.kt */
    /* loaded from: classes3.dex */
    public static final class Ticket {
        public static final int $stable = 0;
        private final String email;
        private final String issueContent;
        private final String issueName;
        private final String languageCode;
        private final String lastName;
        private final String name;
        private final String productModel;
        private final String serialNumber;
        private final String webCode;

        public Ticket(String name, String lastName, String email, String issueName, String issueContent, String languageCode, String productModel, String serialNumber, String webCode) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(lastName, "lastName");
            Intrinsics.checkNotNullParameter(email, "email");
            Intrinsics.checkNotNullParameter(issueName, "issueName");
            Intrinsics.checkNotNullParameter(issueContent, "issueContent");
            Intrinsics.checkNotNullParameter(languageCode, "languageCode");
            Intrinsics.checkNotNullParameter(productModel, "productModel");
            Intrinsics.checkNotNullParameter(serialNumber, "serialNumber");
            Intrinsics.checkNotNullParameter(webCode, "webCode");
            this.name = name;
            this.lastName = lastName;
            this.email = email;
            this.issueName = issueName;
            this.issueContent = issueContent;
            this.languageCode = languageCode;
            this.productModel = productModel;
            this.serialNumber = serialNumber;
            this.webCode = webCode;
        }

        public static /* synthetic */ Ticket copy$default(Ticket ticket, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int r20, Object obj) {
            String str10;
            String str11;
            String str12;
            String str13;
            String str14;
            String str15;
            String str16;
            String str17;
            String str18;
            if ((r20 & 1) != 0) {
                str10 = ticket.name;
            } else {
                str10 = str;
            }
            if ((r20 & 2) != 0) {
                str11 = ticket.lastName;
            } else {
                str11 = str2;
            }
            if ((r20 & 4) != 0) {
                str12 = ticket.email;
            } else {
                str12 = str3;
            }
            if ((r20 & 8) != 0) {
                str13 = ticket.issueName;
            } else {
                str13 = str4;
            }
            if ((r20 & 16) != 0) {
                str14 = ticket.issueContent;
            } else {
                str14 = str5;
            }
            if ((r20 & 32) != 0) {
                str15 = ticket.languageCode;
            } else {
                str15 = str6;
            }
            if ((r20 & 64) != 0) {
                str16 = ticket.productModel;
            } else {
                str16 = str7;
            }
            if ((r20 & 128) != 0) {
                str17 = ticket.serialNumber;
            } else {
                str17 = str8;
            }
            if ((r20 & 256) != 0) {
                str18 = ticket.webCode;
            } else {
                str18 = str9;
            }
            return ticket.copy(str10, str11, str12, str13, str14, str15, str16, str17, str18);
        }

        public final String component1() {
            return this.name;
        }

        public final String component2() {
            return this.lastName;
        }

        public final String component3() {
            return this.email;
        }

        public final String component4() {
            return this.issueName;
        }

        public final String component5() {
            return this.issueContent;
        }

        public final String component6() {
            return this.languageCode;
        }

        public final String component7() {
            return this.productModel;
        }

        public final String component8() {
            return this.serialNumber;
        }

        public final String component9() {
            return this.webCode;
        }

        public final Ticket copy(String name, String lastName, String email, String issueName, String issueContent, String languageCode, String productModel, String serialNumber, String webCode) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(lastName, "lastName");
            Intrinsics.checkNotNullParameter(email, "email");
            Intrinsics.checkNotNullParameter(issueName, "issueName");
            Intrinsics.checkNotNullParameter(issueContent, "issueContent");
            Intrinsics.checkNotNullParameter(languageCode, "languageCode");
            Intrinsics.checkNotNullParameter(productModel, "productModel");
            Intrinsics.checkNotNullParameter(serialNumber, "serialNumber");
            Intrinsics.checkNotNullParameter(webCode, "webCode");
            return new Ticket(name, lastName, email, issueName, issueContent, languageCode, productModel, serialNumber, webCode);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Ticket)) {
                return false;
            }
            Ticket ticket = (Ticket) obj;
            if (Intrinsics.areEqual(this.name, ticket.name) && Intrinsics.areEqual(this.lastName, ticket.lastName) && Intrinsics.areEqual(this.email, ticket.email) && Intrinsics.areEqual(this.issueName, ticket.issueName) && Intrinsics.areEqual(this.issueContent, ticket.issueContent) && Intrinsics.areEqual(this.languageCode, ticket.languageCode) && Intrinsics.areEqual(this.productModel, ticket.productModel) && Intrinsics.areEqual(this.serialNumber, ticket.serialNumber) && Intrinsics.areEqual(this.webCode, ticket.webCode)) {
                return true;
            }
            return false;
        }

        public final String getEmail() {
            return this.email;
        }

        public final String getIssueContent() {
            return this.issueContent;
        }

        public final String getIssueName() {
            return this.issueName;
        }

        public final String getLanguageCode() {
            return this.languageCode;
        }

        public final String getLastName() {
            return this.lastName;
        }

        public final String getName() {
            return this.name;
        }

        public final String getProductModel() {
            return this.productModel;
        }

        public final String getSerialNumber() {
            return this.serialNumber;
        }

        public final String getWebCode() {
            return this.webCode;
        }

        public int hashCode() {
            return this.webCode.hashCode() + TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.serialNumber, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.productModel, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.languageCode, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.issueContent, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.issueName, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.email, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.lastName, this.name.hashCode() * 31, 31), 31), 31), 31), 31), 31), 31);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Ticket(name=");
            sb.append(this.name);
            sb.append(", lastName=");
            sb.append(this.lastName);
            sb.append(", email=");
            sb.append(this.email);
            sb.append(", issueName=");
            sb.append(this.issueName);
            sb.append(", issueContent=");
            sb.append(this.issueContent);
            sb.append(", languageCode=");
            sb.append(this.languageCode);
            sb.append(", productModel=");
            sb.append(this.productModel);
            sb.append(", serialNumber=");
            sb.append(this.serialNumber);
            sb.append(", webCode=");
            return OpaqueKey$$ExternalSyntheticOutline0.m(sb, this.webCode, ')');
        }
    }

    public CustomerSupportTicketUtils(RemoteConfigController remoteConfigController, boolean z) {
        String customerSupportUrl;
        Intrinsics.checkNotNullParameter(remoteConfigController, "remoteConfigController");
        this.tag = String.valueOf(Reflection.getOrCreateKotlinClass(CustomerSupportTicketUtils.class).getSimpleName());
        this.appAnalytics = ProviderFactory.getAppAnalytics();
        if (z) {
            customerSupportUrl = "http://pre-fcloud.festina.com:8080/public/dmz/services/";
        } else {
            customerSupportUrl = remoteConfigController.getCustomerSupportUrl();
        }
        this.webCode = remoteConfigController.getCustomerSupportWebCode();
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(customerSupportUrl);
        builder.converterFactories.add(new MoshiConverterFactory(new Moshi(new Moshi.Builder())));
        Object create = builder.build().create(CustomerSupportTicketApi.class);
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        this.api = (CustomerSupportTicketApi) create;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00f2 A[Catch: Exception -> 0x0039, TryCatch #1 {Exception -> 0x0039, blocks: (B:11:0x0034, B:12:0x00c0, B:14:0x00f2, B:18:0x0102), top: B:10:0x0034 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0102 A[Catch: Exception -> 0x0039, TRY_LEAVE, TryCatch #1 {Exception -> 0x0039, blocks: (B:11:0x0034, B:12:0x00c0, B:14:0x00f2, B:18:0x0102), top: B:10:0x0034 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object createTicket(java.util.Map<com.animaconnected.watch.device.DeviceInfo, java.lang.String> r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, kotlin.coroutines.Continuation<? super java.lang.Boolean> r27) {
        /*
            Method dump skipped, instructions count: 323
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.utils.customersupport.CustomerSupportTicketUtils.createTicket(java.util.Map, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
