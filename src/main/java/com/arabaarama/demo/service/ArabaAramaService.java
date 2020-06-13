package com.arabaarama.demo.service;

import com.arabaarama.demo.entity.Araba;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface ArabaAramaService {

    List<Araba> searchCriteriaMarka(String marka) throws IOException;
    List<Araba> searchCriteriaModel(String model) throws IOException;
    List<Araba> searchCriteriaSinif(String sinif) throws IOException;

    List<Araba> searchKey(String x) throws IOException;

    List<Araba> searchCriteriaHepsi(String marka, String model, String sinif) throws IOException;
}
