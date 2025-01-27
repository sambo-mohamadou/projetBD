package com.vetrix.projetBD.produit;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/produit")
@CrossOrigin("*")
@Tag(name = "Produit")
public class ProduitController {
    private final ProduitService service;
    private final ProduitRepository repository;

    public ProduitController(ProduitService service, ProduitRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    @GetMapping(path = "/{id}")
    public ProduitDto getProduit(@PathVariable int id){
        return service.getProduit(id);
    }
    @GetMapping
    public List<ProduitDto> getProduits(){
        return service.getProduit();
    }
    @PostMapping(path = "/add")
    public Produit addPro(@RequestBody Produit produit){
        return service.addProd(produit);
    }
    @GetMapping(path = "/nombre")
    public int getNombre(){
        return (int) repository.count();
    }
    @GetMapping(path = "/nombre/{cat}")
    public int getCatNombre(@PathVariable Integer cat){
        return Math.toIntExact(repository.catCount(cat));
    }
    @GetMapping(path = "/categorie/{idCat}")
    public List<Produit> getByCategorie(@PathVariable int idCat){
        return repository.getByCat(idCat);
    }
    @PutMapping(path = "/update/{id}")
    public Produit updatePro(@PathVariable int id,@RequestBody Produit produit){
        return service.updateProd(id,produit);
    }
    @DeleteMapping(path = "/delete/{id}")
    public void deletePro(@PathVariable int id){
        service.deleteProd(id);
    }


    public List<Produit> getBySize(int typeSize, int size){return repository.getBySize(typeSize, size);}

    public int getNombreBySize(int typeSize, int size){return (int) repository.countSize(typeSize, size); }

    public boolean isOnProm(int id){
        switch (service.getProduit(id).getPromo()){
            case 0: return false;
            case 1: return true;
            default: return false;
        }
    }

}