/* queries reto 5 */

/* ListaLideresVo */
SELECT ID_Lider AS id, Nombre, Primer_Apellido AS apellido, Ciudad_Residencia AS ciudad
FROM Lider
ORDER BY Ciudad_Residencia;

/* ProyectosClasificadosVo */
SELECT ID_Proyecto AS id, Constructora, Numero_Habitantes AS habitaciones, Ciudad
FROM Proyecto
WHERE Clasificacion = 'Casa Campestre' AND Ciudad IN ('Santa Marta', 'Barranquilla', 'Cartagena');

/* ComprasClasificadasVo */
SELECT Compra.ID_Compra AS id, Proyecto.Constructora, Proyecto.Banco_Vinculado AS banco
FROM Compra
INNER JOIN Proyecto ON Compra.ID_Proyecto=Proyecto.ID_Proyecto
WHERE Compra.Proveedor = 'Homecenter' AND Proyecto.Ciudad = 'Salento';