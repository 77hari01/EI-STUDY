# Singleton Pattern - Database Connection 

This is a **DatabaseConnection (Singleton)** model that ensures only one instance of the database connection exists throughout the application. It prevents multiple connections being created unnecessarily, saving memory and improving performance.

## Use Case

The use case is to create a **DatabaseConnection class** that ensures there is always only one connection object used by the entire system.

- A developer can call `getInstance()` to get the single database connection
- Queries can be executed using this single instance
- Depending on the requirement, Singleton can be implemented in **4 variations**:
    1. **Eager Initialization**
    2. **Lazy Initialization**
    3. **Synchronized Method**
    4. **Double-Checked Locking**

## Implementation

### 1. Eager Initialization

The instance is created **at the time of class loading**. The connection is always available instantly.

**Advantages:**
- Simple to implement
- Thread-safe without synchronization
- Fast access

**Disadvantages:**
- Instance is created even if it is never used
- Wastes memory if connection is heavy and unused

---

### 2. Lazy Initialization

The instance is created **only when requested**. The object is `null` initially and created the first time `getInstance()` is called.

**Advantages:**
- Saves memory because the instance is created only when needed
- Good when the object is heavy and may not be used always

**Disadvantages:**
- Not thread-safe. Multiple threads can create multiple instances at the same time
- Needs additional synchronization for multi-threaded environments

---

### 3. Synchronized Method

The `getInstance()` method is marked as `synchronized`. Only one thread can access it at a time, preventing multiple object creation.

**Advantages:**
- Thread-safe
- Simple and reliable for concurrent environments

**Disadvantages:**
- Slower because every call to `getInstance()` is synchronized
- Performance bottleneck if method is called frequently

---

### 4. Double-Checked Locking

Uses **synchronization only when the instance is null**. Locks only once at initialization, not every time. The instance variable is declared `volatile` for safe publishing.

**Advantages:**
- Thread-safe
- High performance (locks only at the first initialization)
- Most efficient Singleton implementation in Java

**Disadvantages:**
- Slightly complex implementation compared to eager/lazy
- Requires understanding of `volatile` and memory visibility issues

---

## Summary

| Implementation | Best Use Case |
|----------------|---------------|
| **Eager Initialization** | Best when the object is lightweight and always needed |
| **Lazy Initialization** | Best when object creation is expensive and may not always be used (but avoid in multi-thread apps) |
| **Synchronized Method** | Safe but slower, suitable for small projects |
| **Double-Checked Locking** | Best practice for multi-threaded applications with performance in mind |

---
