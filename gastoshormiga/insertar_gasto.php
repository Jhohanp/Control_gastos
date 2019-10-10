<?php
include 'conexion.php';
$id=$_POST['id'];
$monto=$_POST['monto'];
$fecha=$_POST['fecha'];
$hora=$_POST['hora'];
$categoria=$_POST['categoria'];
$frecuencia=$_POST['frecuencia'];

$consulta="insert into gasto values('".$id."','".$monto."' , '".$fecha."' , '".$hora."' , '".$categoria."','".$frecuencia."' )";

mysqli_query($conexion,$consulta) or die (mysqli_error());
mysqli_close($conexion);
?>