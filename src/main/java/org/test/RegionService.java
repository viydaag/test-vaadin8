package org.test;

public class RegionService extends AbstractDataService<Region, Long> {

	private static final long serialVersionUID = -170719357049601722L;
	
	private static RegionService instance = null;

    public static synchronized RegionService getInstance() {
        if (instance == null) {
            instance = new RegionService();
        }
        return instance;
    }

    private RegionService() {
        super();
        setEntityFactory(new RegionFactory());
        setRepository(new RegionRepository());
    }

}
