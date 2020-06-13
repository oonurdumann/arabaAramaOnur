package com.arabaarama.demo.api;

import com.arabaarama.demo.entity.Araba;
import com.arabaarama.demo.service.ArabaAramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api" )
public class ArabaAramaController {
    private final ArabaAramaService arabaAramaService ;

    @Autowired
    public ArabaAramaController(ArabaAramaService arabaAramaService) {
        this.arabaAramaService = arabaAramaService;
    }


    @GetMapping("/marka/{searchKri}")
    public ResponseEntity<List<Araba>> searchCriteriaMarka(@PathVariable("searchKri") String marka) throws IOException {
        List<Araba> cars = arabaAramaService.searchCriteriaMarka(marka);
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/model/{searchKri}")
    public ResponseEntity<List<Araba>> searchCriteriaModel(@PathVariable("searchKri") String model) throws IOException {
        List<Araba> cars = arabaAramaService.searchCriteriaModel(model);
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/sinif/{searchKri}")
    public ResponseEntity<List<Araba>> searchCriteriaSinif(@PathVariable("searchKri") String sinif) throws IOException {
        List<Araba> cars = arabaAramaService.searchCriteriaSinif(sinif);
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/hepsi/{marka}/{model}/{sinif}")
    public ResponseEntity<List<Araba>> searchCriteriaHepsi(@PathVariable("marka") String marka,
                                                           @PathVariable("model") String model,
                                                           @PathVariable("sinif") String sinif) throws IOException {
        List<Araba> cars = arabaAramaService.searchCriteriaHepsi(marka,model,sinif);
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/key/{searchKey}")
    public ResponseEntity<List<Araba>> searchKey(@PathVariable("searchKey") String x) throws IOException {
        List<Araba> cars = arabaAramaService.searchKey(x);
        return ResponseEntity.ok(cars);
    }


}
