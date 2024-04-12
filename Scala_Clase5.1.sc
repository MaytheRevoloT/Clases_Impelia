//MATCH
val dia=6
val diasemana=dia match
case 0=> "Domingo"
case 1=> "Lunes"
case 2=> "Martes"
case 3 => "Miercoles"
case _ => "Cualquier otro dia"

println(diasemana)
//-------------
val paroimpar=dia match{
  case 1|3|5 => println("impar")
  case 2|4|6 => println("par")
  case _ => println("Superior a 6")}

//-------------
val numero=dia match{
case 1 => println("es igual a uno")
case x if x==2 || x==5 => println("Es 2 o 5")
case x if x>5 => println("Es mayor que 5")
case _ => println("Es culaquier otro numero")}

//Ejercicio
var a=0
var b=0
val x=10
val y=15
for (i<-x to y)
  if(i%2==0)
  a=a+i
  else
  b=b+i

print(s"Suma de los pares es $a e impares $b")

//Ejercicio
var cont:Int=0
val a1=6
if (a1<=1) then
println("No es primo")
else
for (i<-1 to a1){
  if (a1%i==0){
    cont=cont+1}}
if cont>2 then
println("No es primo")
else
println("Es primo")