package org.test;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public abstract class AbstractCrudView<T extends Entity> extends VerticalLayout implements CrudView<T> {

    private static final long serialVersionUID = -6564885112560677215L;

    private Label            title;
    private HorizontalLayout buttonLayout;
    protected TextField      filter;
    private String           filterBy = "name";

    protected DSAbstractForm<T>    form;
    protected Grid<T>              grid;
    protected DataService<T, Long> service;
    protected CrudDataProvider<T>  dataProvider;

    private boolean isFormPopup     = false;
    private boolean isCreateAllowed = true;
    private boolean isDeleteAllowed = true;
    private boolean isFilterAllowed = true;

    //    private DataProvider<T, Void> dataProvider;

    public abstract DSAbstractForm<T> getForm();

    public abstract Grid<T> getGrid();

    public abstract DataService<T, Long> getDataService();

    public AbstractCrudView() {

        form = getForm();
        grid = getGrid();
        service = getDataService();
        dataProvider = new CrudDataProvider<>(service, getFilterBy());

        filter = new TextField();
        filter.setPlaceholder("filtre...");
        filter.addValueChangeListener(e -> {
            listEntries(e.getValue());
        });
        Button clearFilterButton = new Button(VaadinIcons.CLOSE);
        clearFilterButton.addClickListener(event -> filter.clear());
        CssLayout filterLayout = new CssLayout(filter, clearFilterButton);
        filterLayout.addStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
        //                ResetButtonForTextField resetText = ResetButtonForTextField.extend(filter);
        //                resetText.addResetButtonClickedListener(() -> listEntries());

        initForm();

        initGrid();

        if (form != null) {
            addComponent(title);
            if (isCreateAllowed()) {
                addComponent(buttonLayout);
            }
            addComponent(form);
            if (isFilterAllowed()) {
                addComponent(filterLayout);
            }
            addComponentsAndExpand(grid);
        } else {
            if (isFilterAllowed()) {
                addComponent(filterLayout);
            }
            addComponentsAndExpand(grid);
        }

        setSizeFull();
        addStyleName("v-scrollable");
    }

    protected void initGrid() {

        grid.setDataProvider(dataProvider);

        //        dataProvider = DataProvider.fromCallbacks(
        //                // First callback fetches items based on a query
        //                query -> {
        //                    // The index of the first item to load
        //                    int offset = query.getOffset();
        //
        //                    // The number of items to load
        //                    int limit = query.getLimit();
        //
        //                    List<Sort> sortOrders = new ArrayList<>();
        //                    query.getSortOrders().forEach(queryOrder -> {
        //                        Sort sort = service.createSort(
        //                                // The name of the sorted property
        //                                queryOrder.getSorted(),
        //                                // The sort direction for this property
        //                                queryOrder.getDirection() == SortDirection.DESCENDING);
        //                        sortOrders.add(sort);
        //                    });
        //
        //                    List<T> persons = service.findAllPagedOrderBy(offset, limit, sortOrders);
        //
        //                    return persons.stream();
        //                },
        //                // Second callback fetches the number of items for a query
        //                query -> service.count());

        grid.addSelectionListener(selectionEvent -> {
            entrySelected();
        });
    }

    protected void listEntries(String text) {

        dataProvider.setFilter(text);

        //        if (isFilterAllowed()) {
        //            grid.lazyLoadFrom((int firstRow, boolean[] sortAscending, String[] property) -> {
        //                String[] order = new String[sortAscending.length];
        //                for (int i = 0; i < sortAscending.length; i++) {
        //                    order[i] = sortAscending[i] ? "ASC" : "DESC";
        //                }
        //                return service.findAllByLikePagedOrderBy(getFilterBy(), text, firstRow, LazyList.DEFAULT_PAGE_SIZE,
        //                        property, order);
        //            }, () -> service.countWithFilter(getFilterBy(), text));
        //        } else {
        //            grid.lazyLoadFrom((int firstRow, boolean sortAscending, String property) -> service.findAllPaged(firstRow,
        //                    LazyList.DEFAULT_PAGE_SIZE), () -> (int) service.count());
        //        }
        //        grid.setRows(service.findAll());
    }

    protected void listEntries() {
        listEntries(filter.getValue());
    }

    protected void initForm() {
        if (form != null) {
            title = new Label(form.toString());

            if (isCreateAllowed()) {
                Button addNew = new Button("", VaadinIcons.PLUS);
                addNew.addClickListener(this::addNew);
                buttonLayout = new HorizontalLayout(addNew);
            }

            form.setEntity(null);

            //ajout handlers pour boutons
            form.setSavedHandler(this::entrySaved);
            form.setResetHandler(this::entryReset);

            if (isDeleteAllowed()) {
                form.setDeleteHandler(this::deleteSelected);
            } else {
                form.getDeleteButton().setVisible(false);
            }

            form.setCancelHandler(this::cancel);
        }
    }

    @Override
    public void entrySaved(T entity) {

        try {
            //save to database
            //            service.saveOrUpdate(entity);
            dataProvider.save(entity);

            //refresh ui
            grid.deselectAll();
            closeForm();
            //        grid.refresh(entity);
            //            grid.getDataProvider().refreshAll();

            Notification.show("Saved!", Type.HUMANIZED_MESSAGE);
        } catch (Exception e) {
            Notification.show("Failed! " + e.getLocalizedMessage(), Type.ERROR_MESSAGE);
            listEntries();
        }
    }

    protected void closeForm() {
        if (form != null) {
            form.setEntity(null);
            if (isFormPopup()) {
                form.closePopup();
            }
        }
    }

    @Override
    public void entryReset(T entity) {
        //        T original = dataProvider.get(entity.getId());
        //        if (original == null) {
        //            original = service.create();
        //        }
        //        form.setEntity(original);
        boolean isNew = dataProvider.refresh(entity);
        if (isNew) {
            entity = service.create();
        }
        form.setEntity(entity);
    }

    public void cancel(T entity) {
        closeForm();
    }

    @Override
    public void entrySelected() {
        if (form != null) {
            if (grid.getSelectionModel().getFirstSelectedItem().isPresent()) {
                form.setEntity(grid.getSelectionModel().getFirstSelectedItem().get());
            } else {
                form.setEntity(null);
            }

            if (isFormPopup()) {
                form.openInModalPopup();
            }
            form.focusFirst();
        }
    }

    public void addNew(Button.ClickEvent e) {
        form.setEntity(service.create());
        if (isFormPopup()) {
            form.openInModalPopup();
        }
        form.focusFirst();
    }

    @Override
    public void deleteSelected(T entity) {
        try {
            dataProvider.delete(entity);
            //            service.delete(entity);
            closeForm();
            //            grid.getDataProvider().refreshAll();
        } catch (Exception e) {
            Notification.show("Erreur suppression : soit les données n'existent pas ou ils sont utilisées sur d'autres objets", Type.ERROR_MESSAGE);
        }
    }

    @Override
    public void enter(ViewChangeEvent event) {
        listEntries();
    }

    public boolean isFormPopup() {
        return isFormPopup;
    }

    public void setFormPopup(boolean isFormPopup) {
        this.isFormPopup = isFormPopup;
    }

    public boolean isCreateAllowed() {
        return isCreateAllowed;
    }

    public void setCreateAllowed(boolean isCreateAllowed) {
        this.isCreateAllowed = isCreateAllowed;
    }

    public boolean isDeleteAllowed() {
        return isDeleteAllowed;
    }

    public void setDeleteAllowed(boolean isDeleteAllowed) {
        this.isDeleteAllowed = isDeleteAllowed;
    }

    protected void setService(DataService<T, Long> service) {
        this.service = service;
    }

    public String getFilterBy() {
        return filterBy;
    }

    public void setFilterBy(String filterBy) {
        this.filterBy = filterBy;
        dataProvider.setFilterProperty(filterBy);
    }

    public boolean isFilterAllowed() {
        return isFilterAllowed;
    }

    public void setFilterAllowed(boolean isFilterAllowed) {
        this.isFilterAllowed = isFilterAllowed;
    }

}
