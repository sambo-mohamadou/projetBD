package com.vetrix.projetBD.gestionnaire;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/gestionnaire")
@CrossOrigin("*")
@Tag(name = "Gestionnaire")
public class GestController {
    private final GestService service;
    public GestController(GestService service) {
        this.service = service;
    }
    @GetMapping
    public List<Gestionnaire> getGes(){
        return service.getGest();
    }
    @GetMapping(path = "/{id}")
    public Gestionnaire getGest(@PathVariable("id") int id){
        return service.getGest(id);
    }
    @PostMapping(path = "/add")
    public Gestionnaire addGest(@RequestBody Gestionnaire gest){
        return service.addGest(gest);
    }
    @PutMapping(path = "/update/{id}")
    public Gestionnaire updateGest(@PathVariable int id,@RequestBody Gestionnaire gest){
        return service.updateGest(id, gest);
    }
    @DeleteMapping(path = "/delete/{id}")
    public String deleteGest(@PathVariable int id){
        service.deleteGest(id);
        return "delete";
    }

    public boolean isActif(int id){
        switch (service.getGest(id).getActif()){
            case 0 : return false;
            case 1 : return true;
            default: return false;
        }
    }
}
