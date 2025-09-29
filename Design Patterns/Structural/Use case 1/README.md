# Composite Pattern – File System

This project demonstrates the **Composite Design Pattern** using a **File System** example. The Composite pattern allows you to compose objects into tree structures to represent part-whole hierarchies, enabling clients to treat individual objects and compositions uniformly.

## Use Case

The use case is to simulate a **File System** where:
- **Files** are leaf nodes (cannot contain other items)
- **Folders** are composite nodes (can contain files and other folders)
- Both files and folders implement the same interface, allowing uniform treatment
- The entire structure can be traversed and displayed hierarchically

## Implementation

### 1. Component Interface (`FileSystemComponent`)
Defines the common interface for both files and folders with a `show(String indent)` method.

### 2. Leaf Class (`FileLeaf`)
- Represents individual files in the file system
- Implements `FileSystemComponent`
- Cannot contain other components
- Displays its name when `show()` is called

### 3. Composite Class (`FolderComposite`)
- Represents folders that can contain files and other folders
- Implements `FileSystemComponent`
- Maintains a list of child components (files and folders)
- `add(FileSystemComponent component)` → Adds a child component
- `show(String indent)` → Displays folder name and recursively displays all children with proper indentation

### 4. Client
- Creates a file system structure with folders and files
- Adds files and subfolders to the root folder
- Displays the entire structure by calling `show()` on the root

## Example Output

```
File System Structure:
+ Folder: Root
   - File: hello.txt
   - File: notes.docx
   + Folder: Docs
      - File: resume.pdf
      - File: project.pptx
```

## Structure

```
Root (Folder)
├── hello.txt (File)
├── notes.docx (File)
└── Docs (Folder)
    ├── resume.pdf (File)
    └── project.pptx (File)
```
