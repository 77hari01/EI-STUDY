package Composite;

import java.util.*;

public class Compositepattern {
    public static void main(String[] args) {
        FolderComposite root = new FolderComposite("Root");

        FileLeaf file1 = new FileLeaf("hello.txt");
        FileLeaf file2 = new FileLeaf("notes.docx");

        FolderComposite docsFolder = new FolderComposite("Docs");
        docsFolder.add(new FileLeaf("resume.pdf"));
        docsFolder.add(new FileLeaf("project.pptx"));

        root.add(file1);
        root.add(file2);
        root.add(docsFolder);

        System.out.println("File System Structure:");
        root.show("");
    }
}

