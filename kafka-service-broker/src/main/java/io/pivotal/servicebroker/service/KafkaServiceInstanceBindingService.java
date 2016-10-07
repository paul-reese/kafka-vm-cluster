package io.pivotal.servicebroker.service;

import io.pivotal.servicebroker.model.ServiceInstanceBinding;
import org.springframework.cloud.servicebroker.model.CreateServiceInstanceAppBindingResponse;
import org.springframework.cloud.servicebroker.model.CreateServiceInstanceBindingRequest;
import org.springframework.cloud.servicebroker.model.CreateServiceInstanceBindingResponse;
import org.springframework.cloud.servicebroker.model.DeleteServiceInstanceBindingRequest;
import org.springframework.cloud.servicebroker.service.ServiceInstanceBindingService;
import org.springframework.stereotype.Service;

/**
 *
 * @author phopper
 *
 */
@Service
public class KafkaServiceInstanceBindingService implements ServiceInstanceBindingService {

    @Override
    public CreateServiceInstanceBindingResponse createServiceInstanceBinding(CreateServiceInstanceBindingRequest createServiceInstanceBindingRequest) {
        ServiceInstanceBinding serviceInstanceBinding = new ServiceInstanceBinding(createServiceInstanceBindingRequest.getBindingId(),
                createServiceInstanceBindingRequest.getServiceInstanceId(),
                null,
                null,
                createServiceInstanceBindingRequest.getBoundAppGuid());


        return new CreateServiceInstanceAppBindingResponse();
    }

    @Override
    public void deleteServiceInstanceBinding(DeleteServiceInstanceBindingRequest deleteServiceInstanceBindingRequest) {
        // do nothing
    }
}
