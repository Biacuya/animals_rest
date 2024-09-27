package co.edu.uptc.animals_rest.services;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Service
public class FileService {

    private List<String> lines;

    @Scheduled(fixedRate = 5000) // Cada 5 segundos
    public void reloadFile() {
        try {
            lines = Files.readAllLines(Paths.get("/app_run/animals.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getLines() {
        return lines;
    }
}