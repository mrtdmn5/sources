package com.animaconnected.secondo.screens.settings;

import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline0;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline2;
import androidx.compose.animation.AnimatedVisibilityKt$$ExternalSyntheticOutline0;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.material.SliderKt$$ExternalSyntheticOutline0;
import androidx.compose.material.TextKt;
import androidx.compose.material.Typography;
import androidx.compose.material.TypographyKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetCompositeKeyHash$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import com.animaconnected.widget.ModifiersKt;
import com.animaconnected.widget.TopbarKt;
import com.google.common.base.Strings;
import com.kronaby.watch.app.R;
import io.ktor.http.URLProtocolKt;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OpenSourceLicenses.kt */
/* loaded from: classes3.dex */
public final class OpenSourceLicensesKt {
    private static final String amazonLicense = "\nAmazon Software License\nThis Amazon Software License (“License”) governs your use, reproduction, and distribution of the accompanying software as specified below.\n1. Definitions\n“Licensor” means any person or entity that distributes its Work.\n\n“Software” means the original work of authorship made available under this License.\n\n“Work” means the Software and any additions to or derivative works of the Software that are made available under this License.\n\nThe terms “reproduce,” “reproduction,” “derivative works,” and “distribution” have the meaning as provided under U.S. copyright law; provided, however, that for the purposes of this License, derivative works shall not include works that remain separable from, or merely link (or bind by name) to the interfaces of, the Work.\n\nWorks, including the Software, are “made available” under this License by including in or with the Work either (a) a copyright notice referencing the applicability of this License to the Work, or (b) a copy of this License.\n2. License Grants\n2.1 Copyright Grant. Subject to the terms and conditions of this License, each Licensor grants to you a perpetual, worldwide, non-exclusive, royalty-free, copyright license to reproduce, prepare derivative works of, publicly display, publicly perform, sublicense and distribute its Work and any resulting derivative works in any form.\n2.2 Patent Grant. Subject to the terms and conditions of this License, each Licensor grants to you a perpetual, worldwide, non-exclusive, royalty-free patent license to make, have made, use, sell, offer for sale, import, and otherwise transfer its Work, in whole or in part. The foregoing license applies only to the patent claims licensable by Licensor that would be infringed by Licensor’s Work (or portion thereof) individually and excluding any combinations with any other materials or technology.\n3. Limitations\n3.1 Redistribution. You may reproduce or distribute the Work only if (a) you do so under this License, (b) you include a complete copy of this License with your distribution, and (c) you retain without modification any copyright, patent, trademark, or attribution notices that are present in the Work.\n3.2 Derivative Works. You may specify that additional or different terms apply to the use, reproduction, and distribution of your derivative works of the Work (“Your Terms”) only if (a) Your Terms provide that the use limitation in Section 3.3 applies to your derivative works, and (b) you identify the specific derivative works that are subject to Your Terms. Notwithstanding Your Terms, this License (including the redistribution requirements in Section 3.1) will continue to apply to the Work itself.\n3.3 Use Limitation. The Work and any derivative works thereof only may be used or intended for use with the web services, computing platforms or applications provided by Amazon.com, Inc. or its affiliates, including Amazon Web Services, Inc.\n3.4 Patent Claims. If you bring or threaten to bring a patent claim against any Licensor (including any claim, cross-claim or counterclaim in a lawsuit) to enforce any patents that you allege are infringed by any Work, then your rights under this License from such Licensor (including the grants in Sections 2.1 and 2.2) will terminate immediately.\n3.5 Trademarks. This License does not grant any rights to use any Licensor’s or its affiliates’ names, logos, or trademarks, except as necessary to reproduce the notices described in this License.\n3.6 Termination. If you violate any term of this License, then your rights under this License (including the grants in Sections 2.1 and 2.2) will terminate immediately.\n4. Disclaimer of Warranty.\nTHE WORK IS PROVIDED “AS IS” WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING WARRANTIES OR CONDITIONS OF M ERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, TITLE OR NON-INFRINGEMENT. YOU BEAR THE RISK OF UNDERTAKING ANY ACTIVITIES UNDER THIS LICENSE. SOME STATES’ CONSUMER LAWS DO NOT ALLOW EXCLUSION OF AN IMPLIED WARRANTY, SO THIS DISCLAIMER MAY NOT APPLY TO YOU.\n5. Limitation of Liability.\nEXCEPT AS PROHIBITED BY APPLICABLE LAW, IN NO EVENT AND UNDER NO LEGAL THEORY, WHETHER IN TORT (INCLUDING NEGLIGENCE), CONTRACT, OR OTHERWISE SHALL ANY LICENSOR BE LIABLE TO YOU FOR DAMAGES, INCLUDING ANY DIRECT, INDIRECT, SPECIAL, INCIDENTAL, OR CONSEQUENTIAL DAMAGES ARISING OUT OF OR RELATED TO THIS LICENSE, THE USE OR INABILITY TO USE THE WORK (INCLUDING BUT NOT LIMITED TO LOSS OF GOODWILL, BUSINESS INTERRUPTION, LOST PROFITS OR DATA, COMPUTER FAILURE OR MALFUNCTION, OR ANY OTHER COMM ERCIAL DAMAGES OR LOSSES), EVEN IF THE LICENSOR HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGES.\nEffective Date – April 18, 2008 © 2008 Amazon.com, Inc. or its affiliates. All rights reserved.";
    private static final String apacheLicense = "\nApache License\nVersion 2.0, January 2004\nhttp://www.apache.org/licenses/\n\nTERMS AND CONDITIONS FOR USE, REPRODUCTION, AND DISTRIBUTION\n\n1. Definitions.\n\n   \"License\" shall mean the terms and conditions for use, reproduction,\n   and distribution as defined by Sections 1 through 9 of this document.\n\n   \"Licensor\" shall mean the copyright owner or entity authorized by\n   the copyright owner that is granting the License.\n\n   \"Legal Entity\" shall mean the union of the acting entity and all\n   other entities that control, are controlled by, or are under common\n   control with that entity. For the purposes of this definition,\n   \"control\" means (i) the power, direct or indirect, to cause the\n   direction or management of such entity, whether by contract or\n   otherwise, or (ii) ownership of fifty percent (50%) or more of the\n   outstanding shares, or (iii) beneficial ownership of such entity.\n\n   \"You\" (or \"Your\") shall mean an individual or Legal Entity\n   exercising permissions granted by this License.\n\n   \"Source\" form shall mean the preferred form for making modifications,\n   including but not limited to software source code, documentation\n   source, and configuration files.\n\n   \"Object\" form shall mean any form resulting from mechanical\n   transformation or translation of a Source form, including but\n   not limited to compiled object code, generated documentation,\n   and conversions to other media types.\n\n   \"Work\" shall mean the work of authorship, whether in Source or\n   Object form, made available under the License, as indicated by a\n   copyright notice that is included in or attached to the work\n   (an example is provided in the Appendix below).\n\n   \"Derivative Works\" shall mean any work, whether in Source or Object\n   form, that is based on (or derived from) the Work and for which the\n   editorial revisions, annotations, elaborations, or other modifications\n   represent, as a whole, an original work of authorship. For the purposes\n   of this License, Derivative Works shall not include works that remain\n   separable from, or merely link (or bind by name) to the interfaces of,\n   the Work and Derivative Works thereof.\n\n   \"Contribution\" shall mean any work of authorship, including\n   the original version of the Work and any modifications or additions\n   to that Work or Derivative Works thereof, that is intentionally\n   submitted to Licensor for inclusion in the Work by the copyright owner\n   or by an individual or Legal Entity authorized to submit on behalf of\n   the copyright owner. For the purposes of this definition, \"submitted\"\n   means any form of electronic, verbal, or written communication sent\n   to the Licensor or its representatives, including but not limited to\n   communication on electronic mailing lists, source code control systems,\n   and issue tracking systems that are managed by, or on behalf of, the\n   Licensor for the purpose of discussing and improving the Work, but\n   excluding communication that is conspicuously marked or otherwise\n   designated in writing by the copyright owner as \"Not a Contribution.\"\n\n   \"Contributor\" shall mean Licensor and any individual or Legal Entity\n   on behalf of whom a Contribution has been received by Licensor and\n   subsequently incorporated within the Work.\n\n2. Grant of Copyright License. Subject to the terms and conditions of\n   this License, each Contributor hereby grants to You a perpetual,\n   worldwide, non-exclusive, no-charge, royalty-free, irrevocable\n   copyright license to reproduce, prepare Derivative Works of,\n   publicly display, publicly perform, sublicense, and distribute the\n   Work and such Derivative Works in Source or Object form.\n\n3. Grant of Patent License. Subject to the terms and conditions of\n   this License, each Contributor hereby grants to You a perpetual,\n   worldwide, non-exclusive, no-charge, royalty-free, irrevocable\n   (except as stated in this section) patent license to make, have made,\n   use, offer to sell, sell, import, and otherwise transfer the Work,\n   where such license applies only to those patent claims licensable\n   by such Contributor that are necessarily infringed by their\n   Contribution(s) alone or by combination of their Contribution(s)\n   with the Work to which such Contribution(s) was submitted. If You\n   institute patent litigation against any entity (including a\n   cross-claim or counterclaim in a lawsuit) alleging that the Work\n   or a Contribution incorporated within the Work constitutes direct\n   or contributory patent infringement, then any patent licenses\n   granted to You under this License for that Work shall terminate\n   as of the date such litigation is filed.\n\n4. Redistribution. You may reproduce and distribute copies of the\n   Work or Derivative Works thereof in any medium, with or without\n   modifications, and in Source or Object form, provided that You\n   meet the following conditions:\n\n   (a) You must give any other recipients of the Work or\n       Derivative Works a copy of this License; and\n\n   (b) You must cause any modified files to carry prominent notices\n       stating that You changed the files; and\n\n   (c) You must retain, in the Source form of any Derivative Works\n       that You distribute, all copyright, patent, trademark, and\n       attribution notices from the Source form of the Work,\n       excluding those notices that do not pertain to any part of\n       the Derivative Works; and\n\n   (d) If the Work includes a \"NOTICE\" text file as part of its\n       distribution, then any Derivative Works that You distribute must\n       include a readable copy of the attribution notices contained\n       within such NOTICE file, excluding those notices that do not\n       pertain to any part of the Derivative Works, in at least one\n       of the following places: within a NOTICE text file distributed\n       as part of the Derivative Works; within the Source form or\n       documentation, if provided along with the Derivative Works; or,\n       within a display generated by the Derivative Works, if and\n       wherever such third-party notices normally appear. The contents\n       of the NOTICE file are for informational purposes only and\n       do not modify the License. You may add Your own attribution\n       notices within Derivative Works that You distribute, alongside\n       or as an addendum to the NOTICE text from the Work, provided\n       that such additional attribution notices cannot be construed\n       as modifying the License.\n\n   You may add Your own copyright statement to Your modifications and\n   may provide additional or different license terms and conditions\n   for use, reproduction, or distribution of Your modifications, or\n   for any such Derivative Works as a whole, provided Your use,\n   reproduction, and distribution of the Work otherwise complies with\n   the conditions stated in this License.\n\n5. Submission of Contributions. Unless You explicitly state otherwise,\n   any Contribution intentionally submitted for inclusion in the Work\n   by You to the Licensor shall be under the terms and conditions of\n   this License, without any additional terms or conditions.\n   Notwithstanding the above, nothing herein shall supersede or modify\n   the terms of any separate license agreement you may have executed\n   with Licensor regarding such Contributions.\n\n6. Trademarks. This License does not grant permission to use the trade\n   names, trademarks, service marks, or product names of the Licensor,\n   except as required for reasonable and customary use in describing the\n   origin of the Work and reproducing the content of the NOTICE file.\n\n7. Disclaimer of Warranty. Unless required by applicable law or\n   agreed to in writing, Licensor provides the Work (and each\n   Contributor provides its Contributions) on an \"AS IS\" BASIS,\n   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or\n   implied, including, without limitation, any warranties or conditions\n   of TITLE, NON-INFRINGEMENT, MERCHANTABILITY, or FITNESS FOR A\n   PARTICULAR PURPOSE. You are solely responsible for determining the\n   appropriateness of using or redistributing the Work and assume any\n   risks associated with Your exercise of permissions under this License.\n\n8. Limitation of Liability. In no event and under no legal theory,\n   whether in tort (including negligence), contract, or otherwise,\n   unless required by applicable law (such as deliberate and grossly\n   negligent acts) or agreed to in writing, shall any Contributor be\n   liable to You for damages, including any direct, indirect, special,\n   incidental, or consequential damages of any character arising as a\n   result of this License or out of the use or inability to use the\n   Work (including but not limited to damages for loss of goodwill,\n   work stoppage, computer failure or malfunction, or any and all\n   other commercial damages or losses), even if such Contributor\n   has been advised of the possibility of such damages.\n\n9. Accepting Warranty or Additional Liability. While redistributing\n   the Work or Derivative Works thereof, You may choose to offer,\n   and charge a fee for, acceptance of support, warranty, indemnity,\n   or other liability obligations and/or rights consistent with this\n   License. However, in accepting such obligations, You may act only\n   on Your own behalf and on Your sole responsibility, not on behalf\n   of any other Contributor, and only if You agree to indemnify,\n   defend, and hold each Contributor harmless for any liability\n   incurred by, or claims asserted against, such Contributor by reason\n   of your accepting any such warranty or additional liability.\n\nEND OF TERMS AND CONDITIONS\n\nAPPENDIX: How to apply the Apache License to your work.\n\n   To apply the Apache License to your work, attach the following\n   boilerplate notice, with the fields enclosed by brackets \"[]\"\n   replaced with your own identifying information. (Don't include\n   the brackets!)  The text should be enclosed in the appropriate\n   comment syntax for the file format. We also recommend that a\n   file or class name and description of purpose be included on the\n   same \"printed page\" as the copyright notice for easier\n   identification within third-party archives.\n\nCopyright [yyyy] [name of copyright owner]\n\nLicensed under the Apache License, Version 2.0 (the \"License\");\nyou may not use this file except in compliance with the License.\nYou may obtain a copy of the License at\n\n    http://www.apache.org/licenses/LICENSE-2.0\n\nUnless required by applicable law or agreed to in writing, software\ndistributed under the License is distributed on an \"AS IS\" BASIS,\nWITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\nSee the License for the specific language governing permissions and\nlimitations under the License.";
    private static final String bsd2ClauseLicense = "\nThe 2-Clause BSD License\n\nCopyright <YEAR> <COPYRIGHT HOLDER>\n\nRedistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:\n\n1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.\n\n2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.\n\nTHIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS “AS IS” AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.";
    private static final String bsd3ClauseLicense = "\nThe 3-Clause BSD License\n\nCopyright <YEAR> <COPYRIGHT HOLDER>\n\nRedistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:\n\n1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.\n\n2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.\n\n3. Neither the name of the copyright holder nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.\n\nTHIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS “AS IS” AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.";
    private static final String mitLicense = "\nThe MIT License\n\nCopyright <YEAR> <COPYRIGHT HOLDER>\n\nPermission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the “Software”), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:\n\nThe above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.\n\nTHE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.";
    private static final String thirdPartySourceCodeString = "The Android Open Source Project:DeskClock\n\nhttps://source.android.com\nhttps://android.googlesource.com/platform/packages/apps/DeskClock\n\nCopyright (c) 2005-2008, The Android Open Source Project\n\nLicensed under the Apache License, Version 2.0 (the \"License\");\nyou may not use this file except in compliance with the License.\n\nUnless required by applicable law or agreed to in writing, software\ndistributed under the License is distributed on an \"AS IS\" BASIS,\nWITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\nSee the License for the specific language governing permissions and\nlimitations under the License.";

    public static final void LicenseInformation(final Project project, Composer composer, final int r60) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(613671462);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        startRestartGroup.startReplaceableGroup(-483455358);
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, startRestartGroup);
        startRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
        PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
        ComposeUiNode.Companion.getClass();
        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
        ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion);
        if (startRestartGroup.applier instanceof Applier) {
            startRestartGroup.startReusableNode();
            if (startRestartGroup.inserting) {
                startRestartGroup.createNode(layoutNode$Companion$Constructor$1);
            } else {
                startRestartGroup.useNode();
            }
            Updater.m228setimpl(startRestartGroup, columnMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$1 = ComposeUiNode.Companion.SetCompositeKeyHash;
            if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash))) {
                AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash, startRestartGroup, currentCompositeKeyHash, composeUiNode$Companion$SetCompositeKeyHash$1);
            }
            modifierMaterializerOf.invoke((Object) new SkippableUpdater(startRestartGroup), (Object) startRestartGroup, (Object) 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            String projectAndVersion = project.getProjectAndVersion();
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = TypographyKt.LocalTypography;
            TextKt.m216Text4IGK_g(projectAndVersion, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.m529copyv2rsoow$default(16777211, 0L, 0L, 0L, null, ((Typography) startRestartGroup.consume(staticProvidableCompositionLocal)).body1, null, FontWeight.Bold), startRestartGroup, 0, 0, 65534);
            TextKt.m216Text4IGK_g(project.getCopyright(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(staticProvidableCompositionLocal)).body1, startRestartGroup, 0, 0, 65534);
            List<License> licenses = project.getLicenses();
            startRestartGroup.startReplaceableGroup(-1305735874);
            if (licenses != null) {
                for (License license : licenses) {
                    String license2 = license.getLicense();
                    startRestartGroup.startReplaceableGroup(770764177);
                    if (license2 != null) {
                        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                        TextKt.m216Text4IGK_g(license2, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(TypographyKt.LocalTypography)).body1, startRestartGroup, 0, 0, 65534);
                    }
                    startRestartGroup.end(false);
                    String license_url = license.getLicense_url();
                    startRestartGroup.startReplaceableGroup(770764360);
                    if (license_url != null) {
                        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$13 = ComposerKt.removeCurrentGroupInstance;
                        TextKt.m216Text4IGK_g(license_url, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(TypographyKt.LocalTypography)).body1, startRestartGroup, 0, 0, 65534);
                    }
                    startRestartGroup.end(false);
                }
            }
            AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, false, false, true, false);
            startRestartGroup.end(false);
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$14 = ComposerKt.removeCurrentGroupInstance;
            RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
                endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.settings.OpenSourceLicensesKt$LicenseInformation$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int r3) {
                        OpenSourceLicensesKt.LicenseInformation(Project.this, composer2, Strings.updateChangedFlags(r60 | 1));
                    }
                };
                return;
            }
            return;
        }
        ComposablesKt.invalidApplier();
        throw null;
    }

    public static final void LicenseIntro(Composer composer, final int r33) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(-1149702933);
        if (r33 == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            startRestartGroup.startReplaceableGroup(-483455358);
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, startRestartGroup);
            startRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
            PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion);
            if (startRestartGroup.applier instanceof Applier) {
                startRestartGroup.startReusableNode();
                if (startRestartGroup.inserting) {
                    startRestartGroup.createNode(layoutNode$Companion$Constructor$1);
                } else {
                    startRestartGroup.useNode();
                }
                Updater.m228setimpl(startRestartGroup, columnMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$1 = ComposeUiNode.Companion.SetCompositeKeyHash;
                if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash))) {
                    AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash, startRestartGroup, currentCompositeKeyHash, composeUiNode$Companion$SetCompositeKeyHash$1);
                }
                AnimatedVisibilityKt$$ExternalSyntheticOutline0.m(0, modifierMaterializerOf, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585);
                float f = 16;
                Modifier m75paddingqDBjuR0$default = PaddingKt.m75paddingqDBjuR0$default(SizeKt.fillMaxWidth(companion, 1.0f), 0.0f, f, 0.0f, 0.0f, 13);
                String stringResource = URLProtocolKt.stringResource(R.string.licenses_title, startRestartGroup);
                StaticProvidableCompositionLocal staticProvidableCompositionLocal = TypographyKt.LocalTypography;
                TextKt.m216Text4IGK_g(stringResource, m75paddingqDBjuR0$default, 0L, 0L, null, null, null, 0L, null, new TextAlign(3), 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(staticProvidableCompositionLocal)).h1, startRestartGroup, 48, 0, 65020);
                TextKt.m216Text4IGK_g(URLProtocolKt.stringResource(R.string.licenses_intro, startRestartGroup), PaddingKt.m75paddingqDBjuR0$default(SizeKt.fillMaxWidth(companion, 1.0f), 0.0f, 32, 0.0f, 0.0f, 13), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(staticProvidableCompositionLocal)).body1, startRestartGroup, 48, 0, 65532);
                TextKt.m216Text4IGK_g(thirdPartySourceCodeString, PaddingKt.m75paddingqDBjuR0$default(SizeKt.fillMaxWidth(companion, 1.0f), 0.0f, f, 0.0f, f, 5), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(staticProvidableCompositionLocal)).body1, startRestartGroup, 54, 0, 65532);
                AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, false, true, false, false);
            } else {
                ComposablesKt.invalidApplier();
                throw null;
            }
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.settings.OpenSourceLicensesKt$LicenseIntro$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r2) {
                    OpenSourceLicensesKt.LicenseIntro(composer2, Strings.updateChangedFlags(r33 | 1));
                }
            };
        }
    }

    public static final void ThirdPartyLicenses(Modifier modifier, final List<Project> list, final List<Project> list2, final Function0<Unit> function0, Composer composer, final int r23, final int r24) {
        final Modifier modifier2;
        ComposerImpl startRestartGroup = composer.startRestartGroup(-1329784216);
        int r1 = r24 & 1;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        if (r1 != 0) {
            modifier2 = companion;
        } else {
            modifier2 = modifier;
        }
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        startRestartGroup.startReplaceableGroup(-483455358);
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, startRestartGroup);
        startRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
        PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
        ComposeUiNode.Companion.getClass();
        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
        ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier2);
        int r3 = (((((r23 & 14) << 3) & 112) << 9) & 7168) | 6;
        if (startRestartGroup.applier instanceof Applier) {
            startRestartGroup.startReusableNode();
            if (startRestartGroup.inserting) {
                startRestartGroup.createNode(layoutNode$Companion$Constructor$1);
            } else {
                startRestartGroup.useNode();
            }
            Updater.m228setimpl(startRestartGroup, columnMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$1 = ComposeUiNode.Companion.SetCompositeKeyHash;
            if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash))) {
                AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash, startRestartGroup, currentCompositeKeyHash, composeUiNode$Companion$SetCompositeKeyHash$1);
            }
            AnimatedVisibilityKt$$ExternalSyntheticOutline0.m((r3 >> 3) & 112, modifierMaterializerOf, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585);
            String stringResource = URLProtocolKt.stringResource(R.string.feature_path_settings, startRestartGroup);
            startRestartGroup.startReplaceableGroup(-1942279264);
            boolean z = true;
            if ((((r23 & 7168) ^ 3072) <= 2048 || !startRestartGroup.changedInstance(function0)) && (r23 & 3072) != 2048) {
                z = false;
            }
            Object nextSlot = startRestartGroup.nextSlot();
            if (z || nextSlot == Composer.Companion.Empty) {
                nextSlot = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.settings.OpenSourceLicensesKt$ThirdPartyLicenses$1$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        function0.invoke();
                    }
                };
                startRestartGroup.updateValue(nextSlot);
            }
            startRestartGroup.end(false);
            TopbarKt.TopBar(null, R.drawable.ic_chevron_left, (Function0) nextSlot, stringResource, null, startRestartGroup, 48, 17);
            Modifier m1614fadingEdgeTop3ABfNKs = ModifiersKt.m1614fadingEdgeTop3ABfNKs(companion, ModifiersKt.getDefaultFadingEdgeHeight());
            float f = 32;
            LazyDslKt.LazyColumn(PaddingKt.m75paddingqDBjuR0$default(m1614fadingEdgeTop3ABfNKs, f, 0.0f, f, 56, 2), null, null, false, Arrangement.m60spacedBy0680j_4(f), null, null, false, new Function1<LazyListScope, Unit>() { // from class: com.animaconnected.secondo.screens.settings.OpenSourceLicensesKt$ThirdPartyLicenses$1$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                    invoke2(lazyListScope);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Type inference failed for: r3v1, types: [com.animaconnected.secondo.screens.settings.OpenSourceLicensesKt$ThirdPartyLicenses$1$2$invoke$$inlined$items$default$4, kotlin.jvm.internal.Lambda] */
                /* JADX WARN: Type inference failed for: r4v2, types: [com.animaconnected.secondo.screens.settings.OpenSourceLicensesKt$ThirdPartyLicenses$1$2$invoke$$inlined$items$default$8, kotlin.jvm.internal.Lambda] */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(LazyListScope LazyColumn) {
                    Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                    ComposableSingletons$OpenSourceLicensesKt composableSingletons$OpenSourceLicensesKt = ComposableSingletons$OpenSourceLicensesKt.INSTANCE;
                    LazyColumn.item(null, null, composableSingletons$OpenSourceLicensesKt.m970getLambda1$secondo_kronabyRelease());
                    LazyColumn.item(null, null, composableSingletons$OpenSourceLicensesKt.m971getLambda2$secondo_kronabyRelease());
                    final List<Project> list3 = list;
                    final OpenSourceLicensesKt$ThirdPartyLicenses$1$2$invoke$$inlined$items$default$1 openSourceLicensesKt$ThirdPartyLicenses$1$2$invoke$$inlined$items$default$1 = new Function1() { // from class: com.animaconnected.secondo.screens.settings.OpenSourceLicensesKt$ThirdPartyLicenses$1$2$invoke$$inlined$items$default$1
                        @Override // kotlin.jvm.functions.Function1
                        public final Void invoke(Project project) {
                            return null;
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            return invoke((Project) obj);
                        }
                    };
                    LazyColumn.items(list3.size(), null, new Function1<Integer, Object>() { // from class: com.animaconnected.secondo.screens.settings.OpenSourceLicensesKt$ThirdPartyLicenses$1$2$invoke$$inlined$items$default$3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                            return invoke(num.intValue());
                        }

                        public final Object invoke(int r32) {
                            return Function1.this.invoke(list3.get(r32));
                        }
                    }, ComposableLambdaKt.composableLambdaInstance(-632812321, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.settings.OpenSourceLicensesKt$ThirdPartyLicenses$1$2$invoke$$inlined$items$default$4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(4);
                        }

                        @Override // kotlin.jvm.functions.Function4
                        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer2, Integer num2) {
                            invoke(lazyItemScope, num.intValue(), composer2, num2.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(LazyItemScope items, int r32, Composer composer2, int r5) {
                            int r2;
                            Intrinsics.checkNotNullParameter(items, "$this$items");
                            if ((r5 & 14) == 0) {
                                r2 = (composer2.changed(items) ? 4 : 2) | r5;
                            } else {
                                r2 = r5;
                            }
                            if ((r5 & 112) == 0) {
                                r2 |= composer2.changed(r32) ? 32 : 16;
                            }
                            if ((r2 & 731) == 146 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                            } else {
                                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                                OpenSourceLicensesKt.LicenseInformation((Project) list3.get(r32), composer2, 8);
                            }
                        }
                    }, true));
                    final List<Project> list4 = list2;
                    final OpenSourceLicensesKt$ThirdPartyLicenses$1$2$invoke$$inlined$items$default$5 openSourceLicensesKt$ThirdPartyLicenses$1$2$invoke$$inlined$items$default$5 = new Function1() { // from class: com.animaconnected.secondo.screens.settings.OpenSourceLicensesKt$ThirdPartyLicenses$1$2$invoke$$inlined$items$default$5
                        @Override // kotlin.jvm.functions.Function1
                        public final Void invoke(Project project) {
                            return null;
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            return invoke((Project) obj);
                        }
                    };
                    LazyColumn.items(list4.size(), null, new Function1<Integer, Object>() { // from class: com.animaconnected.secondo.screens.settings.OpenSourceLicensesKt$ThirdPartyLicenses$1$2$invoke$$inlined$items$default$7
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                            return invoke(num.intValue());
                        }

                        public final Object invoke(int r32) {
                            return Function1.this.invoke(list4.get(r32));
                        }
                    }, ComposableLambdaKt.composableLambdaInstance(-632812321, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.settings.OpenSourceLicensesKt$ThirdPartyLicenses$1$2$invoke$$inlined$items$default$8
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(4);
                        }

                        @Override // kotlin.jvm.functions.Function4
                        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer2, Integer num2) {
                            invoke(lazyItemScope, num.intValue(), composer2, num2.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(LazyItemScope items, int r32, Composer composer2, int r5) {
                            int r2;
                            Intrinsics.checkNotNullParameter(items, "$this$items");
                            if ((r5 & 14) == 0) {
                                r2 = (composer2.changed(items) ? 4 : 2) | r5;
                            } else {
                                r2 = r5;
                            }
                            if ((r5 & 112) == 0) {
                                r2 |= composer2.changed(r32) ? 32 : 16;
                            }
                            if ((r2 & 731) == 146 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                            } else {
                                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                                OpenSourceLicensesKt.LicenseInformation((Project) list4.get(r32), composer2, 8);
                            }
                        }
                    }, true));
                    LazyColumn.item(null, null, composableSingletons$OpenSourceLicensesKt.m972getLambda3$secondo_kronabyRelease());
                    LazyColumn.item(null, null, composableSingletons$OpenSourceLicensesKt.m973getLambda4$secondo_kronabyRelease());
                    LazyColumn.item(null, null, composableSingletons$OpenSourceLicensesKt.m974getLambda5$secondo_kronabyRelease());
                    LazyColumn.item(null, null, composableSingletons$OpenSourceLicensesKt.m975getLambda6$secondo_kronabyRelease());
                    LazyColumn.item(null, null, composableSingletons$OpenSourceLicensesKt.m976getLambda7$secondo_kronabyRelease());
                }
            }, startRestartGroup, 24576, 238);
            RecomposeScopeImpl m = SliderKt$$ExternalSyntheticOutline0.m(startRestartGroup, false, true, false, false);
            if (m != null) {
                m.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.settings.OpenSourceLicensesKt$ThirdPartyLicenses$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int r9) {
                        OpenSourceLicensesKt.ThirdPartyLicenses(Modifier.this, list, list2, function0, composer2, Strings.updateChangedFlags(r23 | 1), r24);
                    }
                };
                return;
            }
            return;
        }
        ComposablesKt.invalidApplier();
        throw null;
    }

    public static final /* synthetic */ void access$LicenseIntro(Composer composer, int r1) {
        LicenseIntro(composer, r1);
    }

    public static final /* synthetic */ String access$getAmazonLicense$p() {
        return amazonLicense;
    }

    public static final /* synthetic */ String access$getApacheLicense$p() {
        return apacheLicense;
    }

    public static final /* synthetic */ String access$getBsd2ClauseLicense$p() {
        return bsd2ClauseLicense;
    }

    public static final /* synthetic */ String access$getBsd3ClauseLicense$p() {
        return bsd3ClauseLicense;
    }

    public static final /* synthetic */ String access$getMitLicense$p() {
        return mitLicense;
    }
}
