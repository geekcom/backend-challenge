package com.invillia.acme.store.assembler;

import com.invillia.acme.store.controller.StoreController;
import com.invillia.acme.store.entity.Store;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class StoreResourceAssembler implements ResourceAssembler<Store, Resource<Store>> {

    @Override
    public Resource<Store> toResource(Store store) {

        return new Resource<>(store,
                linkTo(methodOn(StoreController.class).one(store.getId())).withSelfRel(),
                linkTo(methodOn(StoreController.class).all()).withRel("stores"));
    }
}