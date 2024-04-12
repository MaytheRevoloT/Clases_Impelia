// METODOS
def suma(a:Int, b:Int): Int=a+b
val x = suma(2,3)
println(x)
//-------
val x2 =List(1,2,3)
x2.size
x2.contains(1)
x2.map(_*10)
//-------
def suma2(a:Int, b:Int): Int=
  val suma = a+b
  suma*2
suma(3,7)

//-------
class Tarjeta(numerotarjeta: String):
  protected  def cifrar() = println("Este no cifra")
class Cifrar(numerotarjeta: String) extends Tarjeta(numerotarjeta: String):
  override def cifrar(): Unit = println(numerotarjeta.take(4))

val mitarjeta = Cifrar("123454321")
mitarjeta.cifrar()
//mitarjeta.cifrar() //Error porque se trata de sobreescribir en un metodo privado
//Por eso cambie a protected

//------------------------------------------
case class Circle(x:Double, y:Double, radius: Double)

extension (c:Circle)
  def circumference: Double = c.radius * math.Pi * 2
  def diameter: Double=c.radius*2
  def area:Double=math.Pi*c.radius*c.radius

val aCircle=Circle(5,10,20)
aCircle.circumference
aCircle.diameter
aCircle.area

//Ejercicio

class Animal:
  protected def hacerSonido()=println("El animal hace un sonido")
class Perro extends Animal:
  def hacerRuido()=hacerSonido()

val miPerro=Perro()
miPerro.hacerRuido()

//-------------------------------------------------
//LAMBDA
val ints=List(1,2,3)
val dobleints=ints.map((i:Int) => i*2)
print(dobleints)
//-------------
val ints1=List(10,20,30)
val dobleints1=ints1.map(_*2)
print(dobleints1)

ints1.foreach((i:Int)=>println(i))

//DEFINIENDO FUNCION COMO VARIABLE
val doble=(i:Int) => i*2
val x1 = doble(2)
val dobleints2=ints.map(doble)
print(dobleints2)

// ETA EXPANSION
def por10(i:Int)=i*10
ints.map(por10)
//----------
def metodopor10(i:Int)=i*10
val funcionpor10 =(i:Int) => i*10
ints.map(funcionpor10)
ints.map(metodopor10) //En Scala2 no corre