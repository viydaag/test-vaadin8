package org.test;

import com.vaadin.navigator.View;

public interface CrudView<T> extends View {

    public void entrySaved(T entity);
    public void entryReset(T entity);
    public void entrySelected();
    public void deleteSelected(T entity);
}
