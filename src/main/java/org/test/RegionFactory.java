package org.test;

public class RegionFactory implements Factory<Region> {

    private static final long serialVersionUID = 482850487986165771L;

    @Override
    public Region create() {
        return new Region();
    }

}
