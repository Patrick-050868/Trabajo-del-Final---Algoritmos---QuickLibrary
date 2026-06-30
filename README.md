# 📚 QuickLibrary

Sistema de Gestión de Préstamos de Libros desarrollado en Java como proyecto del curso **Algoritmos y Estructuras de Datos**.

## 📖 Descripción

QuickLibrary es una aplicación que permite administrar el catálogo de una biblioteca y gestionar las solicitudes de préstamo de libros.

El sistema fue desarrollado utilizando estructuras de datos implementadas desde cero, sin utilizar las estructuras equivalentes de la biblioteca estándar de Java.

## ✨ Características

- Registro de libros
- Modificación de libros
- Eliminación de libros
- Búsqueda por código
- Búsqueda por título
- Búsqueda por autor
- Búsqueda por categoría
- Registro de solicitudes de préstamo
- Gestión de la cola de solicitudes
- Préstamo de libros
- Devolución de libros
- Reporte general del sistema
- Interfaz gráfica desarrollada con Java Swing

---

# 🏗️ Estructuras de Datos Implementadas

## Cola Genérica

Implementada mediante nodos enlazados.

Operaciones implementadas:

- enqueue()
- dequeue()
- peek()
- isEmpty()
- size()
- toString()

Se utiliza para administrar las solicitudes de préstamo respetando el orden FIFO (First In, First Out).

---

## Árbol Binario de Búsqueda (BST)

Implementación genérica utilizada para almacenar los libros ordenados por su código.

Operaciones implementadas:

- Insertar
- Buscar
- Eliminar
- Recorrido InOrden
- Contar elementos
- Verificar si está vacío

# ⚙️ Requisitos

- Java JDK 17 o superior
- IDE compatible con Java
  - Eclipse
  - IntelliJ IDEA
  - NetBeans

---

# ▶️ Ejecución

1. Clonar el repositorio.

```bash
git clone https://github.com/usuario/QuickLibrary.git
```

2. Abrir el proyecto en el IDE.

3. Ejecutar la clase:

```
Main.java
```

---

# 📋 Funcionalidades

## Gestión de Libros

- Registrar libro
- Mostrar libros
- Modificar libro
- Eliminar libro
- Mostrar disponibles
- Mostrar prestados

## Búsquedas

- Por código
- Por título
- Por autor
- Por categoría

## Préstamos

- Registrar solicitud
- Mostrar cola
- Atender solicitud
- Registrar devolución

## Reportes

- Total de libros
- Libros disponibles
- Libros prestados
- Solicitudes pendientes

---

# 📈 Complejidad Temporal

| Operación | Estructura | Complejidad |
|-----------|------------|-------------|
| Registrar solicitud | Cola | O(1) |
| Atender solicitud | Cola | O(1) |
| Buscar libro | BST | O(log n) promedio |
| Insertar libro | BST | O(log n) promedio |
| Eliminar libro | BST | O(log n) promedio |
| Mostrar libros | BST | O(n) |

> En el peor caso, un árbol binario de búsqueda no balanceado puede presentar una complejidad **O(n)**.

---

# 🧪 Pruebas Realizadas

- Registro de libros
- Validación de códigos duplicados
- Búsqueda de libros
- Eliminación de libros
- Registro de solicitudes
- Atención de solicitudes
- Préstamos
- Devoluciones
- Generación de reportes

---

# 🛠️ Tecnologías Utilizadas

- Java
- Java Swing
- Programación Orientada a Objetos
- Árbol Binario de Búsqueda (BST)
- Cola Genérica
- Git
- GitHub

---

# 📄 Licencia

Proyecto desarrollado con fines académicos para el curso de **Algoritmos y Estructuras de Datos**.
