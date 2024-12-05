
# Proyecto literalura

Este proyecto es una aplicación Java que interactúa con una API externa para buscar, registrar y listar libros y autores. Permite buscar libros por título, listar todos los libros registrados, listar autores registrados, listar autores vivos en un año determinado y listar libros por idiomas.


# Estructura del proyecto 

- Entidades: Clases que representan las entidades del dominio (Libro y Persona).
- Modelo: Clases que representan los datos obtenidos de la API externa (LibroAPI y PersonaAPI).
- Servicios: Clases que proporcionan la lógica de negocio (CargarDatosApi, ConvertirDatos, LibroServicio y PersonaServicio).
- Main: Clase principal que contiene el menú de interacción con el usuario.

# Clases Principales
## Main
Contiene el menú de opciones para interactuar con el usuario y llamar a los servicios adecuados.

## LibroServicio y PersonaServicio
Proporcionan métodos para manejar las operaciones CRUD de libros y autores.

## CargarDatosApi
Maneja la lógica para buscar datos en la API externa.

## ConvertirDatos
Convierte los datos JSON obtenidos de la API externa a objetos Java.

# Funcionalidades
1. Buscar libro por título: Permite buscar un libro por su título en la API externa y guardarlo en la base de datos si no está registrado.
2. Listar libros registrados: Muestra todos los libros registrados en la base de datos.
3. Listar autores registrados: Muestra todos los autores registrados en la base de datos.
4. Listar autores vivos en un determinado año: Muestra autores que estaban vivos en el año especificado.
5. Listar libros por idiomas: Filtra los libros registrados por el idioma especificado.

# Uso
1. Clona el repositorio.
2. Configura la base de datos y las dependencias necesarias.
3. Ejecuta la clase Main para iniciar la aplicación.
4. Usa el menú interactivo para acceder a las funcionalidades.
# Ejemplo del menú

```bash
Elije la opción usando números

1. Buscar libro por título
2. Listar libros registrados
3. Listar autores registrados
4. Listar autores vivos en un determinado año
5. Listar libros por idiomas
6. Salir

Digite una opción: 
```

# Consultas
Para buscar libros en español, puedes usar el siguiente endpoint en la API de Gutendex:
```bash
https://gutendex.com/books?languages=es
```
Para más detalles sobre cómo utilizar la API de Gutendex, visita la documentación de Gutendex.
    
