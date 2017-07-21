package org.test;

import com.vaadin.data.TreeData;
import com.vaadin.data.provider.TreeDataProvider;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Tree;
import com.vaadin.ui.VerticalLayout;

public class TreeView extends VerticalLayout implements View {

    private static final long serialVersionUID = 7579875662709767802L;

    public TreeView() {
        super();
    }

    @Override
    public void enter(ViewChangeEvent event) {
        Tree<String> tree = new Tree<>();
        TreeData<String> treeData = new TreeData<>();

        // Couple of childless root items
        treeData.addItem(null, "Mercury");
        treeData.addItem(null, "Venus");

        // Items with hierarchy
        treeData.addItem(null, "Earth");
        treeData.addItem("Earth", "The Moon");

        TreeDataProvider<String> inMemoryDataProvider = new TreeDataProvider<>(treeData);
        tree.setDataProvider(inMemoryDataProvider);
        tree.expand("Earth"); // Expand programmatically

        addComponent(tree);
    }


}
