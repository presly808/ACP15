package university.container;

import university.service.Service;
import university.service.ServiceImpl;

public class ServiceHolder {

    private static Service serviceInstance = init();

    private static Service init() {

        Service service = new ServiceImpl(QueryCreatorHolder.getInstance());

        return service;
    }

    public static Service getInstance() {
        return serviceInstance;
    }
}
