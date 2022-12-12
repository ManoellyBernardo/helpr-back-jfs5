USE helpr;

DELIMITER //

CREATE PROCEDURE proc_lista_chamado_fechados_hoje()
BEGIN
	SELECT * FROM chamado WHERE data_fechamento = CURDATE();
END//

DELIMITER ;

CALL proc_lista_chamado_fechados_hoje();