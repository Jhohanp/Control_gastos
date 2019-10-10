<?php
$hostname='localhost';
$database='gastoshormiga';
$username='root';
$password='';

$conexion=new mysqli($hostname,$username,$password,$database);
if($conexion->connect_errno){
echo "El servidor esta experimentando problemas";
}

?>