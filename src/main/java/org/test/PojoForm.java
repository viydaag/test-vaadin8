package org.test;

import org.vaadin.viritin.fields.IntegerField;
import org.vaadin.viritin.form.AbstractForm;
import org.vaadin.viritin.form.AbstractForm.ResetHandler;

import com.vaadin.ui.Component;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.VerticalLayout;

public class PojoForm extends VerticalLayout {

    private static final long serialVersionUID = -3372312513086236945L;

    public PojoForm() {
        AbstractForm<Pojo> form = new AbstractForm<Pojo>(Pojo.class) {
            
            private static final long serialVersionUID = 1251886098275380006L;
            IntegerField myInteger = new IntegerField("My Integer");

            @Override
            protected Component createContent() {
                FormLayout layout = new FormLayout(myInteger, getToolbar());
                return layout;
            }
        };
        
        form.setResetHandler(new ResetHandler<Pojo>() {
            @Override
            public void onReset(Pojo entity) {
                form.setEntity(null);
            }
        });

        form.setEntity(new Pojo());
        addComponent(form);
    }

    
    public class Pojo {

        private Integer myInteger;

        public Pojo() {
            myInteger = null;
        }

        public Integer getMyInteger() {
            return myInteger;
        }

        public void setMyInteger(Integer myInteger) {
            this.myInteger = myInteger;
        }
    }

}
