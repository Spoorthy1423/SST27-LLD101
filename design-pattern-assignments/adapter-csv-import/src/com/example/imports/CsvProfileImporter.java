package com.example.imports;

import java.nio.file.Path;
import java.util.List;

/**
 * Adapter class that adapts NaiveCsvReader to work with ProfileService
 * This implements the Adapter pattern by converting CSV data format
 * to the format expected by ProfileService
 */
public class CsvProfileImporter implements ProfileImporter {
    private final NaiveCsvReader csvReader;
    private final ProfileService profileService;
    
    public CsvProfileImporter(NaiveCsvReader csvReader, ProfileService profileService) {
        this.csvReader = csvReader;
        this.profileService = profileService;
    }
    
    @Override
    public int importFrom(Path csvFile) {
        List<String[]> rows = csvReader.read(csvFile);
        int importedCount = 0;
        
        for (String[] row : rows) {
            if (row.length >= 3) {
                // Assuming CSV format: id,email,displayName
                String id = row[0].trim();
                String email = row[1].trim();
                String displayName = row[2].trim();
                
                try {
                    profileService.createProfile(id, email, displayName);
                    importedCount++;
                } catch (Exception e) {
                    System.err.println("Failed to import profile: " + id + " - " + e.getMessage());
                }
            } else {
                System.err.println("Skipping invalid row (insufficient columns): " + String.join(",", row));
            }
        }
        
        return importedCount;
    }
}
