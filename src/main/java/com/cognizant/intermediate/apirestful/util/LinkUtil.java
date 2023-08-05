package com.cognizant.intermediate.apirestful.util;

import com.cognizant.intermediate.apirestful.pojo.Order;
import com.cognizant.intermediate.apirestful.resource.OrderResource;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

public class LinkUtil {

    public static EntityModel<Order> link(Order order){
        Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(OrderResource.class).get(order.getId())).withSelfRel();
        Link link2 = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(OrderResource.class).all()).withRel("all");
        return EntityModel.of(order, link, link2);
    }
}
