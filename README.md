
# Mi primera API REST

Una API que hice en Spring Boot sobre las armas del Dark Souls... Funciona correctamente (según yo), pero los deploy gratuitos no ayudaron. Me falta encontrar un buen **Cloud Storage** para poder hacerla 100% funcional (Si alguien ve esto y sabe de alguno, ¡soy todo oídos! 🤔), ya que cuando se sube una imagen y el servidor se apaga porque no lo usan, la imagen deja de funcionar.

**Deploy del proyecto en Render utilizando Docker** (tarda bastante en cargar hasta que inicia el server):

https://souls-armory-api.onrender.com



## 🛠 Skills
Java-Spring boot, Hibernate, Bootstrap, Html, Css, Js, etc...


## API Reference
Ejemplo de algunos Endpoints que hice...

- **Get random weapon**

```http
  GET /api/weaponsDS
```


- **Get random weapon image**

```http
  GET /api/weaponsDS/imagen
```

- **Get weapon image by Id**

```http
  GET /api/weaponsDS/imagen/id/{id}
```


