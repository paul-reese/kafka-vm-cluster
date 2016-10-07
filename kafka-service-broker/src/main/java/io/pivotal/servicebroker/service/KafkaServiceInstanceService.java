package io.pivotal.servicebroker.service;

import io.pivotal.servicebroker.model.ServiceInstance;
import org.springframework.cloud.servicebroker.model.*;
import org.springframework.cloud.servicebroker.service.ServiceInstanceService;
import org.springframework.stereotype.Service;

/**
 *
 * @author phopper
 *
 */
@Service
public class KafkaServiceInstanceService implements ServiceInstanceService {

    @Override
    public CreateServiceInstanceResponse createServiceInstance(CreateServiceInstanceRequest createServiceInstanceRequest) {
        ServiceInstance serviceInstance = new ServiceInstance(createServiceInstanceRequest);

        return new CreateServiceInstanceResponse();
    }

    @Override
    public GetLastServiceOperationResponse getLastOperation(GetLastServiceOperationRequest getLastServiceOperationRequest) {
        // expecting service to exist, no need to manage the service instance within the service itself
        return new GetLastServiceOperationResponse().withOperationState(OperationState.SUCCEEDED);
    }

    @Override
    public DeleteServiceInstanceResponse deleteServiceInstance(DeleteServiceInstanceRequest deleteServiceInstanceRequest) {
        // expecting service to exist, no need to manage the service instance within the service itself
        return new DeleteServiceInstanceResponse();
    }

    @Override
    public UpdateServiceInstanceResponse updateServiceInstance(UpdateServiceInstanceRequest updateServiceInstanceRequest) {
        ServiceInstance instance = new ServiceInstance(updateServiceInstanceRequest);

        return new UpdateServiceInstanceResponse();
    }
}
