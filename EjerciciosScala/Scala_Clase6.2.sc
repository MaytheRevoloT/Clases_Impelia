//FILTER
val numeros=List(1,2,3,4,5,6,7,8,9)
val pares=numeros.filter(_%2==0)
println(pares)
 //Ejercicio
var cont:Int=0
val numeros1=List(1,2,3,4,5,6,7,8,9,10)
val pares1=numeros1.filter(_%2==0)
println(pares1)
pares1.foreach((i:Int)=> cont=cont+i)
println(cont)

//FUNCIONES COMO PARAMETRO
def saludar(f:()=> Unit ):Unit=f()
def holajorge():Unit = println("Hola Jorge")

saludar(holajorge)
//---------
def saludarnveces(f:()=> Unit, n:Int ):Unit=
  for i<-1 to n do f()
def holajorge1():Unit = println("Hola Jorge")

saludarnveces(holajorge1, 5)

//FUNCION DE FUNCIONES
def calculadora (f:(Int, Int) => Int, i:Int, j:Int): Unit=
  println(f(i,j))
def suma(x: Int, y: Int) = x + y
def resta(x: Int, y: Int) = x - y

calculadora(suma,1,2)
calculadora(resta,1,2)
//------------
def calculadora1 (f1:(Int, Int) => Int, f2:(Int, Int) => Int, i:Int, j:Int): Unit=
  println("Suma:" + f1(i,j))
  println("Resta: " + f2(i, j))
def suma1(x: Int, y: Int) = x + y
def resta1(x: Int, y: Int) = x - y

calculadora1(suma1, resta1, 1,2)
//-------------
def calculadora2 (f3:(Int, Int) => Int, f4:(Int, Int) => Int, i:Int, j:Int): List[Int]=
  println("Suma:" + f3(i,j))
  println("Resta: " + f4(i, j))
  List(f3(i,j),f4(i,j))
def suma2(x: Int, y: Int) = x + y
def resta2(x: Int, y: Int) = x - y

val lista=calculadora2(suma2, resta2, 1,2)
println(lista)
