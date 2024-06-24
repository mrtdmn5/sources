package com.amplifyframework.auth.cognito.actions;

import androidx.constraintlayout.solver.PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0;
import com.amplifyframework.auth.cognito.CredentialStoreEnvironment;
import com.amplifyframework.logging.Logger;
import com.amplifyframework.statemachine.Action;
import com.amplifyframework.statemachine.Environment;
import com.amplifyframework.statemachine.EventDispatcher;
import com.amplifyframework.statemachine.codegen.actions.CredentialStoreActions;
import com.amplifyframework.statemachine.codegen.data.AmplifyCredential;
import com.amplifyframework.statemachine.codegen.data.CredentialType;
import com.amplifyframework.statemachine.codegen.data.DeviceMetadata;
import com.amplifyframework.statemachine.codegen.errors.CredentialStoreError;
import com.amplifyframework.statemachine.codegen.events.CredentialStoreEvent;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CredentialStoreCognitoActions.kt */
/* loaded from: classes.dex */
public final class CredentialStoreCognitoActions implements CredentialStoreActions {
    public static final CredentialStoreCognitoActions INSTANCE = new CredentialStoreCognitoActions();

    private CredentialStoreCognitoActions() {
    }

    @Override // com.amplifyframework.statemachine.codegen.actions.CredentialStoreActions
    public Action clearCredentialStoreAction(final CredentialType credentialType) {
        Intrinsics.checkNotNullParameter(credentialType, "credentialType");
        Action.Companion companion = Action.Companion;
        final String str = "ClearCredentialStore";
        return new Action(str, credentialType) { // from class: com.amplifyframework.auth.cognito.actions.CredentialStoreCognitoActions$clearCredentialStoreAction$$inlined$invoke$1
            final /* synthetic */ CredentialType $credentialType$inlined;
            private final String id;

            {
                this.$credentialType$inlined = credentialType;
                this.id = str == null ? Action.DefaultImpls.getId(this) : str;
            }

            @Override // com.amplifyframework.statemachine.Action
            public Object execute(EventDispatcher eventDispatcher, Environment environment, Continuation<? super Unit> continuation) {
                CredentialStoreEvent credentialStoreEvent;
                Intrinsics.checkNotNull(environment, "null cannot be cast to non-null type EnvType of com.amplifyframework.statemachine.Action.Companion.invoke");
                String id = getId();
                CredentialStoreEnvironment credentialStoreEnvironment = (CredentialStoreEnvironment) environment;
                AuthCognitoActions$initializeAuthorizationConfigurationAction$$inlined$invoke$1$$ExternalSyntheticOutline0.m(id, " Starting execution", credentialStoreEnvironment.getLogger());
                try {
                    CredentialType credentialType2 = this.$credentialType$inlined;
                    if (Intrinsics.areEqual(credentialType2, CredentialType.Amplify.INSTANCE)) {
                        credentialStoreEnvironment.getCredentialStore().deleteCredential();
                    } else if (credentialType2 instanceof CredentialType.Device) {
                        credentialStoreEnvironment.getCredentialStore().deleteDeviceKeyCredential(((CredentialType.Device) this.$credentialType$inlined).getUsername());
                    } else if (Intrinsics.areEqual(credentialType2, CredentialType.ASF.INSTANCE)) {
                        credentialStoreEnvironment.getCredentialStore().deleteASFDevice();
                    }
                    credentialStoreEvent = new CredentialStoreEvent(new CredentialStoreEvent.EventType.CompletedOperation(AmplifyCredential.Empty.INSTANCE), null, 2, null);
                } catch (CredentialStoreError e) {
                    credentialStoreEvent = new CredentialStoreEvent(new CredentialStoreEvent.EventType.ThrowError(e), null, 2, null);
                }
                Logger logger = credentialStoreEnvironment.getLogger();
                StringBuilder m = PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0.m(id, " Sending event ");
                m.append(credentialStoreEvent.getType());
                logger.verbose(m.toString());
                eventDispatcher.send(credentialStoreEvent);
                return Unit.INSTANCE;
            }

            @Override // com.amplifyframework.statemachine.Action
            public String getId() {
                return this.id;
            }
        };
    }

    @Override // com.amplifyframework.statemachine.codegen.actions.CredentialStoreActions
    public Action loadCredentialStoreAction(final CredentialType credentialType) {
        Intrinsics.checkNotNullParameter(credentialType, "credentialType");
        Action.Companion companion = Action.Companion;
        final String str = "LoadCredentialStore";
        return new Action(str, credentialType) { // from class: com.amplifyframework.auth.cognito.actions.CredentialStoreCognitoActions$loadCredentialStoreAction$$inlined$invoke$1
            final /* synthetic */ CredentialType $credentialType$inlined;
            private final String id;

            {
                this.$credentialType$inlined = credentialType;
                this.id = str == null ? Action.DefaultImpls.getId(this) : str;
            }

            @Override // com.amplifyframework.statemachine.Action
            public Object execute(EventDispatcher eventDispatcher, Environment environment, Continuation<? super Unit> continuation) {
                CredentialStoreEvent credentialStoreEvent;
                AmplifyCredential retrieveASFDevice;
                Intrinsics.checkNotNull(environment, "null cannot be cast to non-null type EnvType of com.amplifyframework.statemachine.Action.Companion.invoke");
                String id = getId();
                CredentialStoreEnvironment credentialStoreEnvironment = (CredentialStoreEnvironment) environment;
                AuthCognitoActions$initializeAuthorizationConfigurationAction$$inlined$invoke$1$$ExternalSyntheticOutline0.m(id, " Starting execution", credentialStoreEnvironment.getLogger());
                try {
                    CredentialType credentialType2 = this.$credentialType$inlined;
                    if (Intrinsics.areEqual(credentialType2, CredentialType.Amplify.INSTANCE)) {
                        retrieveASFDevice = credentialStoreEnvironment.getCredentialStore().retrieveCredential();
                    } else if (credentialType2 instanceof CredentialType.Device) {
                        retrieveASFDevice = new AmplifyCredential.DeviceData(credentialStoreEnvironment.getCredentialStore().retrieveDeviceMetadata(((CredentialType.Device) this.$credentialType$inlined).getUsername()));
                    } else if (Intrinsics.areEqual(credentialType2, CredentialType.ASF.INSTANCE)) {
                        retrieveASFDevice = credentialStoreEnvironment.getCredentialStore().retrieveASFDevice();
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                    credentialStoreEvent = new CredentialStoreEvent(new CredentialStoreEvent.EventType.CompletedOperation(retrieveASFDevice), null, 2, null);
                } catch (CredentialStoreError e) {
                    credentialStoreEvent = new CredentialStoreEvent(new CredentialStoreEvent.EventType.ThrowError(e), null, 2, null);
                }
                Logger logger = credentialStoreEnvironment.getLogger();
                StringBuilder m = PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0.m(id, " Sending event ");
                m.append(credentialStoreEvent.getType());
                logger.verbose(m.toString());
                eventDispatcher.send(credentialStoreEvent);
                return Unit.INSTANCE;
            }

            @Override // com.amplifyframework.statemachine.Action
            public String getId() {
                return this.id;
            }
        };
    }

    @Override // com.amplifyframework.statemachine.codegen.actions.CredentialStoreActions
    public Action migrateLegacyCredentialStoreAction() {
        Action.Companion companion = Action.Companion;
        final String str = "MigrateLegacyCredentials";
        return new Action(str) { // from class: com.amplifyframework.auth.cognito.actions.CredentialStoreCognitoActions$migrateLegacyCredentialStoreAction$$inlined$invoke$1
            private final String id;

            {
                this.id = str == null ? Action.DefaultImpls.getId(this) : str;
            }

            @Override // com.amplifyframework.statemachine.Action
            public Object execute(EventDispatcher eventDispatcher, Environment environment, Continuation<? super Unit> continuation) {
                CredentialStoreEvent credentialStoreEvent;
                Intrinsics.checkNotNull(environment, "null cannot be cast to non-null type EnvType of com.amplifyframework.statemachine.Action.Companion.invoke");
                String id = getId();
                CredentialStoreEnvironment credentialStoreEnvironment = (CredentialStoreEnvironment) environment;
                AuthCognitoActions$initializeAuthorizationConfigurationAction$$inlined$invoke$1$$ExternalSyntheticOutline0.m(id, " Starting execution", credentialStoreEnvironment.getLogger());
                try {
                    AmplifyCredential retrieveCredential = credentialStoreEnvironment.getLegacyCredentialStore().retrieveCredential();
                    if (!Intrinsics.areEqual(retrieveCredential, AmplifyCredential.Empty.INSTANCE)) {
                        credentialStoreEnvironment.getCredentialStore().saveCredential(retrieveCredential);
                        credentialStoreEnvironment.getLegacyCredentialStore().deleteCredential();
                    }
                    String retrieveLastAuthUserId = credentialStoreEnvironment.getLegacyCredentialStore().retrieveLastAuthUserId();
                    if (retrieveLastAuthUserId != null) {
                        DeviceMetadata retrieveDeviceMetadata = credentialStoreEnvironment.getLegacyCredentialStore().retrieveDeviceMetadata(retrieveLastAuthUserId);
                        if (!Intrinsics.areEqual(retrieveDeviceMetadata, DeviceMetadata.Empty.INSTANCE)) {
                            credentialStoreEnvironment.getCredentialStore().saveDeviceMetadata(retrieveLastAuthUserId, retrieveDeviceMetadata);
                            credentialStoreEnvironment.getLegacyCredentialStore().deleteDeviceKeyCredential(retrieveLastAuthUserId);
                        }
                    }
                    AmplifyCredential.ASFDevice retrieveASFDevice = credentialStoreEnvironment.getLegacyCredentialStore().retrieveASFDevice();
                    if (retrieveASFDevice.getId() != null) {
                        credentialStoreEnvironment.getCredentialStore().saveASFDevice(retrieveASFDevice);
                        credentialStoreEnvironment.getLegacyCredentialStore().deleteASFDevice();
                    }
                    credentialStoreEvent = new CredentialStoreEvent(new CredentialStoreEvent.EventType.LoadCredentialStore(CredentialType.Amplify.INSTANCE), null, 2, null);
                } catch (CredentialStoreError e) {
                    credentialStoreEvent = new CredentialStoreEvent(new CredentialStoreEvent.EventType.ThrowError(e), null, 2, null);
                }
                Logger logger = credentialStoreEnvironment.getLogger();
                StringBuilder m = PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0.m(id, " Sending event ");
                m.append(credentialStoreEvent.getType());
                logger.verbose(m.toString());
                eventDispatcher.send(credentialStoreEvent);
                return Unit.INSTANCE;
            }

            @Override // com.amplifyframework.statemachine.Action
            public String getId() {
                return this.id;
            }
        };
    }

    @Override // com.amplifyframework.statemachine.codegen.actions.CredentialStoreActions
    public Action moveToIdleStateAction() {
        Action.Companion companion = Action.Companion;
        final String str = "MoveToIdleState";
        return new Action(str) { // from class: com.amplifyframework.auth.cognito.actions.CredentialStoreCognitoActions$moveToIdleStateAction$$inlined$invoke$1
            private final String id;

            {
                this.id = str == null ? Action.DefaultImpls.getId(this) : str;
            }

            @Override // com.amplifyframework.statemachine.Action
            public Object execute(EventDispatcher eventDispatcher, Environment environment, Continuation<? super Unit> continuation) {
                Intrinsics.checkNotNull(environment, "null cannot be cast to non-null type EnvType of com.amplifyframework.statemachine.Action.Companion.invoke");
                String id = getId();
                CredentialStoreEnvironment credentialStoreEnvironment = (CredentialStoreEnvironment) environment;
                credentialStoreEnvironment.getLogger().verbose(id + " Starting execution");
                CredentialStoreEvent credentialStoreEvent = new CredentialStoreEvent(new CredentialStoreEvent.EventType.MoveToIdleState(null, 1, null), null, 2, null);
                Logger logger = credentialStoreEnvironment.getLogger();
                StringBuilder m = PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0.m(id, " Sending event ");
                m.append(credentialStoreEvent.getType());
                logger.verbose(m.toString());
                eventDispatcher.send(credentialStoreEvent);
                return Unit.INSTANCE;
            }

            @Override // com.amplifyframework.statemachine.Action
            public String getId() {
                return this.id;
            }
        };
    }

    @Override // com.amplifyframework.statemachine.codegen.actions.CredentialStoreActions
    public Action storeCredentialsAction(final CredentialType credentialType, final AmplifyCredential credentials) {
        Intrinsics.checkNotNullParameter(credentialType, "credentialType");
        Intrinsics.checkNotNullParameter(credentials, "credentials");
        Action.Companion companion = Action.Companion;
        final String str = "StoreCredentials";
        return new Action(str, credentialType, credentials) { // from class: com.amplifyframework.auth.cognito.actions.CredentialStoreCognitoActions$storeCredentialsAction$$inlined$invoke$1
            final /* synthetic */ CredentialType $credentialType$inlined;
            final /* synthetic */ AmplifyCredential $credentials$inlined;
            private final String id;

            {
                this.$credentialType$inlined = credentialType;
                this.$credentials$inlined = credentials;
                this.id = str == null ? Action.DefaultImpls.getId(this) : str;
            }

            @Override // com.amplifyframework.statemachine.Action
            public Object execute(EventDispatcher eventDispatcher, Environment environment, Continuation<? super Unit> continuation) {
                CredentialStoreEvent credentialStoreEvent;
                AmplifyCredential.ASFDevice aSFDevice;
                AmplifyCredential.DeviceMetaDataTypeCredential deviceMetaDataTypeCredential;
                Intrinsics.checkNotNull(environment, "null cannot be cast to non-null type EnvType of com.amplifyframework.statemachine.Action.Companion.invoke");
                String id = getId();
                CredentialStoreEnvironment credentialStoreEnvironment = (CredentialStoreEnvironment) environment;
                AuthCognitoActions$initializeAuthorizationConfigurationAction$$inlined$invoke$1$$ExternalSyntheticOutline0.m(id, " Starting execution", credentialStoreEnvironment.getLogger());
                try {
                    CredentialType credentialType2 = this.$credentialType$inlined;
                    if (Intrinsics.areEqual(credentialType2, CredentialType.Amplify.INSTANCE)) {
                        credentialStoreEnvironment.getCredentialStore().saveCredential(this.$credentials$inlined);
                    } else if (credentialType2 instanceof CredentialType.Device) {
                        Object obj = this.$credentials$inlined;
                        if (obj instanceof AmplifyCredential.DeviceMetaDataTypeCredential) {
                            deviceMetaDataTypeCredential = (AmplifyCredential.DeviceMetaDataTypeCredential) obj;
                        } else {
                            deviceMetaDataTypeCredential = null;
                        }
                        if (deviceMetaDataTypeCredential != null) {
                            credentialStoreEnvironment.getCredentialStore().saveDeviceMetadata(((CredentialType.Device) this.$credentialType$inlined).getUsername(), deviceMetaDataTypeCredential.getDeviceMetadata());
                        }
                    } else if (Intrinsics.areEqual(credentialType2, CredentialType.ASF.INSTANCE)) {
                        AmplifyCredential amplifyCredential = this.$credentials$inlined;
                        if (amplifyCredential instanceof AmplifyCredential.ASFDevice) {
                            aSFDevice = (AmplifyCredential.ASFDevice) amplifyCredential;
                        } else {
                            aSFDevice = null;
                        }
                        if (aSFDevice != null && aSFDevice.getId() != null) {
                            credentialStoreEnvironment.getCredentialStore().saveASFDevice(aSFDevice);
                        }
                    }
                    credentialStoreEvent = new CredentialStoreEvent(new CredentialStoreEvent.EventType.CompletedOperation(this.$credentials$inlined), null, 2, null);
                } catch (CredentialStoreError e) {
                    credentialStoreEvent = new CredentialStoreEvent(new CredentialStoreEvent.EventType.ThrowError(e), null, 2, null);
                }
                Logger logger = credentialStoreEnvironment.getLogger();
                StringBuilder m = PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0.m(id, " Sending event ");
                m.append(credentialStoreEvent.getType());
                logger.verbose(m.toString());
                eventDispatcher.send(credentialStoreEvent);
                return Unit.INSTANCE;
            }

            @Override // com.amplifyframework.statemachine.Action
            public String getId() {
                return this.id;
            }
        };
    }
}
