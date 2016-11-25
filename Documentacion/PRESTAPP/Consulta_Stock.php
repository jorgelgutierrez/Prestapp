<?php
include ('Conexion.php');
$type_name = $_GET["tipo"];

$sql = "SELECT EQUIPOS.cantidadEquipo, EQUIPOS.modeloEquipo FROM TIPOS 
			INNER JOIN marcaTipo 
            	ON TIPOS.idTipo = marcaTipo.idTipo
        	INNER JOIN EQUIPOS 
            	ON marcaTipo.idEquipo = EQUIPOS.idEquipo
   			WHERE TIPOS.nombreTipo = '$type_name'";
$resultado = $conexion->query($sql);

$array = array();

$i = 0;

while ($row = mysqli_fetch_assoc($resultado)){
        $array[$i] = $row;
        $i++;
    }
if($array!=null){
    echo json_encode($array);
}

?>