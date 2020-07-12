package ru.itis.grocerystore.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.io.File;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Slf4j
public class TeacherImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String path;
    private Long size;

    @Transient
    private String fileName;

    @Transient
    private File sourceFile;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private Teacher teacher;

    public TeacherImage(Long id, String type, String path, Long size) {
        this.id = id;
        this.type = type;
        this.path = path;
        this.size = size;
    }

    @PostLoad
    public void loadFile() {
        // persistent(path) -> transient(sourceFile, fileName)
        sourceFile = new File(path);
        fileName = sourceFile.getName().substring(0, sourceFile.getName().lastIndexOf("."));
        log.info("Load file for " + fileName);
    }

    @PreUpdate
    public void updateFileInformation() {
        // transient(sourceFile) -> persistent(path, size)
        this.path = sourceFile.getPath();
        this.size = sourceFile.length();
        this.fileName = sourceFile.getName().substring(0, sourceFile.getName().lastIndexOf("."));
        log.info("Update file information for " + fileName);
    }
}
