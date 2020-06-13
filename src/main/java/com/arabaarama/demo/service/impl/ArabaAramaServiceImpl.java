package com.arabaarama.demo.service.impl;

import com.arabaarama.demo.entity.Araba;
import com.arabaarama.demo.service.ArabaAramaService;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ArabaAramaServiceImpl implements ArabaAramaService {
    List<Araba> returnList = new ArrayList<>();

    @Override
    public List<Araba> searchCriteriaMarka(String marka) throws IOException {
        Araba car = new Araba();
        returnList.clear();

        List<Araba> cars = donecekList();

        for (Araba araba : cars) {
            if (marka.equals(araba.getMarka())) {
                returnList.add(araba);
            }
        }
        return returnList;
    }

    @Override
    public List<Araba> searchCriteriaModel(String model) throws IOException {
        Araba car = new Araba();
        returnList.clear();

        List<Araba> cars = donecekList();

        for (Araba araba : cars) {
            if (model.equals(araba.getModel())) {
                returnList.add(araba);
            }
        }
        return returnList;
    }

    @Override
    public List<Araba> searchCriteriaSinif(String sinif) throws IOException {
        Araba car = new Araba();
        returnList.clear();

        List<Araba> cars = donecekList();

        for (Araba araba : cars) {
            if (sinif.equals(araba.getSinif())) {
                returnList.add(araba);
            }
        }
        return returnList;
    }

    @Override
    public List<Araba> searchKey(String x) throws IOException {
        returnList.clear();
        List<Araba> list = donecekList();
        for (Araba araba : list) {
           if (araba.toString().contains(x)) {
               returnList.add(araba);
           }
        }
        return returnList;
    }

    @Override
    public List<Araba> searchCriteriaHepsi(String marka, String model, String sinif) throws IOException {
        Araba car = new Araba();
        returnList.clear();

        List<Araba> cars = donecekList();
        for (Araba araba : cars) {
            if (marka.equals(araba.getMarka()) && model.equals(araba.getModel()) && sinif.equals(araba.getSinif())){
                returnList.add(araba);
            }
        }

        return returnList;
    }

    private List<Araba> donecekList() throws IOException {
        File file = new File("araba.txt");
        List<String> list = new ArrayList<>();
        List<String> doldurListesi = new ArrayList<>();

        List<Araba> returnListe = new ArrayList<>();
        FileReader fileReader = new FileReader(file);
        String line;
        BufferedReader br = new BufferedReader(fileReader);

        while ((line = br.readLine()) != null) {
            list.add(line);
        }
        br.close();
        for (String s : list) {
            doldurListesi.addAll(Arrays.asList(s.split(";")));
            Araba car = new Araba();
            car.setMarka(doldurListesi.get(0));
            car.setModel(doldurListesi.get(1));
            car.setSinif(doldurListesi.get(2));
            returnListe.add(car);
            doldurListesi.clear();
        }

        return returnListe;
    }
}
