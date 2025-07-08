# BookStore

A simple Java‑based online bookstore demonstrating core domain concepts:

- **Books**: `PaperBook`, `EBook`, `DemoBook`  
- **Inventory**: add/remove Books, track quantities  
- **Delivery**: shipping for print, email for e‑books, no‑op for demos  
- **Purchase flow**: stock validation, payment calculation, delivery delegation  
- **Outdated removal**: purge titles older than N years

---

## Table of Contents

1. [Assumptions](#assumptions)  
2. [Getting Started](#getting-started)  
3. [Test Cases](#test-cases)  
4. [Extending & Testing](#extending--testing)  

---

## Assumptions <a name="assumptions"> </a>

1. **ISBNs are unique** across all book types.  
2. **`PaperBook` stock** is decremented only on successful purchase.  
3. **`EBook`** has no stock limitation (unlimited digital copies).  
4. **`ShowcaseBook`** is not for sale—price is 0 and delivery is a no‑op.  
5. **Payment** is captured immediately when `buyBook()` is called.  
6. **Outdated removal** uses the system clock (`LocalDate.now()`) and purges titles where  
   `years between publication and today > threshold`.  

---

## Getting Started

```bash
# Clone the repo
git clone https://github.com/YassoKhalid/BokkStore.git
cd BokkStore

# Compile (plain javac)
javac -d out \
    src/BookStore/*.java \
    src/BookStore/DeliveryService/*.java

# Run the provided test harness
java -cp out BookStore.QuantumBookstoreFullTest
```
---

## Test Cases

1. [Adding and Buying Books](#addingbuying)
2. [Buying a book and exceeds avaialble Quantity](#exceeds)
3. [Buying a book that doesn't exist](#exist)
   
### 1. Adding and Buying Books <a name="addingbuying"></a>

```java
// This is an example of the main success scenario, The user Wants all books in the stock
BookStore store = new BookStore();
store.AddBook(new PaperBook("P2", "Exact Stock Book", LocalDate.of(2021, 6, 15), 30.0, 2), 2);
System.out.println(store.BuyBook("P2", 2, "bob@example.com", "456 Elm St"));
System.out.println("Remaining stock: " + store.inventory.getQuantity("P2"));
```

### 2.Buying a book and exceeds avaialble Quantity <a name="exceeds"></a>

```java
BookStore store = new BookStore();
store.AddBook(new PaperBook("P4", "Insufficient Book", LocalDate.of(2019, 11, 11), 40.0, 1),1);
// only 1 bool is avaialble of ISBN = P4
store.BuyBook("P4", 5, "dave@example.com", "101 Pine St");
```

### 3. Buying a book that doesn't exist <a name="exist"></a>

```java
BookStore store = new BookStore();
// No book with ISBN = P5
store.BuyBook("P5", 1, "eve@example.com", "202 Birch St");
```

---
## Extending & Testing

* **Unit Tests**: Add JUnit 5 tests under `src/test/java` to cover all methods.
* **Build Tool**: Convert to Maven/Gradle for dependency & test management.
* **CI**: Add GitHub Actions for automated builds & tests
  
