package org.test;

import java.io.Serializable;

public interface Factory<E> extends Serializable {
    
    E create();
    
}
