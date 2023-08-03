package com.cognizant.intermediate.apirestful.resource;

import com.cognizant.intermediate.apirestful.pojo.Employee;
import com.cognizant.intermediate.apirestful.service.EmployeeService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path="employee")
public class EmployeeResource {

    private final EmployeeService employeeService;

    public EmployeeResource(EmployeeService employeeService){
        this.employeeService = employeeService;
    }
    @GetMapping(path = "/{id}")
    public EntityModel<Employee> get(@PathVariable long id){
        Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EmployeeResource.class).get(id)).withSelfRel();
        Link link2 = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EmployeeResource.class).getAll()).withRel("all");
        return EntityModel.of(employeeService.get(id), link, link2);
        //return employeeService.get(id);
    }

    @GetMapping
    public CollectionModel<EntityModel<Employee>> getAll(){
        List<Employee> employees = employeeService.getAll();
        List<EntityModel<Employee>> entityModels = employees.stream()
                .map(employee -> EntityModel.of(employee,
                        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EmployeeResource.class).get(employee.getId())).withSelfRel(),
                        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EmployeeResource.class).getAll()).withRel("all")))
                .collect(Collectors.toList());
        return CollectionModel.of(entityModels, WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EmployeeResource.class).getAll()).withSelfRel());
        //return employeeService.getAll();
    }

    @PostMapping
    public ResponseEntity<?>/**EntityModel<Employee>**/ add(@RequestBody Employee employee){
        Employee _employee = employeeService.add(employee);
        Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EmployeeResource.class).get(_employee.getId())).withSelfRel();
        EntityModel<Employee> entityModel = EntityModel.of(_employee, link, WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EmployeeResource.class).getAll()).withRel("_all"));
        return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(entityModel);
        //return entityModel;
    }

    @PutMapping
    public Employee update(@RequestBody Employee employee){
        return null;
    }

    @DeleteMapping
    public Employee delete(@RequestBody Employee employee){
        return null;
    }
}
