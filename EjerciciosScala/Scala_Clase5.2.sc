object StringUtils:
  def truncate(s: String, length: Int): String = s.take(length)
  def containsWhitespace(s: String): Boolean = s.matches(".*\\s.*")
  def isNullOrEmpty(s: String): Boolean = s == null || s.trim.isEmpty
 
StringUtils.truncate("Jorge Lopez", 5)
 
import StringUtils.*
 
truncate("Jorge Lopez", 5)
containsWhitespace("Jorge Lopez")
isNullOrEmpty("Jorge Lopez")

//--------------------------------------
 
object constantesmatematicas:
  val PI = 3.14159
  val E = 2.71
 
println(constantesmatematicas.PI)
 
object calculadora:
  def sumar(num1:Int ,num2:Int): Int= num1+num2
  def restar(num1:Int ,num2:Int): Int= num1-num2
  def multiplicar(num1:Int ,num2:Int): Int= num1*num2
  def dividir(num1:Double ,num2:Double): Double = num1/num2
println(calculadora.sumar(7,9))
println(calculadora.restar(7,9))
println(calculadora.multiplicar(7,9))
println(calculadora.dividir(7,9))

//--------------------------------------
 
import scala.math.*
 
class Circulo(val radio: Double):
  def area: Double = Circulo.calculararea(radio)
 
object Circulo:
  private def calculararea(radio : Double): Double = Pi*pow(radio, 2)
 
val circulo = Circulo(5)
circulo.area

//-----------------------------------------
trait Tienepatas:
  var numerodepatas: Int
  def caminar(): Unit //Metodo Abstracto
  def stop() = println("Paro de andar") //Metodo Concreto
 
trait Tienecola:
  var colorcola: String
  def movercola() : Unit
  def pararcola() = println("Paro la cola")
class Perro (nombre: String) extends Tienepatas, Tienecola:
  var numerodepatas = 4
  var colorcola = "Negro"
  def movercola() = println("Muevo la cola")
  def caminar() = println("Estoy caminando")
 
val perro = Perro("Pitbull")
 
perro.caminar()
perro.stop()
perro.colorcola = "azul"

//-----------------------------------------------
 
enum Color: 
  case Azul, Negro, Rosa, Verde
 
val rosa = Color.Rosa
 
println(Color.fromOrdinal(1))

//-------------------------------------------
 
enum Planet(mass: Double, radius: Double):
  private final val G = 6.67300E-11
  def surfaceGravity = G * mass / (radius * radius)
  def surfaceWeight(otherMass: Double) = otherMass * surfaceGravity
 
  case Mercury extends Planet(3.303e+23, 2.4397e6)
  case Venus   extends Planet(4.869e+24, 6.0518e6)
  case Earth   extends Planet(5.976e+24, 6.37814e6)
  case Mars    extends Planet(6.421e+23, 3.3972e6)
  case Jupiter extends Planet(1.9e+27,   7.1492e7)
  case Saturn  extends Planet(5.688e+26, 6.0268e7)
  case Uranus  extends Planet(8.686e+25, 2.5559e7)
  case Neptune extends Planet(1.024e+26, 2.4746e7)
end Planet
 
val Mercurio = Planet.Mercury
Mercurio.surfaceWeight(5)

//---------------------------------------------
// Uso de la case class Persona
case class Persona(nombre: String, edad: Int)

val persona = Persona("Juan", 30)
println(persona.nombre) // Imprime "Juan"
println(persona.edad)   // Imprime 30
 
//persona.nombre = "Jose"

//---------------------
trait Conductible:
  def conducir() = println("¡Vehículo a motor en movimiento!")
class Vehiculo (marca: String) extends Conductible
class Bicicleta extends Conductible:
  override def conducir() = println("¡La bicicleta está en movimiento sin motor!")

val vehiculo = Vehiculo("BMW")
vehiculo.conducir()

val bicicleta= Bicicleta()
bicicleta.conducir()
