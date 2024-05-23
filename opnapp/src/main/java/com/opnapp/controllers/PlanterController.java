package com.opnapp.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opnapp.exception.InvalidEntityException;
import com.opnapp.models.Planter;
import com.opnapp.services.PlanterService;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/planter")
public class PlanterController {

    @Autowired
    private PlanterService planterService;

    @PostMapping("/addPlanter")
    public ResponseEntity<Planter> addPlanter(@RequestBody Planter planter) throws InvalidEntityException {
        Planter addedPlanter = planterService.addPlanter(planter);
        return ResponseEntity.ok(addedPlanter);
    }

    @PutMapping("/updatePlanter")
    public ResponseEntity<Planter> updatePlanter(@RequestBody Planter planter) throws InvalidEntityException {
        Planter updatedPlanter = planterService.updatePlanter(planter);
            return ResponseEntity.ok(updatedPlanter);
       
    }

    @DeleteMapping("/deletePlanter/{planterId}")
    public ResponseEntity<Planter> deletePlanter(@PathVariable Long planterId) throws InvalidEntityException {
       Planter deletedPlanter= planterService.deletePlanter(planterId);
        return ResponseEntity.ok(deletedPlanter);
    }

    @GetMapping("/viewPlanterById/{planterId}")
    public ResponseEntity<Planter> viewPlanterById(@PathVariable Long planterId) throws InvalidEntityException {
        Planter viewPlanterById = planterService.viewPlanterById(planterId);
        return ResponseEntity.ok(viewPlanterById);
    }

    @GetMapping("/viewPlanterByShape/{planterShape}")
    public ResponseEntity<List<Planter>> viewPlanterByShape(@PathVariable String planterShape) throws InvalidEntityException {
        List<Planter> viewPlanterByShape = planterService.viewPlanterByShape(planterShape);
        return ResponseEntity.ok(viewPlanterByShape);
    }

    @GetMapping("/viewAllPlanters")
    public ResponseEntity<List<Planter>> viewAllPlanters() throws InvalidEntityException {
        List<Planter> viewAllPlanters = planterService.viewAllPlanters();
        return ResponseEntity.ok(viewAllPlanters);
    }

    @GetMapping("/viewPlanterByCostRange/{minCost}/{maxCost}")
    public ResponseEntity<List<Planter>> viewPlanterByCostRange(@PathVariable String minCost,
            @PathVariable String maxCost) throws InvalidEntityException {
        List<Planter> viewPlanterByCostRange = planterService.viewPlanterByCostRange(Double.parseDouble(minCost), Double.parseDouble(maxCost));
        return ResponseEntity.ok(viewPlanterByCostRange);
    }
}