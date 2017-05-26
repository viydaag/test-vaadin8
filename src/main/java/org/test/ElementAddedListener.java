package org.test;

import java.io.Serializable;

public interface ElementAddedListener<ET> extends Serializable {

    void elementAdded(ElementAddedEvent<ET> e);

}
