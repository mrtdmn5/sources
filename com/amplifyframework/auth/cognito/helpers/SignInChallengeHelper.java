package com.amplifyframework.auth.cognito.helpers;

import aws.sdk.kotlin.services.cognitoidentityprovider.model.AuthenticationResultType;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.ChallengeNameType;
import aws.sdk.kotlin.services.cognitoidentityprovider.model.NewDeviceMetadataType;
import aws.smithy.kotlin.runtime.time.Instant;
import com.amplifyframework.auth.AuthCodeDeliveryDetails;
import com.amplifyframework.auth.AuthException;
import com.amplifyframework.auth.exceptions.UnknownException;
import com.amplifyframework.auth.result.AuthSignInResult;
import com.amplifyframework.auth.result.step.AuthNextSignInStep;
import com.amplifyframework.auth.result.step.AuthSignInStep;
import com.amplifyframework.core.Consumer;
import com.amplifyframework.statemachine.StateMachineEvent;
import com.amplifyframework.statemachine.codegen.data.AuthChallenge;
import com.amplifyframework.statemachine.codegen.data.CognitoUserPoolTokens;
import com.amplifyframework.statemachine.codegen.data.DeviceMetadata;
import com.amplifyframework.statemachine.codegen.data.SignInMethod;
import com.amplifyframework.statemachine.codegen.data.SignedInData;
import com.amplifyframework.statemachine.codegen.events.AuthenticationEvent;
import com.amplifyframework.statemachine.codegen.events.SignInEvent;
import j$.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;
import kotlin.collections.EmptyMap;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* compiled from: SignInChallengeHelper.kt */
/* loaded from: classes.dex */
public final class SignInChallengeHelper {
    public static final SignInChallengeHelper INSTANCE = new SignInChallengeHelper();

    private SignInChallengeHelper() {
    }

    public static /* synthetic */ StateMachineEvent evaluateNextStep$default(SignInChallengeHelper signInChallengeHelper, String str, ChallengeNameType challengeNameType, String str2, Map map, AuthenticationResultType authenticationResultType, SignInMethod signInMethod, int r14, Object obj) {
        if ((r14 & 32) != 0) {
            signInMethod = new SignInMethod.ApiBased(SignInMethod.ApiBased.AuthType.USER_SRP_AUTH);
        }
        return signInChallengeHelper.evaluateNextStep(str, challengeNameType, str2, map, authenticationResultType, signInMethod);
    }

    public final StateMachineEvent evaluateNextStep(String username, ChallengeNameType challengeNameType, String str, Map<String, String> map, AuthenticationResultType authenticationResultType, SignInMethod signInMethod) {
        String str2;
        String str3;
        String str4;
        String userSub;
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(signInMethod, "signInMethod");
        if (authenticationResultType != null) {
            String str5 = authenticationResultType.accessToken;
            if (str5 == null || (userSub = SessionHelper.INSTANCE.getUserSub(str5)) == null) {
                str2 = "";
            } else {
                str2 = userSub;
            }
            DateTimeFormatter dateTimeFormatter = Instant.RFC_5322_FIXED_DATE_TIME;
            Instant now = Instant.Companion.now();
            int r2 = Duration.$r8$clinit;
            SignedInData signedInData = new SignedInData(str2, username, new Date(), signInMethod, new CognitoUserPoolTokens(authenticationResultType.idToken, str5, authenticationResultType.refreshToken, Long.valueOf(now.m621plusLRDsOJo(DurationKt.toDuration(authenticationResultType.expiresIn, DurationUnit.SECONDS)).getEpochSeconds())));
            NewDeviceMetadataType newDeviceMetadataType = authenticationResultType.newDeviceMetadata;
            if (newDeviceMetadataType != null) {
                String str6 = newDeviceMetadataType.deviceKey;
                if (str6 == null) {
                    str3 = "";
                } else {
                    str3 = str6;
                }
                String str7 = newDeviceMetadataType.deviceGroupKey;
                if (str7 == null) {
                    str4 = "";
                } else {
                    str4 = str7;
                }
                return new SignInEvent(new SignInEvent.EventType.ConfirmDevice(new DeviceMetadata.Metadata(str3, str4, (String) null, 4, (DefaultConstructorMarker) null), signedInData), null, 2, null);
            }
            return new AuthenticationEvent(new AuthenticationEvent.EventType.SignInCompleted(signedInData, DeviceMetadata.Empty.INSTANCE), null, 2, null);
        }
        if (!(challengeNameType instanceof ChallengeNameType.SmsMfa) && !(challengeNameType instanceof ChallengeNameType.CustomChallenge) && !(challengeNameType instanceof ChallengeNameType.NewPasswordRequired)) {
            if (challengeNameType instanceof ChallengeNameType.DeviceSrpAuth) {
                return new SignInEvent(new SignInEvent.EventType.InitiateSignInWithDeviceSRP(username, EmptyMap.INSTANCE), null, 2, null);
            }
            return new SignInEvent(new SignInEvent.EventType.ThrowError(new Exception("Response did not contain sign in info.")), null, 2, null);
        }
        return new SignInEvent(new SignInEvent.EventType.ReceivedChallenge(new AuthChallenge(challengeNameType.getValue(), username, str, map)), null, 2, null);
    }

    public final void getNextStep(AuthChallenge challenge, Consumer<AuthSignInResult> onSuccess, Consumer<AuthException> onError) {
        Map map;
        Intrinsics.checkNotNullParameter(challenge, "challenge");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Map<String, String> parameters = challenge.getParameters();
        EmptyMap emptyMap = EmptyMap.INSTANCE;
        if (parameters != null) {
            map = MapsKt__MapsKt.toMutableMap(parameters);
        } else {
            map = emptyMap;
        }
        ChallengeNameType fromValue = ChallengeNameType.Companion.fromValue(challenge.getChallengeName());
        if (fromValue instanceof ChallengeNameType.SmsMfa) {
            onSuccess.accept(new AuthSignInResult(false, new AuthNextSignInStep(AuthSignInStep.CONFIRM_SIGN_IN_WITH_SMS_MFA_CODE, emptyMap, new AuthCodeDeliveryDetails((String) MapsKt__MapsKt.getValue("CODE_DELIVERY_DESTINATION", map), AuthCodeDeliveryDetails.DeliveryMedium.fromString((String) MapsKt__MapsKt.getValue("CODE_DELIVERY_DELIVERY_MEDIUM", map))))));
        } else if (fromValue instanceof ChallengeNameType.NewPasswordRequired) {
            onSuccess.accept(new AuthSignInResult(false, new AuthNextSignInStep(AuthSignInStep.CONFIRM_SIGN_IN_WITH_NEW_PASSWORD, map, null)));
        } else if (fromValue instanceof ChallengeNameType.CustomChallenge) {
            onSuccess.accept(new AuthSignInResult(false, new AuthNextSignInStep(AuthSignInStep.CONFIRM_SIGN_IN_WITH_CUSTOM_CHALLENGE, map, null)));
        } else {
            onError.accept(new UnknownException(null, new Exception("Challenge type not supported."), 1, null));
        }
    }
}
