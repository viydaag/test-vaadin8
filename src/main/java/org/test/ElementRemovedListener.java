package org.test;

import java.io.Serializable;

public interface ElementRemovedListener<ET> extends Serializable {

    void elementRemoved(ElementRemovedEvent<ET> e);

}
