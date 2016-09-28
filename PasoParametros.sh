#!/bin/bash


echo Nombre del program es -> $0
echo El numero de argumentos son-> $# 
echo Todos los argumentos -> $*
echo El primer argument es -> $1

shift # Reasigna las variables renumerandolas hacia delante

echo el primer argumento es $1 despues del 'shift'

while [ $1 ]
do
	echo -e Ahora el primer argumento vale: $1 \\n

done
