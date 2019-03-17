package com.invillia.acme.store.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

import com.invillia.acme.store.assembler.StoreResourceAssembler;
import org.springframework.hateoas.Resource;

import com.invillia.acme.store.entity.Store;
import com.invillia.acme.store.repository.StoreRepository;
import com.invillia.acme.store.exception.StoreNotFoundException;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StoreController {

    private final StoreRepository repository;
    private final StoreResourceAssembler assembler;

    StoreController(StoreRepository repository, StoreResourceAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    @GetMapping("/stores")
    public Resources<Resource<Store>> all() {

        List<Resource<Store>> stores = repository
                .findAll()
                .stream()
                .map(assembler::toResource)
                .collect(Collectors.toList());

        return new Resources<>(stores, linkTo(methodOn(StoreController.class).all()).withSelfRel());
    }

    @PostMapping("/stores")
    ResponseEntity<?> newStore(@RequestBody Store newStore) throws URISyntaxException {

        Resource<Store> resource = assembler.toResource(repository.save(newStore));

        return ResponseEntity
                .created(new URI(resource.getId().expand().getHref()))
                .body(resource);
    }

    @GetMapping("/stores/{id}")
    public Resource<Store> one(@PathVariable Long id) {

        Store store = repository.findById(id)
                .orElseThrow(() -> new StoreNotFoundException(id));

        return assembler.toResource(store);
    }

    @PutMapping("/stores/{id}")
    ResponseEntity<?> replaceStore(@RequestBody Store newStore, @PathVariable Long id) throws URISyntaxException {

        Store updatedStore = repository.findById(id)
                .map(store -> {
                    store.setName(newStore.getName());
                    store.setAddress(newStore.getAddress());
                    return repository.save(store);
                })
                .orElseGet(() -> {
                    newStore.setId(id);
                    return repository.save(newStore);
                });

        Resource<Store> resource = assembler.toResource(updatedStore);

        return ResponseEntity
                .created(new URI(resource.getId().expand().getHref()))
                .body(resource);
    }

    @DeleteMapping("/stores/{id}")
    ResponseEntity<?> deleteStore(@PathVariable Long id) {

        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}
