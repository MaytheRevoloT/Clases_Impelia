//Ejercicio
val numeros=List(2, 3, 5, 7, -7, 5, 8, -5)
var nummax1=numeros(0)

for (numero <-numeros){
  if (numero > nummax1){
    nummax1 = numero
  }
}
println(nummax1)

val numeros1=numeros.filter(_<nummax1)
var nummax2=numeros1(0)
for (numero <-numeros1){
  if (numero > nummax2){
    nummax2 = numero
  }
}
println(nummax2)
println(nummax1*nummax2)

//Ejercicio
val muestra= Array(20, 20, 30, 40, 50, 50, 50, 50, 60, 60)
val muestrasinduplicados= muestra.distinct

println(muestrasinduplicados.length)
