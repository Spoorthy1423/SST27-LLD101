package com.example.imports;
import java.nio.file.Path;
public interface ProfileImporter {
    int importFrom(Path csvFile);
}
//an interface that defines the method to import profiles from a csv file and required for adapter pattern