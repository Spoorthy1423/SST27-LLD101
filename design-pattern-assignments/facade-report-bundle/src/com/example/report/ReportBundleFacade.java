package com.example.report;

import java.nio.file.Path;
import java.util.Map;
import java.util.Objects;

/**
 * ReportBundleFacade - provides a simplified interface for the report bundle export process
 * This facade hides the complexity of orchestrating JsonWriter, Zipper, and AuditLog
 */
public class ReportBundleFacade {
    private final JsonWriter jsonWriter;
    private final Zipper zipper;
    private final AuditLog auditLog;
    
    public ReportBundleFacade() {
        this.jsonWriter = new JsonWriter();
        this.zipper = new Zipper();
        this.auditLog = new AuditLog();
    }
    
    /**
     * Export a report bundle by orchestrating JSON writing, zipping, and audit logging
     * @param data the data to export
     * @param outDir the output directory
     * @param baseName the base name for the files
     * @return the path to the created zip file
     */
    public Path export(Map<String, Object> data, Path outDir, String baseName) {
        Objects.requireNonNull(data, "data");
        Objects.requireNonNull(outDir, "outDir");
        Objects.requireNonNull(baseName, "baseName");
        
        // Step 1: Write JSON file
        Path jsonFile = jsonWriter.write(data, outDir, baseName);
        
        // Step 2: Zip the JSON file to baseName.zip in outDir
        Path zipFile = zipper.zip(jsonFile, outDir.resolve(baseName + ".zip"));
        
        // Step 3: Log the success
        auditLog.log("exported " + zipFile);
        
        return zipFile;
    }
}
