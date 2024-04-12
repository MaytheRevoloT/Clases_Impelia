//Ejercicio
def CF(a:Double)=((a*9/5)+32)

val Celcius=List(5.1,7.3,9.1)
val Fahrenheit=Celcius.map(CF)
println(Fahrenheit)
//
val Celcius1=List(5.1,7.3,9.1)
val camb=Celcius1.map(_*9/5+32)
println(camb)

//Ejercicio
val palabra=List("hola","holaa","aaaaa")
val words=palabra.filter(_.length()>5)
println(words)

//Ejercicio
def operateOnList(lst:List[Int], f:Int=>Int):List[Int]=
  lst.map(f)

val lista = List(1, 2, 3, 4, 5)
def funcion(c:Int)=c+2
println(operateOnList(lista,funcion))

//Ejercicio
def operateOnList(lst: List[Int], f1: Int => Int, f2: Int => Int, f3: Int => Int): List[List[Int]] 
= List(lst.map(f1),lst.map(f2),lst.map(f3))
 
def square(x: Int): Int = x * x
def double(x: Int): Int = x * 2
def triple(x: Int): Int = x * 3
 
val numbers = List(1, 2, 3, 4, 5)
 
val squaredNumbers = operateOnList(numbers, square,double,triple) 
println(squaredNumbers)
