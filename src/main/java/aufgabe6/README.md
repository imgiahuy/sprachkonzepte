# Aufgabe 6 — Java Reflection + StringTemplate HTML Generator

## Task Purpose

The goal of this task is to practice **code generation via templates** combined with **Java Reflection**.

Concretely, the task requires building a Java application that:
1. Accepts any number of fully-qualified Java class or interface names as command-line arguments (e.g. `java.lang.String`, `java.util.Iterator`).
2. Uses **Java Reflection** (`Class.forName`, `getMethods`, `getInterfaces`, etc.) to inspect those types at runtime.
3. Uses a **StringTemplate 4 (ST4)** group file (`.stg`) to render the collected metadata into a structured HTML page.

This teaches the separation of **logic** (what data to collect) from **presentation** (how to display it), which is a core principle in template-based code and document generation.

---

## What We Achieved

After successfully solving the task, the application can generate a well-structured HTML documentation page for **any** Java class or interface available on the classpath — without any hard-coded type knowledge. For example, running:

```
java -cp "target/classes;<deps>" aufgabe6.Aufgabe6 java.lang.String java.util.Iterator java.time.Month
```

Produces an HTML file like `output.html` that shows:
- For **classes**: a table listing each implemented interface alongside all of that interface's methods.
- For **interfaces**: a table listing all declared methods.
- Each method formatted as `returnType name(paramType1, paramType2, ...)`.

---

## Project Structure

```
aufgabe6/
├── Aufgabe6.java       # Main application + model classes
├── aufgabe6.stg        # StringTemplate 4 group file (the templates)
├── aufgabe6.html       # Reference/example output (provided by course)
├── output.html         # Generated output for the example inputs
└── README.md           # This file
```

---

## Key Concepts Used

### Java Reflection
The `java.lang.reflect` API is used to inspect classes at runtime:

| API call | Purpose |
|---|---|
| `Class.forName(String)` | Load a class by its fully-qualified name |
| `clazz.isInterface()` | Check whether the type is a class or interface |
| `clazz.getInterfaces()` | Get all interfaces directly implemented by a class |
| `iface.getMethods()` | Get all public methods of an interface |
| `method.getName()` | Method name |
| `method.getReturnType().getCanonicalName()` | Fully-qualified return type |
| `method.getParameterTypes()` | Array of parameter types |

### StringTemplate 4 (ST4)
ST4 enforces strict **model/view separation** — templates cannot execute logic, only render data passed to them. The delimiter was set to `$...$` to avoid conflicts with HTML's `<` and `>`.

The template group file `aufgabe6.stg` defines 6 templates:

| Template | Description |
|---|---|
| `page(classes)` | Root template — renders the full HTML document |
| `classOrInterface(c)` | Dispatches to `classEntry` or `interfaceEntry` based on `c.interface` |
| `classEntry(c)` | Renders a class: heading + Interface/Methods table |
| `interfaceEntry(c)` | Renders an interface: heading + Methods table |
| `interfaceRow(iface)` | One table row per interface a class implements |
| `methodSig(m)` | Formats a single method signature |

ST4 accesses Java object properties via **bean-style getters**: a method `getReturnType()` is accessed in a template as `$m.returnType$`.

### Model Classes
Three inner model classes in `Aufgabe6.java` bridge reflection data to ST4:

- **`MethodModel`** — wraps `java.lang.reflect.Method`
- **`InterfaceModel`** — wraps a `Class<?>` representing an interface; holds its name and list of `MethodModel`
- **`ClassModel`** — wraps any `Class<?>`; holds its name, whether it is an interface, its implemented interfaces (for classes), and its methods (for interfaces)

---

## How to Build and Run

### Build
```bash
mvn compile
```

### Run (PowerShell — from project root `sprachkonzepte/`)
```powershell
java -cp "target\classes;$env:USERPROFILE\.m2\repository\org\antlr\ST4\4.3.4\ST4-4.3.4.jar;$env:USERPROFILE\.m2\repository\org\antlr\antlr-runtime\3.5.3\antlr-runtime-3.5.3.jar" aufgabe6.Aufgabe6 java.lang.String java.util.Iterator java.time.Month
```

> **Important:** Run from the **project root** (`sprachkonzepte/`), not from inside `aufgabe6/`. PowerShell uses `$env:USERPROFILE` instead of `%USERPROFILE%`, and does not support `^` for line continuation (use a backtick `` ` `` or write it as one line).

### Save output to file (PowerShell)
```powershell
java -cp "target\classes;$env:USERPROFILE\.m2\repository\org\antlr\ST4\4.3.4\ST4-4.3.4.jar;$env:USERPROFILE\.m2\repository\org\antlr\antlr-runtime\3.5.3\antlr-runtime-3.5.3.jar" aufgabe6.Aufgabe6 java.lang.String java.util.Iterator java.time.Month > output.html
```

You can pass **any** fully-qualified class or interface name available on the JVM classpath.

---

## Dependencies

ST4 is bundled transitively through the ANTLR4 dependency already declared in `pom.xml`:

```xml
<dependency>
    <groupId>org.antlr</groupId>
    <artifactId>antlr4</artifactId>
    <version>4.13.2</version>
</dependency>
```

This pulls in `ST4-4.3.4.jar` automatically — no additional dependency is needed.

> **Note:** `pom.xml` includes a `<resources>` block to copy `*.stg` files from `src/main/java` into `target/classes`, so the template is found on the classpath at runtime via `Class.getResource("aufgabe6.stg")`.
