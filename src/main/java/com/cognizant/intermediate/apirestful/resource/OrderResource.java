package com.cognizant.intermediate.apirestful.resource;

import com.cognizant.intermediate.apirestful.pojo.Order;
import com.cognizant.intermediate.apirestful.service.OrderService;
import com.cognizant.intermediate.apirestful.util.LinkUtil;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "orders")
public class OrderResource {

    private final OrderService orderService;

    public OrderResource(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> get(@PathVariable("id") long id){
        Order order = orderService.getOne(id);
        Assert.notNull(order, String.format("Order with %d not found", id));
        return ResponseEntity.ok().body(LinkUtil.link(order));
    }
    @GetMapping
    public ResponseEntity<?> all(){
        Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(OrderResource.class).all()).withSelfRel();
        List<EntityModel<Order>> orders = orderService.allOrders().stream().map(LinkUtil::link).collect(Collectors.toList());
        return ResponseEntity.ok().body(CollectionModel.of(orders, link));
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Order order){
        Order savedOrder = orderService.add(order);
        return ResponseEntity.created(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(OrderResource.class).get(savedOrder.getId())).withSelfRel().toUri())
                      .body(LinkUtil.link(savedOrder));
    }
}
