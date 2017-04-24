package org.test;

import org.apache.commons.codec.digest.DigestUtils;
import org.vaadin.dialogs.ConfirmDialog;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.renderers.ButtonRenderer;

public class UserListView extends VerticalLayout implements View {

    private static final long serialVersionUID = 1085138977601539109L;

    private Label    titre;
    private UserGrid grid;

    private DataService<User, Long> service;

    public UserListView() {
        grid = new UserGrid();
        titre = new Label("Utilisateurs");
        service = UserService.getInstance();

        grid.getEditor().addSaveListener(event -> service.saveOrUpdate(event.getBean()));

        grid.addColumn(user -> "Réinitialiser Mot de passe", new ButtonRenderer<User>(clickEvent -> {
            ConfirmDialog.show(getUI(), "Réinitiliser mot de passe", "Êtes-vous certain?", "OK", "Annuler", new Runnable() {
                @Override
                public void run() {
                    User user = clickEvent.getItem();
                    user.setPassword(DigestUtils.md5Hex(user.getUsername()));
                    service.update(user);
                }
            });
        }));

        addComponents(titre, grid);
    }

    @Override
    public void enter(ViewChangeEvent event) {
        grid.setItems(service.findAll());
    }

}
