package com.github.gwtmaterialdesign.client.application.googleplus;

/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2016 GwtMaterialDesign
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.client.ui.MaterialSplashScreen;
import gwt.material.design.client.ui.MaterialTab;

import javax.inject.Inject;


public class GooglePlusView extends ViewImpl implements GooglePlusPresenter.MyView {
    interface Binder extends UiBinder<Widget, GooglePlusView> {
    }

    @UiField
    MaterialSplashScreen splash;

    @UiField
    MaterialTab tab;

    @Inject
    GooglePlusView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
        splash.show();
        Timer t = new Timer() {
            @Override
            public void run() {
                splash.hide();
                tab.reload();
            }
        };
        t.schedule(5000);
    }
}
