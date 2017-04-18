package org.test;

public class RegionRepository extends AbstractRepository<Region, Long> {

    private static final long serialVersionUID = 613150042929010861L;

    @Override
    protected Class<Region> getEntityClass() {
        return Region.class;
    }

}
