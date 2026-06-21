# Botica Zanabria(BACKEND PROCESO --> PRODUCTO Y CATEGORIA 🦫

## Cómo ejecutar el proyecto
### Opción A: Usando el IDE (Recomendado para desarrollo)
1. Abre **IntelliJ IDEA**  o tu Apache fracasado (o tu IDE favorito).
2. Selecciona **File > Open** y elige el archivo `pom.xml` en la raíz.
3. Espera a que Maven descargue las dependencias.
4. Busca la clase `BoticazanabriaApplication.java` y presiona **Run**.
5. REVISA APLICATION.PROPERTIES ahi esta la conexion a la base de datos AHI le cambias el puerto y tambien el user como la contraseña :v

### Opción B: Usando la terminal
1. Asegúrate de estar en la raíz del proyecto. Si esta en windows mas pichi, entras donde esta el POM y en las direcciones escribes CMD y enter y ahi es la terminal 
2. Ejecuta: `mvnw.cmd spring-boot:run`

## IMPORTANTE
1. PARA PROBAR EL CRUD DE PRODUCTOS https://randomsaxel3-826891.postman.co/workspace/Yaziel-Axel-Rodriguez-Javier's-~fbf14dba-edfa-4689-8e8c-e9701e408819/collection/55497403-992bd6d8-1f51-4cc8-a167-a6ee064d5971?action=share&source=copy-link&creator=55497403
2. Ahi tambien esta una parte del crud de categoria, pero falta pe :v



## DIAGRAMA DE CLASES
@startuml
skinparam class {
    BackgroundColor White
    ArrowColor #2F4F4F
    BorderColor #2F4F4F
    HeaderBackgroundColor #E6F2FF
}
hide circle

title DIAGRAMA DE CLASES\nSistema de Gestión de Ventas y Control de Inventario\nBotica Zanabria

' --- ENUMERADORES (Para Dropdowns en Frontend y validación en Backend) ---
enum MetodoPago {
    EFECTIVO
    YAPE
    PLIN
    TARJETA
}

enum EstadoVenta {
    PAGADO
    ANULADO
}

enum EstadoCaja {
    ABIERTA
    CERRADA
}

' --- ENTIDADES ---
class Usuario {
    - idUsuario : int
    - usuario : String
    - contrasena : String
    - activo : boolean
    + iniciarSesion() : boolean
}

class Caja {
    - idCaja : int
    - fechaApertura : LocalDateTime
    - fechaCierre : LocalDateTime
    - montoInicial : BigDecimal
    - estado : EstadoCaja
    + abrirCaja() : void
    + cerrarCaja() : void
    + realizarCorte() : BigDecimal
}

class Proveedor {
    - idProveedor : int
    - razonSocial : String
    - telefono : String
    - ruc : String
    - activo : boolean
}

class IngresoMercaderia {
    - idIngreso : int
    - nroFactura : String
    - fechaIngreso : LocalDateTime
    - totalCosto : BigDecimal
}

abstract class DetalleMovimiento {
    - idDetalle : int
    - cantidad : int
    - subtotal : BigDecimal
    + calcularSubtotal() : BigDecimal
}

class DetalleIngreso {
    - costoUnitario : BigDecimal
}

class DetalleVenta {
    - precioUnitario : BigDecimal
}

class Venta {
    - idVenta : int
    - fecha : LocalDateTime
    - subtotal : BigDecimal
    - descuento : BigDecimal
    - total : BigDecimal
    - metodoPago : MetodoPago
    - estado : EstadoVenta
    + calcularTotal() : BigDecimal
}

class SaneamientoStock {
    - idSaneamiento : int
    - stockSistema : int
    - stockFisico : int
    - diferencia : int
    - motivo : String
    - fechaAjuste : LocalDateTime
}

class Producto {
    - idProducto : int
    - codigoBarra : String
    - nombre : String
    - laboratorio : String
    - precio : BigDecimal
    - stockActual : int
    - stockMinimo : int
    - fechaVencimiento : LocalDate
    - activo : boolean
    + estaVencido() : boolean
}

class Categoria {
    - idCategoria : int
    - nombre : String
    - descripcion : String
    - activo : boolean
}

' --- Relaciones y Multiplicidades (Mapeables a JPA) ---

Usuario "1" --> "0..*" Caja : "@OneToMany\nadministra"
Caja "1" <-- "0..*" Venta : "@ManyToOne\nregistra"

Proveedor "1" --> "0..*" IngresoMercaderia : "registra"

IngresoMercaderia "1" *-- "1..*" DetalleIngreso : "@OneToMany(Cascade)\ncontiene"
Venta "1" *-- "1..*" DetalleVenta : "@OneToMany(Cascade)\ncontiene"

DetalleMovimiento <|-- DetalleIngreso : "@Inheritance\nhereda"
DetalleMovimiento <|-- DetalleVenta : "@Inheritance\nhereda"

DetalleIngreso "0..*" --> "1" Producto : "@ManyToOne"
DetalleVenta "0..*" --> "1" Producto : "@ManyToOne"
SaneamientoStock "0..*" --> "1" Producto : "@ManyToOne"

Producto "0..*" --> "1" Categoria : "@ManyToOne\nclasifica"

' --- Notas ---
note right of SaneamientoStock : diferencia = stockFisico - stockSistema\nTipos ajustados a enteros para unidades de botica.
note right of Usuario : Se agregó atributo "activo" para\nborrado lógico en Base de Datos.

@enduml
## DIAGRAMA DE DE CASOS DE USO


@startuml
left to right direction
skinparam packageStyle rectangle

actor "Administradora" as Admin
actor "Proveedor" as Proveedor

rectangle "Sistema Gestión - Botica Zanabria" {
  ' Casos de Uso Base
  usecase "Realizar Venta" as UC_Venta
  usecase "Ingresar Mercadería" as UC_Ingreso
  usecase "Consultar Inventario" as UC_Inventario
  usecase "Buscar Producto" as UC_Buscar
  usecase "Registrar Nuevo Producto" as UC_Nuevo
  
  ' Gestión Administrativa
  usecase "Realizar Corte de Caja" as UC_Corte
  usecase "Consultar Historial" as UC_Historial
  usecase "Sincerar Stock" as UC_Sincerar
}

' Relaciones del Admin
Admin --> UC_Venta
Admin --> UC_Ingreso
Admin --> UC_Inventario
Admin --> UC_Nuevo
Admin --> UC_Corte
Admin --> UC_Historial
Admin --> UC_Sincerar

' Relación del Proveedor
Proveedor --> UC_Ingreso

' --- Relaciones <<include>> (Reutilización de lógica) ---
UC_Venta ..> UC_Buscar : <<include>>
UC_Ingreso ..> UC_Buscar : <<include>>
UC_Inventario ..> UC_Buscar : <<include>>

' --- Relación <<extend>> (Si no encuentro el producto, lo registro) ---
UC_Ingreso <.. UC_Nuevo : <<extend>>

' --- Relación de Flujo de Negocio ---
UC_Corte ..> UC_Historial : (consulta previa)

@enduml
