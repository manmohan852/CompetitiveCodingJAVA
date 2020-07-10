package site.designPattern.behavioural.serviceLocator.ex1;

import java.util.ArrayList;
import java.util.List;

public class Cache {

    private List<MessagingService> services = new ArrayList<>();

    public MessagingService getService(String serviceName) {
       for(MessagingService messagingService : services){
           if(messagingService.getServiceName().equalsIgnoreCase(serviceName)){
               return messagingService;
           }
       }
       return null;
    }

    public void addService(MessagingService newService) {
        boolean isAlreadyPresent = false;
        for(MessagingService messagingService : services){
            if(messagingService.getServiceName().equalsIgnoreCase(newService.getServiceName())){
                isAlreadyPresent = true;
            }
        }
        if(!isAlreadyPresent){
            services.add(newService);
        }
    }
}
