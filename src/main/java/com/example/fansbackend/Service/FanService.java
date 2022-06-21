package com.example.fansbackend.Service;

import com.example.fansbackend.Model.Fan;
import com.example.fansbackend.Repository.FanRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class FanService {

    public static List<Fan> fans;
    // Create repository object for the Service object to use
    public static FanRepository repo;

    // Constructor (Service needs a Repo)
    public FanService(FanRepository repoParam) {
        this.repo = repoParam;
    }

    // Method to get all documents from the repository
    public static List<Fan> getAllFans(){
        List<Fan> fans = new LinkedList<Fan>();
        fans = repo.findAll();
        return fans;
    };

    // Method to return 1 fan by their ID
    public static Optional<Fan> getFan(Long id) {
        return repo.findById(id);
    }

    // Method to add or update a document (POST/PUT) to the Spring Repository
    // Update = parameter is existing fan obj (presumably with different attributes)
    // Insert = parameter is net new fan obj
    public static void saveFan(Fan u){
        repo.save(u);
    };

    public static void deleteFan(Fan u){
        repo.delete(u);
    };
}
